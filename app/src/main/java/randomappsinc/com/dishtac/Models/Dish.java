package randomappsinc.com.dishtac.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alexanderchiou on 2/14/16.
 */
public class Dish implements Parcelable {
    private String name;
    private String location;
    private float rating;
    private String description;
    private long timeCreated;
    private String imagePath;

    public Dish() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    protected Dish(Parcel in) {
        name = in.readString();
        location = in.readString();
        rating = in.readInt();
        description = in.readString();
        timeCreated = in.readLong();
        imagePath = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(location);
        dest.writeFloat(rating);
        dest.writeString(description);
        dest.writeLong(timeCreated);
        dest.writeString(imagePath);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Dish> CREATOR = new Parcelable.Creator<Dish>() {
        @Override
        public Dish createFromParcel(Parcel in) {
            return new Dish(in);
        }

        @Override
        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };
}
