package com.dengpan20.somesample.data;

import com.dengpan20.somesample.bean.CateBean;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paddy
 * @time 2019-07-24 22:59
 * @class describe
 */
public class DataUtil {
    @Nullable
    public static List<CateBean> getData(int num) {
        List<CateBean> beans = new ArrayList<>();
        for (int i = 0;i< num;i++){
            beans.add(new CateBean());
        }
        return beans;
    }
}
