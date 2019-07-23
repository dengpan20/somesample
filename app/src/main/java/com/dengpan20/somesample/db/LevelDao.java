package com.dengpan20.somesample.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Single;

import java.util.List;

/**
 * Author: Paddy
 * Date: 2019/7/23 11:09
 * Description:
 */
@Dao
public interface LevelDao {
    @Insert
    Single<Long> insert(Level level);
    @Query("SELECT *,'livelid' FROM x2_level")
    Single<List<Level>> getLevel();
}
