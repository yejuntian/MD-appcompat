package appcompat.com.md_appcompat.CollapsingToolbarLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import appcompat.com.md_appcompat.R;
import appcompat.com.md_appcompat.tabLayout.MyFragment;
import appcompat.com.md_appcompat.tabLayout.ViewPagerAdapter;

/**
 * <类说明 必填>
 *
 * @author tianyejun
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/31]
 */
public class CollapsingToolBarLayoutActivity extends AppCompatActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    private Toolbar toolBar;
    private String[] title = new String[]{"头条", "咨询", "新闻", "媒体", "笑话", "CBA", "NBA", "图片", "故事会", "房地产", "金融", "体育", "美女", "娱乐"};
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsion_toolbar_layout);

        tableLayout = findViewById(R.id.tabLayout);
        toolBar = findViewById(R.id.toolBar);
        viewPager = findViewById(R.id.viewPager);

        setSupportActionBar(toolBar);
        toolBar.setTitle("我是ToolBar");

        for (int pos = 0; pos < title.length; pos++) {
            MyFragment fragment = new MyFragment();
            Bundle args = new Bundle();
            args.putString("title", title[pos]);
            fragment.setArguments(args);
            fragmentList.add(fragment);
        }

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), title, fragmentList);
        tableLayout.setupWithViewPager(viewPager, false);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
