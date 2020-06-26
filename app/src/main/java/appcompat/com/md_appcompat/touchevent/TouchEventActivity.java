package appcompat.com.md_appcompat.touchevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import java.io.Serializable;

import appcompat.com.md_appcompat.R;

/**
 * <颜色滤镜>
 */
public class TouchEventActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customview);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("test", "MaskFilterActivity onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("test", "MaskFilterActivity ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("test", "MaskFilterActivity ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("test", "MaskFilterActivity ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
