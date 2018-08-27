package com.woowahan.study.java.threecards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;


public class SomewhatTestableThreeCardsTest
{
    @Test
    void test() throws Exception
    {
        Reader input = new StringReader("1 2 3 4 5\n8");
        StringWriter output = new StringWriter();

        SomewhatTestableThreeCards.doIt(input, output);

        assertEquals("1 2 5\n" + "1 3 4\n", output.toString());
    }
}