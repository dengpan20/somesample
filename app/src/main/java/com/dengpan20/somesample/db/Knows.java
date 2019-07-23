package com.dengpan20.somesample.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Author: Paddy
 * Date: 2019/7/23 19:11
 * Description:
 */
@Entity
public class Knows {
    @PrimaryKey
    @ColumnInfo
    private int knowsid;
    @ColumnInfo
    private String knows;
    @ColumnInfo
    private int knowssectionid;
    @ColumnInfo
    private String knowsdescribe;
    @ColumnInfo(defaultValue = "1")
    private int knowsstatus;
}
