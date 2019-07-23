package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;

/**
 * Author: Paddy
 * Date: 2019/7/23 11:06
 * Description:
 */
@Entity(tableName = "x2_level")
public class Level {
    @PrimaryKey
    @ColumnInfo
    private int levelid;
    @ColumnInfo
    @NotNull
    private String level;

    public int getLevelid() {
        return levelid;
    }

    public void setLevelid(int levelid) {
        this.levelid = levelid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Level{" +
                "levelid=" + levelid +
                ", level='" + level + '\'' +
                '}';
    }
}
