package org.sandbox.transformer;

import org.jooq.lambda.Seq;
import org.sandbox.data.DataReference;
import org.sandbox.data.TransformationData;

import java.util.ArrayList;
import java.util.List;


/**
 * This class handled the number to English transformation
 * by breaking the inputs up into groups of 3 characters,
 * determining, then translating each segment of 3 recursively
 * while reassembling the english translation.  This approach
 * overcomes the limitations of the built in Integer and Long types
 * of Java.
 */
public class NumberTransformerComplexStrat extends TransformerBase {


    public NumberTransformerComplexStrat() {
        logger.info("Initializing org.sandbox.transformer.NumberTransformerComplexStrat");
    }

    private List<TransformationData> parseInputs(String input) {
        logger.trace("Parsing inputs to seed convert function.");
        List<TransformationData> masterList;
        if (input.length() >= 3) {
            masterList = parseLargerThanThree(input);
        } else {
           masterList = parseSmallerThanThree(input);
        }
        return masterList;
    }

    private List<TransformationData> parseSmallerThanThree(final String input) {
        char[] tmp = new char[3];
        int tmpIdx = 2;
        int length = input.length();
        int startIndex = length - 1;
        List<TransformationData> masterList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            tmp[tmpIdx] = input.charAt(startIndex - i);
            tmpIdx--;
        }
        masterList.add(new TransformationData(Integer.parseInt(String.copyValueOf(tmp).trim()),
                DataReference.numberNames.get(0)));
        return masterList;
    }

    private List<TransformationData> parseLargerThanThree(final String input) {
        //This is for a number with a minimum size of 100
        int length = input.length();
        int numIters = length / 3;
        int startIndex = length - 1;
        int numRemainder = length % 3;
        int lastIterationNumber = 0;
        char[] tmp = new char[3];
        int tmpIdx = 2;
        tmp[0] = tmp[1] = tmp[2] = ' ';
        List<TransformationData> masterList = new ArrayList<>();

        for (int j = 0; j < numIters; j++) {
            for (int i = 0; i < 3; i++) {
                tmp[tmpIdx] = input.charAt(startIndex - i);
                tmpIdx--;
            }
            masterList.add(new TransformationData(Integer.parseInt(String.copyValueOf(tmp).trim()), DataReference.numberNames.get(j)));
            tmp[0] = tmp[1] = tmp[2] = ' ';
            tmpIdx = 2;
            startIndex -= 3;
            lastIterationNumber = j;
        }
        if (++lastIterationNumber == numIters && numRemainder > 0) {

            for (int k = 0; k < numRemainder; k++) {
                tmp[tmpIdx] = input.charAt(startIndex - k);
                tmpIdx--;
            }
            masterList.add(new TransformationData(Integer.parseInt(String.copyValueOf(tmp).trim()), DataReference.numberNames.get(lastIterationNumber)));
        }
        return masterList;
    }

    protected String convert(String input) {
        logger.trace("Initiating convert function, calling parseInputs(input)...");
        List<TransformationData> masterList = parseInputs(input);

        logger.trace("Traversing list of data to build up English transform");

        //Handles the case of having a single element and it's zero
        if (isZero(masterList)) {
            return assembler(masterList.get(0).getData());
        }

        return processNumbersList(masterList);
    }

    private String processNumbersList(final List<TransformationData> masterList) {
        StringBuilder translatedOutput = new StringBuilder();
        Seq.seq(masterList)
                .reverse()
                .filter(entry -> entry.getData() > 0)
                .forEach(data -> translatedOutput.append(extractEntryData(data)));
        return translatedOutput.toString().trim();
    }

    private String extractEntryData(final TransformationData data) {
        StringBuilder localSB = new StringBuilder();
        localSB.append(assembler(data.getData()));
        if (!data.getNumberName().equals("tens")) {
            localSB.append(space)
                    .append(data.getNumberName())
                    .append(space);
        }
        return localSB.toString();
    }

    private boolean isZero(final List<TransformationData> masterList) {
        return masterList.size()==1 && masterList.get(0).getData() == 0;
    }

    private String assembler(int input) {
        logger.trace("Assembler operating on input " + input);
        StringBuilder translatedNumber = new StringBuilder();
        if (input >= HUNDRED) {
            translatedNumber.append(assembler(input / HUNDRED)).append(" hundred ");
            translatedNumber.append(assembler(input % HUNDRED));
        } else if (input >= TEN) {

            if (input > TEN && input <= TWENTY) {
                translatedNumber.append(DataReference.baseReference.get(input));
            } else {
                translatedNumber.append(DataReference.baseReference.get((input / TEN) * TEN));
                int remainder = input % TEN;
                if (remainder != 0)
                    translatedNumber.append(" ").append(DataReference.baseReference.get(remainder));
            }

        } else if (input < TEN) {
            translatedNumber.append(DataReference.baseReference.get(input));
        }
        return translatedNumber.toString();
    }
}
