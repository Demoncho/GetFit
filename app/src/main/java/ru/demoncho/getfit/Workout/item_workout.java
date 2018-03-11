package ru.demoncho.getfit.Workout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ru.demoncho.getfit.R;

/**
 * Created by User on 1/2/2018.
 */

public class item_workout extends Fragment {

    private static final String TAG = "item_workout";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "allo");
        View view = inflater.inflate(R.layout.item_workout, null);
        getIncomingArguments(view);
        return view;
    }

    private void getIncomingArguments(View view){
        Log.d(TAG, "getIncomingArguments: checking for incoming intents.");

        if(!(getArguments().getString("image_url").isEmpty() && getArguments().getString("image_name").isEmpty())){
            Log.d(TAG, "getIncomingArguments: found Arguments extras.");

            String imageUrl = getArguments().getString("image_url");
            String imageName = getArguments().getString("image_name");

            setImage(view, imageUrl, imageName);
        }
    }


    private void setImage(View view, String imageUrl, String imageName){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = view.findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image = view.findViewById(R.id.image);
        Glide.with(this)
                .asGif()
                .load(R.drawable.ser_1)
                .into(image);
    }

}


















