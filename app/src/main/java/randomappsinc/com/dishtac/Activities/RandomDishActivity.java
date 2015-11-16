package randomappsinc.com.dishtac.Activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.rey.material.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import randomappsinc.com.dishtac.R;

/**
 * Created by alexanderchiou on 11/15/15.
 */
public class RandomDishActivity extends StandardActivity {
    @Bind(R.id.dish_rating) RatingBar dishRating;
    @Bind(R.id.submit) Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_form);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        submitButton.setVisibility(View.GONE);
        Drawable progress = dishRating.getProgressDrawable();
        DrawableCompat.setTint(progress, getResources().getColor(R.color.app_red));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.random_dish_menu, menu);
        menu.findItem(R.id.refresh).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_refresh)
                        .colorRes(R.color.white)
                        .actionBarSize());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
        }
        return super.onOptionsItemSelected(item);
    }
}
