package cn.walkpast.filbert;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Author: Kern
 * Time: 2018/6/22 10:30
 * Description:
 */

public class RecursInputMethod {

    private Activity mActivity;
    private static RecursInputMethod mRecursInputMethod;

    public static RecursInputMethod getInstance(Activity activity) {
        if (mRecursInputMethod == null) {
            mRecursInputMethod = new RecursInputMethod(activity);
        }
        return mRecursInputMethod;
    }


    public RecursInputMethod(Activity activity) {
        mActivity = activity;
    }


    /**
     * the function is recursive until the ViewGroup don't have childView
     *
     * @param view the root view in your layout
     */
    public void setBaseView(View view) {

        if (!(view instanceof EditText)) {
            if (view != null) {
                view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InputMethodUtils.getInstance(mActivity).hideSoftInput();
                        return false;
                    }
                });
            }
        }

        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View inView = ((ViewGroup) view).getChildAt(i);
                setBaseView(inView);
            }
        }
    }

}
