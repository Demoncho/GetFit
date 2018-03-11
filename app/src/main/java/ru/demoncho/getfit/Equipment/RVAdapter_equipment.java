package ru.demoncho.getfit.Equipment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import ru.demoncho.getfit.Food.item_food;
import ru.demoncho.getfit.R;

import static ru.demoncho.getfit.MainActivity.PACKAGE_NAME;

/**
 * Created by User on 1/1/2018.
 */

public class RVAdapter_equipment extends RecyclerView.Adapter<RVAdapter_equipment.ViewHolder>{
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mItems_titles = new ArrayList<>();
    private ArrayList<String> mItems = new ArrayList<>();
    //private ArrayList<String> mImageUrls = new ArrayList<>();

    private Context mContext;
    public FragmentManager f_manager; // нужно для смены фрагментов между собой

    public RVAdapter_equipment(Context context, ArrayList<String> images, ArrayList<String> titles, ArrayList<String> items, FragmentManager f_manager) {
        mImages = images;
        mItems_titles = titles;
        mItems = items;
        mContext = context;
        this.f_manager = f_manager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem_equipment, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // действия при клике на элемент
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(R.drawable.velo)
                .into(holder.image);

        holder.imageName.setText(mItems_titles.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment argumentFragment = new item_equipment();
                Bundle data = new Bundle();//create bundle instance
                data.putString("images", mImages.get(position));
                data.putString("titles", mItems_titles.get(position));
                data.putString("items", mItems.get(position));
                argumentFragment.setArguments(data);
                f_manager.beginTransaction().replace(R.id.screen_area, argumentFragment).addToBackStack("my_fragment2").commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems_titles.size();
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














