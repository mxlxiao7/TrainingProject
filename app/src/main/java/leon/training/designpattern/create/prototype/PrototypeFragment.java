package leon.training.designpattern.create.prototype;

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
public class PrototypeFragment extends BaseFragment {


    public PrototypeFragment() {


    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PrototypeFragment newInstance() {
        PrototypeFragment fragment = new PrototypeFragment();
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
        Product cp = new Product();
        for (int i = 0; i < 10; i++) {
            Product clonecp = (Product) cp.clone();
            clonecp.show();
        }
    }
}
