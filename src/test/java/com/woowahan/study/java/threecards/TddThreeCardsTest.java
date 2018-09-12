package com.woowahan.study.java.threecards;

import com.woowahan.study.java.threecards.TddThreeCards.Triple;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TddThreeCardsTest
{
    @Test void 단순한_값_반환() throws Exception
    {
        List<Integer> cards = Arrays.asList(1, 2, 3, 4);
        int target = 6;
        List<Triple> exp = Arrays.asList(new Triple(1, 2, 3));

        List<Triple> result = TddThreeCards.find(cards, target);

        assertEquals(exp.size(), result.size());
        for(int idx=0; idx < exp.size(); idx++)
            assertEquals(result.get(idx), exp.get(idx));
    }

    @Test void 카드_순서() throws Exception
    {
        List<Integer> cards = Arrays.asList(2, 4, 1, 3);
        int target = 6;
        List<Triple> exp = Arrays.asList(new Triple(1, 2, 3));

        List<Triple> result = TddThreeCards.find(cards, target);

        assertEquals(exp.size(), result.size());
        for(int idx=0; idx < exp.size(); idx++)
            assertEquals(result.get(idx), exp.get(idx));
    }

    @Test void 결과가_여렇인_경우() throws Exception
    {
        List<Integer> cards = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
        int target = 5;
        List<Triple> exp = Arrays.asList(new Triple(0, 1, 4), new Triple(0, 2, 3));

        List<Triple> result = TddThreeCards.find(cards, target);

        assertEquals(exp.size(), result.size());
        for(int idx=0; idx < exp.size(); idx++)
            assertEquals(result.get(idx), exp.get(idx));
    }

    @Test void 중복된_결과는_없어야함() throws Exception
    {
        List<Integer> cards = Arrays.asList(1, 1, 2, 3, 4);
        int target = 6;
        List<Triple> exp = Arrays.asList(new Triple(1, 1, 4), new Triple(1, 2, 3));

        List<Triple> result = TddThreeCards.find(cards, target);

        assertEquals(exp.size(), result.size());
        for(int idx=0; idx < exp.size(); idx++)
            assertEquals(result.get(idx), exp.get(idx));
    }
}
