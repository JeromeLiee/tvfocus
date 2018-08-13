package com.jerome.tvfocus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.jerome.tvfocus.view.ViewLayer;
import com.jerome.tvfocus.view.ViewLayerWrapper;


/**
 * @author JeromeLiee
 * @date 2018/8/5.
 */

public class AttrHandler {

    public static void handle(Context context, AttributeSet attrs, View view) {
        if (BorderConfig.INSTANCE == null) {
            throw new RuntimeException("Must init BorderConfig object in Application!");
        }
        JLog.init(BorderConfig.INSTANCE.isDebug());

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.border);
        // 焦点框.9图片资源
        int focus = ta.getResourceId(R.styleable.border_focus, BorderConfig.INSTANCE.getFocusResource());
        // 焦点框修正内距
        int focusPadding = ta.getLayoutDimension(R.styleable.border_focusPadding, 0);
        int focusPaddingLeft = ta.getLayoutDimension(R.styleable.border_focusPaddingLeft, focusPadding);
        int focusPaddingTop = ta.getLayoutDimension(R.styleable.border_focusPaddingTop, focusPadding);
        int focusPaddingRight = ta.getLayoutDimension(R.styleable.border_focusPaddingRight, focusPadding);
        int focusPaddingBottom = ta.getLayoutDimension(R.styleable.border_focusPaddingBottom, focusPadding);
        Rect focusPaddingRect = new Rect(focusPaddingLeft, focusPaddingTop, focusPaddingRight, focusPaddingBottom);
        // 是否显示焦点框
        boolean focusVisible = ta.getBoolean(R.styleable.border_focusVisible, true);

        // 阴影.9图片资源
        int shadow = ta.getResourceId(R.styleable.border_shadow, BorderConfig.INSTANCE.getShadowResource());
        // 阴影修正内距
        int shadowPadding = ta.getLayoutDimension(R.styleable.border_shadowPadding, 0);
        int shadowPaddingLeft = ta.getLayoutDimension(R.styleable.border_shadowPaddingLeft, shadowPadding);
        int shadowPaddingTop = ta.getLayoutDimension(R.styleable.border_shadowPaddingTop, shadowPadding);
        int shadowPaddingRight = ta.getLayoutDimension(R.styleable.border_shadowPaddingRight, shadowPadding);
        int shadowPaddingBottom = ta.getLayoutDimension(R.styleable.border_shadowPaddingBottom, shadowPadding);
        Rect shadowPaddingRect = new Rect(shadowPaddingLeft, shadowPaddingTop, shadowPaddingRight, shadowPaddingBottom);
        // 是否显示阴影
        boolean shadowVisible = ta.getBoolean(R.styleable.border_shadowVisible, true);

        // 是否对控件进行缩放
        boolean scaleWidget = ta.getBoolean(R.styleable.border_scaleWidget, true);
        boolean bringToFront = ta.getBoolean(R.styleable.border_bringToFront, false);
        ta.recycle();

        JLog.d("focus=" + focus
                + ", focusPaddingRect=" + focusPaddingRect
                + ", focusVisible=" + focusVisible
                + ", shadow=" + shadow
                + ", shadowPaddingRect=" + shadowPaddingRect
                + ", shadowVisible=" + shadowVisible
                + ", scaleWidget=" + scaleWidget
                + ", bringToFront=" + bringToFront);

        ViewLayer viewLayer = new ViewLayerWrapper(view);
        viewLayer.setFocusResourceId(focus);
        viewLayer.setFocusPadding(focusPaddingRect);
        viewLayer.setFocusVisible(focusVisible);

        viewLayer.setShadowResourceId(shadow);
        viewLayer.setShadowPadding(shadowPaddingRect);
        viewLayer.setShadowVisible(shadowVisible);

        viewLayer.setScaleWidget(scaleWidget);
        viewLayer.setBringToFront(bringToFront);

        viewLayer.createLayer();
    }

}
