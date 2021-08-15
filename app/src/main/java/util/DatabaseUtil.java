package util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vo.TestData;

/**
 * Created by liyan on 2020/11/20.
 */

public class DatabaseUtil {

    private SQLiteDatabase sqLiteDatabase;

    public DatabaseUtil(Context context) {
        DatabaseCreate databaseCreate = new DatabaseCreate(context);
        sqLiteDatabase = databaseCreate.getWritableDatabase();

    }


    public void insertData(String sex, String weight, String fat, String age, String bmi, String metabolism, String viscera) {
        System.out.println("插入     :" + sex + weight + fat + age + bmi + metabolism + viscera);
        String sql = "insert into test_data(sex,weight,fat,age,bmi,metabolism,viscera) values(?,?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{sex, weight, fat, age, bmi, metabolism, viscera});

    }

    public List<TestData> selectData() {

        String sql = "select * from test_data";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        List<TestData> list = new ArrayList<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String sex = cursor.getString(1);
            String weight = cursor.getString(2);
            String fat = cursor.getString(3);
            String age = cursor.getString(4);
            String bmi = cursor.getString(5);
            String metabolism = cursor.getString(6);
            String viscera = cursor.getString(7);

            TestData testData = new TestData(id, sex, weight, fat, age, bmi, metabolism, viscera);
            list.add(testData);
        }

        return list;
    }

    public void deleteData(int id) {
        String sql = "delete form test_data where _id=" + id + "";
        sqLiteDatabase.execSQL(sql);
    }


}
