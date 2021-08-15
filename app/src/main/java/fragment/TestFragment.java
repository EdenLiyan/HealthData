package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.liyan.healthdata.R;

import java.util.ArrayList;
import java.util.List;

import vo.TestData;

/**
 * Created by liyan on 2020/10/19.
 */

public class TestFragment extends Fragment {

    private EditText weightEdit;
    private EditText fatEdit;
    private EditText ageEdit;
    private EditText bmiEdit;
    private EditText metabolismEdit;
    private EditText visceraEdit;
    private Button testCommit;
    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;

    private List<TestData> editList;
    public String sexValue = "男";
    public String weightValue = null;
    public String fatValue = null;
    public String ageValue = null;
    public String bmiValue = null;
    public String metabolismValue = null;
    public String visceraValue = null;

    TestListener testListener;
    TestFragment testFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //实例化接口
        testListener = (TestListener) getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.test_fragment, null);

        rg = view.findViewById(R.id.test_rg);
        rb1 = view.findViewById(R.id.test_rb1);
        rb2 = view.findViewById(R.id.test_rb2);
        weightEdit = view.findViewById(R.id.test_weight);
        fatEdit = view.findViewById(R.id.test_fat);
        ageEdit = view.findViewById(R.id.test_age);
        bmiEdit = view.findViewById(R.id.test_bmi);
        metabolismEdit = view.findViewById(R.id.test_metabolism);
        visceraEdit = view.findViewById(R.id.test_viscera_fat);
        testCommit = view.findViewById(R.id.test_commit);

        initView();

        return view;
    }

    private void initView() {
        editList = new ArrayList<>();
        testFragment = new TestFragment();
        final TestData testData = new TestData();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.test_rb1:
                    sexValue = "男";
                    rb1.setChecked(true);
                    rb2.setChecked(false);
                    break;

                    case R.id.test_rb2:
                    sexValue = "女";
                    rb1.setChecked(false);
                    rb2.setChecked(true);
                    break;
                }
            }
        });

        testCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                weightValue = weightEdit.getText().toString();
                fatValue = fatEdit.getText().toString();
                ageValue = ageEdit.getText().toString();
                bmiValue = bmiEdit.getText().toString();
                metabolismValue = metabolismEdit.getText().toString();
                visceraValue = visceraEdit.getText().toString();

                boolean a = TextUtils.isEmpty(weightValue);
                boolean b = TextUtils.isEmpty(fatValue);
                boolean c = TextUtils.isEmpty(ageValue);
                boolean d = TextUtils.isEmpty(bmiValue);
                boolean e = TextUtils.isEmpty(metabolismValue);
                boolean f = TextUtils.isEmpty(visceraValue);

                System.out.println("a：" + a + " , " + "b：" + b + " , " + "c：" + c + " , " + "d：" + d + " , " + "e：" + e + " , " + "f：" + f);

                if (a | b | c | d | e | f) {
                    Toast.makeText(getContext(), "所有项均为必填项", Toast.LENGTH_SHORT).show();
                } else {

                    testData.settSex(sexValue);
                    testData.settWeight(weightValue);
                    testData.settAge(ageValue);
                    testData.settBmi(bmiValue);
                    testData.settFat(fatValue);
                    testData.settMetabolism(metabolismValue);
                    testData.settViscera(visceraValue);

                    editList.add(testData);
                    //通过接口，发送消息
                    testListener.sendTest(editList);
                }
            }
        });
    }

    //定义一个接口
    public interface TestListener {
        void sendTest(List<TestData> s);
    }
}
