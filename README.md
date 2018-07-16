# AppBarLayoutBehavior
解决AppbarLayout滑动问题的behavior

## 问题描述
1) 快速滑动AppBarLayout会出现回弹；
2) 快速滑动AppBarLayout到折叠状态下，立马下拉会出现抖动现象；
3) 滑动AppBarLayout过程中，无法像RecyclerView那样通过手指按下停止滚动。

## 如何使用
### gradle
```
Step 1. Add the JitPack repository in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency in your app build.gradle:
	dependencies {
	        implementation 'com.github.yuruiyin:AppbarLayoutBehavior:v1.0.0'
	}
```
### xml
```
<android.support.design.widget.AppBarLayout
        android:id="@+id/appBarLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/white"
        android:fitsSystemWindows="false"
        app:layout_behavior="com.yuruiyin.appbarlayoutbehavior.AppBarLayoutBehavior"
        >

        ......

</android.support.design.widget.AppBarLayout>
```
## 参考
https://blog.csdn.net/vite_s/article/details/78901767
