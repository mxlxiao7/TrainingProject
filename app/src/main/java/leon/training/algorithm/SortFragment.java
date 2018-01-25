package leon.training.algorithm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Arrays;

import leon.training.BaseFragment;
import leon.trainingproject.R;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
@SuppressLint("ValidFragment")
public class SortFragment extends BaseFragment implements View.OnClickListener {


    private Button mSendBtn;
    private TextView mTextTV;
    private EditText mNumET;
    private ProgressBar mPB;

    private Strategy mStrategy;
    private TextView mSectionArrayTV;

    private int mNum = 10;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SortFragment newInstance(Strategy s) {
        SortFragment fragment = new SortFragment(s);
        return fragment;
    }

    public SortFragment() {

    }

    public SortFragment(Strategy s) {
        mStrategy = s;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_decorator_layout, container, false);
        mTextTV = (TextView) rootView.findViewById(R.id.section_label);
        mSectionArrayTV = (TextView) rootView.findViewById(R.id.section_array);
        mSendBtn = (Button) rootView.findViewById(R.id.bt_send);
        mSendBtn.setOnClickListener(this);
        mPB = (ProgressBar) rootView.findViewById(R.id.pb);
        mNumET = (EditText) rootView.findViewById(R.id.et_in_num);
        mNumET.setText(String.valueOf(mNum));
        mNumET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mNum = Integer.parseInt(TextUtils.isEmpty(charSequence) ? "0" : charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ((TextView) rootView.findViewById(R.id.tv_tip)).setText(mStrategy.getTip());
        return rootView;
    }

    @Override
    public void onResume() {
        super.onPause();
    }

    @Override
    public void onPause() {
        super.onStop();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_send:
                mPB.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        doAction();
                    }
                }).start();
                break;
        }
    }


    /**
     *
     */
    private void doAction() {
        final long s = System.currentTimeMillis();
        final int[] data = Creator.randomArray(1, mNum, mNum);

        final String bs = Arrays.toString(data);

        final long s1 = System.currentTimeMillis();
        final long end = s1 - s;

        Client c = new Client(mStrategy);
        c.sort(data);

        final long end1 = System.currentTimeMillis() - s1;

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextTV.setText(getString(R.string.sort_time, new Object[]{end, end1}));
                String s = "排序前：" + bs + "\n排序后：" + Arrays.toString(data);
                mSectionArrayTV.setText(s);
                mPB.setVisibility(View.GONE);
            }
        });
    }
}
