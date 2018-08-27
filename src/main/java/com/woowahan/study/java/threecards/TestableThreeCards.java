package com.woowahan.study.java.threecards;

import java.io.*;
import java.util.*;

class TestableThreeCards
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        int[] cards = new int[nums.length];
        for(int idx=0; idx < nums.length; idx++)
            cards[idx] = Integer.parseInt(nums[idx]);

        int expect = Integer.parseInt(br.readLine());

        List<int[]> result = find(cards, expect);
        for(int[] triple: result)
            System.out.println(String.format("%d %d %d", triple[0], triple[1], triple[2]));

        if(result.size() <= 0)	System.out.println("NO");
    }

    static List<int[]> find(int[] cards, int sum)
    {
        Set<int[]> triples = new HashSet<>();

        Arrays.sort(cards);

        for(int i1=0; i1 < cards.length; i1 ++)
            for(int i2=i1+1; i2 <cards.length; i2 ++)
                for(int i3=i2+1; i3 < cards.length; i3 ++)
                    if(cards[i1]+cards[i2]+cards[i3] == sum)
                        triples.add(new int[] {cards[i1], cards[i2], cards[i3]});

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
}