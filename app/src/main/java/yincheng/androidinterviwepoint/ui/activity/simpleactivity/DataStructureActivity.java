package yincheng.androidinterviwepoint.ui.activity.simpleactivity;

import java.util.List;

import static yincheng.androidinterviwepoint.provider.GlobalConfigInJava.DataStructureList;


/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 16:38
 * Github : yincheng.luo
 */

public class DataStructureActivity extends GenericActivityWithRecyclerView {

    @Override
    protected boolean isClickStartActivity() {
        return true;
    }

    @Override
    protected List<String> fillData() {
        return DataStructureList;
    }
}