package org.sandbox.driver;

import org.apache.commons.cli.*;
import org.sandbox.transformer.NumberTransformerComplexStrat;
import org.sandbox.transformer.NumberTransformerSimpleStrat;
import org.sandbox.transformer.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import java.util.logging.Logger;


/**
 * This is the primary driver, based on user input
 * either the Simple Strategy transformer will be used (which has limitations)
 * or the more Complex Strategy transformer will be used.  In the case of an error
 * on input of the the strategy name, the Complex Strategy is the default.
 */
class NumberToEnglishTransformer {

    private final Options options = new Options();
    private final Logger logger = LoggerFactory.getLogger("NumberToEnglishTransformer");
    private String inputValue;
    private Transformer transformer=new NumberTransformerComplexStrat();


    private NumberToEnglishTransformer() {

        options.addOption("h", "help", false, "show help");
        options.addOption("i", "input-number", true , "the number to be transformed into English(Examples: 9, 23, -345634534223)");
        options.addOption("t", "transformer", true , "the transform strategy to use, default is "+
                "'Complex', other option is 'Simple'");
    }

    private void parse(String[] inputArguments) {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options,inputArguments);
            if (cmd.hasOption('h')) {
                printHelp();
            }
            if (cmd.hasOption('i')) {
                inputValue = cmd.getOptionValue("i");
                logger.info("Retriving input-number arguument " + inputValue);
            }
            else {
                logger.error("Input number is required, please check the inputs command line and retry");
                printHelp();
            }
            if (cmd.hasOption('t')) {
                String transformStrategy = cmd.getOptionValue("t");
                logger.info("Retriving transformer argument " + transformStrategy);
                if (transformStrategy.equalsIgnoreCase("simple")) {
                    logger.info("Using default logger--complex strategy");
                    transformer = new NumberTransformerSimpleStrat();
                } else if (transformStrategy.equalsIgnoreCase("complex")) {
                    logger.info("Using default logger--complex strategy");
                } else {
                    logger.warn("Specified transform strategy " + transformStrategy + " is not valid. Proceeding with default complex strategy.");
                }
            }

        } catch (ParseException e) {
            logger.error("Error encountered parsing inputs, check the inputs and retry.");
            printHelp();
        }
    }

    private void transform() {
        String output = transformer.transformNumberToEnglish(inputValue);
        if (output.contains("INVALID") || output.contains("ERROR")) {
            System.out.println("An error was encountered during transformation. This is typically due to an invalid character in the input value.");
            System.out.println("Please check the inputs and retry");
        } else {
            System.out.println(inputValue + " translated to English is " + output);
        }
    }

    private void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar number-to-english-transformer.jar", options);
        System.exit(0);
    }

    public static void main(String[] args) {
        NumberToEnglishTransformer transformer = new NumberToEnglishTransformer();
        transformer.parse(args);
        transformer.transform();
    }
}
