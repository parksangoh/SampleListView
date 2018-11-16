package com.example.a805_11.samplelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout {

    TextView text1, text2, text3;
    ImageView imageView;

    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    public SingerItemView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        imageView = findViewById(R.id.imageView);
    }

    public void setName(String name) {
        text1.setText(name);
    }

    public void setMobile(String mobile) {
        text2.setText(mobile);
    }

    public void setAge(int age) {
        text3.setText(String.valueOf(age));
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
