package leon.training.function.touch;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import leon.training.BaseActivity;
import leon.trainingproject.R;

/**
 * Created by maxiaolong on 2016/11/11.
 */

public class TouchActivity extends BaseActivity {
    public static final String NAME = "Touch";

    private static final String TAG = TouchActivity.class.getSimpleName();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(NAME, TAG + "-dispatchTouchEvent-ACTION_DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e(NAME, TAG + "-dispatchTouchEvent-ACTION_MOVE");
                break;

            case MotionEvent.ACTION_UP:
                Log.e(NAME, TAG + "-dispatchTouchEvent-ACTION_UP");
                break;

            case MotionEvent.ACTION_CANCEL:
                Log.e(NAME, TAG + "-dispatchTouchEvent-ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
