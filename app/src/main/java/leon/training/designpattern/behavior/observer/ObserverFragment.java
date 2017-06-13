package leon.training.designpattern.behavior.observer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import leon.training.BaseFragment;
import leon.trainingproject.R;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class ObserverFragment extends BaseFragment {


    public ObserverFragment() {


    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ObserverFragment newInstance() {
        ObserverFragment fragment = new ObserverFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_decorator_layout, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        return rootView;
    }

    private void doAction() {

        IObserver o1 = new Observer1();
        IObserver o2 = new Observer2();

        ISubject subject = new Subject();
        subject.regist(o1);
        subject.regist(o2);

        subject.notifyObservers();

        subject.unregist(o1);
        subject.unregist(o2);
    }
}
