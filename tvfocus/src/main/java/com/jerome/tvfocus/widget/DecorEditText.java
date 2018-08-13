package com.jerome.tvfocus.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.jerome.tvfocus.AttrHandler;

/**
 * @author JeromeLiee
 * @date 2018/8/12.
 */

public class DecorEditText extends EditText {
    public DecorEditText(Context context) {
        this(context, null);
    }

    public DecorEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DecorEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        AttrHandler.handle(context, attrs, this);
    }
}
