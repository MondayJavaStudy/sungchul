package com.woowahan.study.java.threecards;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class ComposedMethodThreeCardsTest
{
    @Test void 단순한_결과() throws Exception
    {
        List<Integer> cards = asList(1, 2, 5);
        int target = 8;
        List<int[]> expectations = asList(new int[]{1, 2, 5});

        findCombinationsAndCheckIt(cards, target, expectations);
    }

    @Test void 정렬된_세카드() throws Exception
    {
        List<Integer> cards = asList(5, 2, 1);
        int target = 8;
        List<int[]> expectations = asList(new int[]{1, 2, 5});

        findCombinationsAndCheckIt(cards, target, expectations);
    }

    @Test void 결과가_없는_경우() throws Exception
    {
        List<Integer> cards = asList(1, 2, 3, 4, 5);
        int target = 3;
        List<int[]> expectations = asList();

        findCombinationsAndCheckIt(cards, target, expectations);
    }

    @Test void 세카드_중_중복_허용() throws Exception
    {
        List<Integer> cards = asList(1, 1, 1);
        int target = 3;
        List<int[]> expectations = asList(new int[]{1, 1, 1});

        findCombinationsAndCheckIt(cards, target, expectations);
    }

    @Test void 결과가_하나_이상인_경우() throws Exception
    {
        List<Integer> cards = asList(1, 2, 3, 4, 5);
        int target = 8;
        List<int[]> expectations = asList(new int[]{1, 2, 5}, new int[]{1, 3, 4});

        findCombinationsAndCheckIt(cards, target, expectations);
    }

    private void findCombinationsAndCheckIt(List<Integer> cards, int target, List<int[]> expectations)
    {
        List<int[]> result = ComposedMethodThreeCards.find(cards, target);

        assertEquals(expectations.size(), result.size());
        for (int idx = 0; idx < expectations.size(); idx++)
            assertArrayEquals(result.get(idx), expectations.get(idx));
    }
}