package appcompat.com.md_appcompat.ConstraintLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import appcompat.com.md_appcompat.R;

/**
 * <类说明 必填>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/30]
 */
public class ConstraintLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
    }
}
