package com.dengpan20.somesample.db;

import java.util.Date;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Paddy
 * @time 2019-07-23 21:38
 * @class describe
 */
@Entity
public class NetPars {
    @PrimaryKey
    @ColumnInfo
    private int parsid;
    @ColumnInfo
    private int userid;
    @ColumnInfo
    private Date  p_time;
    @ColumnInfo
    private String p_content;
    @ColumnInfo
    private int p_audit;
    @ColumnInfo
    private int price;
    @ColumnInfo
    private int p_type;
    @ColumnInfo
    private int p_questionid;


    public int getParsid() {
        return parsid;
    }

    public void setParsid(int parsid) {
        this.parsid = parsid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getP_time() {
        return p_time;
    }

    public void setP_time(Date p_time) {
        this.p_time = p_time;
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content;
    }

    public int getP_audit() {
        return p_audit;
    }

    public void setP_audit(int p_audit) {
        this.p_audit = p_audit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getP_type() {
        return p_type;
    }

    public void setP_type(int p_type) {
        this.p_type = p_type;
    }

    public int getP_questionid() {
        return p_questionid;
    }

    public void setP_questionid(int p_questionid) {
        this.p_questionid = p_questionid;
    }
}
