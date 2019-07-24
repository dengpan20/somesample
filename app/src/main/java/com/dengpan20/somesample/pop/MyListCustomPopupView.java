package com.dengpan20.somesample.pop;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dengpan20.somesample.R;
import com.dengpan20.somesample.bean.CateBean;
import com.dengpan20.somesample.pop.adapter.PopComAdapter;
import com.lxj.xpopup.impl.PartShadowPopupView;
import org.jetbrains.anko.ToastsKt;

import java.util.List;

/**
 * @author Paddy
 * @time 2019-07-24 22:46
 * @class describe
 */
public class MyListCustomPopupView extends PartShadowPopupView {
    private RecyclerView recycler;
    private PopComAdapter adapter;
    private List<CateBean> beans;
    public MyListCustomPopupView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.pop_recycler;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        recycler = findViewById(R.id.recycler);
        adapter= new PopComAdapter();
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);
        if(beans != null) adapter.replaceData(beans);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                ToastsKt.longToast(getContext(),"pos"+position);
                if(onDataSelected != null) onDataSelected.onSelect(adapter.getData().get(position));
            }
        });
    }


    public void setData(List<CateBean> list) {
        if(this.recycler != null)
        this.adapter.replaceData(list);
        this.beans = list;
    }
    public interface OnDataSelected{
        void onSelect(CateBean bean);
    }
    OnDataSelected onDataSelected;

    public void setOnDataSelected(OnDataSelected onDataSelected) {
        this.onDataSelected = onDataSelected;
    }
}
