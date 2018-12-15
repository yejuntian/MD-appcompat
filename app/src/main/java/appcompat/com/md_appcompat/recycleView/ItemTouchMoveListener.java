package appcompat.com.md_appcompat.recycleView;

public interface ItemTouchMoveListener {
    /**
     * 当拖拽的时候回调
     *
     * @param fromPosition
     * @param toPosition
     * @return
     */
    public boolean onItemMove(int fromPosition, int toPosition);

    /**
     * 当条目被移除
     * @param position
     * @return
     */
    public boolean onItemRemove(int position);
}
