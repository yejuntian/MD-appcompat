package appcompat.com.md_appcompat.PropertyAnim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import appcompat.com.md_appcompat.R;

/**
 * <属性动画综合练习>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/2/13]
 */
public class PropertyAnimActivity extends AppCompatActivity {
    private View firstView;
    private View secondView;
    private Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_layout);
        firstView = findViewById(R.id.first);
        secondView = findViewById(R.id.second);
        bt = (Button) findViewById(R.id.bt);
    }

    public void startFirstAnimation(View view) {
        //1.旋转2.渐变，3.缩放动画
        ObjectAnimator rotationAnimal = ObjectAnimator.ofFloat(firstView, "rotationX", 0, 25);
        rotationAnimal.setDuration(300);

        //透明度
        ObjectAnimator alphaAnimal = ObjectAnimator.ofFloat(firstView, "alpha", 1f, 0.7f);
        alphaAnimal.setDuration(200);

        //缩放动画
        ObjectAnimator scaleXAnimal = ObjectAnimator.ofFloat(firstView, "scaleX", 0.8f, 1f);
        scaleXAnimal.setDuration(200);

        ObjectAnimator scaleYAnimal = ObjectAnimator.ofFloat(firstView, "scaleY", 0.8f, 1f);
        scaleYAnimal.setDuration(200);

        ObjectAnimator firstResumeRotationAnim = ObjectAnimator.ofFloat(firstView, "rotationX", 25f, 0f);
        firstResumeRotationAnim.setDuration(200);
        firstResumeRotationAnim.setStartDelay(200);//延迟执行
        //由于缩放造成了离顶部有一段距离，需要平移上去
        ObjectAnimator firstTranslationAnim = ObjectAnimator.ofFloat(firstView, "translationY", 0f, -0.1f * firstView.getHeight());
        firstTranslationAnim.setDuration(200);

        //第二个View执行平移动画--网上平移
        ObjectAnimator secondeTranslationAnim = ObjectAnimator.ofFloat(secondView, "translationY",secondView.getHeight(), 0f);
        secondeTranslationAnim.setDuration(200);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotationAnimal, alphaAnimal, scaleXAnimal, scaleYAnimal,
                firstResumeRotationAnim, firstTranslationAnim,secondeTranslationAnim);
        animatorSet.start();

        firstTranslationAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                secondView.setVisibility(View.VISIBLE);
                secondView.setClickable(true);
            }
        });
    }

    public void startSecondAnimation(View view) {
        //1.旋转  2.渐变，3.缩放动画
        ObjectAnimator rotationAnimal = ObjectAnimator.ofFloat(firstView, "rotationX", 0, 25);
        rotationAnimal.setDuration(300);

        //透明度
        ObjectAnimator alphaAnimal = ObjectAnimator.ofFloat(firstView, "alpha", 0.7f, 1f);
        alphaAnimal.setDuration(200);

        //缩放动画
        ObjectAnimator scaleXAnimal = ObjectAnimator.ofFloat(firstView, "scaleX", 0.8f, 1f);
        scaleXAnimal.setDuration(200);

        ObjectAnimator scaleYAnimal = ObjectAnimator.ofFloat(firstView, "scaleY", 0.8f, 1f);
        scaleYAnimal.setDuration(200);

        ObjectAnimator firstResumeRotationAnim = ObjectAnimator.ofFloat(firstView, "rotationX", 25f, 0f);
        firstResumeRotationAnim.setDuration(200);
        firstResumeRotationAnim.setStartDelay(200);//延迟执行
        //由于缩放造成了离顶部有一段距离，需要平移上去
        ObjectAnimator firstTranslationAnim = ObjectAnimator.ofFloat(firstView, "translationY", 300f, 0);
        firstTranslationAnim.setDuration(200);

        //第二个View执行平移动画--网上平移
        ObjectAnimator secondeTranslationAnim = ObjectAnimator.ofFloat(secondView, "translationY", 0f,secondView.getHeight());
        secondeTranslationAnim.setDuration(300);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotationAnimal, alphaAnimal, scaleXAnimal, scaleYAnimal,
                firstResumeRotationAnim, firstTranslationAnim,secondeTranslationAnim);
        animatorSet.start();

        firstTranslationAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                secondView.setVisibility(View.INVISIBLE);
                secondView.setClickable(false);
            }
        });
    }
}
