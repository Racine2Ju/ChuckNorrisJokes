package racine2ju.chucknorris;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Juliette on 11/03/2018.
 */

public class ChuckNorrisResult {
    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("result")
    @Expose
    private List<ChuckNorrisJoke> jokes;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ChuckNorrisJoke> getJokes() {
        return jokes;
    }

    public void setJokes(List<ChuckNorrisJoke> jokes) {
        this.jokes = jokes;
    }
}
