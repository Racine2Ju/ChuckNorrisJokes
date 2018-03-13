package racine2ju.chucknorris;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;



public class ChuckNorrisJokeStreams {

    public static Observable<ChuckNorrisResult> streamFetchChuckNorrisJoke(String query){
        ChuckNorrisService chuckNorrisService = ChuckNorrisService.retrofit.create(ChuckNorrisService.class);
        return chuckNorrisService.getChuckNorrisJokes(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }
}

