# AppBarLayoutBehavior
解决AppbarLayout滑动问题的behavior

## 问题描述
1) 快速滑动AppBarLayout会出现回弹；
2) 快速滑动AppBarLayout到折叠状态下，立马下拉会出现抖动现象；
3) 滑动AppBarLayout过程中，无法像RecyclerView那样通过手指按下停止滚动。

## 如何使用
### gradle

Step 1. Add the JitPack repository in your root build.gradle at the end of repositories:
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Step 2. Add the dependency in your app build.gradle:
```groovy
dependencies {
	implementation 'com.github.yuruiyin:AppbarLayoutBehavior:v1.0.2'
}
```
### xml
```xml
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

### 混淆
若使用support库，则需要保证support库中的代码不被混淆，请在proguard-rules.pro中添加如下配置：
```proguard
# 保留support下的所有类及内部类
-keep class android.support.**{*;}
-dontwarn android.support.v4.**
# 保留继承support库的类
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**
```

若已迁移到androidx，则需要添加如下配置:
```proguard
-keep class com.google.android.material.** {*;}
-keep class androidx.** {*;}
-keep public class * extends androidx.**
-keep interface androidx.** {*;}
-dontwarn com.google.android.material.**
-dontnote com.google.android.material.**
-dontwarn androidx.**
```

## 参考
https://blog.csdn.net/vite_s/article/details/78901767
