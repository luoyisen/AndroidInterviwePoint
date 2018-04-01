package yincheng.androidinterviwepoint.ui.activity.simpleactivity;

import java.util.List;

import static yincheng.androidinterviwepoint.provider.GlobalConfigInJava.MainList;


/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 13:51
 * Github : yincheng.luo
 */

public class MainActivity extends GenericActivityWithRecyclerView {

    @Override
    protected boolean isClickStartActivity() {
        return true;
    }

    @Override
    protected List<String> fillData() {
        return MainList;
    }
}