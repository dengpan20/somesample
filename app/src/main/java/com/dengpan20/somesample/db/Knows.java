package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Author: Paddy
 * Date: 2019/7/23 19:11
 * Description:
 */
@Entity(tableName = "x2_knows")
public class Knows {
    @PrimaryKey
    @ColumnInfo
    private int knowsid;
    @ColumnInfo
    private String knows;
    @ColumnInfo
    private int knowssectionid;
    @ColumnInfo
    private String knowsdescribe;
    @ColumnInfo(defaultValue = "1")
    private int knowsstatus;

    public int getKnowsid() {
        return knowsid;
    }

    public void setKnowsid(int knowsid) {
        this.knowsid = knowsid;
    }

    public String getKnows() {
        return knows;
    }

    public void setKnows(String knows) {
        this.knows = knows;
    }

    public int getKnowssectionid() {
        return knowssectionid;
    }

    public void setKnowssectionid(int knowssectionid) {
        this.knowssectionid = knowssectionid;
    }

    public String getKnowsdescribe() {
        return knowsdescribe;
    }

    public void setKnowsdescribe(String knowsdescribe) {
        this.knowsdescribe = knowsdescribe;
    }

    public int getKnowsstatus() {
        return knowsstatus;
    }

    public void setKnowsstatus(int knowsstatus) {
        this.knowsstatus = knowsstatus;
    }


    @Override
    public String toString() {
        return "Knows{" +
                "knowsid=" + knowsid +
                ", knows='" + knows + '\'' +
                ", knowssectionid=" + knowssectionid +
                ", knowsdescribe='" + knowsdescribe + '\'' +
                ", knowsstatus=" + knowsstatus +
                '}';
    }
}
