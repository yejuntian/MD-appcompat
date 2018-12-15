package appcompat.com.md_appcompat.recycleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import appcompat.com.md_appcompat.R;

public class QQAdapter extends RecyclerView.Adapter<QQAdapter.MyViewHolder> implements ItemTouchMoveListener {
    private List<QQMessage> list;
    private StartDragListener startDragListener;

    public QQAdapter(List<QQMessage> list,StartDragListener startDragListener) {
        this.list = list;
        this.startDragListener = startDragListener;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //1，数据要交换
        Collections.swap(list,fromPosition,toPosition);
        //2,刷新

        notifyItemMoved(fromPosition,toPosition);
        return false;
    }

    @Override
    public boolean onItemRemove(int position) {
        //拖拽删除数据
        //1,删除数据 2，刷新
        list.remove(position);
        notifyItemRemoved(position);
        return false;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_logo;
        private TextView tv_name;
        private TextView tv_Msg;
        private TextView tv_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_logo = (ImageView) itemView.findViewById(R.id.iv_logo);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_Msg = (TextView) itemView.findViewById(R.id.tv_lastMsg);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int location) {
        QQMessage qqMessage = list.get(location);
        holder.iv_logo.setImageResource(qqMessage.getLogo());
        holder.tv_name.setText(qqMessage.getName());
        holder.tv_Msg.setText(qqMessage.getLastMsg());
        holder.tv_time.setText(qqMessage.getTime());
        holder.iv_logo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (startDragListener != null) {
                        startDragListener.startDrag(holder);
                    }
                }
                return false;
            }
        });
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new MyViewHolder(view);
    }

}
