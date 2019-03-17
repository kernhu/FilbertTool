# FilbertTool

	When use EditText and Soft Input,touch the layout besides of EditText,FilbertTool can easily hide the soft input. 
	当使用EditText和输入法软键盘时，触摸EditText之外的布局，自动隐藏输入法软键盘。
	
	代码量非常少，核心就是一个递归算法。

![](https://github.com/KernHu/FilbertTool/raw/master/screenshot/screen_shot.gif)  

##  I: How to use FilbertTool.
### 1.Get the root view and past the root view into RecursInputMethod;

```
 RecursInputMethod
                .getInstance()
                .setActivity(this)
                .setRootView(findViewById(R.id.root_layout))
                .build();

```

## II: Add FilbertTool to your project

### Step 1. Add the dependency
```
	dependencies {
	         compile 'cn.walkpast.filbert:RecursInputMethod:1.0.2'
	}
```
## III: Contact me

Email: vsky580@gmail.com  
Facebook: https://www.facebook.com/kern.hu.580

QQ群：43447852

I'm kern....
```
If it helps you,please give me a star.如果有帮助到你，请给我一个小星星。
```
