package com.dengpan20.somesample.pop;

import com.dengpan20.somesample.bean.CateBean;
import com.lxj.xpopup.interfaces.XPopupCallback;

/**
 * @author Paddy
 * @time 2019-07-24 23:11
 * @class describe
 */
public  abstract class OnClikCallback implements XPopupCallback {
    @Override
    public void onCreated() {

    }

    @Override
    public void onShow() {

    }

    @Override
    public void onDismiss() {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    public abstract void onDataClick(CateBean bean);
}
