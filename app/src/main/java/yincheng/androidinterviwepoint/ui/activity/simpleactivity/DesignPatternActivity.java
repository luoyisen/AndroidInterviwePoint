package yincheng.androidinterviwepoint.ui.activity.simpleactivity;

import java.util.List;

import static yincheng.androidinterviwepoint.provider.GlobalConfigInJava.DesignPatternsList;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 18:29
 * Github : yincheng.luo
 */

public class DesignPatternActivity extends GenericActivityWithRecyclerView {
    @Override
    protected boolean isClickStartActivity() {
        return false;
    }

    @Override
    protected List fillData() {
        return DesignPatternsList;
    }
}
