package com.xcion.softinput;

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

public class SoftInput {

    private static String TAG = "SoftInput";

    private Activity activity;
    private View rootView;
    private SoftInputTools softInputTools;

    public static SoftInput getInstance() {
        return new SoftInput();
    }

    public Activity getActivity() {
        return activity;
    }

    public SoftInput setActivity(Activity activity) {
        this.activity = activity;
        return this;
    }

    public View getRootView() {
        return rootView;
    }

    public SoftInput setRootView(View rootView) {
        this.rootView = rootView;
        return this;
    }

    public void build() {

        softInputTools = new SoftInputTools(getActivity());
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
                        if (softInputTools != null) {
                            softInputTools.hideSoftInput();
                        }
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
