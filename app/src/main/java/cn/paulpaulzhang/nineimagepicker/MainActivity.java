package cn.paulpaulzhang.nineimagepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ImagePickerAdapter mAdapter;
    private View addView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_image_picker);
        initImagePicker();
    }

    private void initImagePicker() {
        mAdapter = new ImagePickerAdapter(R.layout.view_image_picker_item, new ArrayList<ImageItem>());
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        addView = View.inflate(this, R.layout.view_image_picker_add, null);
        addView.findViewById(R.id.iv_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加图片按钮的点击事件，可以打开相册等等
            }
        });

        mAdapter.setFooterViewAsFlow(true);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //图片点击事件，可以点击查看点图编辑图片等
            }
        });

        /**
         * 点击图片右上角的x删除图片
         */
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                adapter.remove(position);
                int size = adapter.getData().size();
                int count = adapter.getFooterLayoutCount();
                if (size < 9 && count == 0) {
                    adapter.addFooterView(addView);
                }
                if (size < 1 && count == 1) {
                    adapter.removeFooterView(addView);
                }
            }
        });

    }
}
