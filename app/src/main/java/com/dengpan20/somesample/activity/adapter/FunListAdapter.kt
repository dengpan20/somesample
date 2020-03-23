package com.dengpan20.somesample.activity.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dengpan20.somesample.R
import com.dengpan20.somesample.bean.FunBean

/**

 * Author: Paddy
 * Date: 2020/3/19 10:57
 * Description:
 *
 */
class FunListAdapter : BaseQuickAdapter<FunBean, BaseViewHolder>(R.layout.item_layout_fun_name) {
    override fun convert(helper: BaseViewHolder, item: FunBean) {
        helper.apply {
            setText(R.id.tvName,item.name)
        }
    }

}