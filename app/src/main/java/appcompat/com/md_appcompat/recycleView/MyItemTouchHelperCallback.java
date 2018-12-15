package appcompat.com.md_appcompat.recycleView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.AdapterView;

public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private ItemTouchMoveListener itemTouchMoveListener;

    public MyItemTouchHelperCallback(ItemTouchMoveListener itemTouchMoveListener) {
        this.itemTouchMoveListener = itemTouchMoveListener;
    }

    //用来判断当前是什么动作，比如判断方向（监听哪个方向的拖动）
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//        方向 down up left right
//        ItemTouchHelper.DOWN
//        ItemTouchHelper.LEFT
//        ItemTouchHelper.RIGHT
//        ItemTouchHelper.UP

        //监听拖拽的是哪个方向
        int dragFlags = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
        //监听侧滑的是哪个方向
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int movementFlags = makeMovementFlags(dragFlags, swipeFlags);
        return movementFlags;
    }

    //移动的时候回调
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        //拖拽过程中不停调用adapter.notifyItemMoved()
        itemTouchMoveListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return false;
    }

    //是否允许长拽效果
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    //侧滑的时候回调
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        itemTouchMoveListener.onItemRemove(viewHolder.getAdapterPosition());
    }

    //当选中的时候触发
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(Color.GREEN);
        }
    }

    //执行操作后恢复原始值
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        //恢复初始值颜色
        viewHolder.itemView.setBackgroundColor(Color.WHITE);
        viewHolder.itemView.setAlpha(1);

        //设置缩放 1~0
        viewHolder.itemView.setScaleX(1);
        viewHolder.itemView.setScaleY(1);
    }

    //绘制item动画
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        //dx 水平方向增值（负向左，右向正）范围：0~view.getWidth 0~1
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            //透明度动画
            float alpha = 1 - Math.abs(dX) / viewHolder.itemView.getWidth();
            viewHolder.itemView.setAlpha(alpha);

            //设置缩放 1~0
            viewHolder.itemView.setScaleX(alpha);
            viewHolder.itemView.setScaleY(alpha);
        }
    }

}
