package appcompat.com.md_appcompat.recycleView;

import android.support.v7.widget.RecyclerView;

public interface StartDragListener {
    /**
     * 改接口用于主动回调拖拽效果
     * @param viewHolder
     */
    public void startDrag(RecyclerView.ViewHolder viewHolder);
}
