package appcompat.com.md_appcompat.AppBarLayout;

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
 * TabLayout+ViewPager+
 */
public class BehaviorActivity extends AppCompatActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private String[] title = new String[]{"头条", "咨询", "新闻", "媒体", "笑话", "CBA", "NBA", "图片", "故事会", "房地产", "金融", "体育", "美女", "娱乐"};
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior_layout);
        toolbar = findViewById(R.id.toolBar);
        tableLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setSupportActionBar(toolbar);
        toolbar.setTitle("我是ToolBar");

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

//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tableLayout));
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
