package sri.com.ordersapp.datainjection.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import sri.com.ordersapp.datainjection.module.ApplicationModule;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();

}
