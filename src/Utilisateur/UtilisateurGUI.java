package Utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;

import java.awt.Color;

import javax.swing.border.LineBorder;

import jade.gui.GuiEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import DAO.Information;

import javax.swing.table.DefaultTableModel;

public class UtilisateurGUI extends JFrame
{
	private JPanel contentPane;
	private UtilisateurAgent utilisateurAgent;

	private JTextArea textArea;
	private JScrollPane scrollPane;

	private final ButtonGroup carType = new ButtonGroup();
	private JPanel panel;
	private JTextField depart;
	private JTextField arrivee;
	private JTextField date;
	private JTable table;
	private Image backgroundImage;
	
	public UtilisateurAgent getUtilisateurAgent() {
		return utilisateurAgent;
	}

	public void setUtilisateurAgent(UtilisateurAgent utilisateurAgent) {
		this.utilisateurAgent = utilisateurAgent;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UtilisateurGUI frame = new UtilisateurGUI();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 */
	public UtilisateurGUI(){
		setTitle("Chercher les Vols disponibles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 800);
		contentPane = new JPanel();//new JPanel();
		contentPane.setBackground(new Color(53,81,92));
		contentPane.setBorder(new LineBorder(SystemColor.inactiveCaption, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnvoyer = new JButton("Chercher");
		btnEnvoyer.setForeground(new Color(0,0,0));
		btnEnvoyer.setBackground(new Color(201,233,246));
		btnEnvoyer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String Depart = depart.getText();
				String Arrivee = arrivee.getText();
				String Date = date.getText();
				GuiEvent ev = new GuiEvent(this,1);
				ev.addParameter(Depart);
				ev.addParameter(Arrivee);
				ev.addParameter(Date);
				System.out.println("ev : "+ev);
				utilisateurAgent.onGuiEvent(ev);
			}
		});
		btnEnvoyer.setFont(new Font("Consolas", Font.BOLD, 15));
		btnEnvoyer.setBounds(348, 652, 158, 32);
		contentPane.add(btnEnvoyer);
		
		JButton btnViderLaListe = new JButton("Effacer");
		btnViderLaListe.setContentAreaFilled(true);
		btnViderLaListe.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DefaultTableModel newmodel = new DefaultTableModel(new Object[] {"Depart", "Arrivee", "Date"},0);
				table.setModel(newmodel);
			}
		});
		btnViderLaListe.setForeground(new Color(0,0,0));
		btnViderLaListe.setFont(new Font("Consolas", Font.BOLD, 15));
		btnViderLaListe.setBounds(586, 652, 158, 32);
		btnViderLaListe.setBackground(new Color(201,233,246));
		contentPane.add(btnViderLaListe);
		
		JPanel UserChoicePanel = new JPanel();
		UserChoicePanel.setBounds(94, 33, 500, 300);
		UserChoicePanel.setBackground(new Color(201,233,246));
		UserChoicePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Vols", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(UserChoicePanel);
		UserChoicePanel.setLayout(null);
		
		depart = new JTextField();
		depart.setBounds(40, 44, 276, 30);
		UserChoicePanel.add(depart);
		depart.setColumns(10);

		
		JLabel InputLabel = new JLabel("Départ :");
		InputLabel.setFont(new Font("Consolas", Font.BOLD, 15));
		InputLabel.setBounds(40, 19, 280, 21);
		UserChoicePanel.add(InputLabel);


		arrivee = new JTextField();
		arrivee.setBounds(40, 113, 276, 30);
		UserChoicePanel.add(arrivee);
		arrivee.setColumns(10);


		JLabel InputLabel2 = new JLabel("Arrivée :");
		InputLabel2.setFont(new Font("Consolas", Font.BOLD, 15));
		InputLabel2.setBounds(40, 88, 280, 21);
		UserChoicePanel.add(InputLabel2);

		date = new JTextField();
		date.setBounds(40, 179, 276, 30);
		UserChoicePanel.add(date);
		date.setColumns(10);


		JLabel InputLabel3 = new JLabel("Date de départ :");
		InputLabel3.setFont(new Font("Consolas", Font.BOLD, 15));
		InputLabel3.setBounds(40, 154, 280, 21);
		UserChoicePanel.add(InputLabel3);






		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(94, 400, 500, 100);
		scrollPane_1.setOpaque(false);
		contentPane.add(scrollPane_1);




		table = new JTable();
		table.setOpaque(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Depart", "Arrivee", "Date"
			}
		));
		scrollPane_1.getViewport().add(table);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\LSI S4\\AID & SMA\\JadeTest\\src\\logo.png"));
		lblNewLabel.setBounds(600, 80, 1000, 265);
		contentPane.add(lblNewLabel);


		
		this.setVisible(true);

	}

	public void showMessage(Information info)
	{
		
		System.out.println("show message : "+ info.getDepart());
		
		DefaultTableModel oldmodel =( DefaultTableModel )table.getModel();
		
		oldmodel.addRow(new Object[] {info.getDepart() , info.getArrivee(), info.getDate()});
		
		table.setModel(oldmodel);

	}
	public void showMessage(String message)
	{
		List<Information> infos = Information.StringToList(message);
		
		System.out.println("show message : "+ infos);
		
		DefaultTableModel oldmodel =( DefaultTableModel )table.getModel();
		
		for (Information s : infos) {
			  Object[] o = new Object[3];
			  o[0] = s.getDepart();
			  o[1] = s.getArrivee();
			  o[2] = s.getDate();

			  oldmodel.addRow(o);
			}
		
		table.setModel(oldmodel);

	}

	String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = (AbstractButton) buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	public void showNotFound() {
		JOptionPane jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Aucun resultat n'est trouve", "Information", JOptionPane.INFORMATION_MESSAGE);
         
	}
}
