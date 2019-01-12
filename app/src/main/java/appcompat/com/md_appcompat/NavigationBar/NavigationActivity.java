package appcompat.com.md_appcompat.NavigationBar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import appcompat.com.md_appcompat.R;

/**
 * <沉浸式状态栏>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/12]
 */
public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //状态栏透明
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_navigation_bar_layout);
    }
}
