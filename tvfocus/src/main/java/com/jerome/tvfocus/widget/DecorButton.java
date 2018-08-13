package com.jerome.tvfocus.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.jerome.tvfocus.AttrHandler;


/**
 * @author JeromeLiee
 * @date 2018/8/5.
 */

public class DecorButton extends Button {

    public DecorButton(Context context) {
        this(context, null);
    }

    public DecorButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DecorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        AttrHandler.handle(context, attrs, this);
    }

}
