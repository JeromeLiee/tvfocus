# tvfocus

Android TV或盒子的焦点框处理工具。可根据焦点获取情况，自动显示和隐藏焦点框，并作放大等动画。

### 效果图

<img src="/resources/tvfocus.gif">

### 支持功能
1. 支持全局设置和单独对某控件设置阴影.9图和焦点框.9图
2. 支持自定义控件放大的比例和时长
3. 支持控件获取焦点时置为最前(bringToFront)，PS:当控件的父布局为LinearLayout或RecyclerView时，需使用对应的DecorLinearLayout或DecorRecyclerView控件

### 扩展控件

| 扩展控件      | 原有控件      | 描述 |
|:---           |:---           |:---       |
| DecorButton   | Button        | 默认可获取焦点 focusable=true|
| DecorTextView | TextView      | 默认可获取焦点 focusable=true|
| DecorEditText | EditText      | 默认可获取焦点 focusable=true|
| DecorFrameLayout | FrameLayout | 默认不可获取焦点 focusable=false |
| DecorRelativeLayout | RelativeLayout | 默认不可获取焦点 focusable=false |
| DecorLinearLayout | LinearLayout | 默认不可获取焦点 focusable=false 注意事项请参考：支持功能 -> 第3条|
| DecorRecyclerView | RecyclerView | 当列表item获取到焦点时需要置为最前，需使用该控件，参考：支持功能 -> 第3条|

### 自定义属性

| Attribute 属性          | Description 描述 |  Default 默认值 |
|:---				     |:---| :---|
| focus                     | 焦点框.9图片资源 | 默认全局配置，若xml中已配置则优先使用 |
| focusPaddingLeft         | 焦点框修正内距，左边距 | 默认focusPadding，若该属性已配置则优先使用 |
| focusPaddingTop         | 焦点框修正内距，上边距 | 默认focusPadding，若该属性已配置则优先使用 |
| focusPaddingRight         | 焦点框修正内距，右边距 | 默认focusPadding，若该属性已配置则优先使用 |
| focusPaddingBottom         | 焦点框修正内距，下边距 | 默认focusPadding，若该属性已配置则优先使用 |
| focusPadding         | 焦点框修正内距，优先使用上述4个内边距属性 | 0 | |
| focusVisible        |是否允许显示焦点效果 | true |
| shadow         | 阴影.9图片资源 | 默认全局配置，若xml中已配置则优先使用 |
| shadowPaddingLeft         | 阴影修正内距，左边距 | 默认shadowPadding，若该属性已配置则优先使用 |
| shadowPaddingTop         | 阴影修正内距，上边距 |默认shadowPadding，若该属性已配置则优先使用 |
| shadowPaddingRight         | 阴影修正内距，右边距 |默认shadowPadding，若该属性已配置则优先使用 |
| shadowPaddingBottom         | 阴影修正内距，下边距 |默认shadowPadding，若该属性已配置则优先使用 |
| shadowPadding         | 阴影修正内距，优先使用上述4个内边距属性 |0|
| shadowVisible         | 是否显示阴影 |true|
| scaleWidget         | 是否对控件进行缩放 | true|
| bringToFront         | 当控件获取到焦点时，是否将该控件置为最前 |false|

### 属性配置

#### 1.全局配置

    // 在应用的Application中
    BorderConfig.init(R.drawable.item_focus)    // 焦点框资源
            .shadowRes(R.drawable.item_unfocus) // 阴影资源
            .scaleValues(1.0f, 1.2f, 1.1f)      // 放大的比例，默认为(1.0f, 1.2f, 1.1f)
            .duration(300)                      // 放大时长，默认为300ms
            .debug(true)                        // 可输出log，tag为"TVFocus"，默认关闭
            .create();

#### 2.XML控件单独配置

    <!-- 1.Button、TextView和EditText等非ViewGroup控件配置-->
    <com.jerome.tvfocus.widget.DecorButton
        android:layout_width="200dp"
        android:layout_height="100dp"
        android:text="button"
        border:bringToFront="true"
        border:focus="@drawable/item_focus"
        border:focusPadding="5dp"
        border:focusVisible="true"
        border:scaleWidget="true"
        border:shadow="@drawable/item_unfocus"
        border:shadowPadding="5dp"
        border:shadowVisible="true" />

    <!-- 2.DecorFrameLayout、DecorRelativeLayout等ViewGroup控件配置-->
    <com.jerome.tvfocus.widget.DecorFrameLayout
        android:layout_width="300dp"
        android:layout_height="200dp"
        android:clipChildren="false"
        android:focusable="true"
        border:bringToFront="true">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="FrameLayout"
            android:textColor="#fff" />
    </com.jerome.tvfocus.widget.DecorFrameLayout>

### Gradle使用

    compile 'com.jerome:tvfocus:1.0.2'

### 关于我

个人邮箱：jeromeliee@foxmail.com

[CSDN主页](https://blog.csdn.net/JeromeLiee)





