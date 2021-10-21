package com.xcion.softinput;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.lang.ref.WeakReference;

/**
 * Author: Kern
 * Time: 2018/6/22 10:25
 * Description: This is..a soft input util
 */

public class SoftInputTools {

    private WeakReference<Activity> activityWeakReference;
    private SoftInputTools softInputTools;
    private WeakReference<InputMethodManager> inputMethodManagerReference;
    private InputMethodManager inputMethodManager;

    public SoftInputTools(Activity activity) {
        if (activity != null) {
            activityWeakReference = new WeakReference<>(activity);
            inputMethodManagerReference = new WeakReference<InputMethodManager>((InputMethodManager) activity.getSystemService(Service.INPUT_METHOD_SERVICE));
            inputMethodManager = inputMethodManagerReference.get();
        } else {
            throw new NullPointerException("activity is null");
        }
    }

    /**
     * hide soft input
     */
    public void hideSoftInput() {
        if (inputMethodManager != null && activityWeakReference != null && activityWeakReference.get() != null && activityWeakReference.get().getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activityWeakReference.get().getCurrentFocus().getWindowToken(), 0);
        }
    }


    /**
     * toggle soft input
     */
    public void toggleSoftInput() {

        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    /**
     * show soft input
     *
     * @param view
     */
    public void showSoftInput(View view) {
        if (inputMethodManager != null && view != null) {
            inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        }
    }

}
