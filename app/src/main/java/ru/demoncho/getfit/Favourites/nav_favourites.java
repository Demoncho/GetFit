package ru.demoncho.getfit.Favourites;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import ru.demoncho.getfit.Food.item_food;
import ru.demoncho.getfit.R;
import ru.demoncho.getfit.Workout.RVAdapter_workout;
import ru.demoncho.getfit.training.item_training;

/**
 * Created by pvoro on 08.03.2018.
 */

public class nav_favourites extends Fragment implements View.OnTouchListener{
    private StorageReference mStorageRef;
    private TextView mFavTVFood;
    private String title_food;
    private String item_food;
    private String title_training;
    private String item_training;
    private TextView mFavTVTraining;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_favourite, null);
        initFavourites(view);
        return view;
    }

    //Загружает картинки и названия для элементов списка
    private void initFavourites(View view){
        mFavTVFood = view.findViewById(R.id.fav_food_link);
        mFavTVTraining = view.findViewById(R.id.fav_training_link);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        mStorageRef = storageRef.child("food/fav.dat");
        mFavTVFood.setOnTouchListener((View.OnTouchListener) this);
        mFavTVTraining.setOnTouchListener((View.OnTouchListener) this);

        mStorageRef.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
            @Override
            public void onSuccess(StorageMetadata storageMetadata) {
                mFavTVFood.setText(storageMetadata.getContentType());
                title_food = storageMetadata.getCustomMetadata("title");
                item_food = storageMetadata.getCustomMetadata("item");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
            }
        });

        mStorageRef = storageRef.child("training/fav.dat");
        mStorageRef.getMetadata().addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
            @Override
            public void onSuccess(StorageMetadata storageMetadata) {
                mFavTVTraining.setText(storageMetadata.getContentType());
                title_training= storageMetadata.getCustomMetadata("title");
                item_training = storageMetadata.getCustomMetadata("item");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Избранное");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // check which textview it is and do what you need to do;
        FragmentManager f_manager = getFragmentManager();
        if (v.getId() == R.id.fav_food_link){
            Fragment argumentFragment = new item_food();
            Bundle data = new Bundle();//create bundle instance
            data.putString("titles", title_food);
            data.putString("items", item_food);
            argumentFragment.setArguments(data);
            f_manager.beginTransaction().replace(R.id.screen_area, argumentFragment).addToBackStack("my_fav_food").commit();
        }
        else if (v.getId() == R.id.fav_training_link){
            Fragment argumentFragment = new item_training();
            Bundle data = new Bundle();//create bundle instance
            data.putString("titles", title_training);
            data.putString("items", item_training);
            argumentFragment.setArguments(data);
            f_manager.beginTransaction().replace(R.id.screen_area, argumentFragment).addToBackStack("my_fav_training").commit();
        }
        // return true if you don't want it handled by any other touch/click events after this
        return true;
    }
}
