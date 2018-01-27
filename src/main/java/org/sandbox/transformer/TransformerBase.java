package org.sandbox.transformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.regex.Pattern.matches;


/**
 * Created by twofish on 7/3/17.
 */
public abstract class TransformerBase implements Transformer {

    Logger logger = LoggerFactory.getLogger("TransformerBase");

    final String space = " ";


    final Long QUINTILLION = 1000000000000000000L;
    final Long QUADRILLION = 1000000000000000L;
    final Long TRILLION    = 1000000000000L;
    final Integer BILLION  = 1000000000;
    final Integer MILLION  = 1000000;
    final Integer THOUSAND = 1000;
    final Integer HUNDRED  = 100;
    final Integer TEN      = 10;
    final Integer TWENTY   = 20;


    private boolean validInputs(final String input) {
        logger.trace("Validating input contains only numeric entries");
        return matches("^[0-9]*$", input);
    }
    public String transformNumberToEnglish(final String input) {
        String translatedResponse="";
        int refIdx = 0;
        //check for negative first...
        logger.trace("Checking for negative indicator on the input string ");
        if (input.charAt(0) == '-') {
            refIdx = 1;
            translatedResponse = "negative ";
        }

        if (validInputs(input.substring(refIdx, input.length()))) {
            translatedResponse += convert(input.substring(refIdx, input.length()));
            //Simple sanity for negative zero--special case.
            if (translatedResponse.equals("negative zero"))
                    translatedResponse = "zero";
        }
        else {
            translatedResponse = "INVALID_INPUT";
        }
        return translatedResponse;
    }

    protected abstract String convert(String input);


}
