# XToast

##How to use it?
The XToast is in the library folder,and add this library so that you can use XToast.

Here is a simple example:
```java
XToast.create(MainActivity.this)
        .setText("Testing:This is a XToast....")
        .setAnimation(AnimationUtils.ANIMATION_DRAWER) //Drawer Type
        .setDuration(XToast.XTOAST_SHORT)
        .setOnDisappearListener(new XToast.OnDisappearListener() {
            @Override
            public void onDisappear(XToast xToast) {
                Log.d("cylog","The XToast has disappeared..");
            }
        }).show();
```

Also,you can make the XToast showed close to the bottom.Such like this:
```java
XToast.create(MainActivity.this,"你收到了 1 条新消息..",XToast.XTOAST_TYPE_BOTTOM)
        .setButtonOnClickListener(new XToast.OnButtonClickListener() {
            @Override
            public void click(XToast xToast) {
                Log.d("cylog","The button has been clicked.");
            }
        })
        .setButtonText("取消")
        .show();
``` 