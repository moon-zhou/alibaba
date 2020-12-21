:: 关闭终端回显
@echo off

d:

echo 选择启动的nacos版本，1为正式发布般，2为开发版

set /p nacos=

if "%nacos%"=="1" (
	echo 启动正式版
    cd D:\DevProgram\alibaba\nacos\bin
) else if "%nacos%"=="2" (
    echo 启动开发版
    cd D:\DevProgram\alibaba\nacos_dev_2.0.0\bin
) else (
    echo 错误输入，保持不变
	exit
)

startup.cmd -m standalone