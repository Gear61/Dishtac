package randomappsinc.com.dishtac.Activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import randomappsinc.com.dishtac.Fragments.FoodFeedFragment;
import randomappsinc.com.dishtac.Fragments.NavigationDrawerFragment;
import randomappsinc.com.dishtac.R;

public class HomepageActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    @Bind(R.id.add_dish) FloatingActionButton addDish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        ButterKnife.bind(this);

        addDish.setImageDrawable(new IconDrawable(this, FontAwesomeIcons.fa_plus)
                .colorRes(R.color.white)
                .actionBarSize());

        NavigationDrawerFragment mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));

        FragmentManager fragmentManager = getFragmentManager();
        FoodFeedFragment foodFeedFragment = new FoodFeedFragment();
        fragmentManager.beginTransaction().replace(R.id.container, foodFeedFragment).commit();
    }

    @OnClick(R.id.add_dish)
    public void addDish() {
        startActivity(new Intent(this, DishFormActivity.class));
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.slide_left_out, R.anim.slide_left_in);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, TopLocationsActivity.class);
                break;
            case 1:
                intent = new Intent(this, RandomDishActivity.class);
                break;
            case 2:
                intent = new Intent(this, SettingsActivity.class);
        }
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homepage_menu, menu);
        menu.findItem(R.id.search).setIcon(
                new IconDrawable(this, FontAwesomeIcons.fa_search)
                        .colorRes(R.color.white)
                        .actionBarSize());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search) {
            startActivity(new Intent(this, SearchActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}