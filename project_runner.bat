@echo off
echo Running Maven tests on Chrome browser...
mvn clean test -Dbrowser=chrome
pause
