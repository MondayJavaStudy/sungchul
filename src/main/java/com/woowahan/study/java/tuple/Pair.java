package com.woowahan.study.java.tuple;

import java.util.Objects;

public class Pair<T1, T2>
{
    private final T1 val1;
        public T1 val1() { return this.val1; }

    private final T2 val2;
        public T2 val2() { return this.val2; }

    public Pair(T1 val1, T2 val2)
    {
        this.val1 = val1;
        this.val2 = val2;
    }

    public static <T1, T2> Pair<T1, T2> of(T1 val1, T2 val2)
    {
        return new Pair<>(val1, val2);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Pair)) return false;

        Pair that = (Pair) obj;
        return Objects.equals(this.val1, that.val1) &&
               Objects.equals(this.val2, that.val2);
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 31;

        int hashCode = val1 != null ? val1.hashCode() : 0;
        hashCode = hashCode*PRIME + (val2 != null ? val2.hashCode() : 0);

        return hashCode;
    }

    @Override
    public String toString()
    {
        return "Pair{" + val1 + ", " + val2 + "}";
    }
}
