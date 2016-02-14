package randomappsinc.com.dishtac.Persistence;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import randomappsinc.com.dishtac.Utils.MyApplication;

/**
 * Created by alexanderchiou on 2/14/16.
 */
public class DatabaseManager {
    private static DatabaseManager instance;

    public static DatabaseManager get() {
        if (instance == null) {
            instance = getSync();
        }
        return instance;
    }

    private static synchronized DatabaseManager getSync() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    private Realm realm;

    private DatabaseManager() {
        realm = Realm.getInstance(MyApplication.get().getApplicationContext());
    }

    public List<DishDO> getFoodFeed() {
        RealmResults<DishDO> foodFeed = realm.where(DishDO.class)
                .findAll();
        foodFeed.sort("timeCreated", Sort.DESCENDING);
        return foodFeed;
    }

    public void addDish(final DishDO dish) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(dish);
            }
        });
    }

    public void updateDish(final DishDO dish) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                DishDO dishDO = realm.where(DishDO.class)
                        .equalTo("timeCreated", dish.getTimeCreated())
                        .findFirst();
                dishDO.setName(dish.getName());
                dishDO.setLocation(dish.getLocation());
                dishDO.setRating(dish.getRating());
                dishDO.setDescription(dish.getDescription());
                dishDO.setImagePath(dish.getImagePath());
            }
        });
    }
}
