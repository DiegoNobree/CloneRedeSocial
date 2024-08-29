import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    public static void main(String[] args) {
    	
        JFrame frame = new JFrame();
        frame.setTitle("LIFEinvader");
        frame.setBounds(100, 100, 800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/img/lifeinvader_logo.png")));   
        
        JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 800, 500);
		panel.setLayout(null);
        frame.add(panel);
        
		JLabel namelogo = new JLabel("LIFEINVADER");
		namelogo.setForeground(new Color(255, 255, 255));
		namelogo.setFont(new Font("Arial", Font.BOLD, 18));
		namelogo.setHorizontalAlignment(SwingConstants.CENTER);
		namelogo.setBounds(488, 245, 296, 20);
		panel.add(namelogo);
        
        JLabel imglogo = new JLabel("");
        imglogo.setHorizontalAlignment(SwingConstants.CENTER);
        imglogo.setIcon(new ImageIcon(MainApp.class.getResource("/img/logo.png")));
        imglogo.setBounds(550, 90, 168, 168);
        panel.add(imglogo);
		
		JLabel imgciyt = new JLabel("");
		imgciyt.setIcon(new ImageIcon(MainApp.class.getResource("/img/city.png")));
		imgciyt.setBounds(488, 0, 296, 461);
		panel.add(imgciyt);
		
		
        JButton createUserButton = new JButton("Criar Usuário");
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        User U1 = new User();
                        U1.CreateUser();
                        frame.dispose();
                    }
                });
            }
        });
        createUserButton.setFocusPainted(false);
        createUserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createUserButton.setBorder(null);
        createUserButton.setForeground(new Color(255, 255, 255));
        createUserButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        createUserButton.setBackground(new Color(0, 156, 223));
        createUserButton.setBounds(98, 224, 140, 48);
        panel.add(createUserButton);


        JButton homeUserButton = new JButton("Login de usuário");
        homeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User currentUser = new User();
                frame.dispose();
                currentUser.UserLogin();
            }
        });
        homeUserButton.setFocusPainted(false);
        homeUserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        homeUserButton.setBorder(null);
        homeUserButton.setForeground(new Color(255, 255, 255));
        homeUserButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        homeUserButton.setBackground(new Color(0, 156, 223));
        homeUserButton.setBounds(248, 224, 160, 48);
        panel.add(homeUserButton);

        frame.setVisible(true);
    }
}
