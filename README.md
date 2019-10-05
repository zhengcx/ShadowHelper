# ShadowHelper
A library to add shadows for the Android View.(一个方便为Android View添加自然的阴影的库)

![demo.gif](https://github.com/zhengcx/ShadowHelper/blob/master/shadowhelper.gif)

# How to use

1.**Step 1:** Add the JitPack repository to your build file
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2.**Step 2:** Add the dependency
```gradle
dependencies {
	        compile 'com.github.zhengcx:ShadowHelper:v1.0'
	}
```

3.**Step 3:** Use in Java code like this:
```java
 TextView textView1 = findViewById(R.id.tv_1);
 ShadowConfig.Builder config = new ShadowConfig.Builder()
                .setColor(mColor[0])//View颜色
                .setShadowColor(mShadowColor)//阴影颜色
                .setGradientColorArray(mColor)//如果View是渐变色，则设置color数组
                .setRadius(mRadius)//圆角
                .setOffsetX(mOffsetX)//横向偏移
                .setOffsetY(mOffsetY);//纵向偏移

ShadowHelper.setShadowBgForView(textView1, config);
```

### End 欢迎Star/Fork/Issue.

## License

Apache2.0.


## About Me

- Github: [DavidSu](https://github.com/zhengcx)
- 博客: [舒大飞](https://juejin.im/user/5a6d2293518825734a74ed4c/posts)
