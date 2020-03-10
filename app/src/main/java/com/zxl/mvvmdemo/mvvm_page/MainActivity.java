package com.zxl.mvvmdemo.mvvm_page;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zxl.mvvmdemo.R;
import com.zxl.mvvmdemo.databinding.ActivityMainBinding;
import com.zxl.mvvmdemo.mvvm_adpter.Main2Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("李二牛","15845698752");
        user.setUrl("http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIP7Xl7FtM5RPcqL1hQVzO6ffNtmoAKQfOJibsT04Nl5fa2QYI4Yc68QgJTlxcjAjnwHIo3Q5LX0tA/132");
//"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIP7Xl7FtM5RPcqL1hQVzO6ffNtmoAKQfOJibsT04Nl5fa2QYI4Yc68QgJTlxcjAjnwHIo3Q5LX0tA/132"
        mainBinding.setUser(user);
        mainBinding.setHandle(this);

    }
    /**
     * mv_vm 绑定的click事件
     *
     * @param view view
     *一定要加参数 view 否则编译期间找不到 goMain2
     */
    public void goMain2(View view){
        mainBinding.getUser().setName("hahhaha");
        startActivity(new Intent(this,Main2Activity.class));
//        if (mainBinding.getUser() == null){
//            User user = new User("李二牛","15845698752");
//            mainBinding.setUser(user);
//        }else {
//            mainBinding.setUser(null);
//        }
    }
}
