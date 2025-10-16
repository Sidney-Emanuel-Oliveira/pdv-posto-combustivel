@echo off
chcp 65001 >nul
title Backend PDV Posto Combustivel - PostgreSQL

echo ========================================
echo  BACKEND PDV POSTO COMBUSTIVEL
echo  Usando PostgreSQL Database v18.0
echo ========================================
echo.

cd /d "%~dp0"

echo [INFO] Diretorio atual: %CD%
echo.

echo [1] Verificando porta 8080...
netstat -ano | findstr :8080 >nul 2>&1
if %errorlevel% equ 0 (
    echo [AVISO] Liberando porta 8080...
    for /f "tokens=5" %%a in ('netstat -ano ^| findstr :8080 ^| findstr LISTENING') do (
        taskkill /F /PID %%a >nul 2>&1
    )
    timeout /t 2 /nobreak >nul
)

echo [2] Iniciando Spring Boot com PostgreSQL...
echo.
echo     Backend: http://localhost:8080
echo     Swagger: http://localhost:8080/swagger-ui.html
echo     Database: PostgreSQL 18.0 (localhost:5432/pdvpostocombustivel)
echo.
echo ========================================
echo.

call mvn spring-boot:run

pause

