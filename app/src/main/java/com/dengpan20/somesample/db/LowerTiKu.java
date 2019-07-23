package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Author: Paddy
 * Date: 2019/7/23 19:18
 * Description:
 */
@Entity
public class LowerTiKu {
    @PrimaryKey
    @ColumnInfo
    private int stid;
    @ColumnInfo
    private int subjectid;
    @ColumnInfo
    private int twoobjectid;
    @ColumnInfo
    private int sectionid;
    @ColumnInfo
    private int knowsid;
    @ColumnInfo
    private String stname;
    @ColumnInfo
    private String questionid;
    @ColumnInfo
    private int type;
    @ColumnInfo
    private int levelid;

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public int getTwoobjectid() {
        return twoobjectid;
    }

    public void setTwoobjectid(int twoobjectid) {
        this.twoobjectid = twoobjectid;
    }

    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }

    public int getKnowsid() {
        return knowsid;
    }

    public void setKnowsid(int knowsid) {
        this.knowsid = knowsid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevelid() {
        return levelid;
    }

    public void setLevelid(int levelid) {
        this.levelid = levelid;
    }
}
