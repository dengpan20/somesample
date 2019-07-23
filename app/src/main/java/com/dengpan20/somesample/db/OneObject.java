package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Paddy
 * @time 2019-07-23 21:50
 * @class describe
 */

@Entity(tableName = "x2_oneobject")
public class OneObject {
    @PrimaryKey
    @ColumnInfo
    private int oneobjectid;
    @ColumnInfo
    private String oneobjecttype;
    @ColumnInfo
    private int oneobjectsort;
    @ColumnInfo
    private int oneobjectchoice;

    public int getOneobjectid() {
        return oneobjectid;
    }

    public void setOneobjectid(int oneobjectid) {
        this.oneobjectid = oneobjectid;
    }

    public String getOneobjecttype() {
        return oneobjecttype;
    }

    public void setOneobjecttype(String oneobjecttype) {
        this.oneobjecttype = oneobjecttype;
    }

    public int getOneobjectsort() {
        return oneobjectsort;
    }

    public void setOneobjectsort(int oneobjectsort) {
        this.oneobjectsort = oneobjectsort;
    }

    public int getOneobjectchoice() {
        return oneobjectchoice;
    }

    public void setOneobjectchoice(int oneobjectchoice) {
        this.oneobjectchoice = oneobjectchoice;
    }
}
