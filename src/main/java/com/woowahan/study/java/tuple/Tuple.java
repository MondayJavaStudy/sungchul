package com.woowahan.study.java.tuple;

public final class Tuple
{
    private Tuple() { super(); }

    public static <T1, T2> Pair<T1, T2> tuple(T1 val1, T2 val2)
    {
        return Pair.of(val1, val2);
    }

    public static <T1, T2, T3> Triple<T1, T2, T3> tuple(T1 val1, T2 val2, T3 val3)
    {
        return Triple.of(val1, val2, val3);
    }

    public static <T1, T2, T3, T4> Quadruple<T1, T2, T3, T4> tuple(T1 val1, T2 val2, T3 val3, T4 val4)
    {
        return Quadruple.of(val1, val2, val3, val4);
    }
}
