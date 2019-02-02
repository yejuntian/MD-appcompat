package appcompat.com.md_appcompat.CustomBehavior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import appcompat.com.md_appcompat.R;

/**
 * <自定义behavior 实现：手动点击textview>
 *
 * @author tianyejun
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/2/1]
 */
public class CustomBehaviorActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custombehavior_layout);

        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(v, 13);
            }
        });
    }
}
