import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;

import java.awt.Cursor;
import java.awt.Font;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonUser extends User {
    int idade;

    public PersonUser() {

    }

    public PersonUser(String Nome, String Email, String Senha, String ContaDiferente) {
        super(Nome, Senha, Email, ContaDiferente);

    }

    public void HomeUser() {
        JFrame frame = new JFrame("Bem-Vindo ao LIFEinvader " + getNome() + " Idade pessoal: " + idade);        
        frame.setBounds(100, 100, 800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(null);
        buttonPanel.setBackground(new Color(255, 255, 255));
        buttonPanel.setBounds(0, 0, 800, 500);
        buttonPanel.setLayout(null);
        frame.add(buttonPanel);
        
		JLabel fotoPerfil = new JLabel("");
		fotoPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		fotoPerfil.setIcon(new ImageIcon(PersonUser.class.getResource("/img/imgFotoPerfil.jpg")));
		fotoPerfil.setBackground(new Color(64, 0, 128));
		fotoPerfil.setBounds(10, 11, 190, 190);
		buttonPanel.add(fotoPerfil);
		
		JPanel painelFundo = new JPanel();
		painelFundo.setBackground(new Color(49, 100, 122));
		painelFundo.setBounds(0, 0, 784, 212);
		painelFundo.setLayout(null);
		buttonPanel.add(painelFundo);
		
		JPanel forYou = new JPanel();
		forYou.setBackground(new Color(192, 192, 192));
		forYou.setBounds(10, 223, 764, 227);
		forYou.setLayout(null);
		buttonPanel.add(forYou);
		
		//Labels
		JLabel perfilNome = new JLabel(getNome());
		perfilNome.setBounds(211, 10, 563, 37);
		painelFundo.add(perfilNome);
		perfilNome.setForeground(new Color(255, 255, 255));
		perfilNome.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel perfilNumeroAmigos = new JLabel("Amigos: " + numeroAmigos);
		perfilNumeroAmigos.setBounds(211, 45, 563, 27);
		painelFundo.add(perfilNumeroAmigos);
		perfilNumeroAmigos.setForeground(Color.WHITE);
		perfilNumeroAmigos.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel perfilIdade = new JLabel("Idade: " + idade);
		perfilIdade.setBounds(211, 75, 563, 27);
		painelFundo.add(perfilIdade);
		perfilIdade.setForeground(Color.WHITE);
		perfilIdade.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		//BOTÕES ABAIXO
        JButton DeletarPerfil = new JButton("Deletar seu Perfil");
        DeletarPerfil.setBounds(607, 193, 154, 30);
        DeletarPerfil.setFocusPainted(false);
        DeletarPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        DeletarPerfil.setBorder(null);
        DeletarPerfil.setForeground(new Color(255, 255, 255));
        DeletarPerfil.setFont(new Font("Tahoma", Font.BOLD, 17));
        DeletarPerfil.setBackground(new Color(0, 156, 223));
        
        DeletarPerfil.addActionListener(e -> {
        	DeleteUser(getNome());
        });
        forYou.add(DeletarPerfil);
        
        JButton ListarUsuários = new JButton("Listar todos os usuários");
        ListarUsuários.setBounds(550, 5, 210, 30);
        ListarUsuários.setFocusPainted(false);
        ListarUsuários.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ListarUsuários.setBorder(null);
        ListarUsuários.setForeground(new Color(255, 255, 255));
        ListarUsuários.setFont(new Font("Tahoma", Font.BOLD, 17));
        ListarUsuários.setBackground(new Color(0, 156, 223));
        
        ListarUsuários.addActionListener(e -> {
        	ListUser();
        });
        forYou.add(ListarUsuários);
        
        JButton CriarUsuário = new JButton("Criar um novo usuário");
        CriarUsuário.setBounds(550, 40, 210, 30);
        CriarUsuário.setFocusPainted(false);
        CriarUsuário.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        CriarUsuário.setBorder(null);
        CriarUsuário.setForeground(new Color(255, 255, 255));
        CriarUsuário.setFont(new Font("Tahoma", Font.BOLD, 17));
        CriarUsuário.setBackground(new Color(0, 156, 223));
        
        CriarUsuário.addActionListener(e -> {
        	frame.dispose();
        	CreateUser();
        });
        forYou.add(CriarUsuário);
        
        JButton AdicionarAmizade = new JButton("Adicionar amizade");
        AdicionarAmizade.setBounds(5, 5, 210, 30);
        AdicionarAmizade.setFocusPainted(false);
        AdicionarAmizade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AdicionarAmizade.setBorder(null);
        AdicionarAmizade.setForeground(new Color(255, 255, 255));
        AdicionarAmizade.setFont(new Font("Tahoma", Font.BOLD, 17));
        AdicionarAmizade.setBackground(new Color(0, 156, 223));
        
        AdicionarAmizade.addActionListener(e -> {
            addFriend();
            frame.dispose();
        });
        forYou.add(AdicionarAmizade);
        
        JButton ListarAmizades = new JButton("Listar suas amizades");
        ListarAmizades.setBounds(5, 40, 210, 30);
        ListarAmizades.setFocusPainted(false);
        ListarAmizades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ListarAmizades.setBorder(null);
        ListarAmizades.setForeground(new Color(255, 255, 255));
        ListarAmizades.setFont(new Font("Tahoma", Font.BOLD, 17));
        ListarAmizades.setBackground(new Color(0, 156, 223));
        
        ListarAmizades.addActionListener(e -> {
        	ListFriends();
        });
        forYou.add(ListarAmizades);

        JButton AbaLogin = new JButton("Aba Login");
        AbaLogin.setBounds(550, 75, 210, 30);
        AbaLogin.setFocusPainted(false);
        AbaLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AbaLogin.setBorder(null);
        AbaLogin.setForeground(new Color(255, 255, 255));
        AbaLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
        AbaLogin.setBackground(new Color(0, 156, 223));
        
        AbaLogin.addActionListener(e -> {
        	frame.dispose();
            UserLogin();
        });
        forYou.add(AbaLogin);
        
        JButton RemoverAmizades = new JButton("Remover Amizades");
        RemoverAmizades.setBounds(5, 75, 210, 30);
        RemoverAmizades.setFocusPainted(false);
        RemoverAmizades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        RemoverAmizades.setBorder(null);
        RemoverAmizades.setForeground(new Color(255, 255, 255));
        RemoverAmizades.setFont(new Font("Tahoma", Font.BOLD, 17));
        RemoverAmizades.setBackground(new Color(0, 156, 223));
        
        RemoverAmizades.addActionListener(e -> {
        	removeFriend();
        	frame.dispose();
        });
        forYou.add(RemoverAmizades);
        
        JButton AtualizarDados = new JButton("Atualizar dados");
        AtualizarDados.setBounds(211, 115, 210, 30);
        AtualizarDados.setFocusPainted(false);
        AtualizarDados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AtualizarDados.setBorder(null);
        AtualizarDados.setForeground(new Color(255, 255, 255));
        AtualizarDados.setFont(new Font("Tahoma", Font.BOLD, 17));
        AtualizarDados.setBackground(new Color(0, 156, 223));
        
        AtualizarDados.addActionListener(e -> {
        	updateUserData(getNome());
        	frame.dispose();
        });
        painelFundo.add(AtualizarDados);

        JButton InserirIdade = new JButton("Inserir idade");
        InserirIdade.setBounds(211, 150, 210, 30);
        InserirIdade.setFocusPainted(false);
        InserirIdade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        InserirIdade.setBorder(null);
        InserirIdade.setForeground(new Color(255, 255, 255));
        InserirIdade.setFont(new Font("Tahoma", Font.BOLD, 17));
        InserirIdade.setBackground(new Color(0, 156, 223));
        
        InserirIdade.addActionListener(e -> {
        	MostrarIdade();
        	frame.dispose();
        });
        painelFundo.add(InserirIdade);
        
        frame.setVisible(true);
    }

    public void ButtonClick(String buttonText) {
        if (buttonText.equals("Deletar seu Perfil")) {
            DeleteUser(getNome());
            CreateUser();
        } else if (buttonText.equals("Listar todos os usuários")) {
            ListUser();
            HomeUser();

        } else if (buttonText.equals("Criar um novo usuário")) {
            CreateUser();
        } else if (buttonText.equals("Adicionar amizade")) {
            addFriend();
        } else if (buttonText.equals("Listar suas amizades")) {
            ListFriends();
        } else if (buttonText.equals("Aba Login")) {
            UserLogin();
        } else if (buttonText.equals("Remover Amizades")) {
            removeFriend();
        } else if (buttonText.equals("Atualizar dados")) {
            updateUserData(getNome());
        } else if (buttonText.equals("Inserir idade")) {
            MostrarIdade();
        }
    }

    public void MostrarIdade() {
        JFrame frame = new JFrame("Mostrar Idade");        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100, 100, 400, 200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));

        JLabel ageLabel = new JLabel("Idade:");
        ageLabel.setBounds(140, 30, 50, 30);
        frame.add(ageLabel);
        
        JTextField ageField = new JTextField(20);
        ageField.setBounds(180, 30, 50, 30);
        frame.add(ageField);

        JButton showButton = new JButton("Mostrar Idade");
        showButton.setBounds(110, 80, 150, 38);
        showButton.setFocusPainted(false);
        showButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        showButton.setBorder(null);
        showButton.setForeground(new Color(255, 255, 255));
        showButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        showButton.setBackground(new Color(0, 156, 223));
        frame.add(showButton);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idadeTexto = ageField.getText();

                try {
                    idade = Integer.parseInt(idadeTexto);
                    JOptionPane.showMessageDialog(frame, "Sua idade é: " + idade);
                    frame.dispose();
                    HomeUser();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Entrada inválida. Digite um número inteiro para a idade.");
                }
            }
        });

        frame.setVisible(true);
    }
}
