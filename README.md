# PDV Posto de Combustível

Sistema de Ponto de Venda (PDV) para Posto de Combustível desenvolvido em Java com Spring Boot e Swing.

## 📁 Estrutura do Projeto

```
pdvpostocombustivel/
├── pdv-posto-combustivel/    # Backend (Spring Boot + PostgreSQL)
├── JavaPoo-Front-End-main/   # Frontend (Swing)
└── _docs_e_scripts/          # Documentações e scripts auxiliares
```

## 🚀 Como Executar no IntelliJ IDEA

### Opção 1: Usando as Configurações de Execução (Recomendado)

1. **Abra o projeto** no IntelliJ IDEA (pasta raiz `pdvpostocombustivel`)

2. **No canto superior direito**, você verá um dropdown com as configurações de execução:
   - **Backend - PDV Posto Combustivel** (Execute este primeiro)
   - **Frontend - MainApp** (Execute este depois)

3. **Execute o Backend:**
   - Selecione "Backend - PDV Posto Combustivel" no dropdown
   - Clique no botão verde ▶️ (Run)
   - Aguarde a mensagem: "Started PdvpostocombustivelApplication"
   - Você verá que está conectado no **PostgreSQL** (sem H2)

4. **Execute o Frontend:**
   - Selecione "Frontend - MainApp" no dropdown
   - Clique no botão verde ▶️ (Run)
   - A interface gráfica será aberta

### Opção 2: Usando os Scripts .bat

1. **Backend:**
   - Vá até `_docs_e_scripts/`
   - Execute `EXECUTAR_BACKEND.bat`

2. **Frontend:**
   - Vá até `_docs_e_scripts/`
   - Execute `EXECUTAR_FRONTEND.bat`

## 🗄️ Banco de Dados

- **PostgreSQL** (porta 5432)
- Database: `pdvpostocombustivel`
- Usuário: `postgres`
- Senha: `Sidney123@`

### Scripts Disponíveis

Todos os scripts SQL estão em `_docs_e_scripts/`:
- `PASSO1_CRIAR_BANCO.sql` - Cria o banco de dados
- `PASSO2_CRIAR_TABELAS_E_DADOS.sql` - Cria as tabelas e dados de exemplo
- `LIMPAR_BANCO_DADOS.sql` - Limpa todos os dados
- `RECRIAR_BANCO_LIMPO.sql` - Recria o banco completamente limpo

## 📚 Documentação Completa

Toda a documentação está organizada na pasta `_docs_e_scripts/`:

- `COMO_USAR_SIMPLES.md` - Guia rápido de uso
- `GUIA_BANCO_DE_DADOS.md` - Guia completo do banco
- `GUIA_DE_TESTES.md` - Como testar o sistema
- `INTEGRACAO_COMPLETA.md` - Integração frontend-backend
- E muito mais!

## 🛠️ Tecnologias

### Backend
- Java 17
- Spring Boot 3.4
- Spring Data JPA
- PostgreSQL 18
- Maven
- Swagger/OpenAPI

### Frontend
- Java 17
- Swing
- HTTP Client (java.net.http)
- Maven

## 📝 Funcionalidades

- ✅ Gerenciamento de Pessoas (Clientes/Fornecedores)
- ✅ Gerenciamento de Produtos
- ✅ Controle de Estoque
- ✅ Registro de Vendas
- ✅ Controle de Acessos (Login)
- ✅ Gerenciamento de Contatos
- ✅ Custos e Preços

## 🌐 API REST

Quando o backend estiver rodando, acesse:
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API Docs**: http://localhost:8080/api-docs

## 🤝 Contribuindo

Este é um projeto acadêmico desenvolvido para a disciplina de Programação Orientada a Objetos.

## 📄 Licença

Este projeto está sob a licença MIT. Veja os arquivos LICENSE em cada subprojeto.
