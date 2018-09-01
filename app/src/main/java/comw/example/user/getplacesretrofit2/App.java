package comw.example.user.getplacesretrofit2;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static PlaceApi placeApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        okHttpClientBuilder.addInterceptor(logging);

        retrofit = new Retrofit.Builder().
                baseUrl("http://sms.servio.support:32892/GetPlaces/").
                addConverterFactory(GsonConverterFactory.create()).
                client(okHttpClientBuilder.build()).
                build();

        placeApi = retrofit.create(PlaceApi.class);
    }

    public static PlaceApi getPlaceApi() {
        return placeApi;
    }
}
