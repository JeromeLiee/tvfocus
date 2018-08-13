package com.jerome.tvfocus.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.jerome.tvfocus.AttrHandler;

/**
 * @author JeromeLiee
 * @date 2018/8/12.
 */

public class DecorRelativeLayout extends RelativeLayout {
    public DecorRelativeLayout(Context context) {
        this(context, null);
    }

    public DecorRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DecorRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        AttrHandler.handle(context, attrs, this);
    }
}
