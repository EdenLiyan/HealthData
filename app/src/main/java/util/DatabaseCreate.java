package util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by liyan on 2020/11/20.
 */

public class DatabaseCreate extends SQLiteOpenHelper {

    public DatabaseCreate(Context context) {
        super(context,"mydatabase",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table test_data(_id integer primary key autoincrement,sex varchar(20),weight varchar(20)," +
                "fat varchar(20),age varchar(20),bmi varchar(20),metabolism varchar(20),viscera varchar(20))";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
