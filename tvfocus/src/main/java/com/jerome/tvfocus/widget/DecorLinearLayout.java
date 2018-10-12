package com.jerome.tvfocus.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.jerome.tvfocus.AttrHandler;
import com.jerome.tvfocus.view.ViewLayer;

/**
 * @author JeromeLiee
 * @date 2018/8/12.
 */

public class DecorLinearLayout extends LinearLayout {
    private ViewLayer viewLayer;

    public DecorLinearLayout(Context context) {
        this(context, null);
    }

    public DecorLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DecorLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setChildrenDrawingOrderEnabled(true);
        viewLayer = AttrHandler.handle(context, attrs, this);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        if (childCount == 0) {
            return super.getChildDrawingOrder(childCount, i);
        }
        int newOrder = i;
        if (getChildAt(i).isFocused()) {
            newOrder = childCount - 1;
        } else {
            if (i == childCount - 1) {
                View focusChild = findFocus();
                int indexOfChild = indexOfChild(focusChild);
                newOrder = (indexOfChild >= 0 ? indexOfChild : i);
            }
        }
        return super.getChildDrawingOrder(childCount, newOrder);
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
