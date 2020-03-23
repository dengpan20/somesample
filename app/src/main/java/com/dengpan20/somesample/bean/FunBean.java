package com.dengpan20.somesample.bean;

import java.io.Serializable;

/**
 * Author: Paddy
 * Date: 2020/3/19 11:01
 * Description:实例名称
 */
public class FunBean implements Serializable {

    private int pos;
    private String name;

    public FunBean(int pos, String name) {
        this.pos = pos;
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
