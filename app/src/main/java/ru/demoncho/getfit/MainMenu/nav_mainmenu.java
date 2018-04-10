package ru.demoncho.getfit.MainMenu;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import ru.demoncho.getfit.R;
import ru.demoncho.getfit.Workout.item_workout;

/**
 * Created by Дмитрий on 10.03.2018.
 */

public class nav_mainmenu extends Fragment {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<Integer> first = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_mainmenu, null);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Главное меню");
    }

    /*
    public boolean onTouch (View v, MotionEvent ev) {

        final int action = ev.getAction();

        final int evX = (int) ev.getX();
        final int evY = (int) ev.getY();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                ImageView img = (ImageView) v.findViewById(R.id.body_image);
                img.setDrawingCacheEnabled(true);
                Bitmap imgbmp = Bitmap.createBitmap(img.getDrawingCache());
                img.setDrawingCacheEnabled(false);
                int pxl = imgbmp.getPixel(evX, evY);
                int r = Color.red(pxl);
                int g = Color.green(pxl);
                int b = Color.blue(pxl);
                if (r == 255 && g == 245) {  // грудь

                }
                else if(r == )



                break;
        }

        return true;
    }

    public void LoadItem() {
        FragmentManager f_manager = getFragmentManager();
        Fragment argumentFragment = new item_workout();
        Bundle data = new Bundle();//create bundle instance



        argumentFragment.setArguments(data);
        f_manager.beginTransaction().replace(R.id.screen_area, argumentFragment).addToBackStack("my_fragment").commit();

    }
    */
    }
