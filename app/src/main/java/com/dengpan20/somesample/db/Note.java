package com.dengpan20.somesample.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Author: Paddy
 * Date: 2019/7/23 10:53
 * Description:
 */
@Entity(tableName = "x2_user_question_note")
public class Note {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id",typeAffinity = 3)
    private int id;
    @ColumnInfo
    private String content;
    @ColumnInfo
    @NotNull
    private int saveId;
    @ColumnInfo
    private int createTime;
    @ColumnInfo(defaultValue = "1")
    private int type;
    @ColumnInfo
    private int updateTime;
    @ColumnInfo
    private int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSaveId() {
        return saveId;
    }

    public void setSaveId(int saveId) {
        this.saveId = saveId;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
