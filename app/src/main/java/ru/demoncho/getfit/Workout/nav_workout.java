package ru.demoncho.getfit.Workout;

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
import ru.demoncho.getfit.R;

/**
 * Created by pvoro on 08.03.2018.
 */

public class nav_workout extends Fragment {
    private static final String TAG = "Workout Fragment";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_workout, null);
        initImageBitmaps(view);
        return view;
    }

    //Загружает картинки и названия для элементов списка
    private void initImageBitmaps(View view){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        // без if создает копии каждый раз при нажатии, потом доделаем
        if (mNames.isEmpty() && mImageUrls.isEmpty()){
        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Бицепс");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Грудь");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Ноги");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Плечи");

        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Пресс");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Спина");

        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("Трицепс");
        }

        initRecyclerView(view);
    }

    //Инициализация списка
    private void initRecyclerView(View view){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view);
        RVAdapter_workout adapter = new RVAdapter_workout(this.getActivity(), mNames, mImageUrls, getFragmentManager());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Упражнения");
    };

}
