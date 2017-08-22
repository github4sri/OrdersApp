package sri.com.ordersapp.api;

import retrofit2.http.GET;
import rx.Observable;
import sri.com.ordersapp.mvp.model.OrdersResponse;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
public interface OrderApiService {

    @GET("/deliveries")
    Observable<OrdersResponse> getOrders();
}
