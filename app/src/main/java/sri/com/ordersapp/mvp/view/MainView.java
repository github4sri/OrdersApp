package sri.com.ordersapp.mvp.view;

import java.util.List;

import sri.com.ordersapp.mvp.model.OrdersResponse;

/**
 * Created by Sri. on 19-08-2017.
 * emails4srikanth@gmail.com
 */

public interface MainView extends BaseView {

    void onOrdersLoaded(List<OrdersResponse> ordersResponses);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);

    void onClearItems();
}
