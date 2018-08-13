package com.jerome.tvfocus.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;

import com.jerome.tvfocus.JLog;

/**
 * .9图片
 *
 * @author JeromeLiee
 * @date 2018/7/8.
 */

public class NinePatchDrawableLayer extends NinePatchDrawable implements DrawableLayer {

    /**
     * 所依附的view
     */
    private View mAttachView;
    /**
     * .9图的内边距
     */
    private Rect mPadding;
    /**
     * 修正后的内边距
     */
    private Rect mCorrectPadding;
    private int mAlpha = 255;
    private boolean mHasSetLayerAlpha;

    public NinePatchDrawableLayer(Resources res, Bitmap bitmap, byte[] chunk, Rect padding, String srcName) {
        super(res, bitmap, chunk, padding, srcName);
        JLog.d("padding=" + padding);
        mPadding = padding;
    }

    @Override
    public void draw(Canvas canvas) {
        // Update drawable padding
        int paddingLeft = (mPadding != null ? mPadding.left : 0) + (mCorrectPadding != null ? mCorrectPadding.left : 0);
        int paddingTop = (mPadding != null ? mPadding.top : 0) + (mCorrectPadding != null ? mCorrectPadding.top : 0);
        int paddingRight = (mPadding != null ? mPadding.right : 0) + (mCorrectPadding != null ? mCorrectPadding.right : 0);
        int paddingBottom = (mPadding != null ? mPadding.bottom : 0) + (mCorrectPadding != null ? mCorrectPadding.bottom : 0);
        canvas.save();
        // 修改画布偏移量
        canvas.translate(-paddingLeft, -paddingTop);
        // 修改画布边界
        Rect newRect = canvas.getClipBounds();
        newRect.inset(-(paddingLeft > paddingRight ? paddingLeft : paddingRight), -(paddingTop > paddingBottom ? paddingTop : paddingBottom));
        canvas.clipRect(newRect, Region.Op.REPLACE);
        // 设置Drawable大小
        if (mAttachView != null) {
            Rect rect = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = mAttachView.getWidth() + (paddingLeft + paddingRight);
            rect.bottom = mAttachView.getHeight() + (paddingTop + paddingBottom);
            this.setBounds(rect);
        }
        getPaint().setAlpha(mAlpha);
        super.draw(canvas);
        canvas.restore();
    }

    @Override
    public Drawable getDrawable() {
        return this;
    }

    @Override
    public void setAttachView(View attachView) {
        mAttachView = attachView;
    }

    @Override
    public View getAttachView() {
        return mAttachView;
    }

    @Override
    public void setCorrectPadding(Rect padding) {
        mCorrectPadding = padding;
    }

    @Override
    public Rect getCorrectPadding() {
        return mCorrectPadding;
    }

    @Override
    public void setLayerAlpha(int layerAlpha) {
        if (mHasSetLayerAlpha) {
            return;
        }
        mHasSetLayerAlpha = true;
        mAlpha = layerAlpha;
    }

    @Override
    public void setAlpha(int alpha) {
        mAlpha = alpha;
        super.setAlpha(alpha);
    }
}
