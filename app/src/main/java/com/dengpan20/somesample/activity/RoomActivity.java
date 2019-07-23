package com.dengpan20.somesample.activity;

import android.os.Bundle;
import android.util.Log;
import com.dengpan20.somesample.R;
import com.dengpan20.somesample.base.BaseActivity;
import com.dengpan20.somesample.db.*;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RoomActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        GmatDataBase base = GmatDataBase.getInstance(this);
        LevelDao levelDao = base.levelDao();
        NoteDao noteDao = base.noteDao();
            levelDao.getLevel()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new SingleObserver<List<Level>>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onSuccess(List<Level> aLong) {
                    for (int i = 0;i<aLong.size();i++){
                        String s = aLong.get(i).toString();
                        Log.e("===",s);
                    }
                }

                @Override
                public void onError(Throwable e) {
                    Log.d("===SingleError",e.getMessage());
                }
            });

//        for (int i =0 ;i<2;i++){
//            Level level = new Level();
//            level.setLevel("jibie");
//            level.setLevelid(i+1);
//            levelDao.insert(level)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(new SingleObserver<Long>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//
//                }
//
//                @Override
//                public void onSuccess(Long aLong) {
//                    Log.d("===SingleSuccess",aLong+"");
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    Log.d("===SingleError",e.getMessage());
//                }
//            });
//
//        }


//        for (int i =0 ;i<2;i++){
//            Note note = new Note();
//            note.setContent("jibie");
//            note.setUserid(i+1);
//            noteDao.insert(note)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new SingleObserver<Long>() {
//                        @Override
//                        public void onSubscribe(Disposable d) {
//
//                        }
//
//                        @Override
//                        public void onSuccess(Long aLong) {
//                            Log.d("===SingleNoteSuccess",aLong+"");
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            Log.d("===SingleNoteError",e.getMessage());
//                        }
//                    });
//
//        }






    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return getClass().getSimpleName();
    }
}
