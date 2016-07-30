package com.stayzilla.imageflip.adapters;

/**
 * Created by Mohammed on 30/07/16.
 */


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.stayzilla.imageflip.R;
import com.stayzilla.imageflip.bean.ImageCard;
import com.stayzilla.imageflip.customanim.FlipAnimation;
import com.stayzilla.imageflip.mylib.ImageDownloader;

import java.util.ArrayList;

public class GridImageAdapter extends BaseAdapter {
    private Context mContext;
    ImageDownloader imageDownloader;
    ArrayList<ImageCard> imageStorageList;

    // Constructor
    public GridImageAdapter(Context c,ArrayList<ImageCard> imageStorageList){


       mContext = c;
       imageDownloader = new ImageDownloader();
       imageDownloader.setMode(ImageDownloader.Mode.CORRECT);
       this.imageStorageList = imageStorageList;
    }

    @Override
    public int getCount() {
        return imageStorageList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageStorageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("item id","is "+position);

        //If view already exist just return back the view
        if(convertView!=null && convertView.getTag().equals(""+position)) {
            return convertView;
        }
        LayoutInflater  inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.flip_view, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flipCard(v);

                }
            });

        TextView imageContent = (TextView) convertView.findViewById(R.id.dispContent);
        imageContent.setText(imageStorageList.get(position).getImageContent());

            //Download the image using Image loader
            ImageView loadImage = (ImageView) convertView.findViewById(R.id.dispImage);
            imageDownloader.download(imageStorageList.get(position).getImageUrl(),loadImage);
            Log.d("item id","is "+position);
            convertView.setTag(""+position);


        return convertView;
    }



    public void flipCard(View view)
    {
        View rootLayout = (View) view.findViewById(R.id.main_activity_root);
        View cardFace = (View) view.findViewById(R.id.main_activity_card_face);
        View cardBack = (View) view.findViewById(R.id.main_activity_card_back);

        FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

        if (cardFace.getVisibility() == View.GONE)
        {
            flipAnimation.reverse();
        }
        rootLayout.startAnimation(flipAnimation);
    }

}