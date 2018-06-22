# FilbertTool

	When use EditText and Soft Input,touch the layout besides of EditText,FilbertTool can easily hide the soft input. 
	当使用EditText和输入法软键盘时，触摸EditText之外的布局，自动隐藏输入法软键盘。
	
	代码量非常少，核心就是一个递归算法。

![](https://github.com/KernHu/FilbertTool/raw/master/screenshot/screen_shot.gif)  

##  I: How to use RahmenView.
### 1.Get the root view and past the root view into RecursInputMethod;


 RecursInputMethod.getInstance(this).setRootView(findViewById(R.id.root_layout));


## II: Add FilbertTool to your project

### Step 1. Add the JitPack repository to your build file; Add it in your root build.gradle at the end of repositories:

	allprojects {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
        }
	
### Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.KernHu:FilbertTool:v1.0'
	}
	
## III: Contact me

Email: sky580@126.com  
I'm kern....

If it helps you,please give me a star.如果有帮助到你，请给我一个小星星。
