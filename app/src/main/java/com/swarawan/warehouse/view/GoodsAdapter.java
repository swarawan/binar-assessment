package com.swarawan.warehouse.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.swarawan.warehouse.R;
import com.swarawan.warehouse.model.Goods;

import java.util.List;

/**
 * Created by rioswarawan on 5/15/17.
 */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {

    private Context context;
    private List<Goods> collection;
    private LayoutInflater inflater;

    public GoodsAdapter(Context context, List<Goods> collection) {
        this.context = context;
        this.collection = collection;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public GoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_goods, parent, false);
        return new GoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoodsViewHolder holder, int position) {
        Goods goods = collection.get(position);

        ((TextView) holder.itemView.findViewById(R.id.text_name)).setText(goods.name + " (" + goods.total + ")");
        ((TextView) holder.itemView.findViewById(R.id.text_name)).setText(goods.supplier);
    }

    @Override
    public int getItemCount() {
        return collection.size();
    }

    public class GoodsViewHolder extends RecyclerView.ViewHolder {

        public GoodsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
