package yincheng.androidinterviwepoint.provider.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yincheng.androidinterviwepoint.R;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 15:31
 * Github : yincheng.luo
 */

public class SingleTextAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public SingleTextAdapter(@Nullable List<String> data) {
        super(R.layout.item_single_text, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_desc, item);
    }
}
