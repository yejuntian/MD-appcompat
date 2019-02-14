package appcompat.com.md_appcompat.MDAnimal;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

import appcompat.com.md_appcompat.R;

/**
 * @version [版本号]
 * @see [参考资料]
 */
public class MDActivity extends AppCompatActivity {
    private Button button;
    private Button button1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_anim_layout);

        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置圆形水波纹在中间揭露效果
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Animator reveal = ViewAnimationUtils.createCircularReveal(v, v.getWidth() / 2, v.getHeight() / 2
                            , 0f, v.getWidth() / 2);
                    reveal.setDuration(300);
                    reveal.setInterpolator(new DecelerateInterpolator());
                    reveal.start();
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置圆形水波纹在左上角揭露效果
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Animator reveal = ViewAnimationUtils.createCircularReveal(v, 0, 0
                            , 0f, (float) Math.hypot(v.getWidth(), v.getHeight()));
                    reveal.setDuration(300);
                    reveal.setInterpolator(new DecelerateInterpolator());
                    reveal.start();
                }
            }
        });
    }
}
