
@echo off

for /f "skip=3 tokens=4" %%i in ('sc query MySQL80') do set "zt=%%i" &goto :next

:next
if /i "%zt%"=="RUNNING" (
echo �Ѿ����ָ÷��������У����ڹرշ���
net stop MySQL80

echo mysql��������ͣ�����ڹر�navicat

taskkill /f /im navicat.exe

) else (
echo �÷������ڴ���ֹͣ״̬�����ڿ�������
net start MySQL80

echo Mysql������������������navicat

start "" "D:\DevProgram\Navicat Premium\navicat.exe"
)
pause
exit
