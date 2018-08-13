package com.jerome.tvfocus.view;

import android.os.Build;
import android.view.ViewOverlay;

import com.jerome.tvfocus.JLog;
import com.jerome.tvfocus.drawable.DrawableLayer;

/**
 * 控件的ViewOverLay管理，用于添加和移除Drawable
 *
 * @author JeromeLiee
 * @date 2018/7/16.
 */

public class LayerOverlay {
    private static volatile LayerOverlay sInstance;

    private LayerOverlay() {
    }

    public static LayerOverlay getInstance() {
        if (sInstance == null) {
            synchronized (LayerOverlay.class) {
                if (sInstance == null) {
                    sInstance = new LayerOverlay();
                }
            }
        }
        return sInstance;
    }


    public void addLayer(DrawableLayer drawableLayer) {
        if (drawableLayer == null) {
            JLog.w("DrawableLayer is null.");
            return;
        }
        if (drawableLayer.getDrawable() == null) {
            JLog.w("DrawableLayer's drawable is null.");
            return;
        }

        if (drawableLayer.getAttachView() == null) {
            JLog.w("DrawableLayer's attach view is null.");
            return;
        }
        ViewOverlay overlay;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            overlay = drawableLayer.getAttachView().getOverlay();
            overlay.add(drawableLayer.getDrawable());
        }
    }

    public void removeLayer(DrawableLayer drawableLayer) {
        if (drawableLayer == null) {
            JLog.w("DrawableLayer is null.");
            return;
        }
        if (drawableLayer.getDrawable() == null) {
            JLog.w("DrawableLayer's drawable is null.");
            return;
        }

        if (drawableLayer.getAttachView() == null) {
            JLog.w("DrawableLayer's attach view is null.");
            return;
        }
        ViewOverlay overlay;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            overlay = drawableLayer.getAttachView().getOverlay();
            overlay.remove(drawableLayer.getDrawable());
        }
    }

}
