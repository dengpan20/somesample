package com.dengpan20.somesample.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Single;

/**
 * Author: Paddy
 * Date: 2019/7/23 10:52
 * Description:
 */
@Dao
public interface NoteDao {

    @Insert
    Single<Long> insert(Note note);
    @Query("SELECT * FROM X2_USER_QUESTION_NOTE WHERE id = :id ")
    Single<Note> getNote(int id);
}
