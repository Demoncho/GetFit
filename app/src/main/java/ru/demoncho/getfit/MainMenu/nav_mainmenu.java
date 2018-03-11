package ru.demoncho.getfit.MainMenu;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.demoncho.getfit.R;

/**
 * Created by Дмитрий on 10.03.2018.
 */

public class nav_mainmenu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_mainmenu, null);

        return view;
    }

    public void onBicepsCLick(View view){

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Главное меню");
    }
}
