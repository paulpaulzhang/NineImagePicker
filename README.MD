# 九宫格选择图片
## 利用RecyclerView实现
	可以在这查看实现效果 https://www.jianshu.com/p/1c8b20b3e75d
	这里使用BaseRecyclerViewAdapterHelper这个强大好用的开源库
	代码非常简单，其实就是一个RecyclerView的应用，具体实现看代码吧，下面列出常用的两个功能

	添加按钮点击事件，这里实现自己的图片添加逻辑
	addView.findViewById(R.id.iv_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加图片按钮的点击事件，可以打开相册等等
            }
        });

    点击图片的逻辑，可结合PhotoView实现点击查看大图，拖拽缩放等
	mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //图片点击事件，可以点击查看点图编辑图片等
            }
        });

