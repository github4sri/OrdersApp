package sri.com.ordersapp.modules.orders.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import sri.com.ordersapp.R;
import sri.com.ordersapp.helper.ImageHandler;
import sri.com.ordersapp.mvp.model.OrdersResponse;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.Holder>{

    private LayoutInflater mLayoutInflater;
    private List<OrdersResponse> mOrdersList = new ArrayList<>();
    public OrdersAdapter(LayoutInflater inflater) {
        mLayoutInflater = inflater;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(OrdersAdapter.Holder holder, int position) {
        holder.bind(mOrdersList.get(position));
    }

    @Override
    public int getItemCount() {
        return mOrdersList.size();
    }

    public void addOrders(List<OrdersResponse> orders) {
        mOrdersList.addAll(orders);
        notifyDataSetChanged();
    }

    public void clearOrders(){
        mOrdersList.clear();
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.order_icon) protected ImageView mOrderIcon;
        @Bind(R.id.textview_title) protected TextView mOrderTitle;
        @Bind(R.id.textview_location) protected TextView mOrderLocation;

        private Context mContext;
        private OrdersResponse mOrder;

        public Holder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        public void bind(OrdersResponse ordersResponse) {
            mOrder = ordersResponse;
            mOrderTitle.setText(ordersResponse.getDescription());
            mOrderLocation.setText(ordersResponse.getLocation().getAddress());

            Glide.with(mContext).load(ordersResponse.getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(new ImageHandler(mOrderIcon));
        }

        @Override
        public void onClick(View v) {
            if (mOrderClickListener != null) {
                mOrderClickListener.onClick(mOrderIcon, mOrder, getAdapterPosition());
            }
        }
    }
    public void setOrderClickListener(OnOrderClickListener listener) {
        mOrderClickListener = listener;
    }

    private OnOrderClickListener mOrderClickListener;

    public interface OnOrderClickListener {

        void onClick(View v, OrdersResponse ordersResponse, int position);
    }
}
