package com.inteam.estrellawallet.domain.listeners;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Detects left and right swipes across a view.
 */
public class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;

    public OnSwipeTouchListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public void onSwipeTop() {
    }

    public void onSwipeBottom() {
    }

    public void onSwipeRight() {
    }

    public void onSwipeLeft() {
    }

    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_DISTANCE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();
            Log.d("hello", velocityY + " " + distanceY);

            if (Math.abs(distanceY) > SWIPE_DISTANCE_THRESHOLD &&
                    Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (distanceY > 0)
                    onSwipeTop();
                else
                    onSwipeBottom();
                return true;
            } else if (Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD &&
                    Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (distanceX < 0)
                    onSwipeRight();
                else
                    onSwipeLeft();
                return true;
            }
            return false;
        }
    }
}