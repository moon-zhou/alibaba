:: �ر��ն˻���
@echo off

d:

echo ѡ��������nacos�汾��1Ϊ��ʽ�����㣬2Ϊ������

set /p nacos=

if "%nacos%"=="1" (
	echo ������ʽ��
    cd D:\DevProgram\alibaba\nacos\bin
) else if "%nacos%"=="2" (
    echo ����������
    cd D:\DevProgram\alibaba\nacos_dev_2.0.0\bin
) else (
    echo �������룬���ֲ���
	exit
)

startup.cmd -m standalone