:: �ر��ն˻���
@echo off

echo ѡ������32λjdk8������1��ѡ������64λjdk8������2.

set /p jdk=

if "%jdk%"=="1" (
    :: ����jdk��������
    setx JAVA_HOME "C:\Program Files (x86)\Java\jdk1.8.0_271" /m
    echo ����32λjdk���������������
) else if "%jdk%"=="2" (
    :: ����jdk��������
    setx JAVA_HOME "C:\Program Files\Java\jdk1.8.0_77" /m
    echo ����64λjdk���������������
) else (
    echo �������룬���ֲ���
)


pause