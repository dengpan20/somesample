package com.dengpan20.somesample.db;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Nullable;

public class DBService extends IntentService {

    public DBService() {
        super("databasecopy");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("service","=== copy database start");
        DBManager dbManager = new DBManager(getApplicationContext());
        boolean copyDatabase = dbManager.copyDatabase();
        if (copyDatabase) {
//            SharedPref.saveDBStatus(getApplicationContext(), C.CONTROLLER_DB_UPDATE_VERSION);
            Log.d("service","=== copy database success");
        }
    }
}
