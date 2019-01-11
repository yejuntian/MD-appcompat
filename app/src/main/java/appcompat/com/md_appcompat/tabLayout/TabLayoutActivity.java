package appcompat.com.md_appcompat.tabLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import appcompat.com.md_appcompat.R;

public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    private String[] title = new String[]{"头条", "咨询", "新闻", "媒体", "笑话", "CBA", "NBA", "图片", "故事会", "房地产", "金融", "体育", "美女", "娱乐"};
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        tableLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

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
                setTabColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //设置Tab不同样式
        int count = tableLayout.getTabCount();
        for (int i = 0; i < count; i++) {
            TabLayout.Tab tab = tableLayout.getTabAt(i);
            View view = View.inflate(getApplicationContext(), R.layout.tab_item_layout, null);
            TextView tabName = view.findViewById(R.id.tv_tab_name);
            tabName.setText(title[i]);
            tab.setCustomView(view);
        }
        //设置默认第一个为选择状态
        setTabColor(0);

    }

    /**
     * 自定义切换tab文本颜色
     *
     * @param pos
     */
    public void setTabColor(int pos) {
        for (int i = 0; i < tableLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tableLayout.getTabAt(i);
            View view = tab.getCustomView();
            TextView tabName = view.findViewById(R.id.tv_tab_name);
            if (pos != i) {
                tabName.setTextColor(Color.BLACK);
            } else {
                tabName.setTextColor(Color.RED);
            }
        }
    }
}
