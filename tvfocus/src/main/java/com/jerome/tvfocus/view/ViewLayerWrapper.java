package com.jerome.tvfocus.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import com.jerome.tvfocus.JLog;
import com.jerome.tvfocus.animation.AnimHelper;
import com.jerome.tvfocus.drawable.DrawableLayer;
import com.jerome.tvfocus.drawable.DrawableLayerFactory;


/**
 * @author JeromeLiee
 * @date 2018/8/5.
 */

public class ViewLayerWrapper implements ViewLayer, View.OnFocusChangeListener {
    private View mView;
    private int mFocusResourceId;
    private Rect mFocusPadding;
    private boolean mFocusVisible;

    private int mShadowResourceId;
    private Rect mShadowPadding;
    private boolean mShadowVisible;
    private DrawableLayer mShadowLayer;
    private DrawableLayer mFocusLayer;
    private boolean mBringToFront;
    private boolean mScaleWidget;
    private View.OnFocusChangeListener mOnFocusChangeListener;

    public ViewLayerWrapper(View view) {
        mView = view;
        // 当控件不是ViewGroup时，默认可获取焦点
        boolean focusable = !(view instanceof ViewGroup) || view.isFocusable();
        mView.setFocusable(focusable);
        if (focusable) {
            mView.setOnFocusChangeListener(this);
        }
    }

    @Override
    public void createLayer() {
        if (!mView.isFocusable()) {
            JLog.w("The view is not focusable, so it will not draw shadow and focus drawable.");
            return;
        }
        // 设置阴影
        if (mShadowVisible) {
            if (mShadowLayer == null) {
                mShadowLayer = DrawableLayerFactory.createLayer(mView.getContext(), mShadowResourceId);
            }
            if (mShadowLayer != null) {
                mShadowLayer.setAttachView(mView);
                mShadowLayer.setCorrectPadding(mShadowPadding);
                LayerOverlay.getInstance().addLayer(mShadowLayer);
            }
        }
        // 设置焦点框
        if (mFocusVisible) {
            if (mFocusLayer == null) {
                mFocusLayer = DrawableLayerFactory.createLayer(mView.getContext(), mFocusResourceId);
            }
            if (mFocusLayer != null) {
                mFocusLayer.setAttachView(mView);
                mFocusLayer.setCorrectPadding(mShadowPadding);
                mFocusLayer.setLayerAlpha(0);
                LayerOverlay.getInstance().addLayer(mFocusLayer);
            }
        }
    }

    @Override
    public void setFocusResourceId(int focusResourceId) {
        mFocusResourceId = focusResourceId;
    }

    @Override
    public int getFocusResourceId() {
        return mFocusResourceId;
    }

    @Override
    public void setFocusPadding(Rect focusPadding) {
        mFocusPadding = focusPadding;
    }

    @Override
    public Rect getFocusPadding() {
        return mFocusPadding;
    }

    @Override
    public void setFocusVisible(boolean focusVisible) {
        mFocusVisible = focusVisible;
    }

    @Override
    public boolean isFocusVisible() {
        return mFocusVisible;
    }

    @Override
    public void setShadowResourceId(int shadowResourceId) {
        mShadowResourceId = shadowResourceId;
    }

    @Override
    public int getShadowResourceId() {
        return mShadowResourceId;
    }

    @Override
    public void setShadowPadding(Rect shadowPadding) {
        mShadowPadding = shadowPadding;
    }

    @Override
    public Rect getShadowPadding() {
        return mShadowPadding;
    }

    @Override
    public void setShadowVisible(boolean shadowVisible) {
        mShadowVisible = shadowVisible;
    }

    @Override
    public boolean isShadowVisible() {
        return mShadowVisible;
    }

    @Override
    public void setScaleWidget(boolean scaleWidget) {
        mScaleWidget = scaleWidget;
    }

    @Override
    public boolean isScaleWidget() {
        return mScaleWidget;
    }

    @Override
    public void setBringToFront(boolean bringToFront) {
        mBringToFront = bringToFront;
    }

    @Override
    public boolean isBringToFront() {
        return mBringToFront;
    }

    @Override
    public Drawable getFocusLayer() {
        return mFocusLayer == null ? null : mFocusLayer.getDrawable();
    }

    @Override
    public void setOnFocusChangeListener(View.OnFocusChangeListener listener) {
        mOnFocusChangeListener = listener;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        // 外部添加的焦点监听回调
        if (mOnFocusChangeListener != null) {
            mOnFocusChangeListener.onFocusChange(v, hasFocus);
        }
        AnimHelper.getInstance().handleFocusChanged(v, this, hasFocus);
    }

}
