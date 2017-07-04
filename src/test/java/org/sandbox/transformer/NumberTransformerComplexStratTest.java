package org.sandbox.transformer;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class NumberTransformerComplexStratTest {

    private Logger logger = Logger.getLogger(NumberTransformerComplexStratTest.class.getName());

    @Test
    public void testNumberTransformer2UnDecillion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2UnDecillion() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("2111111000030450123456789987654321000");
        assertEquals("two undecillion one hundred eleven decillion one hundred eleven nonillion thirty septillion four hundred "+
                "fifty sextillion one hundred twenty three quintillion four hundred fifty six quadrillion seven hundred eighty nine trillion " +
                "nine hundred eighty seven billion six hundred fifty four million three hundred twenty one thousand", answer);
    }


    @Test
    public void testNumberTransformer2Decillion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2Decillion() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("2111111000030450123456789987654321");
        assertEquals("two decillion one hundred eleven nonillion one hundred eleven octillion thirty sextillion four hundred "+
                "fifty quintillion one hundred twenty three quadrillion four hundred fifty six trillion seven hundred eighty nine billion " +
                "nine hundred eighty seven million six hundred fifty four thousand three hundred twenty one", answer);
    }


    @Test
    public void testNumberTransformer2Quintillion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2Quintillion() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("2111000111000030450");
        assertEquals("two quintillion one hundred eleven quadrillion one hundred eleven billion thirty thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformer2Quadrillion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2Quadrillion() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("2000111000030450");
        assertEquals("two quadrillion one hundred eleven billion thirty thousand four hundred fifty", answer);
    }

    @Test
    public void testNumberTransformerBadInut()
    {
        logger.log(Level.INFO, "Running testNumberTransformerBadInut() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("211#1000030450");
        assertEquals("INVALID_INPUT", answer);
    }

    @Test
    public void testNumberTransformer2Trillion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2Trillion() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("2111000030450");
        assertEquals("two trillion one hundred eleven billion thirty thousand four hundred fifty", answer);
    }


    @Test
    public void testNumberTransformer2Billion()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2Billion() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("2000030450");
        assertEquals("two billion thirty thousand four hundred fifty", answer);
    }


    @Test
    public void testNumberTransformer2030450()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2030450() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("2030450");
        assertEquals("two million thirty thousand four hundred fifty", answer);
    }


    @Test
    public void testNumberTransformer230450()
    {
        logger.log(Level.INFO, "Running testNumberTransformer230450() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("230450");
        assertEquals("two hundred thirty thousand four hundred fifty", answer);
    }


    @Test
    public void testNumberTransformer23450()
    {
        logger.log(Level.INFO, "Running testNumberTransformer23450() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("23450");
        assertEquals("twenty three thousand four hundred fifty", answer);
    }


    @Test
    public void testNumberTransformer2345()
    {
        logger.log(Level.INFO, "Running testNumberTransformer2345() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("2345");
        assertEquals("two thousand three hundred forty five", answer);
    }

    @Test
    public void testNumberTransformer5237()
    {
        logger.log(Level.INFO, "Running testNumberTransformer5237() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("5237");
        assertEquals("five thousand two hundred thirty seven", answer);
    }


    @Test
    public void testNumberTransformer221()
    {
        logger.log(Level.INFO, "Running testNumberTransformer221() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("221");
        assertEquals("two hundred twenty one", answer);
    }

    @Test
    public void testNumberTransformer85()
    {
        logger.log(Level.INFO, "Running testNumberTransformer85() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("85");
        assertEquals("eighty five", answer);
    }

    @Test
    public void testNumberTransformer21()
    {
        logger.log(Level.INFO, "Running testNumberTransformer21() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("21");
        assertEquals("twenty one", answer);
    }

    @Test
    public void testNumberTransformer0()
    {
        logger.log(Level.INFO, "Running testNumberTransformer0() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("0");
        assertEquals("zero", answer);
    }

    @Test
    public void testNumberTransformer5()
    {
        logger.log(Level.INFO, "Running testNumberTransformer5() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("5");
        assertEquals("five", answer);
    }


    @Test
    public void testNumberTransformer19()
    {
        logger.log(Level.INFO, "Running testNumberTransformer19() ");
        NumberTransformerComplexStrat myNumberTransformer = new NumberTransformerComplexStrat();
        String answer = myNumberTransformer.transformNumberToEnglish("19");
        assertEquals("nineteen", answer);
    }

    @Test
    public void testNumberTransformerSpaceIncludedInInput()
    {
        logger.log(Level.INFO, "Running testNumberTransformerSpaceIncludedInInput() ");
        NumberTransformerComplexStrat myNumberTransformerSimpleStrat = new NumberTransformerComplexStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("-2111 0");
        assertEquals("INVALID_INPUT", answer);
    }

    @Test
    public void testNumberTransformerNegative()
    {
        logger.log(Level.INFO, "Running testNumberTransformerNegative() ");
        NumberTransformerComplexStrat myNumberTransformerSimpleStrat = new NumberTransformerComplexStrat();
        String answer = myNumberTransformerSimpleStrat.transformNumberToEnglish("-21110");
        assertEquals("negative twenty one thousand one hundred ten", answer);
    }

}
