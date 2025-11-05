package br.com.PdvFrontEnd.view;

import br.com.PdvFrontEnd.util.SessionManager;
import br.com.PdvFrontEnd.service.AcessoService;
import br.com.PdvFrontEnd.model.Acesso;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(44, 62, 80);
    private static final Color ACCENT_COLOR = new Color(230, 126, 34);
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Color BUTTON_HOVER_COLOR = new Color(41, 128, 185);

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JRadioButton rbFrentista;
    private JRadioButton rbAdmin;
    private SessionManager sessionManager;
    private AcessoService acessoService;

    public LoginView() {
        this.sessionManager = SessionManager.getInstance();
        this.acessoService = new AcessoService();
        initComponents();
    }

    private void initComponents() {
        setTitle("Login - Sistema PDV");
        setSize(400, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(SECONDARY_COLOR);
        setLayout(new BorderLayout(10, 10));

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(SECONDARY_COLOR);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Título
        JLabel lblTitle = new JLabel("Login");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(TEXT_COLOR);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTitle);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Tipo de usuário
        JLabel lblTipo = new JLabel("Tipo de Usuário:");
        lblTipo.setForeground(TEXT_COLOR);
        lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTipo.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTipo);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        radioPanel.setOpaque(false);

        rbFrentista = new JRadioButton("Frentista");
        rbFrentista.setForeground(TEXT_COLOR);
        rbFrentista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbFrentista.setOpaque(false);
        rbFrentista.setSelected(true);

        rbAdmin = new JRadioButton("Administrador");
        rbAdmin.setForeground(TEXT_COLOR);
        rbAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        rbAdmin.setOpaque(false);

        ButtonGroup group = new ButtonGroup();
        group.add(rbFrentista);
        group.add(rbAdmin);

        radioPanel.add(rbFrentista);
        radioPanel.add(rbAdmin);
        mainPanel.add(radioPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Campo Username
        JLabel lblUsername = new JLabel("Usuário:");
        lblUsername.setForeground(TEXT_COLOR);
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblUsername);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        txtUsername = new JTextField(20);
        txtUsername.setMaximumSize(new Dimension(300, 35));
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(txtUsername);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Campo Password
        JLabel lblPassword = new JLabel("Senha:");
        lblPassword.setForeground(TEXT_COLOR);
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblPassword);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        txtPassword = new JPasswordField(20);
        txtPassword.setMaximumSize(new Dimension(300, 35));
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(txtPassword);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Botão Login
        JButton btnLogin = createStyledButton("Entrar");
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setMaximumSize(new Dimension(300, 40));
        btnLogin.addActionListener(e -> handleLogin());
        mainPanel.add(btnLogin);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botão Preencher Informações (para frentistas cadastrarem dados pessoais)
        JButton btnPreencherInfo = createStyledButton("Preencher Informações");
        btnPreencherInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPreencherInfo.setMaximumSize(new Dimension(300, 40));
        btnPreencherInfo.setBackground(new Color(46, 204, 113)); // Verde
        btnPreencherInfo.addActionListener(e -> new CadastroPessoaView().setVisible(true));
        mainPanel.add(btnPreencherInfo);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botão Cadastrar (só se não existir frentista)
        if (!sessionManager.userExists()) {
            JButton btnRegister = createStyledButton("Cadastrar Frentista");
            btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnRegister.setMaximumSize(new Dimension(300, 40));
            btnRegister.setBackground(ACCENT_COLOR);
            btnRegister.addActionListener(e -> {
                new RegisterView().setVisible(true);
                dispose();
            });
            mainPanel.add(btnRegister);
        }

        // Botão Cadastrar Admin (só se não existir admin)
        if (!sessionManager.adminExists()) {
            JButton btnRegisterAdmin = createStyledButton("Cadastrar Admin");
            btnRegisterAdmin.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnRegisterAdmin.setMaximumSize(new Dimension(300, 40));
            btnRegisterAdmin.setBackground(new Color(155, 89, 182)); // Roxo
            btnRegisterAdmin.addActionListener(e -> {
                new RegisterAdminView().setVisible(true);
                dispose();
            });
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            mainPanel.add(btnRegisterAdmin);
        }

        add(mainPanel, BorderLayout.CENTER);

        // Enter para fazer login
        txtPassword.addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, preencha todos os campos!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tenta fazer login via backend
        try {
            Acesso acesso = acessoService.login(username, password);

            if (acesso == null) {
                JOptionPane.showMessageDialog(this,
                        "Usuário ou senha incorretos!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                txtPassword.setText("");
                return;
            }

            // Verifica se o role corresponde ao tipo selecionado
            boolean isAdmin = rbAdmin.isSelected();
            String roleEsperado = isAdmin ? "ADMIN" : "FRENTISTA";

            if (acesso.getRole() != null && !acesso.getRole().equals(roleEsperado)) {
                JOptionPane.showMessageDialog(this,
                        "Este usuário não tem permissão de " + roleEsperado + "!",
                        "Acesso Negado",
                        JOptionPane.WARNING_MESSAGE);
                txtPassword.setText("");
                return;
            }

            // Login bem-sucedido
            String role = acesso.getRole() != null ? acesso.getRole() : "FRENTISTA";
            sessionManager.login(username, String.valueOf(acesso.getId()), role);

            JOptionPane.showMessageDialog(this,
                    "Login realizado com sucesso!\n" +
                    "Bem-vindo(a), " + (acesso.getNomeCompleto() != null ? acesso.getNomeCompleto() : username) + "!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            // Abre a tela principal
            MainApp.showMainApp();
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Usuário ou senha incorretos!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            txtPassword.setText("");
        }
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(PRIMARY_COLOR.darker(), 1),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(BUTTON_HOVER_COLOR);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (button.getBackground().equals(ACCENT_COLOR)) {
                    button.setBackground(ACCENT_COLOR);
                } else {
                    button.setBackground(PRIMARY_COLOR);
                }
            }
        });

        return button;
    }
}

