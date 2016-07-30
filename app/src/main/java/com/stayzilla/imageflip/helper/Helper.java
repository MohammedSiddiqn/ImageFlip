package com.stayzilla.imageflip.helper;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stayzilla.imageflip.R;

/**
 * Created by Mohammed on 30/07/16.
 *
 */
public class Helper {

    /**
     * Contains basic static methods which are frequently used having
     * no business logic
     */


    /**
     *
     * Checks whether internet is available or not
     * requires ACCESS_NETWORK_STATE permission
     * return true if yes else false
     * @param activity reference of calling activity
     */
    public static boolean isNetworkAvailable(final Activity activity) {
        try {
            if(activity!=null){
                ConnectivityManager connectivity = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivity != null) {
                    NetworkInfo[] info = connectivity.getAllNetworkInfo();
                    if (info != null) {
                        for (int i = 0; i < info.length; i++) {
                            if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                                return true;
                            }
                        }
                    }
                }
            }else{

                Log.e("Is network","activity is null");
            }


        }catch (RuntimeException ex){
            Log.e("Is network","activity is null "+ ex.getMessage());
        }
//Toast.makeText(activity,"Pls check your internet connection",Toast.LENGTH_LONG).show();
//show dialog message


        return false;
    }



    /**
     * Displays snack bar
     * @param parent reference of parent layout
     * @param message message to be displayed on the snackbar
     * @param context context of calling activity.
     */
    public static void SnackBarLayout(View parent, String message, Context context) {

        try {
            if(context != null) {
                Snackbar snackbar = Snackbar
                        .make(parent, message, Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();

                TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(context.getResources().getColor(R.color.colorBlue));

                snackbar.show();
            }
        }catch (RuntimeException ex){

            Log.e("Snackbar","::error "+ ex.getMessage());

        }
    }
}
