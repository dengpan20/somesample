package com.dengpan20.somesample;

import android.app.Application;
import android.content.Intent;
import androidx.room.DatabaseConfiguration;
import com.dengpan20.somesample.db.DBManager;
import com.dengpan20.somesample.db.DBService;
import com.dengpan20.somesample.db.GmatDataBase;

/**
 * Author: Paddy
 * Date: 2019/7/23 16:33
 * Description:
 */
public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        deleteDatabase(DBManager.DB_NAME);
        Intent intent = new Intent(this, DBService.class);
        startService(intent);
//        GmatDataBase.getInstance(this);
    }
}
