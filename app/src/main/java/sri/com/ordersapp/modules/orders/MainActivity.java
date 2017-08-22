package sri.com.ordersapp.modules.orders;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import sri.com.ordersapp.R;
import sri.com.ordersapp.base.BaseActivity;
import sri.com.ordersapp.datainjection.module.OrdersModule;
import sri.com.ordersapp.modules.detials.OrderDetails;
import sri.com.ordersapp.modules.orders.adapter.OrdersAdapter;
import sri.com.ordersapp.mvp.model.OrdersResponse;
import sri.com.ordersapp.mvp.presenter.OrdersPresenter;
import sri.com.ordersapp.mvp.view.MainView;
import sri.com.ordersapp.utilities.NetworkUtils;

public class MainActivity extends BaseActivity implements MainView {

    @Bind(R.id.order_list) protected RecyclerView mOrderList;
    @Inject
    protected OrdersPresenter mPresenter;
    private OrdersAdapter mOrdersAdapter;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        loadOrders();
    }

    private void loadOrders() {
        if(NetworkUtils.isNetAvailable(this)) {
            mPresenter.getOrders();
        } else {
            mPresenter.getOrdersFromDatabase();
        }
    }


    private void initializeList() {
        mOrderList.setHasFixedSize(true);
        mOrderList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mOrdersAdapter = new OrdersAdapter(getLayoutInflater());
        mOrdersAdapter.setOrderClickListener(mOrdersClickListener);
        mOrderList.setAdapter(mOrdersAdapter);
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerOrderComponent.builder()
                .applicationComponent(getApplicationComponent())
                .orderModule(new OrdersModule(this))
                .build().inject(this);
    }

    @Override

    protected int getContentView() {
        return R.layout.activity_main;
    }


    @Override
    public void onOrdersLoaded(List<OrdersResponse> ordersResponses) {

    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClearItems() {
        mOrdersAdapter.clearOrders();
    }

    private OrdersAdapter.OnOrderClickListener mOrdersClickListener = new OrdersAdapter.OnOrderClickListener() {
        @Override
        public void onClick(View v, OrdersResponse ordersResponse, int position) {
            Intent intent = new Intent(MainActivity.this, OrderDetails.class);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, v, "orderImageAnimation");
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        }

    };
}
