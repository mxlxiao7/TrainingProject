package leon.training.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static leon.training.touch.TouchActivity.NAME;

/**
 * Created by maxiaolong on 2016/11/11.
 */

public class TouchCView extends View {
    private static final String TAG = TouchCView.class.getSimpleName();

    public TouchCView(Context context) {
        super(context);
    }


    public TouchCView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(NAME, TAG + "-onTouchEvent-ACTION_DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e(NAME, TAG + "-onTouchEvent-ACTION_MOVE");
                break;

            case MotionEvent.ACTION_UP:
                Log.e(NAME, TAG + "-onTouchEvent-ACTION_UP");
                break;

            case MotionEvent.ACTION_CANCEL:
                Log.e(NAME, TAG + "-onTouchEvent-ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(ev);
    }



}
