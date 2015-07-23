package intership.dev.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import intership.dev.adapter.ListViewAdapter;
import intership.dev.contact.R;

/**
 * Created by vanteo89 on 7/23/2015.
 */
public class ListUserFragment extends Fragment {
    ListView lv_Info;
    ListViewAdapter listViewAdapter;
    public String TextInfos[] = {"Brunch this weekend ?", "Summer BBQ", "Oui Oui", "BirthDay Gift", "Recipe to try", "Giant Game", "Giant Game"};
    public Integer ImgInfos[] = {R.drawable.ic_nu, R.drawable.ic_summer_bbq, R.drawable.ic_oui_oui_1,
            R.drawable.ic_birth_with, R.drawable.ic_recipe_to_try_1, R.drawable.ic_oui_oui_2, R.drawable.ic_oui_oui_2};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_user_fragment, container, false);
        lv_Info = (ListView) view.findViewById(R.id.lvInfo);
        listViewAdapter = new ListViewAdapter(getActivity(), R.layout.custom_listview, TextInfos, ImgInfos);
        lv_Info.setAdapter(listViewAdapter);
        return view;
    }
}

