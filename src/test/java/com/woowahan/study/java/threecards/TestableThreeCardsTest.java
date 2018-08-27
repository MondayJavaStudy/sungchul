package com.woowahan.study.java.threecards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

public class TestableThreeCardsTest
{
    @Test
    void test() throws Exception
    {
        int[] cards = {1, 2, 3, 4, 5};
        List<int[]> expectations = Arrays.asList(new int[]{1, 2, 5}, new int[]{1, 3, 4});

        List<int[]> result = TestableThreeCards.find(cards, 8);

        assertEquals(2, result.size());
        for(int idx=0; idx < expectations.size(); idx++)
                assertArrayEquals(result.get(idx), expectations.get(idx));
    }
}