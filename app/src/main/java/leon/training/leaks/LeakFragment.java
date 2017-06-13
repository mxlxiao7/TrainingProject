package leon.training.leaks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import leon.training.BaseFragment;
import leon.training.designpattern.structure.adapter.AdapterFragment;
import leon.trainingproject.R;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class LeakFragment extends BaseFragment {

    private static final String TAG = AdapterFragment.class.getSimpleName();
    private Button mBtn;
    private Button mClearBtn;

    public LeakFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static LeakFragment newInstance() {
        LeakFragment fragment = new LeakFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leak_layout, container, false);
        mBtn = (Button) rootView.findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LeakActivity.class));
            }
        });
        mClearBtn = (Button) rootView.findViewById(R.id.clear);
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "清空Activity强引用 " + LeakActivity.ACTIVITY_CACHE.size(), 0).show();
                LeakActivity.ACTIVITY_CACHE.clear();
            }
        });
        return rootView;
    }
}
