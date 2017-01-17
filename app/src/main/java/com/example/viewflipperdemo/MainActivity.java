package com.example.viewflipperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewFlipper viewFlipper1 = (ViewFlipper) findViewById(R.id.vf1);

        viewFlipper1.addView(View.inflate(this,R.layout.item_flipper1,null));
        viewFlipper1.addView(View.inflate(this,R.layout.item_flipper1,null));
        viewFlipper1.addView(View.inflate(this,R.layout.item_flipper1,null));


        final ViewFlipper viewFlipper2 = (ViewFlipper) findViewById(R.id.vf2);

        viewFlipper2.addView(View.inflate(this,R.layout.item_flipper2,null));
        viewFlipper2.addView(View.inflate(this,R.layout.item_flipper2,null));
        viewFlipper2.addView(View.inflate(this,R.layout.item_flipper2,null));

        Button button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewFlipper1.isFlipping() && viewFlipper2.isFlipping()){
                    viewFlipper1.stopFlipping();
                    viewFlipper2.stopFlipping();
                }else{
                    //开始滚动时直接滚动下一个,防止从空的页面开始滑动的情况
                    viewFlipper1.showNext();
                    viewFlipper1.startFlipping();
                    viewFlipper2.showNext();
                    viewFlipper2.startFlipping();
                }
            }
        });

    }
}
