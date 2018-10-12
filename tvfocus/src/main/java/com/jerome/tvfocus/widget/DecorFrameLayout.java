package com.jerome.tvfocus.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.jerome.tvfocus.AttrHandler;
import com.jerome.tvfocus.view.ViewLayer;

/**
 * @author JeromeLiee
 * @date 2018/8/12.
 */

public class DecorFrameLayout extends FrameLayout {
    private ViewLayer viewLayer;

    public DecorFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public DecorFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DecorFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        viewLayer = AttrHandler.handle(context, attrs, this);
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        OnFocusChangeListener onFocusChangeListener = getOnFocusChangeListener();
        if (onFocusChangeListener != null) {
            viewLayer.setOnFocusChangeListener(l);
            return;
        }
        super.setOnFocusChangeListener(l);
    }
}
