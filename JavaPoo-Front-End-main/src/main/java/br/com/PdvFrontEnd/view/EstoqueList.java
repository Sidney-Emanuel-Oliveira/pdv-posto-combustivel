package br.com.PdvFrontEnd.view;

import br.com.PdvFrontEnd.model.Estoque;
import br.com.PdvFrontEnd.service.EstoqueService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.util.List;

public class EstoqueList extends JFrame {
    // Cores para a nova interface
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219); // Azul
    private static final Color SECONDARY_COLOR = new Color(44, 62, 80); // Azul escuro quase preto
    private static final Color ACCENT_COLOR = new Color(230, 126, 34); // Laranja
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Color BACKGROUND_COLOR = new Color(236, 240, 241); // Cinza claro
    private static final Color TABLE_HEADER_COLOR = new Color(52, 73, 94); // Azul escuro para cabeçalho da tabela
    private static final Color TABLE_SELECTION_COLOR = new Color(142, 68, 173); // Roxo para seleção da tabela
    private static final Color BUTTON_HOVER_COLOR = new Color(41, 128, 185); // Azul mais escuro para hover

    private JTable table;
    private DefaultTableModel tableModel;
    private EstoqueService estoqueService;

    public EstoqueList(EstoqueService service) {
        this.estoqueService = service;

        setTitle("Gerenciamento de Estoques");
        getContentPane().setBackground(BACKGROUND_COLOR);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(15, 15, 15, 15));

        String[] columnNames = {"Quantidade", "Local Tanque", "Local Endereço", "Lote Fabricação", "Data Validade"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(28);
        table.setGridColor(BACKGROUND_COLOR);
        table.setSelectionBackground(TABLE_SELECTION_COLOR);
        table.setSelectionForeground(TEXT_COLOR);
        table.getTableHeader().setBackground(TABLE_HEADER_COLOR);
        table.getTableHeader().setForeground(TEXT_COLOR);
        table.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(SECONDARY_COLOR, 2));
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotoes.setBackground(SECONDARY_COLOR);
        JButton btnAdicionar = createStyledButton("Adicionar");
        JButton btnEditar = createStyledButton("Editar");
        JButton btnRemover = createStyledButton("Remover");

        panelBotoes.add(btnAdicionar);
        panelBotoes.add(btnEditar);
        panelBotoes.add(btnRemover);
        add(panelBotoes, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(e -> {
            EstoqueForm form = new EstoqueForm(estoqueService, this);
            form.setVisible(true);
        });

        btnEditar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                List<Estoque> estoques = estoqueService.getAllEstoques();
                if (selectedRow < estoques.size()) {
                    Estoque estoque = estoques.get(selectedRow);
                    if (estoque.getId() != null) {
                        EstoqueForm form = new EstoqueForm(estoqueService, this, estoque);
                        form.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Estoque não possui ID válido!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um estoque para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnRemover.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // Pegar o estoque da lista usando o índice da linha
                List<Estoque> estoques = estoqueService.getAllEstoques();
                if (selectedRow < estoques.size()) {
                    Estoque estoque = estoques.get(selectedRow);
                    if (estoque.getId() != null) {
                        estoqueService.removeEstoque(estoque.getId());
                        atualizarTabela();
                    } else {
                        JOptionPane.showMessageDialog(this, "Estoque não possui ID válido!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um estoque para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        atualizarTabela();
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(ACCENT_COLOR, 2),
                BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        button.setFocusPainted(false);
        button.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                AbstractButton b = (AbstractButton) c;
                ButtonModel model = b.getModel();

                if (model.isPressed()) {
                    g2.setColor(BUTTON_HOVER_COLOR.darker());
                } else if (model.isRollover()) {
                    g2.setColor(BUTTON_HOVER_COLOR);
                } else {
                    g2.setColor(b.getBackground());
                }
                g2.fillRect(0, 0, b.getWidth(), b.getHeight());
                g2.dispose();
                super.paint(g, c);
            }
        });
        return button;
    }

    public void atualizarTabela() {
        tableModel.setRowCount(0);
        List<Estoque> estoques = estoqueService.getAllEstoques();
        for (Estoque estoque : estoques) {
            tableModel.addRow(new Object[]{estoque.getQuantidade(), estoque.getLocalTanque(), estoque.getLocalEndereco(), estoque.getLoteFabricacao(), estoque.getDataValidade()});
        }
    }
}
