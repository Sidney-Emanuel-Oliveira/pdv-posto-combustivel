package br.com.PdvFrontEnd.view;

import br.com.PdvFrontEnd.service.*;
import br.com.PdvFrontEnd.util.SessionManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
            mainFrame.setSize(680, 720);  // Aumentado para acomodar melhor os botões
            mainFrame.setResizable(false);
            mainFrame.setLocationRelativeTo(null);

            // Painel de fundo com gradiente
            JPanel backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                    int w = getWidth();
                    int h = getHeight();
                    GradientPaint gp = new GradientPaint(0, 0, SECONDARY_COLOR, 0, h, SECONDARY_COLOR.darker());
                    g2d.setPaint(gp);
                    g2d.fillRect(0, 0, w, h);
                }
            };
            backgroundPanel.setLayout(new BorderLayout(10, 10));
            mainFrame.setContentPane(backgroundPanel);

            // Painel superior com informações do usuário (estilizado)
            JPanel topPanel = new JPanel(new BorderLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    // Fundo com leve gradiente
                    GradientPaint gp = new GradientPaint(0, 0, new Color(52, 73, 94), 0, getHeight(), new Color(44, 62, 80));
                    g2d.setPaint(gp);
                    g2d.fillRect(0, 0, getWidth(), getHeight());

                    // Borda inferior brilhante
                    g2d.setColor(new Color(255, 255, 255, 20));
                    g2d.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
                }
            };
            topPanel.setOpaque(false);
            topPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

            // Nome do usuário
            JLabel lblUser = new JLabel("Usuário: " + sessionManager.getCurrentUsername() + " (" + sessionManager.getUserRole() + ")");
            lblUser.setFont(new Font("Segoe UI", Font.BOLD, 18));
            lblUser.setForeground(TEXT_COLOR);

            JButton btnLogout = createModernButton("Sair", new Color(231, 76, 60), new Color(192, 57, 43));
            btnLogout.setPreferredSize(new Dimension(120, 40));
            btnLogout.addActionListener(e -> {
                sessionManager.logout();
                mainFrame.dispose();
                new LoginView().setVisible(true);
            });

            topPanel.add(lblUser, BorderLayout.WEST);
            topPanel.add(btnLogout, BorderLayout.EAST);
            backgroundPanel.add(topPanel, BorderLayout.NORTH);

            // Card central com sombra
            JPanel cardPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    // Sombra
                    g2d.setColor(new Color(0, 0, 0, 50));
                    g2d.fillRoundRect(5, 5, getWidth()-10, getHeight()-5, 20, 20);

                    // Card
                    g2d.setColor(new Color(52, 73, 94));
                    g2d.fillRoundRect(0, 0, getWidth()-10, getHeight()-10, 20, 20);

                    // Borda brilhante
                    g2d.setColor(new Color(255, 255, 255, 25));
                    g2d.setStroke(new BasicStroke(1.5f));
                    g2d.drawRoundRect(1, 1, getWidth()-12, getHeight()-12, 20, 20);

                    g2d.dispose();
                }
            };
            cardPanel.setOpaque(false);
            cardPanel.setLayout(new GridLayout(9, 1, 12, 12));
            cardPanel.setBorder(new EmptyBorder(25, 35, 25, 35));

            // Botão Gerenciar Bombas (sempre disponível)
            JButton btnBombas = createModernButton("Gerenciar Bombas", ACTIVE_COLOR, ACTIVE_COLOR.darker());
            btnBombas.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnBombas.addActionListener(e -> new BombaListView().setVisible(true));
            cardPanel.add(btnBombas);

            // Botão Cadastrar Frentista (apenas para Admin)
            Color purpleColor = new Color(155, 89, 182);
            JButton btnCadastrarFrentista = createModernButton("Cadastrar Novo Frentista", purpleColor, purpleColor.darker());
            btnCadastrarFrentista.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnCadastrarFrentista.addActionListener(e -> {
                if (checkAdminAccess(mainFrame)) {
                    new RegisterView().setVisible(true);
                }
            });
            if (!isAdmin) {
                btnCadastrarFrentista.setEnabled(false);
                btnCadastrarFrentista.setBackground(new Color(100, 100, 100));
            }
            cardPanel.add(btnCadastrarFrentista);

            // Botões de gerenciamento (apenas para Admin)
            JButton btnPessoas = createModernButton("Gerenciar Pessoas", PRIMARY_COLOR, PRIMARY_COLOR.darker());
            btnPessoas.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnPessoas.addActionListener(e -> {
                if (checkAdminAccess(mainFrame)) {
                    new PessoaList(new PessoaService()).setVisible(true);
                }
            });
            if (!isAdmin) {
                btnPessoas.setEnabled(false);
                btnPessoas.setBackground(new Color(100, 100, 100));
            }
            cardPanel.add(btnPessoas);

            JButton btnPrecos = createModernButton("Gerenciar Preços", PRIMARY_COLOR, PRIMARY_COLOR.darker());
            btnPrecos.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnPrecos.addActionListener(e -> {
                if (checkAdminAccess(mainFrame)) {
                    new PrecoList(new PrecoService()).setVisible(true);
                }
            });
            if (!isAdmin) {
                btnPrecos.setEnabled(false);
                btnPrecos.setBackground(new Color(100, 100, 100));
            }
            cardPanel.add(btnPrecos);

            JButton btnProdutos = createModernButton("Gerenciar Produtos", PRIMARY_COLOR, PRIMARY_COLOR.darker());
            btnProdutos.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnProdutos.addActionListener(e -> {
                if (checkAdminAccess(mainFrame)) {
                    new ProdutoList(new ProdutoService()).setVisible(true);
                }
            });
            if (!isAdmin) {
                btnProdutos.setEnabled(false);
                btnProdutos.setBackground(new Color(100, 100, 100));
            }
            cardPanel.add(btnProdutos);

            JButton btnCustos = createModernButton("Gerenciar Custos", PRIMARY_COLOR, PRIMARY_COLOR.darker());
            btnCustos.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnCustos.addActionListener(e -> {
                if (checkAdminAccess(mainFrame)) {
                    new CustoList(new CustoService()).setVisible(true);
                }
            });
            if (!isAdmin) {
                btnCustos.setEnabled(false);
                btnCustos.setBackground(new Color(100, 100, 100));
            }
            cardPanel.add(btnCustos);

            JButton btnEstoques = createModernButton("Gerenciar Estoques", PRIMARY_COLOR, PRIMARY_COLOR.darker());
            btnEstoques.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnEstoques.addActionListener(e -> {
                if (checkAdminAccess(mainFrame)) {
                    new EstoqueList(new EstoqueService()).setVisible(true);
                }
            });
            if (!isAdmin) {
                btnEstoques.setEnabled(false);
                btnEstoques.setBackground(new Color(100, 100, 100));
            }
            cardPanel.add(btnEstoques);

            JButton btnAcessos = createModernButton("Gerenciar Acessos", PRIMARY_COLOR, PRIMARY_COLOR.darker());
            btnAcessos.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnAcessos.addActionListener(e -> {
                if (checkAdminAccess(mainFrame)) {
                    new AcessoList(new AcessoService()).setVisible(true);
                }
            });
            if (!isAdmin) {
                btnAcessos.setEnabled(false);
                btnAcessos.setBackground(new Color(100, 100, 100));
            }
            cardPanel.add(btnAcessos);

            JButton btnContatos = createModernButton("Gerenciar Contatos", PRIMARY_COLOR, PRIMARY_COLOR.darker());
            btnContatos.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnContatos.addActionListener(e -> {
                if (checkAdminAccess(mainFrame)) {
                    new ContatoList(new ContatoService()).setVisible(true);
                }
            });
            if (!isAdmin) {
                btnContatos.setEnabled(false);
                btnContatos.setBackground(new Color(100, 100, 100));
            }
            cardPanel.add(btnContatos);

            // Centralizar o card
            JPanel centerWrapper = new JPanel(new GridBagLayout());
            centerWrapper.setOpaque(false);
            centerWrapper.add(cardPanel);
            backgroundPanel.add(centerWrapper, BorderLayout.CENTER);

            // Painel inferior com informações (estilizado)
            JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    // Fundo com leve gradiente
                    GradientPaint gp = new GradientPaint(0, 0, new Color(44, 62, 80), 0, getHeight(), new Color(52, 73, 94));
                    g2d.setPaint(gp);
                    g2d.fillRect(0, 0, getWidth(), getHeight());

                    // Borda superior brilhante
                    g2d.setColor(new Color(255, 255, 255, 20));
                    g2d.drawLine(0, 0, getWidth(), 0);
                }
            };
            footerPanel.setOpaque(false);
            footerPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

            JLabel lblInfo = new JLabel("Sistema de Gerenciamento - PDV Posto de Combustível");
            lblInfo.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblInfo.setForeground(new Color(189, 195, 199));
            footerPanel.add(lblInfo);

            backgroundPanel.add(footerPanel, BorderLayout.SOUTH);

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

    private static JButton createModernButton(String text, Color startColor, Color endColor) {
        JButton button = new JButton(text) {
            private boolean hovered = false;
            private int shadowSize = 4;

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                int w = getWidth();
                int h = getHeight();

                // Sombra
                g2d.setColor(new Color(0, 0, 0, 30));
                for (int i = 0; i < shadowSize; i++) {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.05f));
                    g2d.fillRoundRect(i, i, w - i * 2, h - i * 2, 12, 12);
                }

                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

                // Gradiente
                GradientPaint gradient;
                if (isEnabled()) {
                    if (hovered) {
                        Color hoverStart = endColor.darker();
                        Color hoverEnd = endColor;
                        gradient = new GradientPaint(0, 0, hoverStart, 0, h, hoverEnd);
                    } else {
                        gradient = new GradientPaint(0, 0, startColor, 0, h, endColor);
                    }
                } else {
                    Color disabledColor = new Color(100, 100, 100);
                    gradient = new GradientPaint(0, 0, disabledColor, 0, h, disabledColor.darker());
                }

                g2d.setPaint(gradient);
                g2d.fillRoundRect(shadowSize, shadowSize, w - shadowSize * 2, h - shadowSize * 2, 12, 12);

                // Borda brilhante
                g2d.setColor(new Color(255, 255, 255, isEnabled() ? 50 : 20));
                g2d.setStroke(new BasicStroke(1.5f));
                g2d.drawRoundRect(shadowSize + 1, shadowSize + 1,
                        w - shadowSize * 2 - 2, h - shadowSize * 2 - 2, 12, 12);

                g2d.dispose();
                super.paintComponent(g);
            }
        };

        button.setForeground(TEXT_COLOR);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(false);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (button.isEnabled()) {
                    button.repaint();
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (button.isEnabled()) {
                    button.repaint();
                }
            }
        });

        return button;
    }
}

