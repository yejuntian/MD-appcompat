package appcompat.com.md_appcompat.AppBarLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

import appcompat.com.md_appcompat.CustomCoordinatorLayout.HideScrollListener;
import appcompat.com.md_appcompat.CustomCoordinatorLayout.MyAdapter;
import appcompat.com.md_appcompat.CustomCoordinatorLayout.ScrollListener;
import appcompat.com.md_appcompat.R;

/**
 * <类说明 必填>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/30]
 */
public class AppBarLayoutActivity extends AppCompatActivity implements HideScrollListener {
    private RecyclerView recyclerView;
    private AppBarLayout appBarLayout;
    private Toolbar mToolBar;
    private FloatingActionButton mImgBtn;
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_layout);
        recyclerView = findViewById(R.id.recyclerView);
        appBarLayout = findViewById(R.id.appBarLayout);
        mToolBar = findViewById(R.id.toolBar);
        mImgBtn = findViewById(R.id.floatActionBtn);

        for (int i = 0; i < 100; i++) {
            stringList.add("第" + i + "选项");
        }
        MyAdapter adapter = new MyAdapter(stringList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new ScrollListener(this));

    }

    @Override
    public void onHide() {
        mToolBar.animate().translationY(-mToolBar.getHeight())
                .setInterpolator(new AccelerateInterpolator(3))
                .setDuration(200);
        //隐藏动画
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mImgBtn.getLayoutParams();
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
