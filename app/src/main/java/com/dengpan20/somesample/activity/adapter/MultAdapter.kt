package com.dengpan20.somesample.activity.adapter

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dengpan20.somesample.R
import com.dengpan20.somesample.bean.FunBean
import com.dengpan20.somesample.bean.MultBean

/**

 * Author: Paddy
 * Date: 2020/3/19 14:03
 * Description:
 *
 */

class MultAdapter(data: List<MultBean>?) :
    BaseMultiItemQuickAdapter<MultBean, BaseViewHolder>(data) {
    init {
        addItemType(MultBean.TYPE_TITLE, R.layout.item_layout_fun_name)
        addItemType(MultBean.TYPE_CONTENT, R.layout.pop_recycler)
    }

    override fun convert(helper: BaseViewHolder, item: MultBean) {
        when(item.itemType){
            MultBean.TYPE_TITLE->setTitle(helper,item)
            MultBean.TYPE_CONTENT->setContent(helper,item)
        }
    }

    private fun setContent(helper: BaseViewHolder, item: MultBean) {
        val listAdapter = FunListAdapter()
        val recyclerView = helper.getView<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = GridLayoutManager(helper.itemView.context,3)
        recyclerView.adapter = listAdapter
        listAdapter.replaceData(item.data)
    }

    private fun setTitle(helper: BaseViewHolder, item: MultBean) {
        helper.apply {
            setText(R.id.tvName,item.title)
        }
    }

}