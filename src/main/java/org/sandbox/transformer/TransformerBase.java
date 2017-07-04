package org.sandbox.transformer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

/**
 * Created by twofish on 7/3/17.
 */
public abstract class TransformerBase implements Transformer {

    protected Logger logger = LogManager.getLogger();
    protected final String space = " ";


    protected final Long QUINTILLION = 1000000000000000000L;
    protected final Long QUADRILLION = 1000000000000000L;
    protected final Long TRILLION    = 1000000000000L;
    protected final Integer BILLION  = 1000000000;
    protected final Integer MILLION  = 1000000;
    protected final Integer THOUSAND = 1000;
    protected final Integer HUNDRED  = 100;
    protected final Integer TEN      = 10;
    protected final Integer TWENTY   = 20;


    private boolean validInputs(final String input) {
        logger.trace("Validating input contains only numeric entries");
        boolean status = Pattern.matches("^[0-9]*$", input);
        return status;
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
