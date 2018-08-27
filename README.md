# AIDL
使用AIDL实现跨进程双向通讯简单的demo

注意点：

1.两个aidl文件的包名要保持一致，使用系统生成.aidl文件的时候需要进行重新编译才会产生对应的java文件

2.aidl是典型的C/S模型，所以需要借助service充当服务端

3.service在注册的时候需要添加过滤条件（action）

