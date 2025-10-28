@echo off
echo ========================================
echo Recompilando Backend com campo ROLE
echo ========================================
cd "C:\Users\sidney\Documents\faculdades 2025\pdvpostocombustivel\pdv-posto-combustivel"
call mvn clean install -DskipTests
echo.
echo ========================================
echo Compilacao concluida!
echo ========================================
pause

