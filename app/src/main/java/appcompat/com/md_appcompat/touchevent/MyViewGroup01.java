package appcompat.com.md_appcompat.touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * <类说明 必填>
 *
 * @author tianyejun
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2020-02-25]
 */
public class MyViewGroup01 extends LinearLayout {


    public MyViewGroup01(Context context) {
        super(context);
    }

    public MyViewGroup01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("test", "MyViewGroup01 dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("test", "MyViewGroup01 onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("test", "MyViewGroup01 onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("test", "MyViewGroup01 ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("test", "MyViewGroup01 ACTION_MOVE");
                return true;
            case MotionEvent.ACTION_UP:
                Log.e("test", "MyViewGroup01 ACTION_UP");
                break;
        }
        return true;
    }
}
