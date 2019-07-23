package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Paddy
 * @time 2019-07-23 22:48
 * @class describe
 */
@Entity(tableName = "x2_sections")
public class Sections {
    @PrimaryKey
    @ColumnInfo
    private int sectionid;
    @ColumnInfo
    private String section;
    @ColumnInfo
    private int sectionsubjectid;
    @ColumnInfo
    private String sectiondescribe;


    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getSectionsubjectid() {
        return sectionsubjectid;
    }

    public void setSectionsubjectid(int sectionsubjectid) {
        this.sectionsubjectid = sectionsubjectid;
    }

    public String getSectiondescribe() {
        return sectiondescribe;
    }

    public void setSectiondescribe(String sectiondescribe) {
        this.sectiondescribe = sectiondescribe;
    }
}
