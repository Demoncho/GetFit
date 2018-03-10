package ru.demoncho.getfit.Food;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import ru.demoncho.getfit.R;
import ru.demoncho.getfit.Workout.item_workout;

/**
 * Created by User on 1/1/2018.
 */

public class RVAdapter_food extends RecyclerView.Adapter<RVAdapter_food.ViewHolder>{

    private ArrayList<String> mItem_titles = new ArrayList<>();
    private ArrayList<String> mItem_srok = new ArrayList<>();
    private ArrayList<String> mItem_protiv = new ArrayList<>();
    private ArrayList<String> mItem_effect = new ArrayList<>();
    private ArrayList<String> mItem_metod = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private Context mContext;
    public FragmentManager f_manager; // нужно для смены фрагментов между собой

    public RVAdapter_food(Context context, ArrayList<String> images, ArrayList<String> titles, ArrayList<String> protiv, ArrayList<String> srok, ArrayList<String> effect, ArrayList<String> metod, FragmentManager f_manager) {
        mImageUrls = images;
        mItem_titles = titles;
        mItem_srok = srok;
        mItem_protiv = protiv;
        mItem_effect = effect;
        mItem_metod = metod;
        mContext = context;
        this.f_manager = f_manager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // действия при клике на элемент
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into(holder.image);

        holder.imageName.setText(mItem_titles.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext, mItem_titles.get(position), Toast.LENGTH_SHORT).show();
                Fragment argumentFragment = new item_food();
                Bundle data = new Bundle();//create bundle instance
                data.putString("titles", mItem_titles.get(position));
                data.putString("srok", mItem_srok.get(position));
                data.putString("protiv", mItem_protiv.get(position));
                data.putString("effect", mItem_effect.get(position));
                data.putString("metod", mItem_metod.get(position));
                argumentFragment.setArguments(data);
                f_manager.beginTransaction().replace(R.id.screen_area, argumentFragment).addToBackStack("my_fragment1").commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItem_titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}















