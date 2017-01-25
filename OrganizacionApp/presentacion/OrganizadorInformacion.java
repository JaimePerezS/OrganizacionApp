package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import javax.swing.border.TitledBorder;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrganizadorInformacion extends JInternalFrame {
	private JPanel panel;
	private JLabel lblUsuario;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblUltimaConexion;
	private JTextField txtUsuario;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtFechaDeNacimiento;
	private JTextField txtUltimaConexion;
	private JScrollPane scpFoto;
	private JLabel lblFoto;
	private JButton btnCerrarSesion;

	/*Organizador*/
	
	private Organizador organizador = new Organizador();
	
	public Organizador getOrganizador(){
		return organizador;
	}
	
	public void setOrganizador(Organizador organizador) {
		this.organizador= organizador;
		mostrarInformacion();
	}
	
	/* Lista Organizador */
	
	private ArrayList<Organizador> listOrganizador = new ArrayList<Organizador>();

	public ArrayList<Organizador> getListaOrganizadores () {
		return listOrganizador;
	}

	public void setListaOrganizadores (ArrayList<Organizador> listOrganizador) {
		this.listOrganizador = listOrganizador;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrganizadorInformacion frame = new OrganizadorInformacion();
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
	public OrganizadorInformacion() {
		setFrameIcon(new ImageIcon(OrganizadorInformacion.class.getResource("/presentacion/imagenes/iconoHome.png")));
		setClosable(true);
		setTitle(Messages.getString("OrganizadorInformacion.this.title")); //$NON-NLS-1$
		setBounds(100, 100, 497, 275);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{85, 190, 0, 76, 91, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 169, 42, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, Messages.getString("OrganizadorInformacion.panel.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 2;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			getContentPane().add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				lblUsuario = new JLabel(Messages.getString("OrganizadorInformacion.lblUsuario.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
				gbc_lblUsuario.anchor = GridBagConstraints.EAST;
				gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
				gbc_lblUsuario.gridx = 0;
				gbc_lblUsuario.gridy = 0;
				panel.add(lblUsuario, gbc_lblUsuario);
			}
			{
				txtUsuario = new JTextField();
				txtUsuario.setEditable(false);
				GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
				gbc_txtUsuario.insets = new Insets(0, 0, 5, 0);
				gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtUsuario.gridx = 1;
				gbc_txtUsuario.gridy = 0;
				panel.add(txtUsuario, gbc_txtUsuario);
				txtUsuario.setColumns(10);
			}
			{
				lblDni = new JLabel(Messages.getString("OrganizadorInformacion.lblDni.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblDni = new GridBagConstraints();
				gbc_lblDni.anchor = GridBagConstraints.EAST;
				gbc_lblDni.insets = new Insets(0, 0, 5, 5);
				gbc_lblDni.gridx = 0;
				gbc_lblDni.gridy = 1;
				panel.add(lblDni, gbc_lblDni);
			}
			{
				txtDNI = new JTextField();
				txtDNI.setEditable(false);
				GridBagConstraints gbc_txtDNI = new GridBagConstraints();
				gbc_txtDNI.insets = new Insets(0, 0, 5, 0);
				gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDNI.gridx = 1;
				gbc_txtDNI.gridy = 1;
				panel.add(txtDNI, gbc_txtDNI);
				txtDNI.setColumns(10);
			}
			{
				lblNombre = new JLabel(Messages.getString("OrganizadorInformacion.lblNombre.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblNombre = new GridBagConstraints();
				gbc_lblNombre.anchor = GridBagConstraints.EAST;
				gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombre.gridx = 0;
				gbc_lblNombre.gridy = 2;
				panel.add(lblNombre, gbc_lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				GridBagConstraints gbc_txtNombre = new GridBagConstraints();
				gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
				gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNombre.gridx = 1;
				gbc_txtNombre.gridy = 2;
				panel.add(txtNombre, gbc_txtNombre);
				txtNombre.setColumns(10);
			}
			{
				lblApellidos = new JLabel(Messages.getString("OrganizadorInformacion.lblApellidos.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
				gbc_lblApellidos.anchor = GridBagConstraints.EAST;
				gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
				gbc_lblApellidos.gridx = 0;
				gbc_lblApellidos.gridy = 3;
				panel.add(lblApellidos, gbc_lblApellidos);
			}
			{
				txtApellidos = new JTextField();
				txtApellidos.setEditable(false);
				GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
				gbc_txtApellidos.anchor = GridBagConstraints.NORTH;
				gbc_txtApellidos.insets = new Insets(0, 0, 5, 0);
				gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtApellidos.gridx = 1;
				gbc_txtApellidos.gridy = 3;
				panel.add(txtApellidos, gbc_txtApellidos);
				txtApellidos.setColumns(10);
			}
			{
				lblFechaDeNacimiento = new JLabel(Messages.getString("OrganizadorInformacion.lblFechaDeNacimiento.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
				gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.EAST;
				gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
				gbc_lblFechaDeNacimiento.gridx = 0;
				gbc_lblFechaDeNacimiento.gridy = 4;
				panel.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
			}
			{
				txtFechaDeNacimiento = new JTextField();
				txtFechaDeNacimiento.setEditable(false);
				GridBagConstraints gbc_txtFechaDeNacimiento = new GridBagConstraints();
				gbc_txtFechaDeNacimiento.insets = new Insets(0, 0, 5, 0);
				gbc_txtFechaDeNacimiento.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFechaDeNacimiento.gridx = 1;
				gbc_txtFechaDeNacimiento.gridy = 4;
				panel.add(txtFechaDeNacimiento, gbc_txtFechaDeNacimiento);
				txtFechaDeNacimiento.setColumns(10);
			}
			{
				lblUltimaConexion = new JLabel(Messages.getString("OrganizadorInformacion.lblUltimaConexion.text")); //$NON-NLS-1$
				GridBagConstraints gbc_lblUltimaConexion = new GridBagConstraints();
				gbc_lblUltimaConexion.anchor = GridBagConstraints.EAST;
				gbc_lblUltimaConexion.insets = new Insets(0, 0, 0, 5);
				gbc_lblUltimaConexion.gridx = 0;
				gbc_lblUltimaConexion.gridy = 5;
				panel.add(lblUltimaConexion, gbc_lblUltimaConexion);
			}
			{
				txtUltimaConexion = new JTextField();
				txtUltimaConexion.setEditable(false);
				GridBagConstraints gbc_txtUltimaConexion = new GridBagConstraints();
				gbc_txtUltimaConexion.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtUltimaConexion.gridx = 1;
				gbc_txtUltimaConexion.gridy = 5;
				panel.add(txtUltimaConexion, gbc_txtUltimaConexion);
				txtUltimaConexion.setColumns(10);
			}
		}
		{
			scpFoto = new JScrollPane();
			scpFoto.setBorder(new TitledBorder(null, Messages.getString("OrganizadorInformacion.scpFoto.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			GridBagConstraints gbc_scpFoto = new GridBagConstraints();
			gbc_scpFoto.gridwidth = 2;
			gbc_scpFoto.insets = new Insets(0, 0, 5, 5);
			gbc_scpFoto.fill = GridBagConstraints.BOTH;
			gbc_scpFoto.gridx = 3;
			gbc_scpFoto.gridy = 1;
			getContentPane().add(scpFoto, gbc_scpFoto);
			{
				lblFoto = new JLabel("");
				scpFoto.setViewportView(lblFoto);
			}
		}
		{
			btnCerrarSesion = new JButton(Messages.getString("OrganizadorInformacion.btnCerrarSesion.text")); //$NON-NLS-1$
			btnCerrarSesion.setIcon(new ImageIcon(OrganizadorInformacion.class.getResource("/presentacion/imagenes/log-35496_1280.png")));
			btnCerrarSesion.addActionListener(new BtnCerrarSesionActionListener());
			GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
			gbc_btnCerrarSesion.fill = GridBagConstraints.VERTICAL;
			gbc_btnCerrarSesion.insets = new Insets(0, 0, 5, 5);
			gbc_btnCerrarSesion.gridx = 4;
			gbc_btnCerrarSesion.gridy = 2;
			getContentPane().add(btnCerrarSesion, gbc_btnCerrarSesion);
		}

	}
	
	public void mostrarInformacion(){
		txtUsuario.setText(organizador.getUsuario());
		txtDNI.setText(organizador.getDni());
		txtNombre.setText(organizador.getNombre());
		txtApellidos.setText(organizador.getApellidos());
		txtFechaDeNacimiento.setText(organizador.getFechaNacimiento());
		txtUltimaConexion.setText(organizador.getUltimaConexion());
		lblFoto.setIcon(new ImageIcon(Login.class.getResource(organizador.getImg())));
	}
	
	private class BtnCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Login ventanaLogin = new Login();
			ventanaLogin.getFrmAutentificacion().setVisible(true);
			Principal.getFrame().dispose();
		}
	}
}
