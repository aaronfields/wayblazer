package com.example.travlr;

/**
 * Created by samwyz on 7/9/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by micahherrera on 7/9/16.
 */
public class HotelSwiperAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Hotel> mHotels;

    public HotelSwiperAdapter(Context context, ArrayList<Hotel> hotels){
        mContext = context;
        mHotels = hotels;

    }
    @Override
    public int getCount() {
        return mHotels.size();
    }

    @Override
    public Hotel getItem(int i) {
        return mHotels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        Hotel h = mHotels.get(i);

        if (view == null) {
            LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.hotel_view, viewGroup, false);
        }

        ImageView hotelImage = (ImageView)v.findViewById(R.id.hotel_view_image);
        TextView hotelName = (TextView)v.findViewById(R.id.hotel_view_name);
        TextView hotelDesc = (TextView)v.findViewById(R.id.hotel_view_placesNearby);

        Picasso.with(v.getContext())
                .load(h.getPicUrl())
                .resize(360,380)
                .centerCrop()
                .into(hotelImage);

        hotelName.setText(h.getHotelName());
        hotelDesc.setText(h.getAddress());
        //TODO: set variables for hotel view from object
//

        return v;
    }
}
