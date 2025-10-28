@echo off
echo ========================================
echo Limpando arquivos inuteis do repositorio
echo ========================================

cd "C:\Users\sidney\Documents\faculdades 2025\pdvpostocombustivel"

echo.
echo Removendo arquivo .iml da raiz do Git...
git rm --cached pdv-posto-combustivel-parent.iml

echo.
echo Removendo outros arquivos .iml se existirem...
git rm --cached pdv-posto-combustivel/pdvpostocombustivel.iml 2>nul
git rm --cached JavaPoo-Front-End-main/pdv-frontend.iml 2>nul

echo.
echo Removendo pastas target do Git (se existirem)...
git rm -r --cached pdv-posto-combustivel/target 2>nul
git rm -r --cached JavaPoo-Front-End-main/target 2>nul

echo.
echo Adicionando .gitignore atualizado...
git add .gitignore

echo.
echo Adicionando outras alteracoes (remocao do numero_ctps e adicao do role)...
git add .

echo.
echo Fazendo commit...
git commit -m "Limpeza: Remover arquivos .iml e target do repositorio + Remover campo numero_ctps + Adicionar campo role"

echo.
echo ========================================
echo Limpeza e commit concluidos!
echo ========================================
echo.
echo Os arquivos .iml ainda existem localmente, mas nao serao mais enviados ao GitHub.
echo.
echo Para enviar ao GitHub, execute:
echo git push
echo.
pause

