package sri.com.ordersapp.datainjection.component;

import dagger.Component;
import sri.com.ordersapp.datainjection.module.OrdersModule;
import sri.com.ordersapp.datainjection.scope.PerActivity;
import sri.com.ordersapp.modules.orders.MainActivity;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
@PerActivity
@Component(modules = OrdersModule.class, dependencies = ApplicationComponent.class)
public interface OrdersComponent {

    void inject(MainActivity activity);
}
