package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

/**
 * @author Paddy
 * @time 2019-07-23 21:53
 * @class describe
 */
@Entity(tableName = "x2_questions")
public class Questions {
    @PrimaryKey
    @ColumnInfo
    private int questionid;
    @ColumnInfo
    private int questiontype;
    @ColumnInfo
    private int question;
    @ColumnInfo
    private int questiontitle;
    @ColumnInfo
    private int questionuserid;
    @ColumnInfo
    private String questionusername;
    @ColumnInfo
    private String questionlastmodifyuser;
    @ColumnInfo
    private String questionselect;
    @ColumnInfo
    private int questionselectnumber;
    @ColumnInfo
    private String questionanswer;
    @ColumnInfo
    private String questiondescribe;
    @ColumnInfo
    private String questionknowsid;
    @ColumnInfo
    private int questioncreatetime;
    @ColumnInfo
    private int questionstatus;
    @ColumnInfo
    private String questionhtml;
    @ColumnInfo
    private int questionparent;
    @ColumnInfo
    private int questionsequence;
    @ColumnInfo
    private int questionlevel;
    @ColumnInfo
    private int oneobjecttype;
    @ColumnInfo
    private int twoobjecttype;
    @ColumnInfo
    private int subjecttype;
    @ColumnInfo
    private int sectiontype;
    @ColumnInfo
    private String questionarticle;
    @ColumnInfo
    private String articletitle;
    @ColumnInfo
    private String mathfoundation;
    @ColumnInfo
    private int views;
    @ColumnInfo
    private int comments;
    @ColumnInfo
    private Date discusstime;
    @ColumnInfo
    private int discussmark;
    @ColumnInfo
    private int readArticleId;
    @ColumnInfo
    private String articleContent;
    @ColumnInfo
    private int questionNumber;
    @ColumnInfo
    private int questionNumber1;
    @ColumnInfo
    private String offer;
    @ColumnInfo
    private int isoffer;
    @ColumnInfo
    private int isOG;
    @ColumnInfo
    private int questionNumber2;
    @ColumnInfo
    private int questionNumber3;
    @ColumnInfo
    private int questionNumber4;
    @ColumnInfo
    private int questionNumber5;
    @ColumnInfo
    private int questionNumber6;

}
