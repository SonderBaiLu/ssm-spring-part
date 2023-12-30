package com.atqicat;

import com.atqicat.Static.StaticProxyCalculator;

public class ConcluiatorImpl implements Concluiator{
    @Override
    public int add(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int result = i + j;
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
