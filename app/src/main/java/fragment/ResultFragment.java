package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liyan.healthdata.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import util.DatabaseUtil;
import util.TestUtil;
import vo.TestData;

/**
 * Created by liyan on 2020/10/19.
 */

public class ResultFragment extends Fragment {

    private TextView title1;
    private TextView title2;
    private TextView miss1;
    private TextView miss2;
    private TextView t1;
    private TextView t2;
    private TextView t2_1;
    private TextView t3;
    private TextView t4;
    private TextView t4_1;
    private TextView t5;
    private TextView t6;
    private TextView t6_1;
    private TextView t7;
    private TextView t8;
    private Button saveBtn;

    private String sex;
    private String weight;
    private String fat;
    private String age;
    private String bmi;
    private String metabolism;
    private String viscera;

    private TestUtil testUtil;
    private DatabaseUtil databaseUtil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.result_fragment, null);
        title1 = view.findViewById(R.id.title1);
        title2 = view.findViewById(R.id.title2);
        miss1 = view.findViewById(R.id.miss1);
        miss2 = view.findViewById(R.id.miss2);
        t1 = view.findViewById(R.id.t1);
        t2 = view.findViewById(R.id.t2);
        t2_1 = view.findViewById(R.id.t2_1);
        t3 = view.findViewById(R.id.t3);
        t4 = view.findViewById(R.id.t4);
        t4_1 = view.findViewById(R.id.t4_1);
        t5 = view.findViewById(R.id.t5);
        t6 = view.findViewById(R.id.t6);
        t6_1 = view.findViewById(R.id.t6_1);
        t7 = view.findViewById(R.id.t7);
        t8 = view.findViewById(R.id.t8);
        saveBtn = view.findViewById(R.id.result_save);

        testUtil = new TestUtil();
        databaseUtil = new DatabaseUtil(getContext());

        return view;
    }

    public void getTestData(final List<TestData> list) {

        if (!list.isEmpty()) {

            miss1.setVisibility(View.INVISIBLE);
            miss2.setVisibility(View.INVISIBLE);
            saveBtn.setVisibility(View.VISIBLE);

            final Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (int i = 0; i < list.size(); i++) {
                sex = list.get(i).gettSex();
                weight = list.get(i).gettWeight();
                fat = list.get(i).gettFat();
                age = list.get(i).gettAge();
                bmi = list.get(i).gettBmi();
                metabolism = list.get(i).gettMetabolism();
                viscera = list.get(i).gettViscera();
                System.out.println("全局常量     :"+sex+weight+fat+age+bmi+metabolism+viscera);

                t1.setText(getResources().getString(R.string.result_text_weight) + list.get(i).gettWeight());
                t2.setText(getResources().getString(R.string.result_text_fat) + list.get(i).gettFat());

                if (list.get(i).gettSex().equals("男"))
                    t2_1.setText(getResources().getString(R.string.result_text_fat1));
                else
                    t2_1.setText(getResources().getString(R.string.result_text_fat2));

                t3.setText(getResources().getString(R.string.result_text_body_age) + list.get(i).gettAge());
                t4.setText(getResources().getString(R.string.result_text_bmi) + list.get(i).gettBmi());
                t4_1.setText(getResources().getString(R.string.result_text_bmi1));
                t5.setText(getResources().getString(R.string.result_text_metabolism) + list.get(i).gettMetabolism());
                t6.setText(getResources().getString(R.string.result_text_viscera) + list.get(i).gettViscera());
                t6_1.setText(getResources().getString(R.string.result_text_viscera1));

                t7.setText("您的身体指数为：" + testUtil.weightTestUtil(list.get(i).gettBmi()) + "\n" + "\n"
                        + "您的身体脂肪比例为：" + testUtil.fatTestUtil(list.get(i).gettFat(), list.get(i).gettSex()) + "\n" + "\n"
                        + "您的内脏脂肪比例为：" + testUtil.visceraTestUtil(list.get(i).gettViscera())
                );

                t8.setText("测试日期：" + dateFormat.format(date));

            }
            saveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    databaseUtil.insertData(sex,weight,fat,age,bmi,metabolism,viscera);

                }
            });
        } else {
            miss1.setVisibility(View.VISIBLE);
            miss2.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.INVISIBLE);
            Toast.makeText(getContext(), "测试失败！请重新测试", Toast.LENGTH_LONG).show();
        }
    }

}

