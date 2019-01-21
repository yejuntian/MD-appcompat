package appcompat.com.md_appcompat.cardView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import appcompat.com.md_appcompat.R;

/**
 * <类说明 必填>
 *
 * @author tianyejun
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/21]
 */
public class CardViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview_layout);
    }
}
