
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class User {
    String Nome;
    String Senha;
    String Email;
    String ContaDiferente;
    String NomeEmpresa, NomePessoal, SenhaPessoal, SenhaEmpresa;
    int numeroAmigos = 0;

    public static HashMap<String, String> usersList = new HashMap<String, String>();

    public User() {

    }

    public User(String Nome, String Senha, String Email, String ContaDiferente) {
        this.Nome = Nome;
        this.Senha = Senha;
        this.Email = Email;
        this.ContaDiferente = ContaDiferente;
    }

    @Override
    public String toString() {
        return Nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String NomeSET) {
        this.Nome = NomeSET;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContaDiferente() {
        return ContaDiferente;
    }

    public void setContaDiferente(String contaDiferente) {
        ContaDiferente = contaDiferente;
    }

    public void CreateUser() {

        JFrame frame = new JFrame();
        frame.setTitle("Cadastro no LIFEinvader");
        frame.setBounds(100, 100, 800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(
                Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));

        JLabel namelLabel = new JLabel("Username:");
        namelLabel.setBounds(280, 140, 100, 25);
        frame.add(namelLabel);

        JTextField nameTextField = new JTextField(20);
        nameTextField.setBounds(350, 140, 150, 25);
        frame.add(nameTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(280, 170, 100, 25);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(350, 170, 150, 25);
        frame.add(passwordField);

        JLabel contLabel = new JLabel("Tipo de conta:");
        contLabel.setBounds(262, 200, 210, 25);
        frame.add(contLabel);

        JTextField tipoTextField = new JTextField(20);
        tipoTextField.setBounds(350, 200, 150, 25);
        frame.add(tipoTextField);

        JButton createButton = new JButton("Criar conta");

        createButton.setBounds(350, 240, 140, 35);
        createButton.setFocusPainted(false);
        createButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createButton.setBorder(null);
        createButton.setForeground(new Color(255, 255, 255));
        createButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        createButton.setBackground(new Color(0, 156, 223));
        frame.add(createButton);

        createButton.addActionListener(e -> {
            Nome = nameTextField.getText();
            Senha = new String(passwordField.getPassword());
            ContaDiferente = tipoTextField.getText();

            if (ContaDiferente.equalsIgnoreCase("EMPRESA")) {
                CompanyUser userNewE = new CompanyUser(Nome, Email, Senha, ContaDiferente);
                usersList.put(Nome, Senha);
                frame.dispose();
                userNewE.HomeUser();
            } else if (ContaDiferente.equalsIgnoreCase("PESSOAL")) {
                PersonUser userNewP = new PersonUser(Nome, Email, Senha, ContaDiferente);
                usersList.put(Nome, Senha);
                frame.dispose();
                userNewP.HomeUser();
            }
        });

        frame.setVisible(true);
    }

    public void HomeUser() {
        JFrame frame = new JFrame("Bem-Vindo ao LIFEinvader " + getNome());
        frame.setBounds(100, 100, 800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(
                Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));

        JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel);

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
        }
    }

    public static void DeleteUser(String nome) {
        int choise = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este perfil", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (choise == JOptionPane.YES_OPTION) {
            if (usersList.containsKey(nome)) {
                usersList.remove(nome);
            }
            JOptionPane.showMessageDialog(null, "O usuário " + nome + " foi removido com sucesso");
            System.exit(0);
        }
    }

    public static void ListUser() {
        JFrame frame = new JFrame("Lista de Usuários");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(
                Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));

        DefaultListModel<String> userListModel = new DefaultListModel<>();
        JList<String> userList = new JList<>(userListModel);

        for (String name : usersList.keySet()) {
            userListModel.addElement(name);
        }

        JScrollPane scrollPane = new JScrollPane(userList);
        frame.add(scrollPane);

        frame.setPreferredSize(new Dimension(300, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void UserLogin() {
        JFrame frame = new JFrame();
        frame.setTitle("Login");
        frame.setBounds(100, 100, 800, 500);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(
                Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));

        JLabel usernameLabel = new JLabel("UserName");
        usernameLabel.setBounds(280, 140, 100, 25);
        frame.add(usernameLabel);

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(350, 140, 150, 25);
        frame.add(usernameField);

        JLabel passwordJLabel = new JLabel("Password");
        passwordJLabel.setBounds(280, 170, 100, 25);
        frame.add(passwordJLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(350, 170, 150, 25);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(350, 200, 150, 30);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBorder(null);
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        loginButton.setBackground(new Color(0, 156, 223));
        frame.add(loginButton);

        loginButton.addActionListener(e -> {
            Nome = usernameField.getText();
            Senha = new String(passwordField.getPassword());
            AuthUser();
            frame.dispose();
        });

        frame.setVisible(true);
    }

    public void AuthUser() {
        boolean auth = false;
        do {
            if (usersList.containsKey(Nome) && usersList.get(Nome).equals(Senha)) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                auth = true;
                if ("EMPRESA".equals(ContaDiferente)) {
                    CompanyUser userNewE = new CompanyUser(Nome, Senha, Email, ContaDiferente);
                    userNewE.HomeUser();
                } else if ("PESSOAL".equals(ContaDiferente)) {
                    PersonUser userNewP = new PersonUser(Nome, Senha, Email, ContaDiferente);
                    userNewP.HomeUser();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dados inválidos!");
                UserLogin();
                return;
            }
        } while (!auth);

    }

    public static HashMap<String, ArrayList<String>> friendList = new HashMap<>();

    public void addFriend() {
        JFrame frame = new JFrame("Adicionar Amigo");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setResizable(false);
        frame.setIconImage(
                Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));

        JComboBox<String> userListComboBox = new JComboBox<>();
        JButton addButton = new JButton("Adicionar Amigo");
        addButton.setPreferredSize(new Dimension(150, 30));
        addButton.setFocusPainted(false);
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addButton.setBorder(null);
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        addButton.setBackground(new Color(0, 156, 223));

        for (String name : usersList.keySet()) {
            if (!name.equals(Nome) && !areFriends(name)) {
                userListComboBox.addItem(name);
            }
        }

        userListComboBox.setPreferredSize(new Dimension(200, 30));

        frame.add(userListComboBox);
        frame.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String friendName = (String) userListComboBox.getSelectedItem();
                if (friendName != null && usersList.containsKey(friendName)) {
                    if (!friendList.containsKey(Nome)) {
                        friendList.put(Nome, new ArrayList<>());
                    }
                    friendList.get(Nome).add(friendName);
                    numeroAmigos = numeroAmigos + 1;
                    JOptionPane.showMessageDialog(null, Nome + " e " + friendName + " agora são FRIENDS");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO: não foi possível adicionar a amizade.");
                    frame.dispose();
                }
                HomeUser();
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void ListFriends() {
        JFrame frame = new JFrame("Lista de Amigos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(
                Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));

        JTextArea friendTextArea = new JTextArea(10, 20);
        friendTextArea.setEditable(false);

        if (friendList.containsKey(Nome)) {
            friendTextArea.append("Sua lista de amigos, " + Nome + ":\n");
            ArrayList<String> friends = friendList.get(Nome);
            for (String friend : friends) {
                friendTextArea.append(friend + "\n");
                frame.dispose();
            }
            frame.dispose();
        } else {
            friendTextArea.append("Você não possui amigos");
            frame.dispose();
        }

        JScrollPane scrollPane = new JScrollPane(friendTextArea);

        frame.add(scrollPane);
        frame.setPreferredSize(new Dimension(300, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public boolean areFriends(String friendName) {
        if (friendList.containsKey(Nome)) {
            ArrayList<String> friends = friendList.get(Nome);
            return friends.contains(friendName);
        }
        return false;
    }

    public void removeFriend() {
        if (friendList.containsKey(Nome)) {
            ArrayList<String> friends = friendList.get(Nome);

            JFrame frame = new JFrame("Remover Amigo");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setBounds(100, 100, 500, 300);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);
            frame.setIconImage(
                    Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));

            JLabel label = new JLabel("Sua lista de amigos, " + Nome + ":");
            label.setBounds(5, 10, 200, 25);
            frame.add(label);

            JList<String> friendListGUI = new JList<>(friends.toArray(new String[0]));
            friendListGUI.setBounds(170, 35, 140, 100);
            frame.add(friendListGUI);

            JLabel removeLabel = new JLabel("Digite o nome do amigo que deseja remover: ");
            removeLabel.setBounds(5, 150, 260, 25);
            frame.add(removeLabel);

            JTextField friendToRemoveField = new JTextField(20);
            friendToRemoveField.setBounds(260, 150, 190, 25);
            frame.add(friendToRemoveField);

            JButton removeButton = new JButton("Remover Amigo");
            removeButton.setBounds(170, 190, 148, 40);
            removeButton.setFocusPainted(false);
            removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            removeButton.setBorder(null);
            removeButton.setForeground(new Color(255, 255, 255));
            removeButton.setFont(new Font("Tahoma", Font.BOLD, 17));
            removeButton.setBackground(new Color(0, 156, 223));
            frame.add(removeButton);

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String friendName = friendToRemoveField.getText();
                    if (friends.contains(friendName)) {
                        friends.remove(friendName);
                        JOptionPane.showMessageDialog(frame, Nome + " e " + friendName + " não são mais amigos!");
                        numeroAmigos = numeroAmigos - 1;
                        frame.dispose();
                        HomeUser();
                    } else {
                        JOptionPane.showMessageDialog(frame, Nome + " não era amigo de " + friendName + ".");
                        HomeUser();
                    }
                }
            });

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem amigos ainda. Adicione amigos antes de listar.");
            HomeUser();
        }
    }

    public void updateUserData(String nome) {
        JFrame frame = new JFrame("Atualizar dados de usuário");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100, 100, 400, 200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(
                Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));

        JLabel nameLabel = new JLabel("Novo UserName:");
        nameLabel.setBounds(70, 30, 100, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(170, 30, 150, 30);
        frame.add(nameField);

        JButton updateButton = new JButton("Atualizar Dados");
        updateButton.setBounds(120, 80, 150, 38);
        updateButton.setFocusPainted(false);
        updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateButton.setBorder(null);
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        updateButton.setBackground(new Color(0, 156, 223));
        frame.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novoNome = nameField.getText();

                if (usersList.containsKey(nome)) {
                    if (!novoNome.isEmpty()) {
                        setNome(novoNome);
                    }

                    usersList.get(nome);
                    usersList.get(Senha);
                    usersList.remove(nome);
                    usersList.remove(Senha);
                    usersList.put(novoNome, Senha);

                }

                frame.dispose();
                HomeUser();

            }
        });

        frame.setVisible(true);

    }

}
