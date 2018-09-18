package com.woowahan.study.java.threecards;

import com.woowahan.study.java.tuple.Triple;

import java.util.*;

import static com.woowahan.study.java.tuple.Tuple.tuple;

public class GenericTripleThreeCards
{
    public static List<Triple<Integer, Integer, Integer>> find(List<Integer> cards, int target)
    {
        List<Integer> sortedCards = sortCards(cards);
        Set<Triple<Integer, Integer, Integer>> bucket = getTriples(sortedCards, target);
        return sortTriples(bucket);
    }

    static List<Integer> sortCards(Collection<Integer> cards)
    {
        List<Integer> result = new ArrayList<>(cards);
        Collections.sort(result);
        return result;
    }

    static Set<Triple<Integer, Integer, Integer>> getTriples(List<Integer> cards, int target)
    {
        Set<Triple<Integer, Integer, Integer>> bucket = new HashSet<>();

        for(int i1 = 0; i1 < cards.size(); i1 ++)
            for(int i2 = i1 + 1; i2 < cards.size(); i2 ++)
                for(int i3 = i2 + 1; i3 < cards.size(); i3 ++)
                {
                    Triple<Integer, Integer, Integer> triple = tuple(cards.get(i1), cards.get(i2), cards.get(i3));
                    if(triple.val1() + triple.val2()+ triple.val3() == target)
                        bucket.add(triple);
                }
        return bucket;
    }

    static List<Triple<Integer, Integer, Integer>> sortTriples(Set<Triple<Integer, Integer, Integer>> bucket)
    {
        List<Triple<Integer, Integer, Integer>> result = new ArrayList<>(bucket);
        result.sort(new Comparator<Triple<Integer, Integer, Integer>>() {
            @Override
            public int compare(Triple<Integer, Integer, Integer> o1, Triple<Integer, Integer, Integer> o2)
            {
                return o1.val1() != o2.val1() ? o1.val1() - o2.val1() :
                       o1.val2() != o2.val2() ? o1.val2() - o2.val2() :
                       o1.val3() != o2.val3() ? o1.val3() - o2.val3() : 0;
            }
        });
        return result;
    }
}
