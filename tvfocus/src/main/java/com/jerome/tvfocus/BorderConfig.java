package com.jerome.tvfocus;

/**
 * @author JeromeLiee
 * @date 2018/8/5.
 */

public class BorderConfig {
    public static BorderConfig INSTANCE;

    private int focusResource;
    private int shadowResource;
    private float[] scaleValues;
    private long duration;
    private boolean debug;

    private BorderConfig(BorderConfigBuilder borderConfigBuilder) {
        this.focusResource = borderConfigBuilder.focusResource;
        this.shadowResource = borderConfigBuilder.shadowResource;
        this.scaleValues = borderConfigBuilder.scaleValues;
        this.duration = borderConfigBuilder.duration;
        this.debug = borderConfigBuilder.debug;
    }

    public static BorderConfigBuilder init(int focusResource) {
        return new BorderConfigBuilder(focusResource);
    }

    public int getFocusResource() {
        return focusResource;
    }

    public int getShadowResource() {
        return shadowResource;
    }

    public float[] getScaleValues() {
        return scaleValues;
    }

    public long getDuration() {
        return duration;
    }

    public boolean isDebug() {
        return debug;
    }

    public static class BorderConfigBuilder {
        private int focusResource;
        private int shadowResource;
        private float[] scaleValues = {1.0f, 1.2f, 1.1f};
        private long duration = 300;
        private boolean debug;

        private BorderConfigBuilder(int focusResource) {
            this.focusResource = focusResource;
        }

        public BorderConfigBuilder shadowRes(int shadowResource) {
            this.shadowResource = shadowResource;
            return this;
        }

        public BorderConfigBuilder scaleValues(float... values) {
            this.scaleValues = values;
            return this;
        }

        public BorderConfigBuilder duration(long duration) {
            this.duration = duration;
            return this;
        }

        public BorderConfigBuilder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public void create() {
            INSTANCE = new BorderConfig(this);
        }
    }

}
