package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Paddy
 * @time 2019-07-23 22:55
 * @class describe
 */
@Entity(tableName = "x2_xuhao_tiku")
public class XuhaoTiku {
    @PrimaryKey
    @ColumnInfo
    private int id;
    @ColumnInfo
    private int name;
    @ColumnInfo
    private int twoobject;
    @ColumnInfo
    private int section;
    @ColumnInfo
    private int createTime;
    @ColumnInfo
    private int number;
    @ColumnInfo
    private int sort;
    @ColumnInfo
    private int type;
    @ColumnInfo
    private int orderNumber;
    @ColumnInfo
    private int livesdk;
    @ColumnInfo
    private int pass;
    @ColumnInfo
    private int duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getTwoobject() {
        return twoobject;
    }

    public void setTwoobject(int twoobject) {
        this.twoobject = twoobject;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getLivesdk() {
        return livesdk;
    }

    public void setLivesdk(int livesdk) {
        this.livesdk = livesdk;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
