package com.dengpan20.somesample.pop.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dengpan20.somesample.R;
import com.dengpan20.somesample.bean.CateBean;

/**
 * @author Paddy
 * @time 2019-07-24 22:49
 * @class describe
 */
public class PopComAdapter extends BaseQuickAdapter<CateBean, BaseViewHolder> {
    public PopComAdapter() {
        super(R.layout.item_com_pop);
    }

    @Override
    protected void convert(BaseViewHolder helper, CateBean item) {

    }
}
