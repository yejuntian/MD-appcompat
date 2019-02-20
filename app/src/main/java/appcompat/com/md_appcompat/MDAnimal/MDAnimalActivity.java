package appcompat.com.md_appcompat.MDAnimal;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import appcompat.com.md_appcompat.R;

/**
 * MD动画
 *
 * @version [版本号]
 * @see [参考资料]
 */
public class MDAnimalActivity extends AppCompatActivity {
    private Button button;
    private Button button1;
    private Button button3;
    private ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //设置运行转场动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_anim_layout);

        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button3 = findViewById(R.id.button3);
        imageView = findViewById(R.id.imgGirl);

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

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat shareMeiNv = ActivityOptionsCompat.makeSceneTransitionAnimation(MDAnimalActivity.this,
                        imageView,//共享view
                        "shareMeiNv");//共享元素的名称
                Intent intent = new Intent(MDAnimalActivity.this, ShareElementActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                    startActivity(intent, shareMeiNv.toBundle());
            }
        });
    }
}
