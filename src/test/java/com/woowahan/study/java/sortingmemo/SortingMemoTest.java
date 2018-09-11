package com.woowahan.study.java.sortingmemo;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingMemoTest
{
    @Test
    void test()
    {
        String[] memos = String[]{
                "2018/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.",
                "타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일",
                "배민은행앞 별다방에서 18-06-12에 만나기로 함"
        };

        List<String> result = SortingMemo.sort(Arrays.asList(memos[0], memos[1], memos[2]));

        assertEquals(Arrays.asList(memos[2], memos[1], memos[0]), result);
    }
}