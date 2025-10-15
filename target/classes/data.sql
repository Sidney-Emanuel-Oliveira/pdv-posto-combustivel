-- Inserindo pessoas (funcionários e clientes)
INSERT INTO pessoas (nome_completo, cpf_cnpj, numero_ctps, data_nascimento, tipo_pessoa, ativo)
VALUES
('João Silva', '12345678901', 123456789, '1990-05-15', 'FISICA', true),
('Maria Santos', '98765432101', 987654321, '1988-08-20', 'FISICA', true),
('Pedro Oliveira', '45678912301', NULL, '1985-03-10', 'FISICA', true),
('Empresa XYZ Ltda', '12345678000199', NULL, '2000-01-01', 'JURIDICA', true);

-- Inserindo contatos
INSERT INTO contatos (pessoa_id, telefone, email, endereco) VALUES
(1, '(11) 98765-4321', 'joao.silva@email.com', 'Rua A, 123'),
(2, '(11) 91234-5678', 'maria.santos@email.com', 'Rua B, 456'),
(3, '(11) 95555-9999', 'pedro.oliveira@email.com', 'Rua C, 789'),
(4, '(11) 3333-4444', 'contato@xyz.com', 'Av. Principal, 1000');

-- Inserindo acessos (usuários do sistema)
INSERT INTO acessos (pessoa_id, usuario, senha, nivel_acesso) VALUES
(1, 'joao.silva', '$2a$10$YourHashedPasswordHere', 'ADMIN'),
(2, 'maria.santos', '$2a$10$YourHashedPasswordHere', 'OPERADOR');

-- Inserindo produtos (combustíveis e produtos de conveniência)
INSERT INTO produtos (nome, descricao, codigo_barras, tipo_produto, unidade_medida, ativo) VALUES
('Gasolina Comum', 'Gasolina tipo C comum', 'GASCOM001', 'COMBUSTIVEL', 'LITRO', true),
('Etanol', 'Etanol Hidratado', 'ETANOL001', 'COMBUSTIVEL', 'LITRO', true),
('Diesel S10', 'Diesel S10', 'DIES10001', 'COMBUSTIVEL', 'LITRO', true),
('Óleo Motor 5W30', 'Óleo lubrificante sintético', 'OLE5W30001', 'LUBRIFICANTE', 'UNIDADE', true),
('Água Mineral 500ml', 'Água mineral sem gás', 'AGU500001', 'CONVENIENCIA', 'UNIDADE', true);

-- Inserindo preços dos produtos
INSERT INTO precos (produto_id, preco_compra, preco_venda, margem_lucro, data_vigencia) VALUES
(1, 4.50, 5.89, 30.89, CURRENT_TIMESTAMP),
(2, 3.20, 3.99, 24.69, CURRENT_TIMESTAMP),
(3, 3.80, 4.99, 31.32, CURRENT_TIMESTAMP),
(4, 25.00, 35.00, 40.00, CURRENT_TIMESTAMP),
(5, 0.75, 2.50, 233.33, CURRENT_TIMESTAMP);

-- Inserindo estoque inicial
INSERT INTO estoque (produto_id, quantidade, data_ultima_movimentacao, tipo_movimentacao) VALUES
(1, 5000.00, CURRENT_TIMESTAMP, 'ENTRADA'),
(2, 3000.00, CURRENT_TIMESTAMP, 'ENTRADA'),
(3, 4000.00, CURRENT_TIMESTAMP, 'ENTRADA'),
(4, 50.00, CURRENT_TIMESTAMP, 'ENTRADA'),
(5, 100.00, CURRENT_TIMESTAMP, 'ENTRADA');

-- Inserindo uma venda de exemplo
INSERT INTO vendas (cliente_id, funcionario_id, data_venda, valor_total, forma_pagamento, status) VALUES
(3, 1, CURRENT_TIMESTAMP, 294.50, 'CARTAO_CREDITO', 'CONCLUIDA');

-- Inserindo itens da venda de exemplo
INSERT INTO itens_venda (venda_id, produto_id, quantidade, preco_unitario, subtotal) VALUES
(1, 1, 50.00, 5.89, 294.50);

-- Inserindo alguns custos de exemplo
INSERT INTO custos (descricao, valor, data_lancamento, tipo_custo, observacao) VALUES
('Conta de Luz', 1500.50, CURRENT_TIMESTAMP, 'FIXO', 'Conta de energia elétrica mensal'),
('Manutenção Bomba 01', 350.00, CURRENT_TIMESTAMP, 'VARIAVEL', 'Manutenção preventiva da bomba de gasolina'),
('Salários', 8000.00, CURRENT_TIMESTAMP, 'FIXO', 'Folha de pagamento mensal');
