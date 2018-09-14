package com.woowahan.study.java.sortingmemo;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

public class SortingMemo
{
    static final Pattern DATE_PATTERN = Pattern.compile("(\\d{2,4}).(\\d{1,2}).(\\d{1,2})");

    static public List<String> sort(List<String> memoTexts)
    {
        List<Memo> memos = parseMemoTexts(memoTexts);
        sortMemos(memos);
        return buildResult(memos);
    }

    static List<Memo> parseMemoTexts(List<String> memoTexts)
    {
        List<Memo> memos= new ArrayList<>();

        for(String memoText: memoTexts)
        {
            Matcher m = DATE_PATTERN.matcher(memoText);

            if(!m.find() || m.groupCount() < 3)
                throw new IllegalStateException("Invalid memo: " + memoText);

            int year = Integer.parseInt(m.group(1));
            int month = Integer.parseInt(m.group(2));
            int dayOfMonth = Integer.parseInt(m.group(3));

            memos.add(Memo.of(LocalDate.of(year < 100 ? year + 2000 : year, month, dayOfMonth), memoText));
        }
        return memos;
    }

    static void sortMemos(List<Memo> memos)
    {
        memos.sort(new Comparator<Memo>() {
            @Override public int compare(Memo o1, Memo o2)
            {
                return o1.date.compareTo(o2.date) == 0 ? o1.text.compareTo(o2.text): o1.date.compareTo(o2.date);
            }
        });
    }

    static List<String> buildResult(List<Memo> memos)
    {
        List<String> result = new LinkedList<>();
        for(Memo memo: memos)
            result.add(memo.text);
        return result;
    }

    static class Memo
    {
        LocalDate date;
        String text;

        private Memo() { super(); }

        static Memo of(LocalDate date, String text)
        {
            Memo memo = new Memo();
            memo.date = date;
            memo.text = text;
            return memo;
        }

        @Override
        public int hashCode()
        {
            return text.hashCode();
        }

        @Override
        public boolean equals(Object obj)
        {
            if(obj == null || !(obj instanceof Memo)) return false;

            Memo that = (Memo) obj;
            return that.text.equals(this.text);
        }

        @Override
        public String toString()
        {
            return "Memo{" + date + ", '" + text + "'}";
        }
    }
}