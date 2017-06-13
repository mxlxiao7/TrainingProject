package leon.training.groovy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import leon.training.BaseFragment;
import leon.trainingproject.R;

/**
 * Created by maxiaolong on 2016/11/28.
 */
public class GroovyFragment extends BaseFragment {

    private static final String TAG = GroovyFragment.class.getSimpleName();
    TextView textView1;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button mBtn;

    public GroovyFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static GroovyFragment newInstance() {
        GroovyFragment fragment = new GroovyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_groovy_layout, container, false);

        mBtn = (Button) rootView.findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction();
            }
        });
        return rootView;
    }

    private void doAction() {
//        leon.training.groovy.GroovyTest test = new leon.training.groovy.GroovyTest("赵云", 20);
//        test.print();
    }
}