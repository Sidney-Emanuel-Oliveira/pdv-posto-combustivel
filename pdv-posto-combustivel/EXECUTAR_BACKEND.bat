@echo off
chcp 65001 >nul
echo ========================================
echo  INICIANDO BACKEND - PDV POSTO COMBUSTIVEL
echo ========================================
echo.

cd /d "C:\Users\sidney\Documents\faculdades 2025\pdvpostocombustivel\pdv-posto-combustivel"

echo [1] Verificando se a porta 8080 está livre...
echo.

netstat -ano | findstr :8080 >nul 2>&1
if %errorlevel% equ 0 (
    echo [AVISO] Porta 8080 em uso. Liberando...
    for /f "tokens=5" %%a in ('netstat -ano ^| findstr :8080 ^| findstr LISTENING') do (
        taskkill /F /PID %%a >nul 2>&1
    )
    echo Porta liberada!
    echo.
)

echo [2] Iniciando o backend com PostgreSQL...
echo.
echo Backend rodando em: http://localhost:8080
echo Swagger UI em: http://localhost:8080/swagger-ui.html
echo.
echo Pressione Ctrl+C para parar o backend
echo ========================================
echo.

mvn spring-boot:run

pause
