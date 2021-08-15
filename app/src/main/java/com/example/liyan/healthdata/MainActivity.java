package com.example.liyan.healthdata;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import fragment.HistoryFragment;
import fragment.ResultFragment;
import fragment.TestFragment;
import vo.TestData;

public class MainActivity extends FragmentActivity implements TestFragment.TestListener {

    public String test_tag = "TEST_TAG";
    public String result_tag = "RESULT_TAG";
    public String history_tag = "HISTORY_TAG";

    private RadioGroup radioGroup;
    private RadioButton rb_test;
    private RadioButton rb_result;
    private RadioButton rb_history;
    private TestFragment testFragment;
    private ResultFragment resultFragment;
    private HistoryFragment historyFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.rg);
        rb_test = findViewById(R.id.rb_test);
        rb_result = findViewById(R.id.rb_result);
        rb_history = findViewById(R.id.rb_history);

        initView();

    }

    private void initView() {

        testFragment = new TestFragment();
        resultFragment = new ResultFragment();
        historyFragment = new HistoryFragment();
        fragmentList = new ArrayList<>();
        fragmentList.add(testFragment);
        fragmentList.add(resultFragment);
        fragmentList.add(historyFragment);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentShow(testFragment, true, true, test_tag);
        fragmentShow(resultFragment, false, true, result_tag);
        fragmentShow(historyFragment, false, true, history_tag);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {

                    case R.id.rb_test:
                        fragmentShow(testFragment, true, false, test_tag);
                        System.out.println("dian ji test button");
                        break;

                    case R.id.rb_result:
                        fragmentShow(resultFragment, true, false, result_tag);
                        break;

                    case R.id.rb_history:
                        fragmentShow(historyFragment, true, false, history_tag);
                        break;
                }

            }
        });

    }

    private void fragmentShow(Fragment fragment, boolean isShow, boolean isAdd, String tag) {

        fragmentTransaction = fragmentManager.beginTransaction();

        if (isAdd) {
            fragmentTransaction.add(R.id.frame_layout, fragment, tag);
        }

        if (isShow) {
            for (Fragment myFragment : fragmentList) {
                if (myFragment.equals(fragment)) {
                    fragmentTransaction.show(myFragment);
                } else {
                    fragmentTransaction.hide(myFragment);
                }
            }

        } else {
            fragmentTransaction.hide(fragment);
        }

        fragmentTransaction.commit();

    }

    //接收TestFragment里接口发送过来的消息
    @Override
    public void sendTest(List<TestData> s) {

        resultFragment = (ResultFragment) fragmentManager.findFragmentByTag(result_tag);
        resultFragment.getTestData(s);

        fragmentShow(resultFragment, true, false, result_tag);

        rb_test.setChecked(false);
        rb_result.setChecked(true);

    }
}
