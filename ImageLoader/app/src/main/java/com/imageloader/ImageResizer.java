package com.imageloader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.FileDescriptor;

/**
 * Created by kouchengjian on 17/3/17.
 * 图片压缩
 */
public class ImageResizer {

    private static final String TAG = "ImageResizer";

    public ImageResizer(){

    }

    public Bitmap decodeSampledBitmapFromResource(Resources res , int resId , int reqWidth , int reqHeight){
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res , resId , options);

        options.inSampleSize = calculateInSampleSize (options ,reqWidth , reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res , resId , options);
    }

    public Bitmap decodeSampledBitmapFromFileDescriptor(FileDescriptor fd, int reqWidth , int reqHeight){
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fd , null , options);

        options.inSampleSize = calculateInSampleSize (options ,reqWidth , reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fd , null , options);
    }

    public int calculateInSampleSize(BitmapFactory.Options option , int reqWidth , int reqHeight){
        if(reqWidth == 0 || reqHeight == 0){
            return 1;
        }

        final int heighe = option.outHeight;
        final int width = option.outWidth;

        int inSampleSize = 1;

        if(heighe > reqHeight || width > reqWidth){

            final int halfHeight = heighe / 2;
            final int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) >= reqHeight &&
                    (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }

            Log.d(TAG,"inSampleSize = " + inSampleSize);
        }
        return inSampleSize;
    }

}
