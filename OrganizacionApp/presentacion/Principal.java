package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Principal {

	private static JFrame frmOrganizacionApp;
	private static JDesktopPane desktopPane;
	private JInternalFrame ventanaInformacion;
	private JInternalFrame ventanaCompeticiones;
	private JToolBar toolBar;
	private JButton btnPanelDeInformacion;
	private static JInternalFrame ventanaParticipantes;
	private JButton btnPanelDeCompeticiones;
	private JButton btnCerrarSesion;
	
	/* Se crean los organizadores */
	
	Organizador organizador1 = new Organizador(1,"admin","Alfonso","Morera","5656625-H","07/12/1977","27/12/2014","/presentacion/imagenes/organizador1.png"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
	
	private ArrayList<Organizador> listOrganizadores = new ArrayList<Organizador>();

	public ArrayList<Organizador> getListaOrganizadores () {
		return listOrganizadores;
	}

	public void setListOrganizadores (ArrayList<Organizador> listOrganizadores) {
		this.listOrganizadores = listOrganizadores;
	}
	
	/* Se crean las competiciones */
	
	Competicion competicion1 = new Competicion(1,"Maraton Madrid","20/1/2015 15:30",Messages.getString("Principal.1"),2.15,"Madrid","Ayuntamiento","Competición celebrada anualmente.","15/01/2015","www.competicion1.es","presentacion/imagenes/mapa1.PNG", "presentacion/imagenes/cartel1.jpg", false); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
	Competicion competicion2 = new Competicion(2,"Competicion Ciclista de Barcelona","15/1/2015 12:00",Messages.getString("Principal.0"),4,"Barcelona","Club de Ciclismo de Barcelona","Competición organizada con fines sociales.","05/01/2015","www.competicion2.es","presentacion/imagenes/mapa2.PNG", "presentacion/imagenes/cartel2.jpg", false); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
	private ArrayList<Competicion> listCompeticiones = new ArrayList<Competicion>();
	
	public ArrayList<Competicion> getListaCompeticiones () {
		return listCompeticiones;
	}

	public void setCompeticiones (ArrayList<Competicion> listCompeticiones) {
		this.listCompeticiones = listCompeticiones;
	}
	
	/* Se crean los participantes */
	
	Participante participante1 = new Participante(1,"Pedro","Muñoz","05978769Y","presentacion/imagenes/atleta1.jpg","Calle Lepanto","Valencia","9955952","15/2/1982","Hombre",0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ 
	Participante participante2 = new Participante(2,"Alejandro","Valverde","05556525Z","presentacion/imagenes/ciclista.jpg","Calle Guadiana","Madrid","445646","05/2/1977","Hombre",0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ 

	private static ArrayList<Participante> listParticipantes = new ArrayList<Participante>();
	
	public ArrayList<Participante> getListaParticipantes () {
		return listParticipantes;
	}

	public void setParticipantes (ArrayList<Participante> listParticipantes) {
		this.listParticipantes = listParticipantes;
	}
	
	/* Variable que contiene el usuario logeado */
	
	private Organizador organizadorLogueado = new Organizador();
	
	private static String usuario;
	private JButton btnAyuda;
	private JButton btnPanelDeParticipantes;

	public static void setUsuario(String usu) {
		usuario = usu;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String usuarioAux) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					Principal window = new Principal();
					window.frmOrganizacionApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOrganizacionApp = new JFrame();
		frmOrganizacionApp.addWindowListener(new FrmOrganizacionAppWindowListener());
		frmOrganizacionApp.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmOrganizacionApp.setBackground(Color.LIGHT_GRAY);
		frmOrganizacionApp.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/presentacion/imagenes/logo.jpg"))); //$NON-NLS-1$
		frmOrganizacionApp.setTitle("OrganizacionApp"); //$NON-NLS-1$
		frmOrganizacionApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmOrganizacionApp.setBounds(100, 100, 700, 700);
		frmOrganizacionApp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmOrganizacionApp.getContentPane().setLayout(new BorderLayout(0, 0));
		{
			desktopPane = new JDesktopPane();
			desktopPane.setBackground(SystemColor.scrollbar);
			frmOrganizacionApp.getContentPane().add(desktopPane);
			{
				ventanaInformacion = new OrganizadorInformacion();
				ventanaInformacion.setBounds(0, 0, 518, 286);
				desktopPane.add(ventanaInformacion);
				{
					ventanaCompeticiones = new PanelDeCompeticiones();
					ventanaCompeticiones.setResizable(true);
					ventanaCompeticiones.setBounds(521, 0, 833, 315);
					desktopPane.add(ventanaCompeticiones);
					{
						ventanaParticipantes = new PanelDeParticipantes();
						ventanaParticipantes.setBounds(521, 314, 833, 350);
						desktopPane.add(ventanaParticipantes);
						ventanaParticipantes.setVisible(false);
					}

					{
						toolBar = new JToolBar();
						toolBar.setBorder(new LineBorder(new Color(0, 0, 0)));
						frmOrganizacionApp.getContentPane().add(toolBar, BorderLayout.NORTH);
						{
							btnPanelDeInformacion = new JButton(Messages.getString("Principal.btnPanelDeInformacion.text")); //$NON-NLS-1$
							btnPanelDeInformacion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
							btnPanelDeInformacion.addActionListener(new BtnPanelDeInformacionActionListener());
							btnPanelDeInformacion.setIcon(new ImageIcon(Principal.class.getResource("/presentacion/imagenes/iconoHome.png"))); //$NON-NLS-1$
							toolBar.add(btnPanelDeInformacion);
						}
						{
							btnPanelDeCompeticiones = new JButton(Messages.getString("Principal.btnPanelDeCompeticiones.text")); //$NON-NLS-1$
							btnPanelDeCompeticiones.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
							btnPanelDeCompeticiones.addActionListener(new BtnPanelesActionListener());
							btnPanelDeCompeticiones.setIcon(new ImageIcon(Principal.class.getResource("/presentacion/imagenes/iconoCompeticiones.png"))); //$NON-NLS-1$
							toolBar.add(btnPanelDeCompeticiones);
						}
						{
							btnCerrarSesion = new JButton(Messages.getString("Principal.btnCerrarSesion.text")); //$NON-NLS-1$
							btnCerrarSesion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
							btnCerrarSesion.addActionListener(new BtnCerrarSesionActionListener());
							{
								btnPanelDeParticipantes = new JButton(Messages.getString("Principal.btnPanelDeParticipantes.text")); //$NON-NLS-1$
								btnPanelDeParticipantes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
								btnPanelDeParticipantes.addActionListener(new BtnPanelDeParticipantesActionListener());
								btnPanelDeParticipantes.setIcon(new ImageIcon(Principal.class.getResource("/presentacion/imagenes/iconoParticipantes.png"))); //$NON-NLS-1$
								toolBar.add(btnPanelDeParticipantes);
							}
							{
								btnAyuda = new JButton(Messages.getString("Principal.btnAyuda.text")); //$NON-NLS-1$
								btnAyuda.addActionListener(new BtnAyudaActionListener());
								btnAyuda.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
								btnAyuda.setIcon(new ImageIcon(Principal.class.getResource("/presentacion/imagenes/iconoAyuda.png"))); //$NON-NLS-1$
								toolBar.add(btnAyuda);
							}
							btnCerrarSesion.setIcon(new ImageIcon(Principal.class.getResource("/presentacion/imagenes/log-35496_1280.png"))); //$NON-NLS-1$
							toolBar.add(btnCerrarSesion);
						}
					}
					ventanaCompeticiones.setVisible(true);
				}
				ventanaInformacion.setVisible(true);
			}
		}
		
		/*Se añaden los organizadores a la lista*/
		
		listOrganizadores.add(organizador1);
		listCompeticiones.add(competicion1);
		listCompeticiones.add(competicion2);
		listParticipantes.add(participante1);
		listParticipantes.add(participante2);
		
		
		/*Se busca el organizadorLogueado*/
		
		for (int i = 0; i < listOrganizadores.size(); i++) {
			if (usuario.equalsIgnoreCase(listOrganizadores.get(i).getUsuario())) {
				organizadorLogueado = listOrganizadores.get(i);
				
				break;
			}
		}
		
		mostrarInformacionOrganizador();
		mostrarCompeticiones();
		
	}
	
	public void mostrarInformacionOrganizador() {
		((OrganizadorInformacion) ventanaInformacion).setOrganizador(organizadorLogueado);
		ventanaInformacion.setVisible(true);
		
	}
	
	public void mostrarCompeticiones(){
		
		((PanelDeCompeticiones) ventanaCompeticiones).setCompeticiones(listCompeticiones);
	}

	public static JFrame getFrame() {
		return frmOrganizacionApp;
	}
	private class BtnCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Login ventanaLogin = new Login();
			ventanaLogin.getFrmAutentificacion().setVisible(true);
			Principal.getFrame().dispose();
		}
	}
	private class BtnPanelDeInformacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(!ventanaInformacion.isVisible()){
				ventanaInformacion = new OrganizadorInformacion();
				ventanaInformacion.setBounds(0, 0, 518, 286);
				desktopPane.add(ventanaInformacion);
				mostrarInformacionOrganizador();
			}
		}
	}
	private class BtnPanelesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!ventanaCompeticiones.isVisible()){
				
				ventanaCompeticiones = new PanelDeCompeticiones();
				ventanaCompeticiones.setResizable(true);
				ventanaCompeticiones.setBounds(528, 0, 826, 310);
				desktopPane.add(ventanaCompeticiones);
				mostrarCompeticiones();
				ventanaCompeticiones.setVisible(true);
				
			}
		}
	}
	private class BtnPanelDeParticipantesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(ventanaCompeticiones.isVisible() && !ventanaParticipantes.isVisible()){
				
				ventanaParticipantes = new PanelDeParticipantes();
				ventanaParticipantes.setResizable(true);
				ventanaParticipantes.setBounds(528, 314, 826, 350);
				desktopPane.add(ventanaParticipantes);
				ventanaParticipantes.setVisible(true);
			}
			else if(ventanaParticipantes.isClosed()){
				ventanaParticipantes = new PanelDeParticipantes();
				ventanaParticipantes.setBounds(528, 314, 826, 350);
				desktopPane.add(ventanaParticipantes);
				ventanaParticipantes.setVisible(false);
			}
		}
	}
	private class FrmOrganizacionAppWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			Object[] seleccion = new Object[] { Messages.getString("Principal.4"), Messages.getString("Principal.5") }; //$NON-NLS-1$ //$NON-NLS-2$
			int respuesta = JOptionPane.showOptionDialog(null,Messages.getString("Principal.52"),Messages.getString("Principal.53"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,null,
					seleccion,0); //$NON-NLS-1$ //$NON-NLS-2$
			if(respuesta == JOptionPane.YES_OPTION){
				System.exit(0);
			}
			else{
				
			}
		}
	}
	private class BtnAyudaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Ayuda ventanaAyuda = new Ayuda();
			ventanaAyuda.setVisible(true);
		}
	}
	public static void mostrarParticipantes(int competicionSeleccionada) {
		// TODO Auto-generated method stub
		
		((PanelDeParticipantes) ventanaParticipantes).setParticipantes(listParticipantes,competicionSeleccionada);
		
		ventanaParticipantes.setVisible(true);
		
	}
}