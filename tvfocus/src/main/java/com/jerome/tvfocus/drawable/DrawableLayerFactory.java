package com.jerome.tvfocus.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.util.TypedValue;

import com.jerome.tvfocus.JLog;

import java.io.IOException;
import java.io.InputStream;

/**
 * Drawable层的工厂，主要用于创建Drawable
 *
 * @author JeromeLiee
 * @date 2018/7/8.
 */

public class DrawableLayerFactory {

    private DrawableLayerFactory() {
    }

    public static DrawableLayer createLayer(Context context, int resourceId) {
        if (resourceId == 0) {
            JLog.w("Drawable resource is empty.");
            return null;
        }
        return createDrawableFromBitmap(context, resourceId);
    }

    private static DrawableLayer createDrawableFromBitmap(Context context, int id) {
        Resources res = context.getResources();
        // 内边距Padding
        Rect padding = new Rect();

        // Refer code from class BitmapFactory.java#decodeResource(Resources res, int id, Options opts).
        Bitmap bm = null;
        InputStream is = null;
        try {
            final TypedValue value = new TypedValue();
            is = res.openRawResource(id, value);
            bm = BitmapFactory.decodeResourceStream(res, value, is, padding, null);
        } catch (Exception e) {
            /*  do nothing.
                If the exception happened on open, bm will be null.
                If it happened on close, bm is still valid.
            */
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                // Ignore
            }
        }

        if (bm == null) {
            return null;
        }
        byte[] chunk = bm.getNinePatchChunk();
        boolean isNinePatchChunk = NinePatch.isNinePatchChunk(chunk);
        // If it is NinePatch type, then create a NinePatchDrawableLayer object.
        if (isNinePatchChunk) {
            return new NinePatchDrawableLayer(res, bm, chunk, padding, null);
        }
        return null;
    }
}
