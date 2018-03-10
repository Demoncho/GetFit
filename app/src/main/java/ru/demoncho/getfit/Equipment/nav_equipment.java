package ru.demoncho.getfit.Equipment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.demoncho.getfit.Food.RVAdapter_food;
import ru.demoncho.getfit.R;

/**
 * Created by pvoro on 08.03.2018.
 */

public class nav_equipment extends Fragment {
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mItems = new ArrayList<>();
    private ArrayList<String> mItems_titles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_equipment, null);
        initImageBitmaps(view);
        return view;
    }

    //Загружает картинки и названия для элементов списка
    private void initImageBitmaps(View view){
        // без if создает копии каждый раз при нажатии, потом доделаем
        if (mItems_titles.isEmpty()){
            mImages.add("vello");
            mItems_titles.add(getString(R.string.Velo_title));
            mItems.add("vello_description");
        }

        initRecyclerView(view);
    }

    //Инициализация списка
    private void initRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view);
        RVAdapter_equipment adapter = new RVAdapter_equipment(this.getActivity(), mImages, mItems_titles, mItems, getFragmentManager());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Спортивные снаряды");
    }
}
