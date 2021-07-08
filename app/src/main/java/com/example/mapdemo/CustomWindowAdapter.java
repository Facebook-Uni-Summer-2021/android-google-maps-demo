package com.example.mapdemo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

class CustomWindowAdapter implements GoogleMap.InfoWindowAdapter {
    LayoutInflater mInflater;

    public CustomWindowAdapter(LayoutInflater i){
        mInflater = i;
    }

    // This defines the contents within the info window based on the marker
    @Override
    public View getInfoContents(Marker marker) {
        // Getting view from the layout file
        View v = mInflater.inflate(R.layout.custom_info_window, null);
        // Populate fields
        TextView title = (TextView) v.findViewById(R.id.tv_info_window_title);
        title.setText(marker.getTitle());

        TextView description = (TextView) v.findViewById(R.id.tv_info_window_description);
        String[] arr = marker.getSnippet().split(",");
        Log.i("Tag", "Test: " + marker.getSnippet() + "\n" + arr[1]);
        description.setText(arr[0]);

        ImageView icon = (ImageView) v.findViewById(R.id.ivWindowIcon);
        int image = Integer.parseInt(arr[1]);
        if (image == 0) {
            icon.setBackgroundResource(android.R.drawable.ic_menu_directions);
        } else if (image == 1) {
            icon.setBackgroundResource(android.R.drawable.ic_menu_gallery);
        } else if (image == 2) {
            icon.setBackgroundResource(android.R.drawable.ic_menu_help);
        } else if (image == 3) {
            icon.setBackgroundResource(android.R.drawable.ic_menu_info_details);
        }
        // Return info window contents
        return v;
    }

    // This changes the frame of the info window; returning null uses the default frame.
    // This is just the border and arrow surrounding the contents specified above
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }


}
