package randomappsinc.com.dishtac.Activities;

import android.os.Bundle;

import butterknife.ButterKnife;
import randomappsinc.com.dishtac.R;

/**
 * Created by alexanderchiou on 11/15/15.
 */
public class TopRestaurantsActivity extends StandardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_restaurants);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
