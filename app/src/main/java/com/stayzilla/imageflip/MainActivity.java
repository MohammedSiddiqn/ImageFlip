package com.stayzilla.imageflip;

/**
 * Created by Mohammed on 29/07/16.
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;


import com.stayzilla.imageflip.adapters.GridImageAdapter;
import com.stayzilla.imageflip.bean.ImageCard;
import com.stayzilla.imageflip.helper.Helper;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<ImageCard> imageCardArrayList;
    GridImageAdapter gridImageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setNumColumns(2);
        if(!Helper.isNetworkAvailable(this)){

            Helper.SnackBarLayout(gridView,"Please check you internet connection",getApplicationContext());
        }


        imageCardArrayList = new ArrayList<>();
        // Instance of ImageAdapter Class
        gridImageAdapter = new GridImageAdapter(this,imageCardArrayList);
        gridView.setAdapter(gridImageAdapter);
        loadImage();

    }


    /**
     * Load image data from server using volley or any network library and
     * add it in array list
     */

    private void loadImage() {

        imageCardArrayList.add(new ImageCard("https://firebasestorage.googleapis.com/v0/b/test-app-75189.appspot.com/o/images%2Fimg1-compressor.jpg?alt=media&token=4e446443-46d7-4a9b-a0f6-07116156343f","Image 1 content"));
        imageCardArrayList.add(new ImageCard("https://firebasestorage.googleapis.com/v0/b/test-app-75189.appspot.com/o/images%2Fimg2-compressor.jpg?alt=media&token=4e446443-46d7-4a9b-a0f6-07116156343f","Image 2 content"));
        imageCardArrayList.add(new ImageCard("https://firebasestorage.googleapis.com/v0/b/test-app-75189.appspot.com/o/images%2Fimg3-compressor.jpg?alt=media&token=4e446443-46d7-4a9b-a0f6-07116156343f","Image 3 content"));
        imageCardArrayList.add(new ImageCard("https://firebasestorage.googleapis.com/v0/b/test-app-75189.appspot.com/o/images%2Fimg4-compressor.jpg?alt=media&token=4e446443-46d7-4a9b-a0f6-07116156343f","Image 4 content"));
        imageCardArrayList.add(new ImageCard("https://firebasestorage.googleapis.com/v0/b/test-app-75189.appspot.com/o/images%2Fimg5-compressor.jpg?alt=media&token=4e446443-46d7-4a9b-a0f6-07116156343f","Image 5 content"));
        imageCardArrayList.add(new ImageCard("https://firebasestorage.googleapis.com/v0/b/test-app-75189.appspot.com/o/images%2Fimg6-compressor.jpg?alt=media&token=4e446443-46d7-4a9b-a0f6-07116156343f","Image 6 content"));
        imageCardArrayList.add(new ImageCard("https://firebasestorage.googleapis.com/v0/b/test-app-75189.appspot.com/o/images%2Fimg7-compressor.jpg?alt=media&token=4e446443-46d7-4a9b-a0f6-07116156343f","Image 7 content"));
        imageCardArrayList.add(new ImageCard("https://firebasestorage.googleapis.com/v0/b/test-app-75189.appspot.com/o/images%2Fimg8-compressor.jpg?alt=media&token=4e446443-46d7-4a9b-a0f6-07116156343f","Image 8 content"));

        gridImageAdapter.notifyDataSetChanged();
    }
}
