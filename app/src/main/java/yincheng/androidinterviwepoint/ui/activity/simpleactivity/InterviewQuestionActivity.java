package yincheng.androidinterviwepoint.ui.activity.simpleactivity;

import java.util.List;

import static yincheng.androidinterviwepoint.provider.GlobalConfigInJava.InterviewQuestionList;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 17:00
 * Github : yincheng.luo
 */

public class InterviewQuestionActivity extends GenericActivityWithRecyclerView {

    @Override
    protected boolean isClickStartActivity() {
        return false;
    }

    @Override
    protected List<String> fillData() {
        return InterviewQuestionList;
    }
}