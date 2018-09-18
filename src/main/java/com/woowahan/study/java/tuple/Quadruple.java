package com.woowahan.study.java.tuple;

import java.util.Objects;

public final class Quadruple<T1, T2, T3, T4>
{
    private final T1 val1;
    public T1 val1() { return val1; }

    private final T2 val2;
    public T2 val2() { return val2; }

    private final T3 val3;
    public T3 val3() { return val3; }

    private final T4 val4;
    public T4 val4() { return val4; }

    public Quadruple(T1 val1, T2 val2, T3 val3, T4 val4)
    {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
        this.val4 = val4;
    }

    public static <T1, T2, T3, T4> Quadruple<T1, T2, T3,T4> of(T1 val1, T2 val2, T3 val3, T4 val4)
    {
        return new Quadruple<>(val1, val2, val3, val4);
    }


    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Quadruple)) return false;

        Quadruple that = (Quadruple) obj;
        return (Objects.equals(this.val1, that.val1) &&
                Objects.equals(this.val2, that.val2) &&
                Objects.equals(this.val3, that.val3) &&
                Objects.equals(this.val4, that.val4));
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 31;

        int hashCode = val1 != null ? val1.hashCode() : 0;
        hashCode = hashCode*PRIME + (val2 != null ? val2.hashCode() : 0);
        hashCode = hashCode*PRIME + (val3 != null ? val3.hashCode() : 0);
        hashCode = hashCode*PRIME + (val4 != null ? val4.hashCode() : 0);

        return hashCode;
    }

    @Override
    public String toString()
    {
        return "Quadruple{" + val1 + ", " + val2 + ", " + val3 + ", " + val4 + "}";
    }
}
