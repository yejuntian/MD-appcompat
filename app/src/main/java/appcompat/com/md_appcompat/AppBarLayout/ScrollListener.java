package appcompat.com.md_appcompat.AppBarLayout;

import android.support.v7.widget.RecyclerView;

/**
 * <监听recycle滑动监听，执行动画显示隐藏操作>
 */
public class ScrollListener extends RecyclerView.OnScrollListener {
    private int SCROLL_DISTANCE = 20;
    private int distance = 0;
    private HideScrollListener listener;
    private boolean isVisible = true;//判断动画是否在执行

    public ScrollListener(HideScrollListener listener) {
        this.listener = listener;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (distance > SCROLL_DISTANCE) {//表示下滑,隐藏动画
            if (listener != null && isVisible) {
                listener.onHide();
                isVisible = false;
            }
            distance = 0;
        } else if (distance < -SCROLL_DISTANCE) {//表示上滑，显示动画
            if (listener != null && !isVisible) {
                listener.onShow();
                isVisible = true;
            }
            distance = 0;
        }
        if ((isVisible && dy > 0) || (!isVisible && dy < 0)) {//只有执行动画的时候才进行位移计算
            distance += dy;
        }
    }
}
