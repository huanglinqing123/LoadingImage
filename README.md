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




     



