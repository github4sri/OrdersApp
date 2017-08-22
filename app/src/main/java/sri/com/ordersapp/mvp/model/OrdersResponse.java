
package sri.com.ordersapp.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
public class OrdersResponse {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("location")
    @Expose
    private Location location;

    /**
     * No args constructor for use in serialization
     */
    public OrdersResponse() {
    }

    /**
     * 
     * @param location
     * @param imageUrl
     * @param description
     */
    public OrdersResponse(String description, String imageUrl, Location location) {
        super();
        this.description = description;
        this.imageUrl = imageUrl;
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
