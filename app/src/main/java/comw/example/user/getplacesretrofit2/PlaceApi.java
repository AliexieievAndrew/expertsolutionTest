package comw.example.user.getplacesretrofit2;

import comw.example.user.getplacesretrofit2.ResponseBody.PlaceObject;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface PlaceApi {
    @POST()
    Call<PlaceObject> getData (@Url String url);
}
