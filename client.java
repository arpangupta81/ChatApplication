package chattingapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;

import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class client extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf2;
	private static JTextArea ta2;
	static Socket s;
	    static  DataInputStream din;
	     static  DataOutputStream dout;
	     private JLabel lblTypeYourMessage;
	     private JSeparator separator_1;
	   
	/**
	 * Launch the application.
	 */
	     
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client frame = new client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		String magin="";
		try
		{
			s=new Socket("127.0.0.1",100);
			din=new DataInputStream(s.getInputStream());
			dout =new DataOutputStream(s.getOutputStream());
			
			while(!magin.equals("exit"))
			{
				magin=din.readUTF(); 
				ta2.setText(ta2.getText().trim()+"\nSERVER:  "+magin);
			}
			
		}
		catch(Exception e)
		{
		
		}
	}

	/**
	 * Create the frame.
	 */
	public client() {
		setTitle("CLIENT");
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Arpan\\Java\\chattingapp\\user_clients_01.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 13, 337, 147);
		contentPane.add(scrollPane);
		
		ta2 = new JTextArea();
		ta2.setEditable(false);
		scrollPane.setViewportView(ta2);
		ta2.setBackground(new Color(51, 255, 255));
		
		tf2 = new JTextField();
		tf2.setBounds(27, 215, 277, 25);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JButton b2 = new JButton("SEND");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				try
				{
					String magout="";
			magout=tf2.getText().trim();
			ta2.setText(ta2.getText().trim()+"\nME:  "+magout);
				dout.writeUTF(magout);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Game Over", "NO SERVER FOUND", JOptionPane.YES_NO_OPTION);
				//e.printStackTrace();
			}
			}
		});
		b2.setBounds(323, 215, 97, 25);
		contentPane.add(b2);
		
		lblTypeYourMessage = new JLabel("TYPE YOUR MESSAGE HERE:");
		lblTypeYourMessage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTypeYourMessage.setBounds(37, 185, 222, 16);
		contentPane.add(lblTypeYourMessage);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(12, 0, 2, 253);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(12, 173, 420, 4);
		contentPane.add(separator_1);
	}
}
