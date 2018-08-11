package as.bwei.com.weima.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import as.bwei.com.weima.MainActivity;
import as.bwei.com.weima.R;
import as.bwei.com.weima.bean.InfoDatas;

/**
 * Created by HP on 2018/8/11.
 */

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.MyViewHolder> {

    private Context context;
    private InfoDatas infoDatas;

    public MyRecyAdapter(Context context, InfoDatas infoDatas) {
        this.context = context;
        this.infoDatas = infoDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recy_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(infoDatas.getData().get(position).getImages()).into(holder.iv_item);
        holder.tv_item.setText(infoDatas.getData().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return infoDatas.getData().size();
    }

  public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_item;
        private  TextView tv_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_item = (ImageView) itemView.findViewById(R.id.iv_item);
            tv_item = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
