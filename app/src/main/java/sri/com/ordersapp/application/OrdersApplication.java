package sri.com.ordersapp.application;

import android.app.Application;

import sri.com.ordersapp.datainjection.component.ApplicationComponent;
import sri.com.ordersapp.datainjection.module.ApplicationModule;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
public class OrdersApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "http://mi-mobile-dev.ap-southeast-1.elasticbeanstalk.com"))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
