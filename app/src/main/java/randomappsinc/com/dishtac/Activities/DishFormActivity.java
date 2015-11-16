package randomappsinc.com.dishtac.Activities;

import android.os.Bundle;

import butterknife.ButterKnife;
import randomappsinc.com.dishtac.Adapters.FontAwesomeAdapter;
import randomappsinc.com.dishtac.R;

/**
 * Created by alexanderchiou on 11/15/15.
 */
public class DishFormActivity extends StandardActivity {
    public static String DISH_KEY = "dish";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_form);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null) {
            setTitle(R.string.update_dish);
        }
        else {
            setTitle(R.string.add_dish);
        }
    }
}
