package com.imooc.carlisle.calculator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by carlisle on 2016/8/26.
 */
public class MarqueeText extends TextView{
    public MarqueeText(Context context) {
        super(context);
    }

    public MarqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isFocused(){
        return true;
    }

}
