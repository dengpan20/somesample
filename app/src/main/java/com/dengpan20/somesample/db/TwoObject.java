package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Paddy
 * @time 2019-07-23 22:50
 * @class describe
 */
@Entity(tableName = "x2_twoobject")
public class TwoObject {
    @PrimaryKey
    @ColumnInfo
    private int twoobjectid;
    @ColumnInfo
    private String twoobjecttype;
    @ColumnInfo
    private int twoobjectsort;
    @ColumnInfo
    private int twoobjectchoice;

    public int getTwoobjectid() {
        return twoobjectid;
    }

    public void setTwoobjectid(int twoobjectid) {
        this.twoobjectid = twoobjectid;
    }

    public String getTwoobjecttype() {
        return twoobjecttype;
    }

    public void setTwoobjecttype(String twoobjecttype) {
        this.twoobjecttype = twoobjecttype;
    }

    public int getTwoobjectsort() {
        return twoobjectsort;
    }

    public void setTwoobjectsort(int twoobjectsort) {
        this.twoobjectsort = twoobjectsort;
    }

    public int getTwoobjectchoice() {
        return twoobjectchoice;
    }

    public void setTwoobjectchoice(int twoobjectchoice) {
        this.twoobjectchoice = twoobjectchoice;
    }
}
