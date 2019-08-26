package appcompat.com.md_appcompat.colorFilter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import appcompat.com.md_appcompat.R;

/**
 * <类说明 必填>
 *
 * @author tianyejun
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019-08-25]
 */
public class MaskFilterView extends View {
    public MaskFilterView(Context context) {
        super(context);
    }

    public MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //关闭硬件加速效果（没有硬件加速则没有效果）
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
//        MaskFilter maskFilter = new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);
        float direction[] = new float[]{30, 30, 30};
        float ambient = 0.76f;
        float specular = 50;
        float blurRadius = 100;
        /**
         * EmbossMaskFilter 浮雕滤镜效果
         * direction： 指定【x,y,z】坐标变量，用来指定光源位置
         * ambient：指定周边背景光源（0~1）
         * specular：镜面反射系数
         * blurRadius：指定模糊半径
         */
        MaskFilter maskFilter = new EmbossMaskFilter(direction, ambient, specular, blurRadius);
        paint.setMaskFilter(maskFilter);

        @SuppressLint("DrawAllocation")
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.logo_3);
        canvas.drawBitmap(bitmap, 100, 300, paint);
    }
}
