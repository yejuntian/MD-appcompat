package appcompat.com.md_appcompat.MDAnimal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Window;

import appcompat.com.md_appcompat.R;

/**
 * <共享图片元素>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/2/20]
 */
public class ShareElementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //设置运行转场动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_layout);


//        Slide trasation = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            trasation = new Slide();
//            trasation.setDuration(1000);
//            getWindow().setEnterTransition(trasation);//进入的动画
//            getWindow().setExitTransition(trasation);//退出的动画
//        }

    }
}
