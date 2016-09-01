package com.chenyu.library;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  This class is used for showing or hiding a XToast.
 *
 *  @author Chen Yu
 *  @version 1.0
 *  @date 2016-08-19
 */
public class XToastHandler extends Handler {
    private static XToastHandler mToastHandler;
    private final Queue<XToast> mQueue;

    private final static int SHOW_TOAST = 0x123;
    private final static int HIDE_TOAST = 0x456;
    private final static int SHOWNEXT_TOAST = 0X789;

    private XToastHandler(Looper looper)
    {
        super(looper);
        mQueue = new LinkedList<>();
    }

    public synchronized static XToastHandler getInstance()
    {
        if(mToastHandler != null)
            return mToastHandler;
        else{
            mToastHandler = new XToastHandler(Looper.getMainLooper());
            return mToastHandler;
        }
    }

    /**
     *  该方法把XToast添加到消息队列中
     * @param xToast
     */
    public void add(XToast xToast)
    {
        mQueue.offer(xToast);
        showNextToast();
    }

    public void showNextToast()
    {
        if(mQueue.isEmpty()) return;
        //获取队列头部的XToast
        XToast xToast = mQueue.peek();
        if(!xToast.isShowing()){
            Message message = Message.obtain();
            message.what = SHOW_TOAST;
            message.obj = xToast;
            sendMessage(message);
        }
    }

    @Override
    public void handleMessage(Message msg) {
        XToast xToast = (XToast) msg.obj;
        switch (msg.what)
        {
            case SHOW_TOAST:
                showToast(xToast);
                break;

            case HIDE_TOAST:
                hideToast(xToast);
                break;

            case SHOWNEXT_TOAST:
                showNextToast();
                break;
        }
    }

    public void hideToast(final XToast xToast) {

        if(!xToast.isShowing()){
            mQueue.remove(xToast);
            return;
        }

        if(!mQueue.contains(xToast))
            return;

        AnimatorSet set = xToast.getHideAnimatorSet();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //如果动画结束了，界面中移除mView
                xToast.getViewRoot().removeView(xToast.getViewGroup());
                if (xToast.getOnDisappearListener() != null){
                    xToast.getOnDisappearListener().onDisappear(xToast);
                }

                sendEmptyMessage(SHOWNEXT_TOAST);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.start();
        mQueue.poll();
    }

    private void showToast(XToast xToast) {

        //如果当前有XToast正在展示，直接返回
        if(xToast.isShowing()) return;
        //把mView添加到界面中，实现Toast效果
        xToast.getViewGroup().addView(xToast.getView());
        //获取动画效果
        AnimatorSet set = xToast.getShowAnimatorSet();
        set.start();

        Message message = Message.obtain();
        message.what = HIDE_TOAST;
        message.obj = xToast;
        sendMessageDelayed(message,xToast.getDuration());
    }
}
