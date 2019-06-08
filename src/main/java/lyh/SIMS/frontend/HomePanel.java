package lyh.SIMS.frontend;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	ImageIcon icon;
	Image img;
	public HomePanel() {
		icon=new ImageIcon("C:\\Users\\l4728\\git\\SIMS\\src\\main\\java\\lyh\\SIMS\\frontend\\yazi.jpg");
		img=icon.getImage();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
	}

}