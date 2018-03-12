package ru.demoncho.getfit.training;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.demoncho.getfit.R;

import static ru.demoncho.getfit.MainActivity.PACKAGE_NAME;

/**
 * Created by Дмитрий on 12.03.2018.
 */

public class item_training extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_training, null);
        getIncomingArguments(view);
        return view;
    }

    private void getIncomingArguments(View view){
        if(!(getArguments().getString("titles").isEmpty())){
            String title = getArguments().getString("titles");
            String item = getArguments().getString("items");
            setContent(view, title, item, null);
        }
    }

    private void setContent(View view, String title, String item, @Nullable Bundle savedInstanceState){
        TextView tv_title = view.findViewById(R.id.item_title);
        tv_title.setText(title);

        TextView tv_metod = view.findViewById(R.id.item_description);
        int resId = getResources().getIdentifier(item, "string", PACKAGE_NAME);
        tv_metod.setText(Html.fromHtml(getString(resId)));

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(title);
    }
}
