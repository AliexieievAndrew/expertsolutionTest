package comw.example.user.getplacesretrofit2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comw.example.user.getplacesretrofit2.R;
import comw.example.user.getplacesretrofit2.ResponseBody.Place;
import comw.example.user.getplacesretrofit2.ResponseBody.PlaceGroup;
import comw.example.user.getplacesretrofit2.ResponseBody.PlaceGroupSchema;
import comw.example.user.getplacesretrofit2.ResponseBody.PlaceUnion;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder>{
    private List<Place> places;

    public PlacesAdapter(List<Place> places) {
        this.places = places;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Place place = places.get(position);

        holder.placeName.setText(place.getName());
        holder.placeCode.setText(place.getCode());
    }

    @Override
    public int getItemCount() {
        if (places == null)
            return 0;
        return places.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView placeName;
        private TextView placeCode;

        public ViewHolder(View itemView) {
            super(itemView);
            placeName = itemView.findViewById(R.id.placeName);
            placeCode = itemView.findViewById(R.id.placeCode);
        }
    }
}
