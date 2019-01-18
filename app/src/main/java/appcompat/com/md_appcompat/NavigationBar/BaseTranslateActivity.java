package appcompat.com.md_appcompat.NavigationBar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import appcompat.com.md_appcompat.R;

/**
 * <沉浸式封装基类>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/17]
 */
public class BaseTranslateActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private View bottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_translate_layout);
        toolbar = findViewById(R.id.toolBar);
        bottomBar = findViewById(R.id.bottomBar);
        setStatusBgColor(toolbar, bottomBar, Color.parseColor("#0000ff"));

    }

    /**
     * 设置状态栏背景颜色
     *
     * @param toolbar
     * @param bottomNavigationBar
     * @param statusColor
     */
    public void setStatusBgColor(Toolbar toolbar, View bottomNavigationBar, int statusColor) {
        if (toolbar == null || bottomBar == null) return;
        //1.判断版本如果【4.4~5.0）就设置状态栏为透明色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT &&
                Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //设置为透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup.LayoutParams params = toolbar.getLayoutParams();
            int height = params.height + getStatusBarHeight();
            params.height = height;
            toolbar.setLayoutParams(params);

            toolbar.setPadding(
                    toolbar.getPaddingLeft(),
                    toolbar.getPaddingTop() + getStatusBarHeight(),
                    toolbar.getPaddingRight(),
                    toolbar.getPaddingBottom());

            //设置底部虚拟导航view高度
            if (hasNavigationBar()) {
                bottomBar.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams layoutParams = bottomNavigationBar.getLayoutParams();
                layoutParams.height = getVirtualBarHeight(this);
                bottomNavigationBar.setLayoutParams(layoutParams);
            } else {
                bottomBar.setVisibility(View.GONE);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//version >= 5.0
            getWindow().setStatusBarColor(statusColor);
            getWindow().setNavigationBarColor(statusColor);
        } else {//version < 4.4 不做处理

        }

        //设置状态栏背景颜色
        toolbar.setBackgroundColor(statusColor);
        if (hasNavigationBar()) {
            bottomNavigationBar.setVisibility(View.VISIBLE);
            //设置底部导航栏背景颜色
            bottomNavigationBar.setBackgroundColor(statusColor);
        }
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

    /**
     * 获取虚拟导航高度
     *
     * @param context
     * @return
     */
    public static int getVirtualBarHeight(Context context) {
        int vh = 0;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        try {
            @SuppressWarnings("rawtypes")
            Class c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            vh = dm.heightPixels - display.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vh;
    }


    /**
     * 获取整个屏幕的高度
     *
     * @return
     */
    public int getScreenHeight() {
        int screenHeight = 0;
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        try {
            Class c = Class.forName("android.view.Display");
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            screenHeight = dm.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenHeight;
    }

    /**
     * 获取除了虚拟导航栏以为的屏幕高度
     */
    public int getContentHeight() {
        return getWindowManager().getDefaultDisplay().getHeight();
    }

    /**
     * 判断是否有虚拟导航栏
     *
     * @return
     */
    public boolean hasNavigationBar() {
        int height = getScreenHeight() - getContentHeight();
        return height > 0;
    }
}
