package com.dengpan20.somesample.util;

import android.content.Context;

import java.io.*;

/**
 * @author Paddy
 * @time 2019-09-01 20:43
 * @class describe
 */
public class FileUtil {

    public static String getFile(Context context,String name){
        try {
            InputStream open = context.getAssets().open(name);
            InputStreamReader inputStreamReader = new InputStreamReader(open);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder builder = new StringBuilder();
            String text;
            while ((text = bufferedReader.readLine())!= null){
                builder.append(text);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
