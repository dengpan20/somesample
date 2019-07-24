package com.dengpan20.somesample.db;

import androidx.room.Dao;
import androidx.room.Query;
import io.reactivex.Single;

import java.util.List;

/**
 * Author: Paddy
 * Date: 2019/7/24 15:22
 * Description:
 */
@Dao
public interface KnowsDao {

    @Query("SELECT * FROM X2_KNOWS")
    Single<List<Knows>> getAll();
}
