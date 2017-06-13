package leon.training.lambda;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import leon.training.BaseFragment;
import leon.trainingproject.R;

/**
 * Created by maxiaolong on 2016/11/28.
 */
public class LambdaFragment extends BaseFragment {

    private static final String TAG = LambdaFragment.class.getSimpleName();
    TextView textView1;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button mBtn;

    public LambdaFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static LambdaFragment newInstance() {
        LambdaFragment fragment = new LambdaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lambda_layout, container, false);

        mBtn = (Button) rootView.findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction();
            }
        });
        return rootView;
    }


    String[] atp = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka",
            "David Ferrer", "Roger Federer",
            "Andy Murray", "Tomas Berdych",
            "Juan Martin Del Potro"};
    List<String> players = Arrays.asList(atp);


    String[] playerstrs = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka", "David Ferrer",
            "Roger Federer", "Andy Murray",
            "Tomas Berdych", "Juan Martin Del Potro",
            "Richard Gasquet", "John Isner"};


    private void doAction() {

        OK:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int m = 0; m < 5; m++) {
                    Log.e("maxiaolong", "i = " + i + ",j = " + j + ",m = " + m);
                    if (i == 0 && j == 1 && m == 1) {
                        break OK;
                    }
                }
            }
        }


    }


//    private void doAction1() {
//
//        /**
//         * 打印
//         */
//        //1.1循环打印
//        players.forEach((player) -> Log.e(TAG, player));
//
//        //1.2::运算符
//        players.forEach(System.out::println);
//
//
//        /**
//         * 匿名内部类
//         */
//        mBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                doAction();
//            }
//        });
//        mBtn.setOnClickListener((view) -> doAction());
//
//        //2.1
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.e(TAG, "Thread start");
//            }
//        }).start();
//        new Thread(() -> Log.e(TAG, "Thread start")).start();
//
//        //2.2
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                Log.e(TAG, "Thread start");
//            }
//        };
//        r.run();
//        Runnable lr = () -> Log.e(TAG, "Thread start");
//        lr.run();
//
//        /**
//         * 使用Lambdas排序集合
//         */
//        //使用匿名内部类根据 name 排序 players
//        Arrays.sort(playerstrs, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return (s1.compareTo(s2));
//            }
//        });
//
//        //3.1
//        Comparator<String> c1 = (String s1, String s2) -> s1.compareTo(s2);
//        Arrays.sort(playerstrs, c1);
//
//        //3.2
//        Arrays.sort(playerstrs, (String s1, String s2) -> s1.compareTo(s2));
//
//        //3.3
//        Arrays.sort(playerstrs, (s1, s2) -> s1.compareTo(s2));
//
//        /**
//         * 使用Lambdas和Streams
//         */
//        Stream<String> stream = players.parallelStream();
//        stream.filter((String s) -> s.contains("N")).
//                sorted((String s, String t) -> s.compareTo(t));
//
//    }


}