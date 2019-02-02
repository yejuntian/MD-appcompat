package appcompat.com.md_appcompat.CustomBehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * <类说明 必填>
 *
 * @version [版本号]
 * @see [参考资料]
 * @since [历史 创建日期:2019/2/2]
 */
public class CustomBehavior extends CoordinatorLayout.Behavior<View> {
    public CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomBehavior() {
        super();
    }

    /**
     * 用来监听哪些控件或容器的状态
     *
     * @param parent     父容器
     * @param child      子控件---需要监听dependency这个view视图的  ---》观察者
     * @param dependency 你要监听的那个view ----》被观察者
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof TextView || super.layoutDependsOn(parent, child, dependency);
    }

    /**
     * 当监听的view发生改变的时候进行回调
     * 可以在此方法中做一些联动的效果
     *
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        //获取被监听的view状态  垂直状态
        int offset = dependency.getTop() - child.getTop();
        ViewCompat.offsetTopAndBottom(child, offset);
        return true;
    }
}


