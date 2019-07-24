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
        testLevel(base);
        testNotes(base);
        testKnows(base);
    }

    private void testKnows(GmatDataBase base) {
        KnowsDao knowsDao = base.getKnowsDao();
        knowsDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Knows>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Knows> datas) {
                        printeDatas(datas);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("===SingleError",e.getMessage());
                    }
                });
    }

    /**
     * 打印Data
     * @param datas
     */
    private void printeDatas(List<?> datas) {
        for (int i = 0;i<datas.size();i++){
            String s = datas.get(i).toString();
            Log.e("===",s);
        }
    }

    private void testNotes(GmatDataBase base) {
        NoteDao noteDao = base.noteDao();
        noteDao.getNote(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Note>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Note note) {
                        Log.d("===SingleSuccess",note == null ? "not is null" :note.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("===SingleError",e.getMessage());
                    }
                });
    }

    private void testLevel(GmatDataBase base) {
        LevelDao levelDao = base.levelDao();
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
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return getClass().getSimpleName();
    }
}
