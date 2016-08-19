package com.chenyu.xtoast;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chenyu.library.Utils.AnimationUtils;
import com.chenyu.library.XToast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                XToast.create(MainActivity.this)
                        .setText("Testing:This is a XToast....")
                        .setAnimation(AnimationUtils.ANIMATION_SCALE)
                        .setDuration(XToast.XTOAST_SHORT)
                        .setOnDisappearListener(new XToast.OnDisappearListener() {
                            @Override
                            public void onDisappear(XToast xToast) {
                                Log.d("cylog","The XToast has disappeared..");
                            }
                        })
                        .show();


            }
        });

    }


}
