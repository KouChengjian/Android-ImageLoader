package com.imageloader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * Created by kouchengjian on 17/3/18.
 */
public class IOUtil {

    public static void outputStreamClose (BufferedOutputStream out){
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inputStreamClose (BufferedInputStream inputStream){
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
