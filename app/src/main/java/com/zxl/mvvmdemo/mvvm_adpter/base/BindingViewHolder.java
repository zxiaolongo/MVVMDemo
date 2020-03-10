package com.zxl.mvvmdemo.mvvm_adpter.base;


import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BindingViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
    /**
     * viewDataBinding
     */
    private B mBinding;

    /**
     * constructor
     *
     * @param binding viewDataBinding
     */
    public BindingViewHolder(B binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    /**
     * @return viewDataBinding
     */
    public B getBinding() {
        return mBinding;
    }

}
