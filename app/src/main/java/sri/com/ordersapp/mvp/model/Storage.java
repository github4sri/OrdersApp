package sri.com.ordersapp.mvp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sri. on 22-08-2017.
 * emails4srikanth@gmail.com
 */
public class Storage extends SQLiteOpenHelper {

    private static final String TAG = Storage.class.getSimpleName();

    private static final String DESCRIPTION = "description";
    private static final String IMAGE_URL = "imageUrl";
    private static final String TABLE_NAME = "orders";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            DESCRIPTION + " text not null," +
            IMAGE_URL + " text not null)";

    public Storage(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
