package com.example.a64.menuapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by 64 on 10/12/2016.
 */

public class ImageAdapter extends BaseAdapter {

    private  Context context;

    public ImageAdapter(Context context){
        this.context = context;

    }

    private  int[] dataset = {
            R.drawable.img_1,  R.drawable.img_2,
            R.drawable.img_3,  R.drawable.img_4,
            R.drawable.img_5,  R.drawable.img_6,
            R.drawable.img_7,  R.drawable.img_8,
            R.drawable.img_9,  R.drawable.img_10
    };

    @Override
    public int getCount() {
        return dataset.length;
    }

    @Override
    public Integer getItem(int position) {
        return dataset[position];
    }

    @Override
    public long getItemId(int position) {
        return dataset[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),dataset[position] );
        ImageView imageView = new ImageView(context);
        //imageView.setImageResource(dataset[position]);
        imageView.setImageBitmap(scaleBitmap(bitmap));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 200));
        return imageView;
    }

    public Bitmap scaleBitmap(Bitmap mBitmap) {
        int ScaleSize = 250;//max Height or width to Scale
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        float excessSizeRatio = width > height ? width / ScaleSize : height / ScaleSize;
        Bitmap bitmap = Bitmap.createBitmap(
                mBitmap, 0, 0,(int) (width/excessSizeRatio),(int) (height/excessSizeRatio));
        //mBitmap.recycle(); if you are not using mBitmap Obj
        return bitmap;
    }

}
