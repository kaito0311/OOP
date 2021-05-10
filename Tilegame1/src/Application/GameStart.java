package Application;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
// Copy tu Gam Start cua Tuyen
public class GameStart extends JFrame implements ActionListener{
	public static float MAX_WIDTH = 800;
	public static float MAX_HEIGHT = 640;
    private ImageIcon startGameBackground;
    private JPanel panel;
    private JButton newGame;
    private JButton setting;
    private JButton aboutUs;
    public String game_mode;
//    cài đặt chế độ chơi
    
    public GameStart() {
    	
        startGameBackground = new ImageIcon("src/Assets/start_game.png");
        setSize(851,470);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        panel = new JPanel() {
            
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
        newGame = new JButton("Start Game");
        add(newGame);
       
        newGame.setSize(120, 35);
        newGame.setLocation(350, 310);
        newGame.addActionListener(this);
        
        setting = new JButton("Setting");
        setting.setSize(120,35);
        setting.setLocation(350, 350);
        setting.addActionListener(this);
        
        setting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog j =new JDialog();
				String[] options = {"Easy","Hard"};
				JComboBox comboBox = new JComboBox(options);
				comboBox.setBounds(0, 0, 90, 20);
				j.add(comboBox);
				comboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						game_mode  = comboBox.getItemAt(comboBox.getSelectedIndex()).toString();
						System.out.println(game_mode);
						j.setVisible(false);
					}
				});
				
				j.setTitle("Setting");
				j.setSize(100,80);
				j.setLocation(690, 350);
				j.setVisible(true);
				
			}
		});
        add(setting);
              
        aboutUs = new JButton("About Us");
        add(aboutUs);

        aboutUs.setSize(120,35);
        aboutUs.setLocation(350, 390);
        aboutUs.addActionListener(this);    
    }
    
   
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
// End