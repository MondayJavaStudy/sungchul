package com.woowahan.study.java.threecards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ComposedMethodThreeCards
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = getReader();

        List<Integer> cards = pharseCards(br);
        int target = pharseTargetNum(br);

        List<int[]> result = find(cards, target);

        printResult(result);

        //위 여러줄을 한 줄로 축약 가능 (임시변수 인라인 리팩터링)
        //printResult(find(pharseCards(br), pharseTargetNum(br)));
    }

    static BufferedReader getReader()
    {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    static List<Integer> pharseCards(BufferedReader br) throws IOException
    {
        String[] nums = br.readLine().split(" ");

        List<Integer> cards = new LinkedList<>();
        for(String num: nums)
            cards.add(Integer.valueOf(num));

        return cards;
    }

    static int pharseTargetNum(BufferedReader br) throws IOException
    {
        return Integer.parseInt(br.readLine());
    }

    static List<int[]> find(List<Integer> cards, int target)
    {
        Set<int[]> triples = new HashSet<>();

        Collections.sort(cards);

        int idx = 0;
        for(int card: cards)
            findLastTwoCardWithOne(cards.subList(++idx, cards.size()), card, target, triples);

        List<int[]> result = sortTriples(triples);

        return result;
    }

    static void findLastTwoCardWithOne(List<Integer> cards, int card1, int target, Set<int[]> triples)
    {
        int idx = 0;
        for(int card: cards)
            findLastCardWithFirstTwo(cards.subList(++idx, cards.size()), card1, card, target, triples);
    }

    static void findLastCardWithFirstTwo(List<Integer> cards, int card1, int card2, int target, Set<int[]> triples)
    {
        int idx = 0;
        for(int card: cards)
            checkMatch(card1, card2, card, target, triples);
    }

    static void checkMatch(int card1, int card2, int card3, int target, Set<int[]> triples)
    {
        if(card1 + card2 + card3 == target)
            triples.add(new int[] {card1, card2, card3});
    }

    static List<int[]> sortTriples(Set<int[]> triples)
    {
        List<int[]> result = new ArrayList<>(triples);
        result.sort(new Comparator<int[]>()
                    {
                        @Override public int compare(int[] set1, int[] set2)
                        {
                            return (set1[0] != set2[0]) ? set1[0] - set2[0]:
                                            (set1[1] != set2[1]) ? set1[1] - set2[1]:
                                                    set1[2] - set2[2];
                        }
                    });
        return result;
    }

    static void printResult(List<int[]> result)
    {
        for(int[] triple: result)
            System.out.println(String.format("%d %d %d", triple[0], triple[1], triple[2]));

        if(result.size() <= 0)	System.out.println("NO");
    }
}