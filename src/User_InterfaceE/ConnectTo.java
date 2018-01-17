package User_InterfaceE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConnectTo extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectTo frame = new ConnectTo();
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
	public ConnectTo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 70);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("請輸入倉庫金鑰：");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(16, 16, 120, 16);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 12, 369, 26);
		contentPane.add(passwordField);
		
		JButton button = new JButton("確認");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = String.valueOf(passwordField.getPassword());
				
				String key = "393988939398893939889";
				
				if (password.equals(key)){
					
					dispose();
					SupplyHome s = new SupplyHome();
					s.main(null);
					
					JOptionPane.showMessageDialog(null, "歡迎 - 呂老闆。易軒 回來<3");
				} else {
					count = count + 1;
				}
				
				if (count == 1){
					JOptionPane.showMessageDialog(null, "密碼錯誤，尚有 2 次嘗試機會！");
				}
				
				if (count == 2){
					JOptionPane.showMessageDialog(null, "密碼錯誤，尚有 1 次嘗試機會！");
				}
				
				if (count == 3){
					JOptionPane.showMessageDialog(null, "系統於 3 秒後自動報警，電腦IP位址傳送中。。。");
					
					dispose();
				}

			}
		});
		button.setBounds(518, 12, 68, 29);
		contentPane.add(button);
	}
}
