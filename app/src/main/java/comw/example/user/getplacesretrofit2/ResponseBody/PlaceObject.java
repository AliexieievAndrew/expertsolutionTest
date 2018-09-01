package comw.example.user.getplacesretrofit2.ResponseBody;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import comw.example.user.getplacesretrofit2.ResponseBody.PlaceUnion;

public class PlaceObject {

    @SerializedName("PlaceUnions")
    @Expose
    private List<PlaceUnion> placeUnions = null;

    public List<PlaceUnion> getPlaceUnions() {
        return placeUnions;
    }

    public void setPlaceUnions(List<PlaceUnion> placeUnions) {
        this.placeUnions = placeUnions;
    }
}
