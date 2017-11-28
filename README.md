# Android_Flux
Flux模式最大的特点是单向的数据流，它的UI状态更新模式继承了MVC模式的设计思想.  
* Flux是Facebook在14年提出的一种Web前端架构， 
* 主要用来处理复杂的UI逻辑的一致性问题（当时是为了解决Web页面的消息通知问题）。  
* 经过实践之后发现，这种架构可以很好的应用于Android平台， 
* 相对于其他的MVC/MVP/MVVM等模式，拥有良好的文档和更具体的设计，比较适合于快速开发实现.

对本工程结构示意图

![image](https://github.com/zhuangzeqin/Android_Flux/blob/master/TIM%E6%88%AA%E5%9B%BE20171128222431.png)

Flux最大的特点就是数据的单向流  View--->Action--->Dispatch---Store--->View

抽象出基类； 方便扩展 可以直接引用到工程上面

如果对你有用；不妨请小编我喝个咖啡；嘻嘻；你的动力；是我不懈努力

![image](https://github.com/zhuangzeqin/APPChannel/blob/master/TIM20171109141728.png)

License
-------

    Copyright 2017 zhuangzeqin

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

