package appcompat.com.md_appcompat.drawerlayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import appcompat.com.md_appcompat.R;

public class DrawerActvity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private RelativeLayout mMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        toolbar = findViewById(R.id.toorbar);
        drawerLayout = findViewById(R.id.drawer);
        mMenu = findViewById(R.id.rl_menu);

        //将actionBar替换成toolbar
        setSupportActionBar(toolbar);

        @SuppressLint("ResourceType")
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        actionBarDrawerToggle.syncState();//同步状态
//        给侧滑设置监听
//        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
//                滑动过程不断回调 slideOffset 0~1
                View content = drawerLayout.getChildAt(0);
                View menu = drawerView;

                float scale = 1 - slideOffset;//1~0
                float leftScale = (float) (1 - 0.3 * scale);//1~0.7
                float rightScale = (float) (1 - 0.3 * scale);//0.7~1

                menu.setScaleX(leftScale);
                menu.setScaleY(leftScale);

                content.setScaleX(rightScale);
                content.setScaleY(rightScale);
                content.setTranslationX(menu.getMeasuredWidth() * slideOffset);

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {
                //状态发生改变
            }
        });

    }
}
