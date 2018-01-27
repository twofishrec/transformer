package org.sandbox.transformer;


import org.sandbox.data.DataReference;

import static java.lang.Long.*;

/**
 * Class to convert input numbers to English words.
 * This approach uses a naive approach and relies on the built in Java
 * Integer/Long types for inspecting the input values.  This of course
 * has limitations due to the maximum sizes of those types. However,
 * depending on the use case, this approach does work up effectively up
 * to the type limits.
 */
public class NumberTransformerSimpleStrat extends TransformerBase {

    public NumberTransformerSimpleStrat() {
        logger.info("Initializing org.sandbox.transformer.NumberTransformerComplexStrat");
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    protected String convert(String input) {
        logger.trace("converting input...");
        String response;
        try {
            logger.trace("testing the length of the input");
            parseLong(input);
            response = transformNumberToEnglish(parseLong(input));
        } catch (NumberFormatException nfe) {
            logger.error("The provided input exceeded the transformers size limitation, "+
                    "retry using the ComplexStrat transformer");
            response = "ERROR: INPUT EXCEEDED SIZE LIMITS.";
        }
        return response;
    }


    private String transformNumberToEnglish(final Long input) {
        logger.trace("transformNumberToEnglish(long input) with " + input);
        StringBuilder translatedNumber = new StringBuilder();

        if (input >= QUINTILLION) {
            logger.trace("value greater than " + QUINTILLION);
            translatedNumber.append(transformNumberToEnglish(input / QUINTILLION)).append(" quintillion ");
            translatedNumber.append(transformNumberToEnglish(input % QUINTILLION));
        } else if (input >= QUADRILLION) {
            translatedNumber.append(transformNumberToEnglish(input / QUADRILLION)).append(" quadrillion ");
            translatedNumber.append(transformNumberToEnglish(input % QUADRILLION));

        } else if (input >= TRILLION) {
            translatedNumber.append(transformNumberToEnglish(input / TRILLION)).append(" trillion ");
            translatedNumber.append(transformNumberToEnglish(input % TRILLION));

        } else if (input >= BILLION) {
            translatedNumber.append(transformNumberToEnglish(input / BILLION)).append(" billion ");
            translatedNumber.append(transformNumberToEnglish(input % BILLION));

        } else if (input >= MILLION) {
            translatedNumber.append(transformNumberToEnglish(input / MILLION)).append(" million ");
            translatedNumber.append(transformNumberToEnglish(input % MILLION));

        } else if (input >= THOUSAND) {
            translatedNumber.append(transformNumberToEnglish(input / THOUSAND)).append(" thousand ");
            translatedNumber.append(transformNumberToEnglish(input % THOUSAND));

        } else if (input >= HUNDRED) {
            translatedNumber.append(transformNumberToEnglish(input / HUNDRED)).append(" hundred ");
            translatedNumber.append(transformNumberToEnglish(input % HUNDRED));

        } else if (input >= TEN) {

            if (input > TEN && input <= TWENTY) {
                translatedNumber.append(DataReference.baseReference.get(Integer.parseInt(input.toString())));
            } else {
                translatedNumber.append(DataReference.baseReference.get((Integer.parseInt(input.toString()) / TEN) * TEN));
                long remainder = input % TEN;
                if (remainder != 0)
                    translatedNumber.append(" ").append(DataReference.baseReference.get(Integer.parseInt(Long.toString(remainder))));
            }

        } else if (input < TEN) {
            translatedNumber.append(DataReference.baseReference.get(Integer.parseInt(input.toString())));
        }

        return translatedNumber.toString();
    }

}
