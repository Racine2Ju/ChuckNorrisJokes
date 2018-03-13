package racine2ju.chucknorris;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;


public class MainActivity extends AppCompatActivity {

    // FOR DESIGN
    @BindView(R.id.activity_main_recycler_view) RecyclerView recyclerView;
    @BindView(R.id.activity_main_edit_text) EditText editText;
    @BindView(R.id.activity_main_button) Button button;

    //FOR DATA
    private Disposable disposable;
    private List<ChuckNorrisJoke> chuckNorrisJokes;
    private ChuckNorrisJokeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.configureRecyclerView();
        this.adapter.notifyDataSetChanged();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    executeHttpRequestWithRetrofit();
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        });
    }
    private void configureRecyclerView(){
        this.chuckNorrisJokes = new ArrayList<>();
      /*  ChuckNorrisJoke joke1 = new ChuckNorrisJoke();
        joke1.setValue("blablabla");
        joke1.setIconUrl("http://i0.kym-cdn.com/photos/images/original/000/341/931/ae8.jpeg");
        chuckNorrisJokes.add(joke1);*/
        // Create adapter passing in the sample user data
        this.adapter = new ChuckNorrisJokeAdapter(this.chuckNorrisJokes, Glide.with(this));
        // Attach the adapter to the recyclerview to populate items
        this.recyclerView.setAdapter(this.adapter);
        // Set layout manager to position the items
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    // -------------------
    // HTTP (RxJAVA)
    // -------------------

    private void executeHttpRequestWithRetrofit(){
        this.disposable = ChuckNorrisJokeStreams.streamFetchChuckNorrisJoke(editText.getText().toString()).subscribeWith(new DisposableObserver<ChuckNorrisResult>() {
            @Override
            public void onNext(ChuckNorrisResult result) {
                updateUI(result.getJokes());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("error", "", e);
            }

            @Override
            public void onComplete() { }
        });
    }

    private void disposeWhenDestroy(){
        if (this.disposable != null && !this.disposable.isDisposed()) this.disposable.dispose();
    }

    // -------------------
    // UPDATE UI
    // -------------------

    private void updateUI(List<ChuckNorrisJoke> users){
        chuckNorrisJokes.clear();
        chuckNorrisJokes.addAll(users);
        adapter.notifyDataSetChanged();
    }
}
