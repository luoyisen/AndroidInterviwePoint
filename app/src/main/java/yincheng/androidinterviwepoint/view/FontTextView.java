package yincheng.androidinterviwepoint.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 16:12
 * Github : yincheng.luo
 */

public class FontTextView extends AppCompatTextView {
    public FontTextView(Context context) {
        super(context);
    }

//    @State
//    int tintColor = -1;
//    @State
//    boolean selected;
//
//    public FontTextView(@NonNull Context context) {
//        this(context, null);
//    }
//
//    public FontTextView(@NonNull Context context, AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public FontTextView(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init(context, attrs);
//    }
//
//    @Override
//    public Parcelable onSaveInstanceState() {
//        // TODO: 2018/4/1 fasthub
////        return StateSaver.saveInstanceState(this, super.onSaveInstanceState());
//        return super.onSaveInstanceState();
//    }
//
//    @Override
//    public void onRestoreInstanceState(Parcelable state) {
//        super.onRestoreInstanceState(state);
//        // TODO: 2018/4/1 fasthub
////        super.onRestoreInstanceState(StateSaver.restoreInstanceState(this, state));
//        tintDrawables(tintColor);
//        setSelected(selected);
//    }
//
//    @Override
//    public void setSelected(boolean selected) {
//        super.setSelected(selected);
//        this.selected = selected;
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void setText(CharSequence text, BufferType type) {
//        try {
//            super.setText(text, type);
//        } catch (Exception e) {
//            setText("I tried, but your OEM just sucks because they modify the framework components and therefore causing the app to crash!" + "" +
//                    ".\nFastHub");
////            Crashlytics.logException(e);
//        }
//    }
//
//    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
//        if (attributeSet != null) {
//            TypedArray tp = context.obtainStyledAttributes(attributeSet, R.styleable.FontTextView);
//            try {
//                int color = tp.getColor(R.styleable.FontTextView_drawableColor, -1);
//                tintDrawables(color);
//            } finally {
//                tp.recycle();
//            }
//        }
//        if (isInEditMode()) return;
//        setFreezesText(true);
//        TypefaceHelper.applyTypeface(this);
//    }
//
//    public void tintDrawables(@ColorInt int color) {
//        if (color != -1) {
//            this.tintColor = color;
//            Drawable[] drawables = getCompoundDrawablesRelative();
//            for (Drawable drawable : drawables) {
//                if (drawable == null) continue;
////                ViewHelper.tintDrawable(drawable, color);
//            }
//        }
//    }
//
//    public void setEventsIcon(@DrawableRes int drawableRes) {
//        Drawable drawable = ContextCompat.getDrawable(getContext(), drawableRes);
//        int width = drawable.getIntrinsicWidth();
//        int height = drawable.getIntrinsicHeight();
//        drawable.setBounds(0, 0, width / 2, height / 2);
//        ScaleDrawable sd = new ScaleDrawable(drawable, Gravity.CENTER, 0.6f, 0.6f);
//        sd.setLevel(8000);
////        ViewHelper.tintDrawable(drawable, ViewHelper.getTertiaryTextColor(getContext()));
//        setCompoundDrawablesWithIntrinsicBounds(sd, null, null, null);
//    }

}
