# LoadingImage
正在加载的ImageView
#### 使用方法
##### maven
##### 
       <dependency>
        <groupId>com.hlq</groupId>
        <artifactId>loadingimageview</artifactId>
        <version>1.0.0</version>
        <type>pom</type>
      </dependency>
##### Gradle
##### 
      compile 'com.hlq:loadingimageview:1.0.0'
####  在xml中使用
       <hlq.loadingimage.LoadingImageView
           app:styleanima = "animator"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:layout_marginTop="20dp"
          />
##### width和height是必须的两个属性, app:styleanima 可选可不选，有两个值可以选择  
animation 和 animator 对应两种加载效果<br>
不设置时即默认值是animation

当为animation时，效果如图所示：<br>
![image](http://p86xu5smy.bkt.clouddn.com/1.gif)

大小可以自己设置，20dp左右最佳<br>

当为animator时，效果图如下：<br>
![image](http://p86xu5smy.bkt.clouddn.com/2.gif)
可以看到小球的颜色再变换，当然我们也可以设置多个并排显示，如图所示:<br>
![image](http://p86xu5smy.bkt.clouddn.com/3.gif)
球的大小我们也可以取设置<br>
源码地址;https://github.com/huanglinqing123/LoadingImage<br>
欢迎start和issue



     



