package com.jerome.tvfocus.drawable;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Drawable的扩展接口
 *
 * @author JeromeLiee
 * @date 2018/7/8.
 */

public interface DrawableLayer {

    /**
     * 设置依附的View
     *
     * @param attachView
     */
    void setAttachView(View attachView);

    /**
     * 获取依附的View
     *
     * @return
     */
    View getAttachView();

    /**
     * 修正内边距
     *
     * @param padding
     */
    void setCorrectPadding(Rect padding);

    /**
     * 获取修正内边距
     *
     * @return
     */
    Rect getCorrectPadding();

    /**
     * Drawable透明度
     *
     * @param layerAlpha 透明度
     */
    void setLayerAlpha(int layerAlpha);

    /**
     * 获取Drawable
     *
     * @return
     */
    Drawable getDrawable();

}
