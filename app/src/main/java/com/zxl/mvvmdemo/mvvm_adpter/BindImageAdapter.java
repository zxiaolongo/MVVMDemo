package com.zxl.mvvmdemo.mvvm_adpter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

/**
 * Created by mj
 * on 2017/5/22.
 */

public class BindImageAdapter {
    /**
     * mv_vm xml 传入url 加载图片
     * imageUrl 为xml中 的命名
     *notice 记得加上网络请求权限
     * @param iv   imageView
     * @param path 图片路径
     */
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView iv, String path) {
        Glide.with(iv.getContext()).load(path).into(iv);
    }


//    @BindingAdapter({"app:imageUrl", "app:placeHolder", "app:error"})
//    public static void loadImage(ImageView imageView, String url, int holderDrawable, int errorDrawable) {
//        Glide.with(imageView.getContext())
//                .load(url)
//                .placeholder(holderDrawable)
//                .error(errorDrawable)
//                .into(imageView);
//    }


    /**
     * mv_vm xml 设置 mipmap Resource
     *
     * @param iv    imageView
     * @param resId resource id
     */
    @BindingAdapter({"resId"})
    public static void loadMipmapResource(ImageView iv, int resId) {
        iv.setImageResource(resId);
    }

}
