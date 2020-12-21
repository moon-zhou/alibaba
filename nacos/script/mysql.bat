
@echo off

for /f "skip=3 tokens=4" %%i in ('sc query MySQL80') do set "zt=%%i" &goto :next

:next
if /i "%zt%"=="RUNNING" (
echo 已经发现该服务在运行，正在关闭服务
net stop MySQL80

echo mysql服务已暂停，正在关闭navicat

taskkill /f /im navicat.exe

) else (
echo 该服务现在处于停止状态，正在开启服务
net start MySQL80

echo Mysql服务已启动，现启动navicat

start "" "D:\DevProgram\Navicat Premium\navicat.exe"
)
pause
exit
