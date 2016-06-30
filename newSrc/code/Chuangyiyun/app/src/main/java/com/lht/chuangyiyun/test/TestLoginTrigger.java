package com.lht.chuangyiyun.test;

import com.lht.chuangyiyun.interfaces.ITriggerCompare;

import java.io.Serializable;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.test
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> TestLoginTrigger
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/5/6.
 */
public enum TestLoginTrigger implements ITriggerCompare {
    A(1) , B(2);

    private final int tag;

    TestLoginTrigger(int i) {
        tag = i;
    }

    @Override
    public boolean equals(ITriggerCompare compare) {
        boolean b1 = compare.getClass().getName().equals(getClass().getName());
        boolean b2 = compare.getTag().equals(getTag());
        return b1&b2;
    }

    @Override
    public Object getTag() {
        return tag;
    }

    @Override
    public Serializable getSerializable() {
        return this;
    }

}
