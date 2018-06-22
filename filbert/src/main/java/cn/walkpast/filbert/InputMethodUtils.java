package cn.walkpast.filbert;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.lang.ref.WeakReference;

/**
 * Author: Kern
 * Time: 2018/6/22 10:25
 * Description: This is..a softinput util
 */

public class InputMethodUtils {


    private Activity mActivity;
    private static InputMethodUtils mInputMethodUtils;
    private static WeakReference<InputMethodManager> mInputMethodManagerReference;
    private InputMethodManager mInputMethodManager;

    public static InputMethodUtils getInstance(Activity activity) {

        if (mInputMethodUtils == null) {
            mInputMethodUtils = new InputMethodUtils(activity);
        }
        return mInputMethodUtils;
    }

    public InputMethodUtils(Activity activity) {
        mActivity = activity;
        if (mActivity != null) {
            mInputMethodManagerReference = new WeakReference<InputMethodManager>((InputMethodManager) activity.getSystemService(Service.INPUT_METHOD_SERVICE));
            mInputMethodManager = mInputMethodManagerReference.get();
        } else {
            throw new NullPointerException("activity is null");
        }
    }

    /**
     * hide softinput
     */
    public void hideSoftInput() {

        if (mInputMethodManager != null) {
            mInputMethodManager.hideSoftInputFromWindow(mActivity.getCurrentFocus().getWindowToken(), 0);
        }
    }


    /**
     * toggle softinput
     */
    public void toggleSoftInput() {

        if (mInputMethodManager != null) {
            mInputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    public void showSoftInput(View view) {
        if (mInputMethodManager != null && view != null) {
            mInputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        }
    }

}
