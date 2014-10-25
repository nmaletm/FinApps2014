package com.inteam.estrellawallet;

import android.app.Activity;

/**
 * Created by marcct on 25/10/14.
 */
public abstract class SlidingActivity extends Activity {
    protected enum ExitPoint {TOP, BOTTOM, RIGHT};
    protected ExitPoint exitPoint = ExitPoint.RIGHT;

    @Override
    protected void onResume() {
        super.onResume();
        switch (exitPoint) {
            case TOP:
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                break;
            case BOTTOM:
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                break;
            case RIGHT:
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        switch (exitPoint) {
            case TOP:
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                break;
            case BOTTOM:
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                break;
            case RIGHT:
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }
}
