@echo off
echo ========================================
echo  LIBERANDO PORTA 8080 E INICIANDO BACKEND
echo ========================================
echo.

REM Liberar porta 8080
echo [1] Liberando porta 8080...
for /f "tokens=5" %%a in ('netstat -ano ^| findstr :8080 ^| findstr LISTENING') do (
    echo Matando processo PID: %%a
    taskkill /F /PID %%a
)

echo.
echo [2] Aguardando 3 segundos...
timeout /t 3 /nobreak

echo.
echo [3] Verificando se porta esta livre...
netstat -ano | findstr :8080
if %errorlevel% equ 0 (
    echo [ERRO] Porta ainda em uso!
    pause
    exit /b 1
) else (
    echo [OK] Porta 8080 livre!
)

echo.
echo [4] Iniciando backend com PostgreSQL...
echo.

cd /d "C:\Users\sidney\Documents\faculdades 2025\pdvpostocombustivel\pdv-posto-combustivel"

echo Backend rodando em: http://localhost:8080
echo Swagger UI em: http://localhost:8080/swagger-ui.html
echo Database: PostgreSQL 18.0
echo.
echo Pressione Ctrl+C para parar
echo ========================================
echo.

mvn spring-boot:run

pause

