package Application;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameStart extends JFrame implements ActionListener{
	public static float MAX_WIDTH = 800;
	public static float MAX_HEIGHT = 640;
    private ImageIcon startGameBackground;
    private JPanel panel;
    private JButton newGame;
    private JButton gamePlay;
    private JButton aboutUs;
    
    public GameStart() {
    	
        startGameBackground = new ImageIcon("src/assets/Start.jpg");

        setSize(640,512);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (startGameBackground != null) {
                    g.drawImage(startGameBackground.getImage(), 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        setContentPane(panel);

        this.setLayout(null);
        setControl();
    }
    
    public void setControl(){
        newGame = new JButton("NEW GAME");
        add(newGame);
       
        newGame.setSize(100, 50);
        newGame.setLocation(350, 200);
        newGame.addActionListener(this);
        
              
        aboutUs = new JButton("ABOUT US");
        add(aboutUs);

        aboutUs.setSize(100,50);
        aboutUs.setLocation(350, 250);
        aboutUs.addActionListener(this);    
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        JButton btn =(JButton) e.getSource();
        
        if (btn == newGame){
            this.dispose();
            Game game = new Game("Game", (int)MAX_WIDTH, (int)MAX_HEIGHT);
            game.start();
        }
        
        
        if (btn == aboutUs){
            JOptionPane.showMessageDialog(null, "Nhom xx: "
                    + "\n- Dinh Tan Minh"
                    + "\n- Tran Doan Hiep"
                    + "\n- Nguyen Van Linh"
                    + "\n- Duong Van Tuyen"
                    + "\n- Dao Minh Tien"
                    + "\n GVHD:", "Information of us", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}