package br.com.PdvFrontEnd.service;

import br.com.PdvFrontEnd.dto.PrecoRequest;
import br.com.PdvFrontEnd.dto.PrecoResponse;
import br.com.PdvFrontEnd.model.Preco;
import br.com.PdvFrontEnd.util.HttpClient;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PrecoService {

    public PrecoService() {
    }

    public void addPreco(Preco preco) {
        try {
            PrecoRequest request = new PrecoRequest(
                preco.getValor(),
                preco.getDataAlteracao(),
                preco.getHoraAlteracao()
            );

            HttpClient.post("/precos", request, PrecoResponse.class);
            JOptionPane.showMessageDialog(null,
                "Preço adicionado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Erro ao adicionar preço: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Preco> getAllPrecos() {
        try {
            PrecoResponse[] responses = HttpClient.getArray("/precos", PrecoResponse[].class);
            List<Preco> precos = new ArrayList<>();
            for (PrecoResponse response : responses) {
                Preco preco = new Preco(
                    response.getValor(),
                    parseDateString(response.getDataAlteracao()),
                    parseDateString(response.getHoraAlteracao())
                );
                preco.setId(response.getId());
                precos.add(preco);
            }
            return precos;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Erro ao listar preços: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    private java.util.Date parseDateString(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }

        try {
            // Tenta vários formatos
            java.text.SimpleDateFormat[] formats = {
                new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
                new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"),
                new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"),
                new java.text.SimpleDateFormat("yyyy-MM-dd"),
                new java.text.SimpleDateFormat("HH:mm:ss")
            };

            for (java.text.SimpleDateFormat format : formats) {
                try {
                    format.setLenient(false);
                    return format.parse(dateStr);
                } catch (java.text.ParseException e) {
                    // Tenta próximo formato
                }
            }

            // Se nenhum formato funcionou, retorna null
            System.err.println("Não foi possível fazer parse da data: " + dateStr);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removePreco(Long id) {
        try {
            HttpClient.delete("/precos/" + id);
            JOptionPane.showMessageDialog(null,
                "Preço removido com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Erro ao remover preço: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePreco(Long id, Preco preco) {
        try {
            PrecoRequest request = new PrecoRequest(
                preco.getValor(),
                preco.getDataAlteracao(),
                preco.getHoraAlteracao()
            );

            HttpClient.put("/precos/" + id, request, PrecoResponse.class);
            JOptionPane.showMessageDialog(null,
                "Preço atualizado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Erro ao atualizar preço: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
