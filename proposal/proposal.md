# <div  align=center>**移动应用开发期末Proposal**</div>

<div align=center>2017学年秋季</div>

<div align=center>课程名称：Mobile Application Development                                                                               指导老师：郑贵锋</div>

|   姓名    |    学号    |      院系/年级      |    联系电话     |
| :-----: | :------: | :-------------: | :---------: |
| 喻鸿玮(组长) | 14353376 | 数据科学与计算机（2014级） |  ---------  |
|   张甲选   | 14353391 | 数据科学与计算机（2014级） | 13265113921 |
|   黄义    | 14353106 | 数据科学与计算机（2014级） | ----------  |
|   陈阳    | 14353038 | 数据科学与计算机（2014级） | ----------  |

---------------------------------

###**项目计划书**

 -  **项目名称**：  忆语

 -  **项目背景**：

> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们项目的灵感来源于中山大学图书馆的窗台文化（经常去图书馆并且坐的位置靠窗边的同学会留下一些感慨或者目标，写在窗台上，但些文字以窗台作为载体，总感觉虽然出发是好的，但表达的方式不妥当，想用一款APP来来直接表达就即彰显了素质，又不破坏公物），并且我们小组观察了市面上只有像微信、微博这类与朋友或者自己关注了的人分享信息，并没有回忆录，或者类似于到此一游的辅助APP，并且经过内部讨论我们自己觉得这个想法挺好的，就决定去实现这个东西了。`

 - **项目概述**：

> &nbsp;&nbsp;&nbsp;&nbsp;无论走到世界各地，我们总想留点东西，不论是到此一游，or whatever else, 证明我们来过，不论是鼓励还是目 标，或者仅仅把它当做美好的回忆，当下次再来时，我们还能看到．或者我们可以把自己独有的回忆写在此处，与众多来到这里的人共同分享。这可以是个回忆录，也可以是个树洞，我们说的话只有树洞知道。  

 -  **功能描述**：

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`1. 登录`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`2. 写自己的回忆（删除+照片+视频） `

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`3. 评论`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`还有一些功能就不一一赘述，因为具体还是要实干，空谈误国！！！`

```flow
st=>start: 登录
e=>end
op1=>operation: 检查各项权限
op2=>operation: 载入界面
cond1=>condition: 回忆录
sub1=>subroutine: 退出程序
cond=>condition: permit 
or forbid
condL=>condition: 
st->op2->op1->cond
cond(yes)->cond1
cond(no)->sub1(right)->e

```



 - **主要技术**：

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;` 1. 全球定位` 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`2. 数据库以及服务器的应用`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`3. 沉浸式状态栏 `

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`4. 区域网格分块化（感觉实现起来会比较难）`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`......`

 - **表现形式**：

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;` 概念界面参考微信，微博界面。（技术成熟的话，可以弄3D俯视图）`

 -  **小组分工**：

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;` 四人合力完成`

