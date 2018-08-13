package com.jerome.tvfocus.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import com.jerome.tvfocus.BorderConfig;
import com.jerome.tvfocus.JLog;
import com.jerome.tvfocus.view.ViewLayer;
import com.jerome.tvfocus.widget.DecorLinearLayout;


/**
 * @author JeromeLiee
 * @date 2018/7/31.
 */

public class AnimHelper {
    private BorderConfig borderConfig = BorderConfig.INSTANCE;

    private AnimHelper() {
    }

    public static AnimHelper getInstance() {
        return AnimHelperHolder.sInstance;
    }

    private static class AnimHelperHolder {
        private static AnimHelper sInstance = new AnimHelper();
    }

    public void handleFocusChanged(View view, ViewLayer layer, boolean hasFocus) {
        JLog.d("view=" + view + ", layer=" + layer + ", hasFocus=" + hasFocus);
        bringToFront(view, layer, hasFocus);
        if (hasFocus) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", borderConfig.getScaleValues());
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", borderConfig.getScaleValues());
            ObjectAnimator alpha;
            scaleX.setDuration(borderConfig.getDuration());
            scaleY.setDuration(borderConfig.getDuration());
            if (layer.getFocusLayer() != null) {
                alpha = ObjectAnimator.ofInt(layer.getFocusLayer(), "alpha", 255);
                alpha.setDuration(borderConfig.getDuration());
                animatorSet.playTogether(scaleX, scaleY, alpha);
            } else {
                animatorSet.playTogether(scaleX, scaleY);
            }
            animatorSet.start();
        } else {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", borderConfig.getScaleValues()[borderConfig.getScaleValues().length - 1], 1.0f);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", borderConfig.getScaleValues()[borderConfig.getScaleValues().length - 1], 1.0f);
            ObjectAnimator alpha;
            scaleX.setDuration(borderConfig.getDuration());
            scaleY.setDuration(borderConfig.getDuration());
            if (layer.getFocusLayer() != null) {
                alpha = ObjectAnimator.ofInt(layer.getFocusLayer(), "alpha", 255, 0);
                alpha.setDuration(borderConfig.getDuration());
                animatorSet.playTogether(scaleX, scaleY, alpha);
            } else {
                animatorSet.playTogether(scaleX, scaleY);
            }
            animatorSet.start();
        }
    }

    private void bringToFront(View view, ViewLayer layer, boolean hasFocus) {
        if (layer.isBringToFront()) {
            if (hasFocus) {
                // 父布局为DecorLinearLayout或DecorLinearLayout，则使用bringToFront方法会有问题
                if (view.getParent() instanceof DecorLinearLayout || view.getParent() instanceof DecorLinearLayout) {
                    ((DecorLinearLayout) view.getParent()).invalidate();
                } else {
                    view.bringToFront();
                }
            }
        }
    }

}
