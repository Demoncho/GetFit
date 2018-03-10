package ru.demoncho.getfit.Food;

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

public class item_food extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_food, null);
        getIncomingArguments(view);
        return view;
    }

    private void getIncomingArguments(View view){
        if(!(getArguments().getString("titles").isEmpty())){
            String titles = getArguments().getString("titles");
            String srok = getArguments().getString("srok");
            String protiv = getArguments().getString("protiv");
            String effect = getArguments().getString("effect");
            String metod = getArguments().getString("metod");
            setContent(view, titles, srok, protiv, effect, metod);
        }
    }


    private void setContent(View view, String titles, String srok, String protiv, String effect, String metod){
        TextView tv_title = view.findViewById(R.id.item_title);
        tv_title.setText(titles);

        TextView tv_protiv = view.findViewById(R.id.item_protiv_description);
        tv_protiv.setText(protiv);

        TextView tv_srok = view.findViewById(R.id.item_srok_description);
        tv_srok.setText(srok);

        TextView tv_effect = view.findViewById(R.id.item_effect_description);
        tv_effect.setText(effect);

        TextView tv_metod = view.findViewById(R.id.item_metod_description);
        tv_metod.setText(metod);
    }

}