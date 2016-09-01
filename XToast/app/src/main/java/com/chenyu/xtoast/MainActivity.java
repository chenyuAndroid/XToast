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

                XToast.create(MainActivity.this,"你收到了 1 条新消息..",XToast.XTOAST_TYPE_BOTTOM)
                        .setButtonOnClickListener(new XToast.OnButtonClickListener() {
                            @Override
                            public void click(XToast xToast) {
                                Log.d("cylog","The button has been clicked.");
                            }
                        })
                        .setButtonText("取消")
                        .show();



            }
        });

    }


}
