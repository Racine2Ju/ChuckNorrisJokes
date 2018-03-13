package racine2ju.chucknorris;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Juliette on 10/03/2018.
 */

public class ChuckNorrisJoke {
    @SerializedName("category")
    @Expose
    private List<String> category;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("value")
    @Expose
    private String value;

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getValue() {
        return value;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
