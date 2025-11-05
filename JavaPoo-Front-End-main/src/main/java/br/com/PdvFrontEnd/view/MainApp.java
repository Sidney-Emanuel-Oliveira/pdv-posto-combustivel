package br.com.PdvFrontEnd.view;

import br.com.PdvFrontEnd.service.*;
import br.com.PdvFrontEnd.util.SessionManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainApp {
    // Cores para a nova interface
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219); // Azul
    private static final Color SECONDARY_COLOR = new Color(44, 62, 80); // Azul escuro quase preto
    private static final Color ACCENT_COLOR = new Color(230, 126, 34); // Laranja
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Color BUTTON_HOVER_COLOR = new Color(41, 128, 185); // Azul mais escuro para hover
    private static final Color ACTIVE_COLOR = new Color(46, 204, 113); // Verde

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            // Inicia o sistema pelo login
            SessionManager sessionManager = SessionManager.getInstance();

            // Se não existir usuário cadastrado, abre a tela de cadastro
            if (!sessionManager.userExists()) {
                new RegisterView().setVisible(true);
            } else {
                new LoginView().setVisible(true);
            }
        });
    }

    public static void showMainApp() {
        EventQueue.invokeLater(() -> {
            SessionManager sessionManager = SessionManager.getInstance();
            boolean isAdmin = sessionManager.isAdmin();

            JFrame mainFrame = new JFrame("Gerenciamento PDV - " + (isAdmin ? "ADMINISTRADOR" : "FRENTISTA"));
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(600, 550);  // Tamanho menor e mais adequado
            mainFrame.setResizable(false);  // Impede redimensionamento
            mainFrame.getContentPane().setBackground(SECONDARY_COLOR);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setLayout(new BorderLayout(10, 10));

            // Painel superior com informações do usuário
            JPanel topPanel = new JPanel(new BorderLayout());
            topPanel.setBackground(SECONDARY_COLOR.darker());
            topPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

            JLabel lblUser = new JLabel("Usuário: " + sessionManager.getCurrentUsername() + " (" + sessionManager.getUserRole() + ")");
            lblUser.setFont(new Font("Segoe UI", Font.BOLD, 16));
            lblUser.setForeground(TEXT_COLOR);

            JButton btnLogout = createStyledButton("Sair", e -> {
                sessionManager.logout();
                mainFrame.dispose();
                new LoginView().setVisible(true);
            });

            topPanel.add(lblUser, BorderLayout.WEST);
            topPanel.add(btnLogout, BorderLayout.EAST);
            mainFrame.add(topPanel, BorderLayout.NORTH);

            // Painel Central com os Botões de Gerenciamento
            JPanel mainPanel = new JPanel(new GridLayout(9, 1, 10, 10));
            mainPanel.setBackground(SECONDARY_COLOR);
            mainPanel.setBorder(new EmptyBorder(20, 40, 20, 40));

            // Botão Gerenciar Bombas (sempre disponível)
            JButton btnBombas = createStyledButton("Gerenciar Bombas", e -> new BombaListView().setVisible(true));
            btnBombas.setBackground(ACTIVE_COLOR);  // Verde para destacar
            mainPanel.add(btnBombas);

            // Botão Cadastrar Frentista (apenas para Admin)
            JButton btnCadastrarFrentista = createStyledButton("Cadastrar Novo Frentista", e -> {
                if (checkAdminAccess(mainFrame)) {
                    new RegisterView().setVisible(true);
                }
            });
            btnCadastrarFrentista.setBackground(new Color(155, 89, 182)); // Roxo para destacar
            if (!isAdmin) btnCadastrarFrentista.setEnabled(false);
            mainPanel.add(btnCadastrarFrentista);

            // Botões de gerenciamento (apenas para Admin)
            JButton btnPessoas = createStyledButton("Gerenciar Pessoas", e -> {
                if (checkAdminAccess(mainFrame)) {
                    new PessoaList(new PessoaService()).setVisible(true);
                }
            });
            if (!isAdmin) btnPessoas.setEnabled(false);
            mainPanel.add(btnPessoas);

            JButton btnPrecos = createStyledButton("Gerenciar Preços", e -> {
                if (checkAdminAccess(mainFrame)) {
                    new PrecoList(new PrecoService()).setVisible(true);
                }
            });
            if (!isAdmin) btnPrecos.setEnabled(false);
            mainPanel.add(btnPrecos);

            JButton btnProdutos = createStyledButton("Gerenciar Produtos", e -> {
                if (checkAdminAccess(mainFrame)) {
                    new ProdutoList(new ProdutoService()).setVisible(true);
                }
            });
            if (!isAdmin) btnProdutos.setEnabled(false);
            mainPanel.add(btnProdutos);

            JButton btnCustos = createStyledButton("Gerenciar Custos", e -> {
                if (checkAdminAccess(mainFrame)) {
                    new CustoList(new CustoService()).setVisible(true);
                }
            });
            if (!isAdmin) btnCustos.setEnabled(false);
            mainPanel.add(btnCustos);

            JButton btnEstoques = createStyledButton("Gerenciar Estoques", e -> {
                if (checkAdminAccess(mainFrame)) {
                    new EstoqueList(new EstoqueService()).setVisible(true);
                }
            });
            if (!isAdmin) btnEstoques.setEnabled(false);
            mainPanel.add(btnEstoques);

            JButton btnAcessos = createStyledButton("Gerenciar Acessos", e -> {
                if (checkAdminAccess(mainFrame)) {
                    new AcessoList(new AcessoService()).setVisible(true);
                }
            });
            if (!isAdmin) btnAcessos.setEnabled(false);
            mainPanel.add(btnAcessos);

            JButton btnContatos = createStyledButton("Gerenciar Contatos", e -> {
                if (checkAdminAccess(mainFrame)) {
                    new ContatoList(new ContatoService()).setVisible(true);
                }
            });
            if (!isAdmin) btnContatos.setEnabled(false);
            mainPanel.add(btnContatos);

            mainFrame.add(mainPanel, BorderLayout.CENTER);

            // Painel inferior com informações
            JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            footerPanel.setBackground(SECONDARY_COLOR.darker());
            footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel lblInfo = new JLabel("Sistema de Gerenciamento - PDV Posto de Combustível");
            lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            lblInfo.setForeground(TEXT_COLOR);
            footerPanel.add(lblInfo);

            mainFrame.add(footerPanel, BorderLayout.SOUTH);


            mainFrame.setVisible(true);
        });
    }

    private static boolean checkAdminAccess(JFrame parent) {
        SessionManager sessionManager = SessionManager.getInstance();
        if (!sessionManager.isAdmin()) {
            JOptionPane.showMessageDialog(parent,
                    "Acesso negado!\n\nApenas o Administrador pode acessar este recurso.",
                    "Acesso Restrito",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private static JButton createStyledButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(ACCENT_COLOR, 1),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        button.setFocusPainted(false);
        button.addActionListener(actionListener);
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
}