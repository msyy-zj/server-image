# server-image

springboot 独立图片服务器，支持单图片，多图片，表单提交，前后端分离，Layui 上传，ajax 上传，图片压缩等功能

## 接口说明

| 方式 | 接口名称 | 接口说明 |
|:--|:--|:--|
| POST | localhost:9000/upload |支持单图片上传、多图片上传 |
| POST | localhost:9000/uploadFileThumbnail | 上传图片并压缩，只会返回未压缩过的图片上传路径，压缩过的访问路径为后面加上 -thumbnail |

- 参数folder为上传文件后保存的文件根路径
- 多图片上传将返回结果用逗号隔开
- 未压缩访问路径：http://localhost:9000/default/201908281810009917.jpg
- 已压缩访问路径：http://localhost:9000/default/201908281810009917-thumbnail.jpg

## 启动

找到clone的项目的run文件夹，然后双击 `server-image-start.bat`文件，运行之后，浏览器访问：http://localhost:9000/ ，上传即可。上传之后保存的路径默认为当前启动项目jar的地方。

> 页面上的输入框表示图片存储的根目录，默认为default

![图片预览](https://github.com/Tellsea/server-image/blob/master/images/1.png)

## 交流学习

![在这里插入图片描述](https://github.com/Tellsea/springboot-learn/blob/master/doc/images/emoticon1.jpg)
![交流学习](https://github.com/Tellsea/springboot-learn/blob/master/doc/images/qq-group.png)
