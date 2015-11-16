package randomappsinc.com.dishtac.Fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import randomappsinc.com.dishtac.Activities.DishFormActivity;
import randomappsinc.com.dishtac.R;

/**
 * Created by alexanderchiou on 11/15/15.
 */
public class FoodFeedFragment extends Fragment{
    @Bind(R.id.add_dish) FloatingActionButton addDish;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.food_feed, container, false);
        ButterKnife.bind(this, rootView);
        addDish.setImageDrawable(new IconDrawable(getActivity(), FontAwesomeIcons.fa_plus)
                .colorRes(R.color.white)
                .actionBarSize());
        return rootView;
    }

    @OnClick(R.id.add_dish)
    public void addDish() {
        getActivity().startActivity(new Intent(getActivity(), DishFormActivity.class));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.add_dish)
    public void addMonster(View view) {
        //
    }
}