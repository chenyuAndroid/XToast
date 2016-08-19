# XToast

##How to use it?
The XToast is in the library folder,and add this library so that you can use XToast.

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
