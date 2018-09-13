package com.woowahan.study.java.threecards;

import java.util.*;

public class TddThreeCards
{
    public static List<Triple> find(List<Integer> cards, int target)
    {
        List<Integer> sortedCards = sortCards(cards);
        Set<Triple> bucket = getTriples(sortedCards, target);
        return sortTriples(bucket);
    }

    static List<Integer> sortCards(Collection<Integer> cards)
    {
        List<Integer> result = new ArrayList<>(cards);
        Collections.sort(result);
        return result;
    }

    static Set<Triple> getTriples(List<Integer> cards, int target)
    {
        Set<Triple> bucket = new HashSet<>();

        for(int i1 = 0; i1 < cards.size(); i1 ++)
            for(int i2 = i1 + 1; i2 < cards.size(); i2 ++)
                for(int i3 = i2 + 1; i3 < cards.size(); i3 ++)
                {
                    Triple triple = new Triple(cards.get(i1), cards.get(i2), cards.get(i3));
                    if(triple.getCard1()+ triple.getCard2()+ triple.getCard3() == target)
                        bucket.add(triple);
                }
        return bucket;
    }

    static List<Triple> sortTriples(Set<Triple> bucket)
    {
        List<Triple> result = new ArrayList<>(bucket);
        result.sort(new Comparator<Triple>() {
            @Override
            public int compare(Triple o1, Triple o2)
            {
                return o1.card1 != o2.card1 ? o1.card1 - o2.card1 :
                        o1.card2 != o2.card2 ? o1.card2 - o2.card2 :
                                o1.card3 != o2.card3 ? o1.card3 - o2.card3 : 0;
            }
        });
        return result;
    }

    public static final class Triple
    {
        private final int card1;
            public int getCard1() { return card1; }

        private final int card2;
            public int getCard2() { return card2; }

        private final int card3;
            public int getCard3() { return card3; }

        public Triple(int card1, int card2, int card3)
        {
            this.card1 = card1;
            this.card2 = card2;
            this.card3 = card3;
        }

        @Override
        public boolean equals(Object obj)
        {
            if(obj == null || !(obj instanceof Triple)) return false;

            Triple that = (Triple) obj;
            return (this.card1 == that.card1 && this.card2 == that.card2 && this.card3 == that.card3);
        }

        @Override
        public int hashCode()
        {
            return (Integer.hashCode(card1)*31 + Integer.hashCode(card2))*31 + Integer.hashCode(card3);
        }

        @Override
        public String toString()
        {
            return String.format("Triple{card1=%s, card2=%s, card3=%s}", card1, card2, card3);
        }
    }
}
