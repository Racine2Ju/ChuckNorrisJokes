package racine2ju.chucknorris;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.RequestManager;

import java.util.List;

/**
 * Created by Juliette on 10/03/2018.
 */

public class ChuckNorrisJokeAdapter extends RecyclerView.Adapter<ChuckNorrisJokeViewHolder> {

    // FOR DATA
    private List<ChuckNorrisJoke> chuckNorrisJokes;
    private RequestManager glide;

    // CONSTRUCTOR
    public ChuckNorrisJokeAdapter(List<ChuckNorrisJoke> chuckNorrisJokes, RequestManager glide) {
        this.chuckNorrisJokes = chuckNorrisJokes;
        this.glide = glide;
    }
    @Override
    public ChuckNorrisJokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // CREATE VIEW HOLDER AND INFLATING ITS XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_main_item, parent, false);

        return new ChuckNorrisJokeViewHolder(view);
    }
    // UPDATE VIEW HOLDER WITH A GITHUBUSER
    @Override
    public void onBindViewHolder(ChuckNorrisJokeViewHolder viewHolder, int position) {
        viewHolder.updateWithChuckNorrisJoke(this.chuckNorrisJokes.get(position), this.glide);
    }

    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.chuckNorrisJokes.size();
    }

    public ChuckNorrisJoke getJoke(int position){
        return this.chuckNorrisJokes.get(position);
    }
}
