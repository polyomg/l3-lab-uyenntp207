@echo off
set PORT=8080
for /f "tokens=5" %%a in ('netstat -aon ^| findstr :%PORT%') do taskkill /F /PID %%a
call mvnw spring-boot:run

