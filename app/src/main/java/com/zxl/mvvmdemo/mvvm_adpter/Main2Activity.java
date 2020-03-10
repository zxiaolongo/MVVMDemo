package com.zxl.mvvmdemo.mvvm_adpter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.zxl.mvvmdemo.R;
import com.zxl.mvvmdemo.databinding.ActivityMain2Binding;
import com.zxl.mvvmdemo.mvvm_adpter.adpter.MyBindingAdapter;
import com.zxl.mvvmdemo.mvvm_adpter.bean.NewsEntity;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ActivityMain2Binding viewDataBinding;
    MyBindingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        initRv();

    }

    private void initRv() {
        RecyclerView mRcycleView = viewDataBinding.rvList;
        mRcycleView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyBindingAdapter(this);
        mRcycleView.setAdapter(adapter);
        adapter.refreshData(moniData());
    }

    private List<NewsEntity> moniData(){
        final List<NewsEntity> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NewsEntity entity = new NewsEntity();
            switch (i % 3) {
                case 0:
                    entity.setImageUrls(new String[]{
                            "http://img1.gtimg.com/19/1967/196723/19672355_980x640_281.jpg",
                            "http://img1.gtimg.com/19/1967/196723/19672354_980x640_281.jpg",
                            "http://img1.gtimg.com/19/1967/196723/19672357_980x640_281.jpg"
                    });
                    break;
                case 1:
                    break;
                case 2:
                    entity.setImageUrls(new String[]{
                            "http://img1.gtimg.com/19/1967/196723/19672356_980x640_281.jpg"
                    });
                    break;
            }
            entity.setContent("视觉中国讯 近日，章子怡现身某会场。章子怡走出休息室心情不错，被粉丝围观面带微笑十分从容。");
            entity.setDateStr("2017年5月23日");
            entity.setNiceCount(100);
            data.add(entity);

        }
        return data;
    }
}
