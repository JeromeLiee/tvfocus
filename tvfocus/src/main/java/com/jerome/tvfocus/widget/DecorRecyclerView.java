package com.jerome.tvfocus.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author JeromeLiee
 * @date 2018/8/13.
 */

public class DecorRecyclerView extends RecyclerView {
    public DecorRecyclerView(Context context) {
        this(context, null);
    }

    public DecorRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DecorRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setChildrenDrawingOrderEnabled(true);
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
}
