package com.br.pdvpostocombustivel;

import com.br.pdvpostocombustivel.domain.entity.Acesso;
import com.br.pdvpostocombustivel.domain.entity.Contato;
import com.br.pdvpostocombustivel.domain.entity.Custo;
import com.br.pdvpostocombustivel.domain.entity.Estoque;
import com.br.pdvpostocombustivel.domain.entity.Pessoa;
import com.br.pdvpostocombustivel.domain.entity.Preco;
import com.br.pdvpostocombustivel.domain.entity.Produto;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;
@SpringBootApplication
public class PdvpostocombustivelApplication {

    public static void main(String[] args) {
        // SpringApplication.run(PdvpostocombustivelApplication.class, args);

        // ==================== PESSOA ====================
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNomeCompleto("Pedro");
        pessoa1.setCpfCnpj("700055567548");
        pessoa1.setNumeroCtps(1223L);
        pessoa1.setDataNascimento(java.time.LocalDate.of(1990, 1, 1)); // 01/01/1990

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNomeCompleto("Maria");
        pessoa2.setCpfCnpj("12345678901");
        pessoa2.setNumeroCtps(23769L);
        pessoa2.setDataNascimento(java.time.LocalDate.of(1985, 5, 15)); // 15/05/1985

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNomeCompleto("João");
        pessoa3.setCpfCnpj("98765432100");
        pessoa3.setNumeroCtps(23769L);
        pessoa3.setDataNascimento(java.time.LocalDate.of(1992, 8, 20)); // 20/08/1992

        System.out.println("-----------------------------------------");
        System.out.println("Nome Completo: " + pessoa1.getNomeCompleto());
        System.out.println("CPF/CNPJ: " + pessoa1.getCpfCnpj());
        System.out.println("NumeroCtps: " + pessoa1.getNumeroCtps());

        System.out.println("-----------------------------------------");
        System.out.println("Nome Completo: " + pessoa2.getNomeCompleto());
        System.out.println("CPF/CNPJ: " + pessoa2.getCpfCnpj());
        System.out.println("NumeroCtps: " + pessoa2.getNumeroCtps());

        System.out.println("-----------------------------------------");
        System.out.println("Nome Completo: " + pessoa3.getNomeCompleto());
        System.out.println("CPF/CNPJ: " + pessoa3.getCpfCnpj());
        System.out.println("NumeroCtps: " + pessoa3.getNumeroCtps());

        // ==================== CONTATO ====================
        Contato contato1 = new Contato();
        contato1.setTelefone("1199999-8888");
        contato1.setEmail("joao@email.com");
        contato1.setEndereco("Rua das Flores, 123");

        Contato contato2 = new Contato();
        contato2.setTelefone("2198888-7777");
        contato2.setEmail("maria@empresa.com");
        contato2.setEndereco("Av. Atlântica, 456");

        Contato contato3 = new Contato();
        contato3.setTelefone("3197777-6666");
        contato3.setEmail("carlos.contato@gmail.com");
        contato3.setEndereco("Praça da Liberdade, 789");

        System.out.println("==============================");
        System.out.println("          DADOS DOS CONTATOS");
        System.out.println("==============================");

        System.out.println("------------------------");
        System.out.println("Telefone: " + contato1.getTelefone());
        System.out.println("Email: " + contato1.getEmail());
        System.out.println("Endereço: " + contato1.getEndereco());

        System.out.println("------------------------");
        System.out.println("Telefone: " + contato2.getTelefone());
        System.out.println("Email: " + contato2.getEmail());
        System.out.println("Endereço: " + contato2.getEndereco());

        System.out.println("------------------------");
        System.out.println("Telefone: " + contato3.getTelefone());
        System.out.println("Email: " + contato3.getEmail());
        System.out.println("Endereço: " + contato3.getEndereco());

        System.out.println("------------------------");

        // ==================== ACESSO ====================
        Acesso acesso1 = new Acesso();
        acesso1.setUsuario("joao");
        acesso1.setSenha("senha123");

        Acesso acesso2 = new Acesso();
        acesso2.setUsuario("maria");
        acesso2.setSenha("senha456");

        Acesso acesso3 = new Acesso();
        acesso3.setUsuario("carlos");
        acesso3.setSenha("senha789");

        System.out.println("==============================");
        System.out.println("          DADOS DOS ACESSOS");
        System.out.println("==============================");

        System.out.println("------------------------");
        System.out.println("Usuário: " + acesso1.getUsuario());
        System.out.println("Senha: " + acesso1.getSenha());

        System.out.println("------------------------");
        System.out.println("Usuário: " + acesso2.getUsuario());
        System.out.println("Senha: " + acesso2.getSenha());

        System.out.println("------------------------");
        System.out.println("Usuário: " + acesso3.getUsuario());
        System.out.println("Senha: " + acesso3.getSenha());

        System.out.println("------------------------");

        // ==================== CUSTO ====================
        Custo custo1 = new Custo();
        custo1.setImposto(10.50);
        custo1.setFrete(25.00);
        custo1.setCustoVariavel(80.00);
        custo1.setCustoFixo(150.00);
        custo1.setMargemLucro(20.0);
        custo1.setDataProcessamento(new Date());

        Custo custo2 = new Custo();
        custo2.setImposto(8.75);
        custo2.setFrete(30.00);
        custo2.setCustoVariavel(120.00);
        custo2.setCustoFixo(100.00);
        custo2.setMargemLucro(25.0);
        custo2.setDataProcessamento(new Date());

        Custo custo3 = new Custo();
        custo3.setImposto(12.00);
        custo3.setFrete(18.00);
        custo3.setCustoVariavel(90.00);
        custo3.setCustoFixo(180.00);
        custo3.setMargemLucro(18.0);
        custo3.setDataProcessamento(new Date());

        System.out.println("==============================");
        System.out.println("          DADOS DOS CUSTOS");
        System.out.println("==============================");

        System.out.println("------------------------");
        System.out.println("Imposto: " + custo1.getImposto());
        System.out.println("Frete: " + custo1.getFrete());
        System.out.println("Custo Variável: " + custo1.getCustoVariavel());
        System.out.println("Custo Fixo: " + custo1.getCustoFixo());
        System.out.println("Margem de Lucro: " + custo1.getMargemLucro());
        System.out.println("Data de Processamento: " + custo1.getDataProcessamento());

        System.out.println("------------------------");
        System.out.println("Imposto: " + custo2.getImposto());
        System.out.println("Frete: " + custo2.getFrete());
        System.out.println("Custo Variável: " + custo2.getCustoVariavel());
        System.out.println("Custo Fixo: " + custo2.getCustoFixo());
        System.out.println("Margem de Lucro: " + custo2.getMargemLucro());
        System.out.println("Data de Processamento: " + custo2.getDataProcessamento());

        System.out.println("------------------------");
        System.out.println("Imposto: " + custo3.getImposto());
        System.out.println("Frete: " + custo3.getFrete());
        System.out.println("Custo Variável: " + custo3.getCustoVariavel());
        System.out.println("Custo Fixo: " + custo3.getCustoFixo());
        System.out.println("Margem de Lucro: " + custo3.getMargemLucro());
        System.out.println("Data de Processamento: " + custo3.getDataProcessamento());

        System.out.println("------------------------");

        // ==================== ESTOQUE ====================
        Estoque estoque1 = new Estoque();
        estoque1.setQuantidade(new BigDecimal("1000.50"));
        estoque1.setLocalTanque("TANQUE A");
        estoque1.setLocalEndereco("ESTOQUE PRINCIPAL");
        estoque1.setLoteFabricacao("LOTE-001");
        estoque1.setDataValidade(new Date());

        Estoque estoque2 = new Estoque();
        estoque2.setQuantidade(new BigDecimal("500.00"));
        estoque2.setLocalTanque("TANQUE B");
        estoque2.setLocalEndereco("ESTOQUE SECUNDÁRIO");
        estoque2.setLoteFabricacao("LOTE-002");
        estoque2.setDataValidade(new Date());

        Estoque estoque3 = new Estoque();
        estoque3.setQuantidade(new BigDecimal("2500.75"));
        estoque3.setLocalTanque("TANQUE C");
        estoque3.setLocalEndereco("ESTOQUE RESERVA");
        estoque3.setLoteFabricacao("LOTE-003");
        estoque3.setDataValidade(new Date());

        System.out.println("==============================");
        System.out.println("          DADOS DO ESTOQUE");
        System.out.println("==============================");

        System.out.println("------------------------");
        System.out.println("Quantidade: " + estoque1.getQuantidade());
        System.out.println("Local Tanque: " + estoque1.getLocalTanque());
        System.out.println("Local Endereço: " + estoque1.getLocalEndereco());
        System.out.println("Lote de Fabricação: " + estoque1.getLoteFabricacao());
        System.out.println("Data de Validade: " + estoque1.getDataValidade());

        System.out.println("------------------------");
        System.out.println("Quantidade: " + estoque2.getQuantidade());
        System.out.println("Local Tanque: " + estoque2.getLocalTanque());
        System.out.println("Local Endereço: " + estoque2.getLocalEndereco());
        System.out.println("Lote de Fabricação: " + estoque2.getLoteFabricacao());
        System.out.println("Data de Validade: " + estoque2.getDataValidade());

        System.out.println("------------------------");
        System.out.println("Quantidade: " + estoque3.getQuantidade());
        System.out.println("Local Tanque: " + estoque3.getLocalTanque());
        System.out.println("Local Endereço: " + estoque3.getLocalEndereco());
        System.out.println("Lote de Fabricação: " + estoque3.getLoteFabricacao());
        System.out.println("Data de Validade: " + estoque3.getDataValidade());

        System.out.println("------------------------");

        // ==================== PRECO ====================
        Preco preco1 = new Preco();
        preco1.setValor(new BigDecimal("5.99"));
        preco1.setDataAlteracao(new Date());
        preco1.setHoraAlteracao(new Date());

        Preco preco2 = new Preco();
        preco2.setValor(new BigDecimal("6.15"));
        preco2.setDataAlteracao(new Date());
        preco2.setHoraAlteracao(new Date());

        Preco preco3 = new Preco();
        preco3.setValor(new BigDecimal("4.80"));
        preco3.setDataAlteracao(new Date());
        preco3.setHoraAlteracao(new Date());

        System.out.println("==============================");
        System.out.println("          DADOS DOS PREÇOS");
        System.out.println("==============================");

        System.out.println("------------------------");
        System.out.println("Valor: " + preco1.getValor());
        System.out.println("Data de Alteração: " + preco1.getDataAlteracao());
        System.out.println("Hora de Alteração: " + preco1.getHoraAlteracao());

        System.out.println("------------------------");
        System.out.println("Valor: " + preco2.getValor());
        System.out.println("Data de Alteração: " + preco2.getDataAlteracao());
        System.out.println("Hora de Alteração: " + preco2.getHoraAlteracao());

        System.out.println("------------------------");
        System.out.println("Valor: " + preco3.getValor());
        System.out.println("Data de Alteração: " + preco3.getDataAlteracao());
        System.out.println("Hora de Alteração: " + preco3.getHoraAlteracao());

        System.out.println("------------------------");

        // ==================== PRODUTO ====================
        Produto produto1 = new Produto();
        produto1.setNome("Gasolina Comum");
        produto1.setReferencia("GCOM-001");
        produto1.setFornecedor("Petrobras");
        produto1.setCategoria("Combustível");
        produto1.setMarca("Petrobras");

        Produto produto2 = new Produto();
        produto2.setNome("Etanol");
        produto2.setReferencia("ETAN-002");
        produto2.setFornecedor("União");
        produto2.setCategoria("Combustível");
        produto2.setMarca("União");

        Produto produto3 = new Produto();
        produto3.setNome("Óleo Diesel");
        produto3.setReferencia("DIESEL-003");
        produto3.setFornecedor("Shell");
        produto3.setCategoria("Combustível");
        produto3.setMarca("Shell");

        System.out.println("==============================");
        System.out.println("          DADOS DOS PRODUTOS");
        System.out.println("==============================");

        System.out.println("------------------------");
        System.out.println("Nome: " + produto1.getNome());
        System.out.println("Referência: " + produto1.getReferencia());
        System.out.println("Fornecedor: " + produto1.getFornecedor());
        System.out.println("Categoria: " + produto1.getCategoria());
        System.out.println("Marca: " + produto1.getMarca());

        System.out.println("------------------------");
        System.out.println("Nome: " + produto2.getNome());
        System.out.println("Referência: " + produto2.getReferencia());
        System.out.println("Fornecedor: " + produto2.getFornecedor());
        System.out.println("Categoria: " + produto2.getCategoria());
        System.out.println("Marca: " + produto2.getMarca());

        System.out.println("------------------------");
        System.out.println("Nome: " + produto3.getNome());
        System.out.println("Referência: " + produto3.getReferencia());
        System.out.println("Fornecedor: " + produto3.getFornecedor());
        System.out.println("Categoria: " + produto3.getCategoria());
        System.out.println("Marca: " + produto3.getMarca());

        System.out.println("------------------------");
    }
}