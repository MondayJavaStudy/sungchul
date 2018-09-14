package com.woowahan.study.java.sortingmemo;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingMemoTest
{
    @Test
    void 결과는_정렬되어야함()
    {
        String[] memos = new String[]{
                "2018/7/3 메모1",
                "2018년6월13일 메모2",
                "2018-6-12 메모3"
        };

        List<String> result = SortingMemo.sort(Arrays.asList(memos[0], memos[1], memos[2]));
        assertEquals(Arrays.asList(memos[2], memos[1], memos[0]), result);
    }

    @Test
    void 두자리_연도는_20XX로_처리되어야_함()
    {
        String[] memos = new String[]{"18/7/3 메모1", "2017/1/1 메모2"};

        List<String> result = SortingMemo.sort(Arrays.asList(memos[0], memos[1]));
        assertEquals(Arrays.asList(memos[1], memos[0]), result);
    }

    @Test
    void 공백없이_포함된_날짜도_인식해야함()
    {
        String[] memos = new String[]{
                "메모2018/7/3중간에포함된날짜",
                "2018년6월13일날짜로시작하는메모",
                "메모뒤에붙은날짜2018-6-12"
        };

        List<String> result = SortingMemo.sort(Arrays.asList(memos[0], memos[1], memos[2]));
        assertEquals(Arrays.asList(memos[2], memos[1], memos[0]), result);
    }

    @Test
    void 달일이_10_이하고_앞에_0이_붙은_경우()
    {
        String[] memos = new String[]{
                "2018/07/03 메모1",
                "2018년06월03일 메모2",
                "2018-06-02 메모3"
        };

        List<String> result = SortingMemo.sort(Arrays.asList(memos[0], memos[1], memos[2]));
        assertEquals(Arrays.asList(memos[2], memos[1], memos[0]), result);
    }
}