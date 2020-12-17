:: 关闭终端回显
@echo off

echo 选择设置32位jdk8请输入1，选择设置64位jdk8请输入2.

set /p jdk=

if "%jdk%"=="1" (
    :: 设置jdk环境变量
    setx JAVA_HOME "C:\Program Files (x86)\Java\jdk1.8.0_271" /m
    echo 设置32位jdk环境变量，已完成
) else if "%jdk%"=="2" (
    :: 设置jdk环境变量
    setx JAVA_HOME "C:\Program Files\Java\jdk1.8.0_77" /m
    echo 设置64位jdk环境变量，已完成
) else (
    echo 错误输入，保持不变
)


pause