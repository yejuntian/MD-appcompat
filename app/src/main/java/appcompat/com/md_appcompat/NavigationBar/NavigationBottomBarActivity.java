package appcompat.com.md_appcompat.NavigationBar;

import android.content.Context;
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
 * <底部虚拟按键沉浸式状态栏>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/12]
 */
public class NavigationBottomBarActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private View mNavagationBottom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏的透明属性
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_navigation_bottom_bar_layout);

        toolbar = findViewById(R.id.toolBar);
        mNavagationBottom = findViewById(R.id.navigation_bottom);

        //设置状态栏高度
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
        ViewGroup.LayoutParams layoutParams = mNavagationBottom.getLayoutParams();
        layoutParams.height = getVirtualBarHeight(this);
        mNavagationBottom.setLayoutParams(layoutParams);
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
}
