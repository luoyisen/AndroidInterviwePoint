package yincheng.androidinterviwepoint.adapter;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 12:33
 * Github : yincheng.luo
 */

public class MySection extends SectionEntity<Video> {
    private boolean isMore;
    public MySection(boolean isHeader, String header, boolean isMroe) {
        super(isHeader, header);
        this.isMore = isMroe;
    }

    public MySection(Video t) {
        super(t);
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean mroe) {
        isMore = mroe;
    }
}

