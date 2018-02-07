package chattingapp;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class server extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tf1;
	private static  JTextArea ta1;
	/**
	 * Launch the application.
	 */
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout ;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JSeparator separator_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server frame = new server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		String magin="";
		try 
		{
		ss= new ServerSocket(100);
		s=ss.accept();
		din=new DataInputStream(s.getInputStream());
		dout=new DataOutputStream(s.getOutputStream());
		while(!magin.equals("exit"))
		{
			magin=din.readUTF();
		ta1.setText(ta1.getText().trim()+"\nCLIENT:  "+magin);
		}
		}catch(Exception e)
		{
			
		}
	}

	/**
	 * Create the frame.
	 */
	public server() {
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Arpan\\Java\\chattingapp\\server.png"));
		setTitle("SERVER");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 13, 337, 147);
		contentPane.add(scrollPane);
		
		ta1 = new JTextArea();
		ta1.setEditable(false);
		scrollPane.setViewportView(ta1);
		ta1.setBackground(new Color(102, 255, 255));
		
		tf1 = new JTextField();
		tf1.setBounds(27, 215, 277, 25);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JButton b1 = new JButton("SEND");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try{
				String magout="";
				magout=tf1.getText().trim();
				ta1.setText(ta1.getText().trim()+"\nME:  "+magout);
					dout.writeUTF(magout);
				} catch (IOException e) {
					// TODO Auto-generated catch block
				
					e.printStackTrace();
				}
			}
		});
		b1.setBounds(323, 215, 97, 25);
		contentPane.add(b1);
		
		JLabel lblTypeYourMessage = new JLabel("TYPE YOUR MESSAGE HERE :");
		lblTypeYourMessage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTypeYourMessage.setBounds(37, 185, 222, 16);
		contentPane.add(lblTypeYourMessage);
		
		separator = new JSeparator();
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
