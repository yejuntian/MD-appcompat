package appcompat.com.md_appcompat.CustomCoordinatorLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import appcompat.com.md_appcompat.R;

/**
 * <打造折叠悬浮效果>
 *
 * @author tianyejun
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/20]
 */
public class CoordinatorLayoutActivity extends AppCompatActivity implements HideScrollListener {
    private RecyclerView mRecyclerView;
    private Toolbar mToolBar;
    private ImageButton mImgBtn;
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        mRecyclerView = findViewById(R.id.recyclerView);
        mToolBar = findViewById(R.id.toolBar);
        mImgBtn = findViewById(R.id.imgBtn);
        for (int i = 0; i < 100; i++) {
            stringList.add("第" + i + "选项");
        }
        MyAdapter adapter = new MyAdapter(stringList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(new ScrollListener(this));

        setSupportActionBar(mToolBar);
        mToolBar.setTitle("我的标题模块");

    }

    @Override
    public void onHide() {
        mToolBar.animate().translationY(-mToolBar.getHeight())
                .setInterpolator(new AccelerateInterpolator(3))
                .setDuration(200);
        //隐藏动画
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mImgBtn.getLayoutParams();
        mImgBtn.animate().translationY(mImgBtn.getHeight() + params.bottomMargin)
                .setInterpolator(new AccelerateInterpolator(3))
                .setDuration(200);
    }

    @Override
    public void onShow() {

        mToolBar.animate().translationY(0)
                .setInterpolator(new DecelerateInterpolator(3))
                .setDuration(200);

        //显示动画
        mImgBtn.animate().translationY(0)
                .setInterpolator(new DecelerateInterpolator(3))
                .setDuration(200);
    }
}
