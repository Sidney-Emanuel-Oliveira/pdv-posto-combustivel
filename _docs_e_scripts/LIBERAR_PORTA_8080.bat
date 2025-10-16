@echo off
chcp 65001 >nul
echo ========================================
echo  LIBERAR PORTA 8080
echo ========================================
echo.

echo [1] Verificando processos na porta 8080...
echo.
netstat -ano | findstr :8080

echo.
echo [2] Encerrando processos na porta 8080...
echo.

for /f "tokens=5" %%a in ('netstat -ano ^| findstr :8080 ^| findstr LISTENING') do (
    echo Finalizando processo PID: %%a
    taskkill /F /PID %%a
)

echo.
echo ========================================
echo  PORTA 8080 LIBERADA!
echo ========================================
echo.
echo Agora você pode executar o backend normalmente.
echo.
pause

