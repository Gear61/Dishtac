package randomappsinc.com.dishtac.Activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.widget.RatingBar;

import com.rey.material.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import randomappsinc.com.dishtac.R;

/**
 * Created by alexanderchiou on 11/15/15.
 */
public class DishFormActivity extends StandardActivity {
    @Bind(R.id.dish_rating) RatingBar dishRating;
    @Bind(R.id.submit) Button submitButton;

    public static String DISH_KEY = "dish";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_form);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null) {
            submitButton.setText(R.string.update_dish);
        }
        else {
            submitButton.setText(R.string.add_dish);
        }

        Drawable progress = dishRating.getProgressDrawable();
        DrawableCompat.setTint(progress, getResources().getColor(R.color.app_red));
    }

    @OnClick(R.id.submit)
    public void submitDish(View view) {

    }
}
