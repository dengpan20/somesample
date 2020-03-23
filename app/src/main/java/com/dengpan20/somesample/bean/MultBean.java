package com.dengpan20.somesample.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Author: Paddy
 * Date: 2020/3/19 14:06
 * Description:
 */
public class MultBean implements MultiItemEntity {
    public final static int TYPE_TITLE = 1;
    public final static int TYPE_CONTENT = 2;
    private int type;
    private String title;
    private List<FunBean> data;

    public MultBean(int type, String title, List<FunBean> data) {
        this.type = type;
        this.title = title;
        this.data = data;
    }

    @Override
    public int getItemType() {
        return type;
    }
    public void setItemType(int type){
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FunBean> getData() {
        return data;
    }

    public void setData(List<FunBean> data) {
        this.data = data;
    }
}
