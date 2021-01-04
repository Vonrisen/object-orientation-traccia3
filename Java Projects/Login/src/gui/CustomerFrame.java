package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import gui_support.RoundJRadioButton;
import gui_support.RoundJTextField;

public class CustomerFrame {

	public JFrame frame;
	private int mouseX=0;
	private int mouseY=0;
	private JTable table;
	private JScrollPane scrollPane1;
	public JTextField nameTF;
	private JTextField surnameTF;
	private JTextField birth_dateTF;
	private JTextField birth_placeTF;
	private JTextField addressTF;
	private JTextField emailTF;
	private JTextField passwordTF;
	private JTextField cellphoneTF;
	private ButtonGroup gender;
	
	/**
	 * Create the application.
	 */
	public CustomerFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon maximize_button = new ImageIcon("src\\images\\FrameIcons\\maximizeFrameButton.png");
		ImageIcon minimize_button = new ImageIcon("src\\images\\FrameIcons\\minimizeFrameButton.png");
		ImageIcon close_button = new ImageIcon("src\\images\\FrameIcons\\closeFrameButton.png");
		ImageIcon iconifier_button = new ImageIcon("src\\images\\FrameIcons\\iconifierFrameButton.png");
		ImageIcon logoIcon = new ImageIcon("src\\images\\FrameIcons\\logoIcon.png");
		ImageIcon customers_table_title = new ImageIcon("src\\images\\tableTitles\\customers.png");
		ImageIcon delete_button_inactive = new ImageIcon("src\\images\\SqlButtons\\deleteButtonInactive.png");
		ImageIcon delete_button_active = new ImageIcon("src\\images\\SqlButtons\\deleteButtonActive.png");
		ImageIcon insert_button_inactive = new ImageIcon("src\\images\\SqlButtons\\insertButtonInactive.png");
		ImageIcon insert_button_active = new ImageIcon("src\\images\\SqlButtons\\insertButtonActive.png");
		ImageIcon update_button_inactive = new ImageIcon("src\\images\\SqlButtons\\updateButtonInactive.png");
		ImageIcon update_button_active = new ImageIcon("src\\images\\SqlButtons\\updateButtonActive.png");
		ImageIcon turn_back_inactive = new ImageIcon("src\\images\\AdminFrame\\turnBackInactive.png");
		ImageIcon turn_back_active = new ImageIcon("src\\images\\AdminFrame\\turnBackActive.png");
		
		frame = new JFrame();
		frame.setSize(1600,900);
		int central_width = dim.width/2-frame.getSize().width/2;
		int central_height = dim.height/2-frame.getSize().height/2;
		frame.setLocation(central_width, central_height); //Setta il frame a centro monitor
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
		topPanel.setPreferredSize(new Dimension(100,35));
		topPanel.setBackground(new Color(0x771007));
		topPanel.setVisible(true);
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);	
		
		JLabel iconifierFrameButton = new JLabel();
		iconifierFrameButton.setIcon(iconifier_button);
		
		JLabel resizeFrameButton = new JLabel();
		resizeFrameButton.setIcon(maximize_button);
		
		JLabel closeFrameButton = new JLabel();
		closeFrameButton.setIcon(close_button);
		
		JLabel logoFrameButton = new JLabel("<html><font face='Calibri' size='4' color=rgb(243,236,215)>FOOD OVERFLOW:</font> <font face='Calibri' size='4' color=rgb(244,153,105)>ADMIN PANEL (CUSTOMER)</font></html>");
		logoFrameButton.setForeground(new Color(0xf3ecd7));;
		logoFrameButton.setIcon(logoIcon);
		topPanel.add(logoFrameButton);
		topPanel.add(Box.createHorizontalGlue());
		topPanel.add(iconifierFrameButton);
		topPanel.add(resizeFrameButton);
		topPanel.add(closeFrameButton);
		
		JPanel rider_panel = new JPanel();
		rider_panel.setLayout(null);
		rider_panel.setBackground(new Color(0xf3ecd7));
		frame.getContentPane().add(rider_panel, BorderLayout.CENTER);
		
		scrollPane1 = new JScrollPane();
		rider_panel.add(scrollPane1);
		scrollPane1.setBounds(90, 132, 850, 600);
	    table = new JTable();
		scrollPane1.setViewportView(table);
		table.setFocusable(false);
		table.setEnabled(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(Color.black);
		table.getTableHeader().setForeground(Color.yellow);
		table.setBackground(Color.blue);
		table.setFont(new Font("", 1, 10));
		table.setForeground(Color.white);
		
		JButton insert_sql_button = new JButton();
		insert_sql_button.setIcon(insert_button_inactive);
		insert_sql_button.setBounds(1000, 600, 150,30);
		insert_sql_button.setBorder(null);
		insert_sql_button.setFocusable(false);
		insert_sql_button.setContentAreaFilled(false);
		rider_panel.add(insert_sql_button);
		
		JButton update_sql_button = new JButton();
		update_sql_button.setIcon(update_button_inactive);
		update_sql_button.setBounds(1200, 600, 150,30);
		update_sql_button.setBorder(null);
		update_sql_button.setFocusable(false);
		update_sql_button.setContentAreaFilled(false);
		rider_panel.add(update_sql_button);
		
		JButton delete_sql_button = new JButton();
		delete_sql_button.setIcon(delete_button_inactive);
		delete_sql_button.setBounds(1000, 660, 150,30);
		delete_sql_button.setBorder(null);
		delete_sql_button.setFocusable(false);
		delete_sql_button.setContentAreaFilled(false);
		rider_panel.add(delete_sql_button);
		
		JLabel customers_tableT = new JLabel();
		customers_tableT.setIcon(customers_table_title);
		customers_tableT.setBounds(90, 20, 250,100);
		rider_panel.add(customers_tableT);

		JLabel nameLB = new JLabel("Name");
		nameLB.setBounds(1000, 132, 100, 14);
		rider_panel.add(nameLB);
		
		JLabel surnameLB = new JLabel("Surname");
		surnameLB.setBounds(1200, 132, 100, 14);
		rider_panel.add(surnameLB);
		
		JLabel birth_dateLB = new JLabel("Birth Date");
		birth_dateLB.setBounds(1000, 188, 100, 14);
		rider_panel.add(birth_dateLB);
		
		JLabel birth_placeLB = new JLabel("Birth Place");
		birth_placeLB.setBounds(1200, 188, 100, 14);
		rider_panel.add(birth_placeLB);
		
		JLabel addressLB = new JLabel("Address");
		addressLB.setBounds(1000, 249, 100, 14);
		rider_panel.add(addressLB);
		
		JLabel genderLB = new JLabel("Gender");
		genderLB.setBounds(1000, 310, 100, 14);
		rider_panel.add(genderLB);
		
		JLabel cellphoneLB = new JLabel("Cellphone");
		cellphoneLB.setBounds(1200, 310, 100, 14);
		rider_panel.add(cellphoneLB);
		
		JLabel emailLB = new JLabel("E-mail");
		emailLB.setBounds(1000, 465, 100, 14);
		rider_panel.add(emailLB);
		
		JLabel passwordLB = new JLabel("Password");
		passwordLB.setBounds(1200, 465, 100, 14);
		rider_panel.add(passwordLB);
		
		nameTF = new RoundJTextField(new Color(0x771007));
		nameTF.setBounds(1000, 152, 150, 25);
		rider_panel.add(nameTF);
		
		surnameTF = new RoundJTextField(new Color(0x771007));
		surnameTF.setBounds(1200, 152, 150, 25);
		rider_panel.add(surnameTF);
		
		birth_dateTF = new RoundJTextField(new Color(0x771007));
		birth_dateTF.setBounds(1000, 213, 150, 25);
		rider_panel.add(birth_dateTF);
		
		birth_placeTF = new RoundJTextField(new Color(0x771007));
		birth_placeTF.setBounds(1200, 213, 150, 25);
		rider_panel.add(birth_placeTF);
		
		addressTF = new RoundJTextField(new Color(0x771007));
		addressTF.setBounds(1000, 274, 350, 25);
		rider_panel.add(addressTF);
		
		gender = new ButtonGroup();
		JRadioButton genderM = new JRadioButton();
		genderM.setText("Maschio");
		genderM.setBounds(1005, 335, 75, 25);
		genderM.setBorder(new LineBorder(null,5));
		genderM.setContentAreaFilled(false);
		genderM.setFocusable(false);
		JRadioButton genderF = new JRadioButton();
		genderF.setText("Femmina");
		genderF.setBounds(1080, 335, 80, 25);
		genderF.setBorder(new LineBorder(null,5));
		genderF.setContentAreaFilled(false);
		genderF.setFocusable(false);
		rider_panel.add(genderM);
		rider_panel.add(genderF);
		gender.add(genderM);
		gender.add(genderF);
		
		JLabel genderBox = new RoundJRadioButton(new Color(0x771007));
		genderBox.setBounds(1000, 335, 165, 25);
		rider_panel.add(genderBox);
		
		cellphoneTF = new RoundJTextField(new Color(0x771007));
		cellphoneTF.setBounds(1200, 335, 150, 25);
		rider_panel.add(cellphoneTF);
		
		emailTF = new RoundJTextField(new Color(0x771007));
		emailTF.setBounds(1000, 490, 150, 25);
		rider_panel.add(emailTF);
		
		passwordTF = new RoundJTextField(new Color(0x771007));
		passwordTF.setBounds(1200, 490, 150, 25);
		rider_panel.add(passwordTF);
		
		JButton turn_back = new JButton();
		turn_back.setBounds(90, 770, 50, 50);
		turn_back.setIcon(turn_back_inactive);
		turn_back.setBorder(null);
		turn_back.setFocusable(false);
		turn_back.setContentAreaFilled(false);
		rider_panel.add(turn_back);
		
		turn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				//Si torna ad adminFrame
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				turn_back.setIcon(turn_back_active);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				turn_back.setIcon(turn_back_inactive);
				
			}
		});
		
		insert_sql_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				insert_sql_button.setIcon(insert_button_active);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				insert_sql_button.setIcon(insert_button_inactive);
				
			}
			
		});
		
		update_sql_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				update_sql_button.setIcon(update_button_active);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				update_sql_button.setIcon(update_button_inactive);
				
			}
		});
		
		delete_sql_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				delete_sql_button.setIcon(delete_button_active);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				delete_sql_button.setIcon(delete_button_inactive);
				
			}
		});
		
		topPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				frame.setLocation (frame.getX()+e.getX()-mouseX,frame.getY()+e.getY()-mouseY);
				
			}
		});
		topPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				mouseX = e.getX();
				mouseY = e.getY();
				
				}
		});
		
		closeFrameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0); // Da rivedere la chiusura del frame
				
			}
		});
		
		resizeFrameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(frame.getSize().equals(new Dimension(1600,900))) {
					
					resizeFrameButton.setIcon(minimize_button);
					frame.setLocation(central_width, central_height);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
					scrollPane1.setBounds(dim.width/2-600, 230, 1200, 700);
					customers_tableT.setBounds(dim.width/2-600, 80, 250,100);
					turn_back.setBounds(25, dim.height-100, 50, 50);
					
					nameLB.setBounds(dim.width/2-300, 50, 100, 14);
					nameTF.setBounds(dim.width/2-300, 70, 150, 25);
					surnameLB.setBounds(dim.width/2-100, 50, 100, 14);
					surnameTF.setBounds(dim.width/2-100, 70, 150, 25);
					birth_dateLB.setBounds(dim.width/2+100, 50, 100, 14);
					birth_dateTF.setBounds(dim.width/2+100, 70, 150, 25);
					birth_placeLB.setBounds(dim.width/2+100, 100, 100, 14);
					birth_placeTF.setBounds(dim.width/2+100, 120, 150, 25);
					addressLB.setBounds(dim.width/2-300, 100, 100, 14);
					addressTF.setBounds(dim.width/2-300, 120, 170, 25);
					genderLB.setBounds(dim.width/2-100, 100, 100, 14);
					genderM.setBounds(dim.width/2-98, 120, 100, 25);
					genderF.setBounds(dim.width/2-28, 120, 100, 25);
					genderBox.setBounds(dim.width/2-100, 120, 150, 25);
					cellphoneLB.setBounds(dim.width/2-300, 150, 100, 14);
					cellphoneTF.setBounds(dim.width/2-300, 170, 150, 25);
					emailLB.setBounds(dim.width/2-100, 150, 100, 14);
					emailTF.setBounds(dim.width/2-100, 170, 150, 25);
					passwordLB.setBounds(dim.width/2+100, 150, 100, 14);
					passwordTF.setBounds(dim.width/2+100, 170, 150, 25);
					
					insert_sql_button.setBounds(dim.width/2+450, 67, 150,30);
					update_sql_button.setBounds(dim.width/2+450, 117, 150,30);
					delete_sql_button.setBounds(dim.width/2+450, 167, 150,30);
					
				} else if(frame.getSize().equals(dim)) {
					
					resizeFrameButton.setIcon(maximize_button);
					frame.setSize(1600,900);
					frame.setLocation(central_width, central_height);
					
					scrollPane1.setBounds(90, 132, 850, 600);
					customers_tableT.setBounds(90, 20, 250,100);
					turn_back.setBounds(90, 770, 50, 50);
					
					nameLB.setBounds(1000, 132, 100, 14);
					surnameLB.setBounds(1200, 132, 100, 14);
					birth_dateLB.setBounds(1000, 188, 100, 14);
					birth_placeLB.setBounds(1200, 188, 100, 14);
					addressLB.setBounds(1000, 249, 100, 14);
					genderLB.setBounds(1000, 310, 100, 14);
					cellphoneLB.setBounds(1200, 310, 100, 14);
					nameTF.setBounds(1000, 152, 150, 25);
					surnameTF.setBounds(1200, 152, 150, 25);
					birth_dateTF.setBounds(1000, 213, 150, 25);
					birth_placeTF.setBounds(1200, 213, 150, 25);
					addressTF.setBounds(1000, 274, 350, 25);
					genderM.setBounds(1005, 335, 75, 25);
					genderF.setBounds(1080, 335, 80, 25);
					genderBox.setBounds(1000, 335, 165, 25);
					cellphoneTF.setBounds(1200, 335, 150, 25);
					emailLB.setBounds(1000, 465, 100, 14);
					passwordLB.setBounds(1200, 465, 100, 14);
					emailTF.setBounds(1000, 490, 150, 25);
					passwordTF.setBounds(1200, 490, 150, 25);
					
					insert_sql_button.setBounds(1000, 600, 150,30);
					update_sql_button.setBounds(1200, 600, 150,30);
					delete_sql_button.setBounds(1000, 660, 150,30);
					
				}
				
			}
		});
		
		iconifierFrameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.setState(Frame.ICONIFIED);
				
			}
		});
	}

}
