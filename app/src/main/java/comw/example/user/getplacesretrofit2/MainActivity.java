package comw.example.user.getplacesretrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import comw.example.user.getplacesretrofit2.Adapter.PlacesAdapter;
import comw.example.user.getplacesretrofit2.ResponseBody.Place;
import comw.example.user.getplacesretrofit2.ResponseBody.PlaceGroup;
import comw.example.user.getplacesretrofit2.ResponseBody.PlaceGroupSchema;
import comw.example.user.getplacesretrofit2.ResponseBody.PlaceObject;
import comw.example.user.getplacesretrofit2.ResponseBody.PlaceUnion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PlaceUnion> placeUnions;
    private List<Place> placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeUnions = new ArrayList<>();
        placeList = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);


        PlacesAdapter adapter = new PlacesAdapter(placeList);
        recyclerView.setAdapter(adapter);

        App.getPlaceApi()
                .getData("http://sms.servio.support:32892/GetPlaces/")
                .enqueue(new Callback<PlaceObject>() {

            @Override
            public void onResponse(Call<PlaceObject> call, Response<PlaceObject> response) {
                placeUnions = new ArrayList<>(response.body().getPlaceUnions());
                placeList.addAll(getPlaces(placeUnions));
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PlaceObject> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private List<Place> getPlaces(List<PlaceUnion> placeUnionsList) {

        List<PlaceGroup> groups = new ArrayList<>();
        List<PlaceGroupSchema> placeGroupSchemas = new ArrayList<>();
        List <Place> places = new ArrayList<>();

        for (PlaceUnion p: placeUnionsList) {
            groups.addAll(p.getPlaceGroups());
        }

        for (PlaceGroup p : groups) {
            placeGroupSchemas.addAll(p.getPlaceGroupSchemas());
        }

        for (PlaceGroupSchema p: placeGroupSchemas) {
            places.addAll(p.getPlaces());
        }
        return places;
    }
}