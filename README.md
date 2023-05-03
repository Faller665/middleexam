## 1.App的简要介绍

该App为一个仿知乎日报的App

### 1App主要功能

1.实现了首页的文章列表

2.可以点击查看新闻详情

### 2.主要功能的实现思想

1.首页banner是使用viewpager2+fragment实现

2.新闻列表是用recycleview实现

3.新闻详情的具体展示是用webview实现

## 2.APP功能的展示
![QQ图片20230503113019](https://user-images.githubusercontent.com/119687323/235827729-19cee528-f612-4f2b-9417-32406bed3d33.gif)![QQ图片20230503113030](https://user-images.githubusercontent.com/119687323/235827753-5429c93d-6572-4ceb-bc12-29fb5b2bf57d.gif)

## 3.技术亮点

1.使用了livedata+viewmodel+viewbinding的mvvm架构

2.继承了Application实现了防止程序崩溃

3.完成了下拉刷新和上拉加载

## 4.不足的地方

1.ui不够好看

2.评论功能存在bug

3.viewpager2与recycleview的联动滑动没有实现
