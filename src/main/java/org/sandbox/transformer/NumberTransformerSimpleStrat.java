package org.sandbox.transformer;


import org.sandbox.data.DataReference;

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

    @Override
    protected String convert(String input) {
        logger.trace("converting input...");
        String response;
        try {
            logger.trace("testing the length of the input");
            Long.parseLong(input);
            response = transformNumberToEnglish(Long.parseLong(input));
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
            translatedNumber.append(transformNumberToEnglish(input / QUINTILLION) + " quintillion ");
            translatedNumber.append(transformNumberToEnglish(input % QUINTILLION));
        } else if (input >= QUADRILLION) {
            translatedNumber.append(transformNumberToEnglish(input / QUADRILLION) + " quadrillion ");
            translatedNumber.append(transformNumberToEnglish(input % QUADRILLION));

        } else if (input >= TRILLION) {
            translatedNumber.append(transformNumberToEnglish(input / TRILLION) + " trillion ");
            translatedNumber.append(transformNumberToEnglish(input % TRILLION));

        } else if (input >= BILLION) {
            translatedNumber.append(transformNumberToEnglish(input / BILLION) + " billion ");
            translatedNumber.append(transformNumberToEnglish(input % BILLION));

        } else if (input >= MILLION) {
            translatedNumber.append(transformNumberToEnglish(input / MILLION) + " million ");
            translatedNumber.append(transformNumberToEnglish(input % MILLION));

        } else if (input >= THOUSAND) {
            translatedNumber.append(transformNumberToEnglish(input / THOUSAND) + " thousand ");
            translatedNumber.append(transformNumberToEnglish(input % THOUSAND));

        } else if (input >= HUNDRED) {
            translatedNumber.append(transformNumberToEnglish(input / HUNDRED) + " hundred ");
            translatedNumber.append(transformNumberToEnglish(input % HUNDRED));

        } else if (input >= TEN) {

            if (input > TEN && input <= TWENTY) {
                translatedNumber.append(DataReference.baseReference.get(Integer.parseInt(input.toString())));
            } else {
                translatedNumber.append(DataReference.baseReference.get((Integer.parseInt(input.toString()) / TEN) * TEN));
                long remainder = input % TEN;
                if (remainder != 0)
                    translatedNumber.append(" " + DataReference.baseReference.get(Integer.parseInt(new Long(remainder).toString())));
                ;
            }

        } else if (input < TEN) {
            translatedNumber.append(DataReference.baseReference.get(Integer.parseInt(input.toString())));
        }

        return translatedNumber.toString();
    }

}
