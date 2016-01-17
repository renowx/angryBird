package ihm;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help {

	public Help(JFrame f, Dimension frameSize) {
		
		f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		
		JButton back = new JButton();
		back.setName("Back");
		back.setBounds(540, 650, 160, 60);
		back.setIcon(new ImageIcon(Menu.imgPath+"ButtonBG.png"));
		back.addMouseListener(Menu.buttonBGlistener);
		back.setContentAreaFilled(false);
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.setContentPane(Menu.p);
			}
		});
		p.add(back);
		
		JLabel backArrow = new JLabel();
		backArrow.setIcon(new ImageIcon(Menu.imgPath+"returnIcon.png"));
		backArrow.setBounds(606, 654, 50, 50);
		p.add(backArrow);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon(Menu.imgPath+"menuBackground.png"));
		bg.setBounds(0, 0, frameSize.width, frameSize.height);
		p.add(bg);
		
		f.setContentPane(p);
		f.setVisible(true);
		
	}
	
}
