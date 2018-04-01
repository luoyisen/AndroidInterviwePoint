package yincheng.androidinterviwepoint.ui.activity.simpleactivity;

import java.util.List;

import static yincheng.androidinterviwepoint.provider.GlobalConfigInJava.ArchitectureList;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 17:37
 * Github : yincheng.luo
 */

public class ArchitectureActivity extends GenericActivityWithRecyclerView {
    @Override
    protected boolean isClickStartActivity() {
        return true;
    }

    @Override
    protected List fillData() {
        return ArchitectureList;
    }
}
