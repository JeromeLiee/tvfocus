package com.jerome.tvfocus.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * @author JeromeLiee
 * @date 2018/7/8.
 */

public interface ViewLayer {

    /**
     * 创建添加的View层
     */
    void createLayer();

    /**
     * 设置焦点框资源
     *
     * @param focusResourceId
     */
    void setFocusResourceId(int focusResourceId);

    /**
     * 获取焦点框资源
     *
     * @return
     */
    int getFocusResourceId();

    /**
     * 设置焦点框修正的Padding
     *
     * @param focusPadding
     */
    void setFocusPadding(Rect focusPadding);

    /**
     * 获取焦点框修正的Padding
     *
     * @return
     */
    Rect getFocusPadding();

    /**
     * 设置焦点是否可显示
     *
     * @param focusVisible
     */
    void setFocusVisible(boolean focusVisible);

    /**
     * 获取焦点框是否可显示
     *
     * @return
     */
    boolean isFocusVisible();

    /**
     * 设置阴影资源id
     *
     * @param shadowResourceId
     */
    void setShadowResourceId(int shadowResourceId);

    /**
     * 获取阴影资源id
     *
     * @return
     */
    int getShadowResourceId();

    /**
     * 设置阴影Padding
     *
     * @param shadowPadding
     */
    void setShadowPadding(Rect shadowPadding);

    /**
     * 获取阴影Padding
     *
     * @return
     */
    Rect getShadowPadding();

    /**
     * 设置阴影是否可显示
     *
     * @param shadowVisible
     */
    void setShadowVisible(boolean shadowVisible);

    /**
     * 阴影是否可显示
     *
     * @return
     */
    boolean isShadowVisible();

    /**
     * 是否对控件进行缩放
     *
     * @param scaleWidget
     */
    void setScaleWidget(boolean scaleWidget);

    /**
     * 控件是否缩放
     *
     * @return
     */
    boolean isScaleWidget();

    /**
     * 当获取焦点时是否将该控件置为最前
     *
     * @param bringToFront
     */
    void setBringToFront(boolean bringToFront);

    /**
     * 获取焦点时该控件是否置为最前
     *
     * @return
     */
    boolean isBringToFront();

    /**
     * 获取焦点Drawable
     *
     * @return
     */
    Drawable getFocusLayer();

}
