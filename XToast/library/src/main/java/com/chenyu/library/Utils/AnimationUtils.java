package com.chenyu.library.Utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AnimationSet;

import com.chenyu.library.XToast;

/**
 *  This class is used for storing some types of Animation.
 *
 *  @author Chen Yu
 *  @version 1.0
 *  @date 2016-08-19
 */
public class AnimationUtils {

    public static final int ANIMATION_DEFAULT = 0X000;
    public static final int ANIMATION_DRAWER = 0x001;
    public static final int ANIMATION_SCALE = 0x002;
    public static final int ANIMATION_PULL = 0X003;

    public static AnimatorSet getShowAnimation(XToast xToast,int animationType){
        switch (animationType){
            case ANIMATION_DRAWER:
                AnimatorSet drawerSet = new AnimatorSet();
                drawerSet.playTogether(
                        ObjectAnimator.ofFloat(xToast.getView(), "translationY", -xToast.getView().getMeasuredHeight(), 0),
                        ObjectAnimator.ofFloat(xToast.getView(), "alpha", 0, 1)
                );
                drawerSet.setDuration(500);
                return drawerSet;

            case ANIMATION_SCALE:
                AnimatorSet scaleSet = new AnimatorSet();
                scaleSet.playTogether(
                        ObjectAnimator.ofFloat(xToast.getView(), "scaleX", 0, 1),
                        ObjectAnimator.ofFloat(xToast.getView(), "scaleY", 0, 1)
                );
                scaleSet.setDuration(500);
                return scaleSet;

            case ANIMATION_PULL:
                AnimatorSet pullSet = new AnimatorSet();
                pullSet.playTogether(
                        ObjectAnimator.ofFloat(xToast.getView(), "translationY", xToast.getView().getMeasuredHeight(), 0),
                        ObjectAnimator.ofFloat(xToast.getView(), "alpha", 0, 1)
                );
                pullSet.setDuration(500);
                return pullSet;

            default:
                AnimatorSet defaultSet = new AnimatorSet();
                defaultSet.play(ObjectAnimator.ofFloat(xToast.getView(), "alpha", 0, 1));
                defaultSet.setDuration(500);
                return defaultSet;
        }
    }

    public static AnimatorSet getHideAnimation(XToast xToast,int animationType){
        switch (animationType){
            case ANIMATION_DRAWER:
                AnimatorSet drawerSet = new AnimatorSet();
                drawerSet.playTogether(
                        ObjectAnimator.ofFloat(xToast.getView(), "translationY", 0,-xToast.getView().getMeasuredHeight()),
                        ObjectAnimator.ofFloat(xToast.getView(), "alpha", 1, 0)
                );
                drawerSet.setDuration(500);
                return drawerSet;

            case ANIMATION_SCALE:
                AnimatorSet scaleSet = new AnimatorSet();
                scaleSet.playTogether(
                        ObjectAnimator.ofFloat(xToast.getView(),"scaleX",1,0),
                        ObjectAnimator.ofFloat(xToast.getView(),"scaleY",1,0)
                );
                scaleSet.setDuration(500);
                return scaleSet;

            case ANIMATION_PULL:
                AnimatorSet pullSet = new AnimatorSet();
                pullSet.playTogether(
                        ObjectAnimator.ofFloat(xToast.getView(),"translationY",0,xToast.getView().getMeasuredHeight()),
                        ObjectAnimator.ofFloat(xToast.getView(),"alpha",1,0)
                );
                pullSet.setDuration(500);
                return pullSet;

            default:
                AnimatorSet defaultSet = new AnimatorSet();
                defaultSet.play(ObjectAnimator.ofFloat(xToast.getView(), "alpha", 1, 0));
                defaultSet.setDuration(500);
                return defaultSet;
        }
    }

}
