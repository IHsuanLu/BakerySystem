package User_InterfaceE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class fire extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fire frame = new fire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fire() {
		setTitle("Better Jade System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel Rlabel = new JLabel();
		Rlabel.setBounds(24, 72, 95, 80);
		Image Rimg = new ImageIcon(this.getClass().getResource("/Rjade.png")).getImage().getScaledInstance(95, 80, Image.SCALE_DEFAULT);
		Rlabel.setIcon(new ImageIcon(Rimg));
		getContentPane().add(Rlabel);
		
		JLabel Nlabel = new JLabel();
		Nlabel.setBounds(253, 72, 95, 80);
		Image Nimg = new ImageIcon(this.getClass().getResource("/necklace.jpg")).getImage().getScaledInstance(95, 80, Image.SCALE_DEFAULT);
		Nlabel.setIcon(new ImageIcon(Nimg));
		getContentPane().add(Nlabel);
		
		JLabel Blabel = new JLabel();
		Blabel.setBackground(Color.WHITE);
		Blabel.setBounds(24, 193, 95, 80);
		Image Bimg = new ImageIcon(this.getClass().getResource("/bracelet.jpg")).getImage().getScaledInstance(95, 80, Image.SCALE_DEFAULT);
		Blabel.setIcon(new ImageIcon(Bimg));
		getContentPane().add(Blabel);
		
		JLabel Elabel = new JLabel();
		Elabel.setBounds(253, 188, 95, 80);
		Image Eimg = new ImageIcon(this.getClass().getResource("/earrings.jpeg")).getImage().getScaledInstance(95, 80, Image.SCALE_DEFAULT);
		Elabel.setIcon(new ImageIcon(Eimg));
		getContentPane().add(Elabel);
	}

}
