package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel LabelLU;
	private JLabel LabelApellido;
	private JLabel LabelNombre;
	private JLabel LabelMail;
	private JLabel LabelURL;
	private JLabel LabelTiempo;
	private JTextField txtGithub;
	private JTextField txtMail;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtA;
	private JLabel imagen;
	private JButton BtnCopiar;
	
	private Font fuenteTexto;
	
	private Icon IconoClipboard;
	@SuppressWarnings("unused")
	private ImageIcon imagenPersonal;
	@SuppressWarnings("unused")
	private ImageIcon imagenPersonalBarbijo;
	

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 280));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		//Imagenes/Iconos
		IconoClipboard = new ImageIcon(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/ClipbIcon.png")));
		ImageIcon imagenPersonal = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()))).getImage().getScaledInstance(149,149,Image.SCALE_DEFAULT) );
		ImageIcon imagenPersonalBarbijo = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/ImageStudentB.png"))).getImage().getScaledInstance(149,149,Image.SCALE_DEFAULT) );
		
		
		//Fuente usada para el texto
		fuenteTexto = new Font("Tahoma", Font.BOLD, 11);
		
		//Creación etiquetas
		LabelLU = new JLabel("LU");
		LabelLU.setFont(fuenteTexto);
		LabelLU.setForeground(Color.DARK_GRAY);
		
		LabelApellido = new JLabel("Apellido");
		LabelApellido.setForeground(Color.DARK_GRAY);
		LabelApellido.setFont(fuenteTexto);
		
		LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(fuenteTexto);
		LabelNombre.setForeground(Color.DARK_GRAY);
		
		LabelMail = new JLabel("E-mail");
		LabelMail.setFont(fuenteTexto);
		LabelMail.setForeground(Color.DARK_GRAY);
		
		LabelURL = new JLabel("Guithub URL");
		LabelURL.setForeground(Color.DARK_GRAY);
		LabelURL.setFont(fuenteTexto);
		
		//Creación campos de texto
		txtGithub = new JTextField();
		txtGithub.setText(studentData.getGithubURL());
		txtGithub.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setText(studentData.getMail());
		txtMail.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText(studentData.getFirstName());
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setText(studentData.getLastName());
		txtApellidos.setColumns(10);
		
		txtA = new JTextField();
		txtA.setText(studentData.getId()+"");
		txtA.setColumns(10);
		
		//Setup botón copy
		BtnCopiar = new JButton("");
		BtnCopiar.setIcon( IconoClipboard);
		BtnCopiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StringSelection  textoACopiar= new StringSelection(txtGithub.getText());
		        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
		        portapapeles.setContents(textoACopiar, null);
		        
		        JOptionPane.showMessageDialog(null, "Texto copiado al portapapeles");
			}
		});
		
		//Disposición elementos (AUTOGENERADA)
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addComponent(LabelLU, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(txtA, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addComponent(LabelApellido, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addComponent(LabelNombre, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addComponent(LabelMail, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(txtMail, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addComponent(LabelURL, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtGithub, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(BtnCopiar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelLU, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelApellido, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelNombre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelMail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelURL, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(BtnCopiar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGithub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane);
		
		
		//Setup imagen personal
		imagen = new JLabel("");
		imagen.setIcon(imagenPersonal);
		imagen.setBounds(445, 38, 149, 149);
		contentPane.add(imagen);
		
		//Acciones imagen personal
		imagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				imagen.setIcon(imagenPersonalBarbijo);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				try {
					Thread.sleep(800);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				imagen.setIcon(imagenPersonal);
			}
		});
		
		
		//Horario en el formato solicitado
		LocalTime now = LocalTime.now();
		DateTimeFormatter tiempoFormatoCorrecto = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		//Mensaje fecha y hora
		LabelTiempo = new JLabel("Esta ventana fue generada el "+LocalDate.now() +" a las : "+now.format(tiempoFormatoCorrecto));
		LabelTiempo.setFont(fuenteTexto);
		LabelTiempo.setBounds(5, 226, 374, 14);
		contentPane.add(LabelTiempo);
		
		
	
	}
}
