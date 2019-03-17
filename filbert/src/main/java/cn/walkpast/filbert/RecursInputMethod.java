package cn.walkpast.filbert;

import android.app.Activity;
import android.util.Log;
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

    private static String TAG = "RecursInputMethod";

    private Activity mActivity;
    private View mRootView;
    private InputMethodUtils mInputMethodUtils;


    public static RecursInputMethod getInstance() {
        return new RecursInputMethod();
    }

    public Activity getActivity() {
        return mActivity;
    }

    public RecursInputMethod setActivity(Activity activity) {
        mActivity = activity;
        return this;
    }

    public View getRootView() {
        return mRootView;
    }

    public RecursInputMethod setRootView(View rootView) {
        mRootView = rootView;
        return this;
    }


    public void build() {

        mInputMethodUtils = new InputMethodUtils(getActivity());
        recursionTraverse(getRootView());

    }


    /**
     * the function is recursive until the ViewGroup don't have childView
     *
     * @param view the root view in your layout
     */
    public void recursionTraverse(View view) {

        if (view != null) {
            if (!(view instanceof EditText)) {
                view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        mInputMethodUtils.hideSoftInput();
                        return false;
                    }
                });
            }

            if (view instanceof ViewGroup) {
                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                    View inView = ((ViewGroup) view).getChildAt(i);
                    recursionTraverse(inView);
                }
            }
        } else {
            throw new NullPointerException("root view is null");
        }
    }

}
