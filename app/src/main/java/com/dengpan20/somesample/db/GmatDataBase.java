package com.dengpan20.somesample.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Author: Paddy
 * Date: 2019/7/23 10:52
 * Description:Gmat 的数据库
 */
@Database(entities ={Note.class,Level.class},version = 1 ,exportSchema = true)
public abstract class GmatDataBase extends RoomDatabase {
    private static volatile GmatDataBase INSTANCE;
    public abstract NoteDao noteDao();
    public abstract LevelDao levelDao();

    public static GmatDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (GmatDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GmatDataBase.class, "gmat.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
