package com.zxl.mvvmdemo.mvvm_adpter.adpter;

import android.content.Context;
import android.view.ViewGroup;

import com.zxl.mvvmdemo.BR;
import com.zxl.mvvmdemo.R;
import com.zxl.mvvmdemo.ToastUtils;
import com.zxl.mvvmdemo.mvvm_adpter.base.BaseBindingAdapter;
import com.zxl.mvvmdemo.mvvm_adpter.base.BindingViewHolder;
import com.zxl.mvvmdemo.mvvm_adpter.bean.NewsEntity;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public class MyBindingAdapter extends BaseBindingAdapter<NewsEntity,BindingViewHolder> {
    /**
     * 没有图片的item 类型
     */
    private final int NO_PIC = 0;
    /**
     * 有一张图片的item 类型
     */
    private final int ONE_PIC = 1;
    /**
     * 更多图片的item 类型
     */
    private final int MORE_PIC = 2;
    /**
     * 根据图片数量判断item 的类型
     *
     * @param position position
     * @return itemType
     */
    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).getPicNum() == 0) {
            return NO_PIC;
        } else if (mList.get(position).getPicNum() == 1) {
            return ONE_PIC;
        } else {
            return MORE_PIC;
        }
    }
    public MyBindingAdapter(Context context) {
        super(context);
    }

    @Override
    public BindingViewHolder onCreateVH(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = null;
        switch (viewType) {
            case NO_PIC:
                viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.mv_vm_item_text, parent, false);
                break;
            case ONE_PIC:
                viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.mv_vm_item_one_pic, parent, false);
                break;
            case MORE_PIC:
                viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.mv_vm_item_more_pic, parent, false);
                break;
        }
        return new BindingViewHolder<>(viewDataBinding);
    }

    @Override
    public void onBindVH(BindingViewHolder bindingViewHolder, int position) {
        bindingViewHolder.getBinding().setVariable(BR.newsEntity, mList.get(position));
        bindingViewHolder.getBinding().setVariable(BR.handle, this);
        bindingViewHolder.getBinding().setVariable(BR.position, position);
        //防止闪烁
        bindingViewHolder.getBinding().executePendingBindings();
    }
    /**
     * 点赞
     *
     * @param newsEntity entity
     */
    public void thumbUpClick(NewsEntity newsEntity, int position) {
        if (newsEntity.isNice()) {
            newsEntity.setNice(false);
            newsEntity.setNiceCount(newsEntity.getNiceCount() - 1);
            ToastUtils.show(mContext, "取消点赞 position=" + position);
        } else {
            newsEntity.setNice(true);
            newsEntity.setNiceCount(newsEntity.getNiceCount() + 1);
            ToastUtils.show(mContext, "点赞成功 position=" + position);
        }
    }
}
