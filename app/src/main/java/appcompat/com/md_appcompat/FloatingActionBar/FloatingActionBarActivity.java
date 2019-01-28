package appcompat.com.md_appcompat.FloatingActionBar;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import appcompat.com.md_appcompat.R;

/**
 * <悬浮的按钮>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/1/23]
 */
public class FloatingActionBarActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    private boolean isReverse = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_actionbar_layout);
        floatingActionButton = findViewById(R.id.floatActionBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float angle = isReverse ? 180f : -180f;
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", angle);
                objectAnimator.setDuration(500);
                objectAnimator.start();
                isReverse = !isReverse;
            }
        });
    }
}
