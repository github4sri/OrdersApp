package sri.com.ordersapp.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sri.com.ordersapp.mvp.model.OrdersResponse;
import sri.com.ordersapp.mvp.model.Storage;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
public class OrdersMapper {

    @Inject
    public OrdersMapper(){

    }

    public List<OrdersResponse> mapOrders(Storage storage, OrdersResponse response) {
        List<OrdersResponse> ordersList = new ArrayList<>();

        if (response != null) {
            OrdersResponse responseOrders = response;
            if (responseOrders != null) {
                for (ordersList cake : responseOrders) {
                    Cake myCake = new Cake();
                    myCake.setId(cake.getId());
                    myCake.setTitle(cake.getTitle());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setImageUrl(cake.getImage());
                    storage.addCake(myCake);
                    cakeList.add(myCake);
                }
            }
        }
        return cakeList;
    }
}
