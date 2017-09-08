package org.sandbox.transformer;

import org.jooq.lambda.Seq;
import org.sandbox.data.DataReference;
import org.sandbox.data.TransformationData;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


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
        List<TransformationData> masterList = new ArrayList<>();
        int l = input.length();
        int startIndex = l - 1;
        int endIndex = 0;
        char[] tmp = new char[3];
        int tmpIdx = 2;
        tmp[0] = tmp[1] = tmp[2] = ' ';
        if (l >= 3) {
            //This is for a number with a minimum size of 100
            int numIters = l / 3;
            int numRemainder = l % 3;
            int lastIterationNumber = 0;

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
        } else {
            for (int i = 0; i < l; i++) {
                tmp[tmpIdx] = input.charAt(startIndex - i);
                tmpIdx--;
            }
            masterList.add(new TransformationData(Integer.parseInt(String.copyValueOf(tmp).trim()), DataReference.numberNames.get(0)));
        }
        return masterList;
    }

    protected String convert(String input) {
        logger.trace("Initiating convert function, calling parseInputs(input)...");
        List<TransformationData> masterList = parseInputs(input);

        logger.trace("Traversing list of data to build up English transform");
        StringBuilder translatedOutput = new StringBuilder();
        Seq.seq(masterList).reverse().collect(toList()).stream().forEach(data -> {
            translatedOutput.append(assembler(data.getData()));
            if (!data.getNumberName().equals("tens"))
                translatedOutput.append(space).append(data.getNumberName()).append(space);
        });
        return translatedOutput.toString().trim();
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
