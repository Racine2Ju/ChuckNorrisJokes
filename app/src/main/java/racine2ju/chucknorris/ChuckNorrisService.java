package racine2ju.chucknorris;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Juliette on 11/03/2018.
 */

public interface ChuckNorrisService {
    @GET("/jokes/search")
    Observable<ChuckNorrisResult> getChuckNorrisJokes(@Query("query") String query);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
