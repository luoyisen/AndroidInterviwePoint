package yincheng.androidinterviwepoint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yincheng.androidinterviwepoint.adapter.GenericTextAdapter;
import yincheng.androidinterviwepoint.adapter.Status;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 13:51
 * Github : yincheng.luo
 */

public abstract class GenericActivityWithRecyclerView<T extends List<Status>> extends AppCompatActivity {

    @BindView(R.id.rv_generic)
    RecyclerView genericRecyclerView;

    private T data;
    public GenericTextAdapter genericTextAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recyclerview);
        ButterKnife.bind(this);
        //填充数据
        data = fillData();
        initAdapter();
        initView();
    }

    protected abstract T fillData();

    private void initAdapter() {
        genericRecyclerView.setHasFixedSize(true);// TODO: 2018/4/1
        genericRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        genericTextAdapter = new GenericTextAdapter(data);
        genericTextAdapter.openLoadAnimation();
        genericTextAdapter.setNotDoAnimationCount(3);
        genericTextAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(GenericActivityWithRecyclerView.this, "我的天安", Toast.LENGTH_SHORT).show();
            }
        });
//        genericTextAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                String content = null;
//                Status status = (Status) adapter.getItem(position);
//                switch (view.getId()) {
//                    case R.id.img:
//                        content = "img:" + status.getUserAvatar();
//                        Toast.makeText(GenericActivityWithRecyclerView.this, content, Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.tweetName:
//                        content = "name:" + status.getUserName();
//                        Toast.makeText(GenericActivityWithRecyclerView.this, content, Toast.LENGTH_LONG).show();
//                        break;
//                    case R.id.tweetText:
//                        content = "tweetText:" + status.getUserName();
//                        Toast.makeText(GenericActivityWithRecyclerView.this, content, Toast.LENGTH_LONG).show();
//                        // you have set clickspan .so there should not solve any click event ,just empty
//                        break;
//
//                }
//            }
//        });
        genericRecyclerView.setAdapter(genericTextAdapter);
    }


    private void initView() {

    }


}
