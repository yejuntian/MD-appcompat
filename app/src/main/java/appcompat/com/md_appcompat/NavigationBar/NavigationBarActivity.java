package appcompat.com.md_appcompat.NavigationBar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.lang.reflect.Field;

import appcompat.com.md_appcompat.R;

/**
 * <沉浸式状态栏>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/12]
 */
public class NavigationBarActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //表示全屏的意思，也就是会将状态栏隐藏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //设置状态栏的透明属性
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_navigation_bar_layout);

        toolbar = findViewById(R.id.toolBar);
        ViewGroup.LayoutParams params = toolbar.getLayoutParams();
        int height = params.height + getStatusBarHeight();
        params.height = height;
        toolbar.setLayoutParams(params);

        toolbar.setPadding(
                toolbar.getPaddingLeft(),
                toolbar.getPaddingTop() + getStatusBarHeight(),
                toolbar.getPaddingRight(),
                toolbar.getPaddingBottom());
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    private int getStatusBarHeight() {
        int height = 0;
        try {
            Class<?> aClass = Class.forName("com.android.internal.R$dimen");
            Object instance = aClass.newInstance();
            Field field = aClass.getField("status_bar_height");
            int statusHeight = Integer.parseInt(field.get(instance).toString());
            height = getResources().getDimensionPixelSize(statusHeight);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return height;
    }
}
