package com.javalec.purchase;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class Purchasedetail extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable innertable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Purchasedetail dialog = new Purchasedetail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Purchasedetail() {
		setTitle("구매내역");
		setBounds(100, 100, 400, 760);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(42, 49, 311, 152);
			getContentPane().add(scrollPane);
			{
				innertable = new JTable();
				scrollPane.setViewportView(innertable);
			}
		}
	}

}
