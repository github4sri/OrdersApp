package sri.com.ordersapp.datainjection.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import sri.com.ordersapp.api.OrderApiService;
import sri.com.ordersapp.datainjection.scope.PerActivity;
import sri.com.ordersapp.mvp.view.MainView;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
@Module
public class OrdersModule {

    private MainView mView;

    public OrdersModule(MainView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    OrderApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(OrderApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mView;
    }
}
