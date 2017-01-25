package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login {

	private static JFrame frmAutentificacion;
	private ArrayList<Usuario> listUsuarios = new ArrayList<Usuario>();
	private JLabel lblIcono;
	@SuppressWarnings("rawtypes")
	private JComboBox comboIdioma;
	private JLabel lblUsuario;
	private JTextField textUsuario;
	private JLabel lblContrasea;
	private JPasswordField textPassword;
	private JButton btnEntrar;
	private JLabel lblMsg;
	private Login ventanaCambiada;
	
	/*
	 * Se crean el mensaje que se mostrar� cuando las combinaciones sean incorrectas.
	 */
	
	private String errorUsuario = Messages.getString("Login.0"); //$NON-NLS-1$
	
	/*
	 * Se crean los usuarios que tendr�n acceso a la aplicaci�n.
	 * */
	
	private Usuario user1 = new Usuario("admin", "admin"); //$NON-NLS-1$ 
	
	/*
	 * Se crea la lista de Usuarios
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {   
			  salir:
			  //recorre todos los temas disponibles en el jkd
			  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			    switch (info.getName()) {
			      case "GTK+": //si encuentra tema gtk establece este //$NON-NLS-1$
			        javax.swing.UIManager.setLookAndFeel(info.getClassName());
			        break salir;
			      case "Windows": //si encuentra tema windows establece este //$NON-NLS-1$
			        javax.swing.UIManager.setLookAndFeel(info.getClassName());
			        break salir;
			      default: //sino encuentra ninguno de los anteriores establece metal
			        javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");      //$NON-NLS-1$
			        break;           
			    }        
			  }       
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			  java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					Login window = new Login();
					window.frmAutentificacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmAutentificacion = new JFrame();
		frmAutentificacion.addWindowListener(new FrmAutentificacionWindowListener());
		frmAutentificacion.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/presentacion/imagenes/logo.jpg"))); //$NON-NLS-1$
		frmAutentificacion.setResizable(false);
		frmAutentificacion.setTitle(Messages.getString("Login.7")); //$NON-NLS-1$
		frmAutentificacion.setBounds(100, 100, 400, 321);
		frmAutentificacion.setLocationRelativeTo(null);
		frmAutentificacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{56, 77, 158, 93, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 17, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmAutentificacion.getContentPane().setLayout(gridBagLayout);
		
		comboIdioma = new JComboBox();
		comboIdioma.setToolTipText(Messages.getString("Login.comboIdioma.toolTipText")); //$NON-NLS-1$
		comboIdioma.addActionListener(new ComboIdiomaActionListener());
		comboIdioma.setModel(new DefaultComboBoxModel(new String[] {Messages.getString("Login.8"),"Español", "English"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		GridBagConstraints gbc_comboIdioma = new GridBagConstraints();
		gbc_comboIdioma.insets = new Insets(0, 0, 5, 0);
		gbc_comboIdioma.anchor = GridBagConstraints.SOUTH;
		gbc_comboIdioma.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboIdioma.gridx = 3;
		gbc_comboIdioma.gridy = 0;
		frmAutentificacion.getContentPane().add(comboIdioma, gbc_comboIdioma);
		
		lblIcono = new JLabel(""); //$NON-NLS-1$
		lblIcono.setIcon(new ImageIcon(Login.class.getResource("/presentacion/imagenes/logo.jpg"))); //$NON-NLS-1$
		GridBagConstraints gbc_lblIcono = new GridBagConstraints();
		gbc_lblIcono.fill = GridBagConstraints.BOTH;
		gbc_lblIcono.insets = new Insets(0, 0, 5, 5);
		gbc_lblIcono.gridx = 2;
		gbc_lblIcono.gridy = 1;
		frmAutentificacion.getContentPane().add(lblIcono, gbc_lblIcono);
		
		lblUsuario = new JLabel(Messages.getString("Login.lblUsuario.text")); //$NON-NLS-1$
		lblUsuario.setFocusable(false);
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 3;
		frmAutentificacion.getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		textUsuario = new JTextField();
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.gridx = 2;
		gbc_textUsuario.gridy = 3;
		frmAutentificacion.getContentPane().add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(10);
		
		lblContrasea = new JLabel(Messages.getString("Login.lblContrasea.text")); //$NON-NLS-1$
		lblContrasea.setFocusable(false);
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		frmAutentificacion.getContentPane().add(lblContrasea, gbc_lblContrasea);
		
		textPassword = new JPasswordField();
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPassword.gridx = 2;
		gbc_textPassword.gridy = 4;
		frmAutentificacion.getContentPane().add(textPassword, gbc_textPassword);
		
		btnEntrar = new JButton(Messages.getString("Login.btnEntrar.text")); //$NON-NLS-1$
		btnEntrar.setToolTipText(Messages.getString("Login.btnEntrar.toolTipText")); //$NON-NLS-1$
		btnEntrar.addActionListener(new BtnEntrarActionListener());
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.anchor = GridBagConstraints.EAST;
		gbc_btnEntrar.gridwidth = 2;
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntrar.gridx = 1;
		gbc_btnEntrar.gridy = 5;
		frmAutentificacion.getContentPane().add(btnEntrar, gbc_btnEntrar);
		
		lblMsg = new JLabel(""); //$NON-NLS-1$
		lblMsg.setForeground(Color.RED);
		GridBagConstraints gbc_lblMsg = new GridBagConstraints();
		gbc_lblMsg.anchor = GridBagConstraints.EAST;
		gbc_lblMsg.gridwidth = 2;
		gbc_lblMsg.insets = new Insets(0, 0, 0, 5);
		gbc_lblMsg.gridx = 1;
		gbc_lblMsg.gridy = 7;
		frmAutentificacion.getContentPane().add(lblMsg, gbc_lblMsg);
		
		/*
		 * Se rellena la lista con los usuarios.
		 */
		
		listUsuarios.add(user1);
		
	}
	
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String usuarioAux, passwordAux;
			boolean datosCorrectos = false;
			
			lblMsg.setText(""); //$NON-NLS-1$
			
			usuarioAux = textUsuario.getText();
			passwordAux = new String (textPassword.getPassword());
			
			for (int i = 0; i < listUsuarios.size(); i++) {
				if (listUsuarios.get(i).getUsuario().toString().equals(usuarioAux)) {
					if (listUsuarios.get(i).getPassword().toString().equals(passwordAux)) 
						datosCorrectos = true;
				}
			}
			
			if (!datosCorrectos) {
				lblMsg.setText(errorUsuario);
			}
			else {
				Principal.setUsuario(usuarioAux);
				Principal.main(usuarioAux);
				textUsuario.setText(""); //$NON-NLS-1$
				textPassword.setText(""); //$NON-NLS-1$
				frmAutentificacion.setVisible(false);
			}
		}
	}
	private class FrmAutentificacionWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			JOptionPane.showMessageDialog(frmAutentificacion, Messages.getString("Login.17"), Messages.getString("Login.18"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.PLAIN_MESSAGE);
		}
	}
	private class ComboIdiomaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String idiomaSeleccionado = comboIdioma.getSelectedItem().toString();
			
			if(idiomaSeleccionado.equals("English")) //$NON-NLS-1$
				Messages.setIdioma("English"); //$NON-NLS-1$
			else if(idiomaSeleccionado.equals("Español")) //$NON-NLS-1$
				Messages.setIdioma("Español"); //$NON-NLS-1$
				
			frmAutentificacion.setVisible(false);
			Login ventanaCambiada = new Login();
			ventanaCambiada.getFrmAutentificacion().setVisible(true);
				
			}
		}
	public JFrame getFrmAutentificacion() {
		return frmAutentificacion;
	}

	public static void setFrmAutentificacion(JFrame frmAutentificacion) {
		Login.frmAutentificacion = frmAutentificacion;
	}

}
