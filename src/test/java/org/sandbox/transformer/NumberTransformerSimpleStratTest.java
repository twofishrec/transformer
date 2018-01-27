package org.sandbox.transformer;


import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple NumberTransformerSimpleStrat.
 */
public class NumberTransformerSimpleStratTest {

    private Logger logger = Logger.getLogger(NumberTransformerSimpleStrat.class.getName());

    @Test
    public void testNumberTransformer2Quintillion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2Quintillion() ");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("2111000111000030450");
        assertEquals("two quintillion one hundred eleven quadrillion one hundred eleven billion thirty thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformerSpaceIncludedInInput()
    {
        logger.log(Level.INFO, "Running testNumberTransformerSpaceIncludedInInput() ");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("-2111 0");
        assertEquals("INVALID_INPUT", answer);
    }

    @Test
    public void testNumberTransformerNegative()
    {
        logger.log(Level.INFO, "Running testNumberTransformerNegative() ");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("-21110");
        assertEquals("negative twenty one thousand one hundred ten", answer);
    }


    @Test
    public void testNumberTransformer2QuadrillionNegative()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2QuadrillionNegative() ");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("-2000111000030450");
        assertEquals("negative two quadrillion one hundred eleven billion thirty thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformer2Quadrillion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2Quadrillion() ");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("2000111000030450");
        assertEquals("two quadrillion one hundred eleven billion thirty thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformerBadInut()
    {
        logger.log(Level.INFO, "Running testNumberTransformerBadInut() ");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("211#1000030450");
        assertEquals("INVALID_INPUT", answer);
    }

    @Test
    public void testNumberTransformer2Trillion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2Trillion()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("2111000030450");
        assertEquals("two trillion one hundred eleven billion thirty thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformer2Billion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2Billion()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("2000030450");
        assertEquals("two billion thirty thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformer2030450()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2030450()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("2030450");
        assertEquals("two million thirty thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformer230450()
    {
        logger.log(Level.INFO, "Running testNumberTransformer230450()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("230450");
        assertEquals("two hundred thirty thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformer23450()
    {
        logger.log(Level.INFO, "Running testNumberTransformer23450()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("23450");
        assertEquals("twenty three thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformer2345()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2345()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("2345");
        assertEquals("two thousand three hundred forty five", answer);
    }

    @Test
    public void testNumberTransformer5237()
    {
        logger.log(Level.INFO, "Running testNumberTransformer5237()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("5237");
        assertEquals("five thousand two hundred thirty seven", answer);
    }

    @Test
    public void testNumberTransformer221()
    {
        logger.log(Level.INFO, "Running testNumberTransformer221()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("221");
        assertEquals("two hundred twenty one", answer);
    }

    @Test
    public void testNumberTransformer85()
    {
        logger.log(Level.INFO, "Running testNumberTransformer85()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("85");
        assertEquals("eighty five", answer);
    }

    @Test
    public void testNumberTransformer21()
    {
        logger.log(Level.INFO, "Running testNumberTransformer21()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("13");
        assertEquals("thirteen", answer);
    }

    @Test
    public void testNumberTransformer0()
    {
        logger.log(Level.INFO, "Running testNumberTransformer0()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("0");
        assertEquals("zero", answer);
    }

    @Test
    public void testNumberTransformer5()
    {
        logger.log(Level.INFO, "Running testNumberTransformer5()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("5");
        assertEquals("five", answer);
    }

    @Test
    public void testNumberTransformer19()
    {
        logger.log(Level.INFO, "Running testNumberTransformer19()");
        NumberTransformerSimpleStrat myNumberTransformerSimpleStrat = new NumberTransformerSimpleStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("19");
        assertEquals("nineteen", answer);
    }
}
