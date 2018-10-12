package com.jerome.tvfocus.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.jerome.tvfocus.AttrHandler;
import com.jerome.tvfocus.view.ViewLayer;


/**
 * @author JeromeLiee
 * @date 2018/8/5.
 */

public class DecorButton extends Button {
    private ViewLayer viewLayer;

    public DecorButton(Context context) {
        this(context, null);
    }

    public DecorButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DecorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        viewLayer = AttrHandler.handle(context, attrs, this);
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        // 先判断是否已设置过焦点监听
        // 如果已经设置过，则将本次设置OnFocusChangeListener对象传递给ViewLayerWrapper中进行监听回调
        OnFocusChangeListener onFocusChangeListener = getOnFocusChangeListener();
        if (onFocusChangeListener != null) {
            viewLayer.setOnFocusChangeListener(l);
            return;
        }
        super.setOnFocusChangeListener(l);
    }
}
