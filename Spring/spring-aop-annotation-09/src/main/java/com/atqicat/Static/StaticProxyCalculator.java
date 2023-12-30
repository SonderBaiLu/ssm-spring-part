package com.atqicat.Static;

import com.atqicat.Concluiator;

public class StaticProxyCalculator implements Concluiator {
    private Concluiator concluiator;
    // 使用构造方法 传入 目标(房东)
    public StaticProxyCalculator(Concluiator concluiator){
        this.concluiator = concluiator;
    }
    @Override
    public int add(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        concluiator.add(1,1);
        return 0;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
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
