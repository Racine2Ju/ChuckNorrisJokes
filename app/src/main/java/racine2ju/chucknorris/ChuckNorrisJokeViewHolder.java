package racine2ju.chucknorris;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Juliette on 10/03/2018.
 */

public class ChuckNorrisJokeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.activity_main_item_quote) TextView textView;
    @BindView(R.id.activity_main_item_image) ImageView imageView;

    public ChuckNorrisJokeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void updateWithChuckNorrisJoke(ChuckNorrisJoke chuckNorrisJoke, RequestManager glide){
        this.textView.setText(chuckNorrisJoke.getValue());
        glide.load(chuckNorrisJoke.getIconUrl()).apply(RequestOptions.circleCropTransform()).into(imageView);

    }
}
