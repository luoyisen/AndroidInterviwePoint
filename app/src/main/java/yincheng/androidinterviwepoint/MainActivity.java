package yincheng.androidinterviwepoint;

import java.util.List;

import yincheng.androidinterviwepoint.adapter.DataServer;
import yincheng.androidinterviwepoint.adapter.Status;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 13:51
 * Github : yincheng.luo
 */

public class MainActivity extends GenericActivityWithRecyclerView {

    @Override
    protected List<Status> fillData() {
        return DataServer.getSampleData(100);
    }
}