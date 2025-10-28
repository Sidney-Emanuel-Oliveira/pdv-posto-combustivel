@echo off
echo ========================================
echo Removendo coluna numero_ctps - Commit
echo ========================================

cd "C:\Users\sidney\Documents\faculdades 2025\pdvpostocombustivel"

echo.
echo Adicionando arquivos ao Git...
git add .

echo.
echo Fazendo commit...
git commit -m "Remover coluna numero_ctps da tabela pessoas e dos DTOs"

echo.
echo ========================================
echo Commit realizado com sucesso!
echo ========================================
echo.
echo Para enviar ao repositorio remoto, execute:
echo git push
echo.
pause

