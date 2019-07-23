package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Paddy
 * @time 2019-07-23 22:53
 * @class describe
 */
@Entity(tableName = "x2_xuhao_question")
public class XuhaoQuestion {
    @PrimaryKey
    @ColumnInfo
    private int id;
    @ColumnInfo
    private int tikuId;
    @ColumnInfo
    private int questionid;
    @ColumnInfo
    private int createTIme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTikuId() {
        return tikuId;
    }

    public void setTikuId(int tikuId) {
        this.tikuId = tikuId;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public int getCreateTIme() {
        return createTIme;
    }

    public void setCreateTIme(int createTIme) {
        this.createTIme = createTIme;
    }
}
