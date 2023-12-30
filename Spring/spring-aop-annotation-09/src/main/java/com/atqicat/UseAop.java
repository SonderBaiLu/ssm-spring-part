package com.atqicat;

import com.atqicat.Static.StaticProxyCalculator;

public class UseAop {
    public static void main(String [] args){
        //房东
        Concluiator tar = new ConcluiatorImpl();
        //中介 代理
        Concluiator proxy = new StaticProxyCalculator(tar);
        int add = proxy.add(1,3);
        System.out.println("add = " + add);
   //useAop -老板-宗介 -->宗介 -->l老板-->宗介-->输出
    }
}
