package Inventory_StatusE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class P_Advice extends JFrame implements Constants {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_Advice frame = new P_Advice();
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
	public P_Advice() {
		setTitle("Lee-Hu Pastry");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSystemSuggestion = new JLabel("System Suggestion");
		Image Logoimg = new ImageIcon(this.getClass().getResource("/info.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		lblSystemSuggestion.setIcon(new ImageIcon(Logoimg));
		lblSystemSuggestion.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSystemSuggestion.setForeground(new Color(255, 255, 255));
		lblSystemSuggestion.setBounds(6, 6, 220, 30);
		contentPane.add(lblSystemSuggestion);
		
		JLabel label = new JLabel("使用模型：單週期訂購模型");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label.setBounds(24, 48, 194, 20);
		contentPane.add(label);
		
		JLabel lblcs = new JLabel("短缺成本 (Cs)：");
		lblcs.setForeground(Color.WHITE);
		lblcs.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblcs.setBounds(52, 77, 114, 20);
		contentPane.add(lblcs);
		
		JLabel lblce = new JLabel("超額成本 (Ce)：");
		lblce.setForeground(Color.WHITE);
		lblce.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblce.setBounds(52, 101, 125, 20);
		contentPane.add(lblce);
		
		textField = new JTextField();
		textField.setText(String.valueOf(pCs));
		textField.setEditable(false);
		textField.setBounds(168, 75, 75, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(String.valueOf(pCe));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(168, 99, 75, 26);
		contentPane.add(textField_1);
		
		JLabel lblserviceLevel = new JLabel("服務水準  (Service Level)：");
		lblserviceLevel.setForeground(Color.WHITE);
		lblserviceLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblserviceLevel.setBounds(52, 125, 207, 20);
		contentPane.add(lblserviceLevel);
		
		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(pService));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(257, 123, 150, 26);
		contentPane.add(textField_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 157, 399, 6);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("鳳梨餡 - 單期需求 (7天 /期)");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		label_1.setBounds(24, 175, 252, 20);
		contentPane.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 207, 399, 120);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		PTableModel model = new PTableModel();
		table.setModel(model);
		table.setCellSelectionEnabled(false);
		
		JButton button = new JButton("關閉");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(348, 347, 75, 29);
		contentPane.add(button);
		
	}
}
