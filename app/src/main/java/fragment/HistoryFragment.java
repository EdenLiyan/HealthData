package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liyan.healthdata.R;

import java.util.List;

import adapter.HistoryRecycleAdapter;
import util.DatabaseUtil;
import vo.TestData;

/**
 * Created by liyan on 2020/10/19.
 */

public class HistoryFragment extends Fragment {

    private HistoryRecycleAdapter historyRecycleAdapter;
    private DatabaseUtil databaseUtil;
    private List<TestData> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.history_fragment,null);

        databaseUtil= new DatabaseUtil(getContext());
        list = databaseUtil.selectData();

        historyRecycleAdapter = new HistoryRecycleAdapter(getContext(),list);



        return view;
    }
}
