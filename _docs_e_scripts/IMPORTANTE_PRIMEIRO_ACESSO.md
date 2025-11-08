# IMPORTANTE - PRIMEIRO ACESSO AO SISTEMA

## Regra de Negócio: Apenas 1 Administrador

O sistema foi projetado com uma regra importante: **APENAS 1 ADMINISTRADOR pode existir no sistema**.

## Problema Comum

Se você tentar cadastrar um admin e receber erro, ou se o login não funcionar após cadastrar, provavelmente é porque:

1. **Já existe um admin cadastrado no banco de dados**
2. **Você está usando um banco que já foi utilizado anteriormente**
3. **O banco possui dados antigos de outros testes**

## Solução: Limpar o Banco de Dados

### Opção 1: Recriar o banco (Recomendado)

Execute no **pgAdmin** ou **psql**:

```sql
-- Apagar banco antigo
DROP DATABASE IF EXISTS pdvpostocombustivel;

-- Criar banco novo e limpo
CREATE DATABASE pdvpostocombustivel;
```

### Opção 2: Limpar apenas a tabela de acessos

```sql
-- Conectar no banco pdvpostocombustivel
\c pdvpostocombustivel

-- Apagar todos os acessos
DELETE FROM acesso WHERE role = 'ADMIN';

-- ou apagar todos os dados
TRUNCATE TABLE acesso CASCADE;
TRUNCATE TABLE pessoa CASCADE;
```

## Fluxo Correto - Primeiro Acesso

1. **Inicie o Backend** (Spring Boot)
   - Execute: `mvn spring-boot:run` na pasta `pdv-posto-combustivel`
   - Aguarde a mensagem: "Started Application"

2. **Inicie o Frontend**
   - Execute: `mvn exec:java -Dexec.mainClass=br.com.PdvFrontEnd.view.MainApp` na pasta `JavaPoo-Front-End-main`
   - OU execute a classe `MainApp.java` pela IDE

3. **Primeira Tela: Cadastro do Admin**
   - Se for o primeiro acesso (banco limpo), aparecerá a tela "Cadastrar Admin"
   - Preencha usuário e senha
   - Clique em "Cadastrar Admin"

4. **Login**
   - Após cadastrar, aparecerá a tela de login
   - Use as credenciais que você acabou de cadastrar
   - Role: ADMIN

5. **Sistema Principal**
   - Agora você está no sistema como Administrador
   - Pode cadastrar Frentistas pelo botão "Cadastrar Frentista"

## Verificar se já existe Admin

Para verificar no banco:

```sql
SELECT * FROM acesso WHERE role = 'ADMIN';
```

Se retornar algum registro, significa que já existe um admin cadastrado.

## Credenciais de Teste

Se você limpou o banco e quer testar rapidamente:

**Admin:**
- Usuário: `admin`
- Senha: `admin123`

**Frentista:** (cadastrado pelo admin)
- Usuário: Definido pelo admin
- Senha: Definida pelo admin

## Arquivos de Configuração Local

O sistema também salva credenciais em arquivos locais:
- `admin_config.properties` - Credenciais do admin
- `user_config.properties` - Credenciais do frentista

Se quiser forçar a tela de cadastro de admin novamente, delete esses arquivos.

## Mensagens de Erro Comuns

### "Já existe um administrador cadastrado no sistema"
**Causa:** Tentou cadastrar um segundo admin  
**Solução:** Use as credenciais do admin existente ou limpe o banco

### "Usuário ou senha incorretos"
**Causa:** Credenciais não correspondem ao que está no banco  
**Solução:** 
1. Verifique se digitou corretamente
2. Verifique no banco qual é o usuário/senha cadastrado
3. Se necessário, limpe o banco e recadastre

### Erro de conexão ao tentar cadastrar admin
**Causa:** Backend não está rodando  
**Solução:** Inicie o Spring Boot primeiro

## Contato

Se encontrar problemas, verifique:
1. Backend está rodando? (porta 8080)
2. Banco de dados está rodando? (PostgreSQL porta 5432)
3. Banco `pdvpostocombustivel` existe?
4. Configurações em `application.properties` estão corretas?

