package yincheng.androidinterviwepoint.ui.activity.simpleactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yincheng.androidinterviwepoint.R;
import yincheng.androidinterviwepoint.provider.adapter.SingleTextAdapter;
import yincheng.androidinterviwepoint.ui.dialogfragment.ShowWorkingResultDialogFragment;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 13:51
 * Github : yincheng.luo
 */

public abstract class GenericActivityWithRecyclerView<T extends List> extends AppCompatActivity {

    private boolean isJumpWithClassName = false;
    private ShowWorkingResultDialogFragment showWorkingResultDialogFragment;
    @BindView(R.id.rv_generic)
    RecyclerView genericRecyclerView;

    private T data;
    public SingleTextAdapter singleTextAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recyclerview);
        ButterKnife.bind(this);
        data = fillData();
        isJumpWithClassName = isClickStartActivity();
        initAdapter();
        initView();
    }

    protected abstract boolean isClickStartActivity();

    protected abstract T fillData();

    private void initAdapter() {
        genericRecyclerView.setHasFixedSize(true);// TODO: 2018/4/1
        genericRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        singleTextAdapter = new SingleTextAdapter(data);
        singleTextAdapter.openLoadAnimation();
        singleTextAdapter.setNotDoAnimationCount(3);
        singleTextAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (isJumpWithClassName) {
                    try {
                        startActivity(new Intent(GenericActivityWithRecyclerView.this, Class.forName("yincheng.androidinterviwepoint.ui.activity.simpleactivity." + data.get(position) + "Activity")));
                    } catch (ClassNotFoundException e) {
                        // TODO: 2018/4/1 日志收集，打印到文件里面
                        e.printStackTrace();
                    }
                } else {
                    showResultDialogFragment();
                }
            }
        });
        genericRecyclerView.setAdapter(singleTextAdapter);
    }


    private void initView() {
        Window window = getWindow();
        window.setBackgroundDrawable(null);//绘制优化
    }

    private void showResultDialogFragment() {
        if (showWorkingResultDialogFragment == null) {
            showWorkingResultDialogFragment = new ShowWorkingResultDialogFragment();
        }

        if (showWorkingResultDialogFragment.getDialog() == null)
            showWorkingResultDialogFragment.show(getSupportFragmentManager(), "resultfragment");// TODO: 2018/4/1
        else
            showWorkingResultDialogFragment.getDialog().show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (showWorkingResultDialogFragment != null)
            showWorkingResultDialogFragment = null;
    }
}
