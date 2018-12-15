package appcompat.com.md_appcompat.searchview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import appcompat.com.md_appcompat.R;

public class SearchViewActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);
        toolbar = findViewById(R.id.toorbar);
        setSupportActionBar(toolbar);
        //设置NavigationIcon
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "设置NavigationIcon", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_search, menu);
        //searchView在menu里面
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView actionView = (SearchView) MenuItemCompat.getActionView(menuItem);
        //设置直接出来搜索框
//        actionView.setIconified(false);
//        //直接出来搜索框并且不能被隐藏
//        actionView.setIconifiedByDefault(false);

//        实现自定义的拓展效果
        SearchView.SearchAutoComplete searchView = actionView.findViewById(R.id.search_src_text);
        searchView.setHint("请输入要搜索的内容关键词");
        searchView.setHintTextColor(Color.WHITE);

        //设置搜索按钮是否可见
        actionView.setSubmitButtonEnabled(true);

        //设置焦点改变监听
        actionView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Toast.makeText(SearchViewActivity.this, "焦点改变", Toast.LENGTH_LONG).show();
            }
        });
//    设置关闭按钮监听
        actionView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Toast.makeText(SearchViewActivity.this, "点击关闭按钮监听", Toast.LENGTH_LONG).show();
                return false;
            }
        });

//        设置联想文字提示
//        actionView.setSuggestionsAdapter();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
