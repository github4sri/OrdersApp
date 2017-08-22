package sri.com.ordersapp.mvp.presenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import sri.com.ordersapp.api.OrderApiService;
import sri.com.ordersapp.base.BasePresenter;
import sri.com.ordersapp.mapper.OrdersMapper;
import sri.com.ordersapp.mvp.model.OrdersResponse;
import sri.com.ordersapp.mvp.model.Storage;
import sri.com.ordersapp.mvp.view.MainView;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
public class OrdersPresenter extends BasePresenter<MainView> implements Observer<OrdersResponse> {

    @Inject
    protected OrderApiService mApiService;
    @Inject protected OrdersMapper mOrdersMapper;
    @Inject protected Storage mStorage;

    @Inject
    public OrdersPresenter(){

    }

    public void getOrders() {
        getView().onShowDialog("Loading Orders....");
        Observable<OrdersResponse> ordersResponseObservable = mApiService.getOrders();
        subscribe(ordersResponseObservable, this);
    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Orders loading complete!");
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error loading Orders " + e.getMessage());
    }

    @Override
    public void onNext(OrdersResponse ordersResponse) {
        List<OrdersResponse> ordersResponses = mOrdersMapper.mapOrders(mStorage, ordersResponse);
        getView().onClearItems();
        getView().onOrdersLoaded(ordersResponses);
    }

    public void getOrdersFromDatabase() {
        List<OrdersResponse> orders = mStorage.getSavedOrders();
        getView().onClearItems();
        getView().onOrdersLoaded(orders);
    }
}
