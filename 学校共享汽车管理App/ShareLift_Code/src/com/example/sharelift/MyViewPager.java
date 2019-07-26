package com.example.sharelift;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;



public class MyViewPager extends ViewPager {
    ViewPagerScroller scroller;
    private boolean isCanScroll = true;
    public MyViewPager(Context context) {
        super(context);
        initScroller(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScroller(context);
    }

    private void initScroller(Context context) {
        scroller = new ViewPagerScroller(context);
        scroller.setScrollDuration(2000);
        scroller.initViewPagerScroll(this);
    }
    
    public void setCanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }
    public void setDuration(int duration) {
        scroller.mScrollDuration = duration;
    }

    public void setCurrentItem(int item, int duration) {
        setDuration(duration);
        this.setCurrentItem(item);
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isCanScroll && super.onInterceptTouchEvent(ev);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isCanScroll && super.onTouchEvent(ev);

    }
    
    class ViewPagerScroller extends Scroller {
        public int mScrollDuration = 1000; 

        
        public void setScrollDuration(int duration) {
            this.mScrollDuration = duration;
        }

        public ViewPagerScroller(Context context) {
            super(context);
        }

        public ViewPagerScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public ViewPagerScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, mScrollDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy, mScrollDuration);
        }

        public void initViewPagerScroll(ViewPager viewPager) {
            try {
                Field mScroller = ViewPager.class.getDeclaredField("mScroller");
                mScroller.setAccessible(true);
                mScroller.set(viewPager, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
