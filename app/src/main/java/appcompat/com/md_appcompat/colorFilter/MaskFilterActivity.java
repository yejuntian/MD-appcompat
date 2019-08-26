package appcompat.com.md_appcompat.colorFilter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * <颜色滤镜>
 */
public class MaskFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MaskFilterView view = new MaskFilterView(this);
        setContentView(view);
    }
}
