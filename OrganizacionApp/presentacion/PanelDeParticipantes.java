package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import java.awt.TextArea;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class PanelDeParticipantes extends JInternalFrame {
	private JPanel pnlParticipantes;
	private JPanel pnlInformaciónParticipantes;
	private JScrollPane spParticipantes;
	private JTable tablaParticipantes;
	private TextArea taInformacionParticipante;
	private JScrollPane spFoto;
	private JLabel lblFoto;
	private JButton btnAnadirParticipante;
	private JButton btnModificarParticipante;
	private JButton btnBorrarParticipante;
	private JButton btnEnviarNotificaciones;

	private JPopupMenu popupMenu;
	private JMenuItem mntmAadir;
	private JMenuItem mntmBorrar;
	
	private ArrayList<Participante> listParticipantes = new ArrayList<Participante>();
	
	public ArrayList<Participante> getListaParticipantes () {
		return listParticipantes;
	}

	public void setParticipantes (ArrayList<Participante> listParticipantes, int competicion) {
		this.listParticipantes = listParticipantes;
		mostrarParticipantes(competicion);
	}
	
	private String competicionSeleccionada;
	
	public String getCompeticionSeleccionada() {
		return competicionSeleccionada;
	}

	public void setCompeticionSeleccionada(String competicionSeleccionada) {
		this.competicionSeleccionada = competicionSeleccionada;
	}
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param competicionSeleccionada 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelDeParticipantes() {
		
		setFrameIcon(new ImageIcon(PanelDeParticipantes.class.getResource("/presentacion/imagenes/iconoParticipantes.png"))); //$NON-NLS-1$
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle(Messages.getString("PanelDeParticipantes.this.title")); //$NON-NLS-1$
		setBounds(100, 100, 755, 416);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{798, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{121, 0, 125, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			pnlParticipantes = new JPanel();
			GridBagConstraints gbc_pnlParticipantes = new GridBagConstraints();
			gbc_pnlParticipantes.gridwidth = 5;
			gbc_pnlParticipantes.fill = GridBagConstraints.BOTH;
			gbc_pnlParticipantes.insets = new Insets(0, 0, 5, 0);
			gbc_pnlParticipantes.gridx = 0;
			gbc_pnlParticipantes.gridy = 0;
			getContentPane().add(pnlParticipantes, gbc_pnlParticipantes);
			GridBagLayout gbl_pnlParticipantes = new GridBagLayout();
			gbl_pnlParticipantes.columnWidths = new int[]{460, 0};
			gbl_pnlParticipantes.rowHeights = new int[]{117, 0};
			gbl_pnlParticipantes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_pnlParticipantes.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			pnlParticipantes.setLayout(gbl_pnlParticipantes);
			{
				spParticipantes = new JScrollPane();
				GridBagConstraints gbc_spParticipantes = new GridBagConstraints();
				gbc_spParticipantes.fill = GridBagConstraints.BOTH;
				gbc_spParticipantes.gridx = 0;
				gbc_spParticipantes.gridy = 0;
				pnlParticipantes.add(spParticipantes, gbc_spParticipantes);
				{
					tablaParticipantes = new JTable();
					tablaParticipantes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					tablaParticipantes.addMouseListener(new TablaParticipantesMouseListener());
					spParticipantes.setViewportView(tablaParticipantes);
					tablaParticipantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
					MiTablaParticipantes modeloTabla = new MiTablaParticipantes();
					tablaParticipantes.setModel(modeloTabla);
					{
						popupMenu = new JPopupMenu();
						addPopup(spParticipantes, popupMenu);
						{
							mntmAadir = new JMenuItem(Messages.getString("PanelDeParticipantes.mntmAadir.text")); //$NON-NLS-1$
							mntmAadir.addActionListener(new BtnAnadirParticipanteActionListener());//TRans 32
							mntmAadir.setIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoAñadir.png"))); //$NON-NLS-1$
							popupMenu.add(mntmAadir);
						}
						{
							mntmBorrar = new JMenuItem(Messages.getString("PanelDeParticipantes.mntmBorrar.text")); //$NON-NLS-1$
							mntmBorrar.addActionListener(new BtnBorrarParticipanteActionListener());//TRans 32
							mntmBorrar.setIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoBorrar.png"))); //$NON-NLS-1$
							popupMenu.add(mntmBorrar);
						}
					}
					addPopup(tablaParticipantes,popupMenu);
					
					
				}
				
			}
		}
		{
			btnAnadirParticipante = new JButton(Messages.getString("PanelDeParticipantes.btnAnadirParticipante.text")); //$NON-NLS-1$
			btnAnadirParticipante.setToolTipText(Messages.getString("PanelDeParticipantes.btnAnadirParticipante.toolTipText")); //$NON-NLS-1$
			btnAnadirParticipante.addActionListener(new BtnAnadirParticipanteActionListener());
			btnAnadirParticipante.setIcon(new ImageIcon(PanelDeParticipantes.class.getResource("/presentacion/imagenes/iconoAñadir.png"))); //$NON-NLS-1$
			GridBagConstraints gbc_btnAnadirParticipante = new GridBagConstraints();
			gbc_btnAnadirParticipante.insets = new Insets(0, 0, 5, 5);
			gbc_btnAnadirParticipante.gridx = 1;
			gbc_btnAnadirParticipante.gridy = 1;
			getContentPane().add(btnAnadirParticipante, gbc_btnAnadirParticipante);
		}
		{
			{
				btnModificarParticipante = new JButton(Messages.getString("PanelDeParticipantes.btnModificarParticipante.text")); //$NON-NLS-1$
				btnModificarParticipante.setToolTipText(Messages.getString("PanelDeParticipantes.btnModificarParticipante.toolTipText")); //$NON-NLS-1$
				btnModificarParticipante.addActionListener(new BtnModificarParticipanteActionListener());
				btnModificarParticipante.setEnabled(false);
				btnModificarParticipante.setIcon(new ImageIcon(PanelDeParticipantes.class.getResource("/presentacion/imagenes/iconoModificar.png"))); //$NON-NLS-1$
				GridBagConstraints gbc_btnModificarParticipante = new GridBagConstraints();
				gbc_btnModificarParticipante.insets = new Insets(0, 0, 5, 5);
				gbc_btnModificarParticipante.gridx = 2;
				gbc_btnModificarParticipante.gridy = 1;
				getContentPane().add(btnModificarParticipante, gbc_btnModificarParticipante);
			}
		}
		btnBorrarParticipante = new JButton(Messages.getString("PanelDeParticipantes.btnBorrarParticipante.text")); //$NON-NLS-1$
		btnBorrarParticipante.setToolTipText(Messages.getString("PanelDeParticipantes.btnBorrarParticipante.toolTipText")); //$NON-NLS-1$
		btnBorrarParticipante.setEnabled(false);
		btnBorrarParticipante.addActionListener(new BtnBorrarParticipanteActionListener());
		btnBorrarParticipante.setIcon(new ImageIcon(PanelDeParticipantes.class.getResource("/presentacion/imagenes/iconoBorrar.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_btnBorrarParticipante = new GridBagConstraints();
		gbc_btnBorrarParticipante.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrarParticipante.gridx = 3;
		gbc_btnBorrarParticipante.gridy = 1;
		getContentPane().add(btnBorrarParticipante, gbc_btnBorrarParticipante);
		{
			btnEnviarNotificaciones = new JButton(Messages.getString("PanelDeParticipantes.btnEnviarNotificaciones.text")); //$NON-NLS-1$
			btnEnviarNotificaciones.setToolTipText(Messages.getString("PanelDeParticipantes.btnEnviarNotificaciones.toolTipText")); //$NON-NLS-1$
			btnEnviarNotificaciones.addActionListener(new BtnEnviarNotificacionesActionListener());
			btnEnviarNotificaciones.setIcon(new ImageIcon(PanelDeParticipantes.class.getResource("/presentacion/imagenes/iconoNotificación.png"))); //$NON-NLS-1$
			GridBagConstraints gbc_btnEnviarNotificaciones = new GridBagConstraints();
			gbc_btnEnviarNotificaciones.insets = new Insets(0, 0, 5, 0);
			gbc_btnEnviarNotificaciones.gridx = 4;
			gbc_btnEnviarNotificaciones.gridy = 1;
			getContentPane().add(btnEnviarNotificaciones, gbc_btnEnviarNotificaciones);
		}
		{
			pnlInformaciónParticipantes = new JPanel();
			GridBagConstraints gbc_pnlInformaciónParticipantes = new GridBagConstraints();
			gbc_pnlInformaciónParticipantes.gridwidth = 5;
			gbc_pnlInformaciónParticipantes.fill = GridBagConstraints.BOTH;
			gbc_pnlInformaciónParticipantes.gridx = 0;
			gbc_pnlInformaciónParticipantes.gridy = 2;
			getContentPane().add(pnlInformaciónParticipantes, gbc_pnlInformaciónParticipantes);
			GridBagLayout gbl_pnlInformaciónParticipantes = new GridBagLayout();
			gbl_pnlInformaciónParticipantes.columnWidths = new int[]{184, 29, 406, 0};
			gbl_pnlInformaciónParticipantes.rowHeights = new int[]{138, 0};
			gbl_pnlInformaciónParticipantes.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_pnlInformaciónParticipantes.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			pnlInformaciónParticipantes.setLayout(gbl_pnlInformaciónParticipantes);
			{
				spFoto = new JScrollPane();
				GridBagConstraints gbc_spFoto = new GridBagConstraints();
				gbc_spFoto.insets = new Insets(0, 0, 0, 5);
				gbc_spFoto.fill = GridBagConstraints.BOTH;
				gbc_spFoto.gridx = 0;
				gbc_spFoto.gridy = 0;
				pnlInformaciónParticipantes.add(spFoto, gbc_spFoto);
				{
					lblFoto = new JLabel(""); //$NON-NLS-1$
					spFoto.setColumnHeaderView(lblFoto);
				}
			}
			{
				taInformacionParticipante = new TextArea();
				taInformacionParticipante.setEditable(false);
				GridBagConstraints gbc_taInformacionParticipante = new GridBagConstraints();
				gbc_taInformacionParticipante.fill = GridBagConstraints.BOTH;
				gbc_taInformacionParticipante.gridx = 2;
				gbc_taInformacionParticipante.gridy = 0;
				pnlInformaciónParticipantes.add(taInformacionParticipante, gbc_taInformacionParticipante);
			}
		}
		
		ListSelectionModel rowSM =  tablaParticipantes.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	   ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		        if (!lsm.isSelectionEmpty()) {
		        	
		        	MiTablaParticipantes modeloTabla = (MiTablaParticipantes) tablaParticipantes.getModel();
		            int n= tablaParticipantes.getSelectedRow();
		            if (n != -1) 
		            {
		            	String contenido = Messages.getString("PanelDeParticipantes.8")+ modeloTabla.getValueAt(n, 0)+"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		            	Messages.getString("PanelDeParticipantes.10")+ modeloTabla.getValueAt(n, 1) +"\n"+  //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeParticipantes.12")+ modeloTabla.getValueAt(n, 2) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeParticipantes.14")+ modeloTabla.getValueAt(n, 3) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeParticipantes.16")+ modeloTabla.getValueAt(n,4) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeParticipantes.18")+ modeloTabla.getValueAt(n, 5) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeParticipantes.20")+ modeloTabla.getValueAt(n, 6) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeParticipantes.22")+ modeloTabla.getValueAt(n, 7) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeParticipantes.24")+ modeloTabla.getValueAt(n, 8) +"\n"; //$NON-NLS-1$ //$NON-NLS-2$
		            	
		                taInformacionParticipante.setText(contenido);
		        		lblFoto.setIcon((ImageIcon)modeloTabla.getValueAt(n, 9));
		            }    

		        }
		    }
		 });
				
		
		TableColumn columnaGenero = tablaParticipantes.getColumnModel().getColumn(5);
		
		
		JComboBox genero = new JComboBox();
		genero.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"})); //$NON-NLS-1$ //$NON-NLS-2$
		
		columnaGenero.setCellEditor(new DefaultCellEditor(genero));
		
		TableColumn columnaFoto = tablaParticipantes.getColumnModel().getColumn(9);
		columnaFoto.setCellEditor(new ColumnaFotoEditor());
		
		spParticipantes.setViewportView(tablaParticipantes);
		
	}

	public void mostrarParticipantes(int competicion) {
		
		tablaParticipantes.setModel(new MiTablaParticipantes());
		MiTablaParticipantes modeloTabla = (MiTablaParticipantes) tablaParticipantes.getModel();	
		
		ArrayList<Participante> participantesDeLaCompeticion = new ArrayList<Participante>();
		
		for(int i = 0; i < listParticipantes.size(); i++)
			if(listParticipantes.get(i).getIdParticipante() == competicion)
				participantesDeLaCompeticion.add(listParticipantes.get(i));
		
		
		for(int i = 0; i < participantesDeLaCompeticion.size(); i++){
			
			Object[] participante = {participantesDeLaCompeticion.get(i).getPosicionFinal(), participantesDeLaCompeticion.get(i).getApellidos(),
					participantesDeLaCompeticion.get(i).getNombre(), participantesDeLaCompeticion.get(i).getDni(),
					participantesDeLaCompeticion.get(i).getFechaNacimiento(), participantesDeLaCompeticion.get(i).getGenero(),
					participantesDeLaCompeticion.get(i).getDireccion(), participantesDeLaCompeticion.get(i).getLocalidad(),
					participantesDeLaCompeticion.get(i).getTelefono(), new ImageIcon(getClass().getClassLoader().getResource(participantesDeLaCompeticion.get(i).getFoto()))};
			modeloTabla.aniadeFila(participante);
			
		}
		
	}

	private class BtnAnadirParticipanteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			MiTablaParticipantes modeloTabla = (MiTablaParticipantes) tablaParticipantes.getModel();
			Object[] nuevaFila ={"NNN", "...", "...","XXXXXXXX-X","XX/XX/XXXX","...","...","...","(***) *** *** ***", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
					new ImageIcon(getClass().getClassLoader().getResource("presentacion/imagenes/iconoFoto.png"))}; //$NON-NLS-1$
			
			modeloTabla.aniadeFila(nuevaFila);
			modeloTabla.fireTableDataChanged();
		}
	}
	private class BtnBorrarParticipanteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(tablaParticipantes.getSelectedRow()!=-1){
				Object[] seleccion = new Object[] { Messages.getString("PanelDeParticipantes.0"), Messages.getString("PanelDeParticipantes.1") }; //$NON-NLS-1$ //$NON-NLS-2$
				int respuesta = JOptionPane.showOptionDialog(null,Messages.getString("PanelDeParticipantes.2"), //$NON-NLS-1$
						Messages.getString("PanelDeParticipantes.3"), JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, //$NON-NLS-1$
						null,seleccion,0);
				if(respuesta == JOptionPane.YES_OPTION){
					MiTablaParticipantes modeloTabla = (MiTablaParticipantes) tablaParticipantes.getModel();
					int n= tablaParticipantes.getSelectedRow();
					if (n != -1) modeloTabla.eliminaFila(tablaParticipantes.getSelectedRow());
					modeloTabla.fireTableDataChanged();
			
					taInformacionParticipante.setText(" "); //$NON-NLS-1$
					lblFoto.setIcon(null);
				}
				else{
					
				}
			}
			else{
				JOptionPane.showMessageDialog(null, Messages.getString("PanelDeParticipantes.39"), Messages.getString("PanelDeParticipantes.40"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}
	private class TablaParticipantesMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent arg0) {
			if(tablaParticipantes.getSelectedRow() >= 0){
				btnModificarParticipante.setEnabled(true);
				btnBorrarParticipante.setEnabled(true);
			}
		}
	}
	private class BtnEnviarNotificacionesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int respuesta = JOptionPane.showOptionDialog(null,Messages.getString("PanelDeParticipantes.41"),Messages.getString("PanelDeParticipantes.42"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null); //$NON-NLS-1$ //$NON-NLS-2$
			if(respuesta == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, Messages.getString("PanelDeParticipantes.43"), Messages.getString("PanelDeParticipantes.44"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}
	private class BtnModificarParticipanteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tablaParticipantes.getSelectedRow() != -1){
				Object[] seleccion = new Object[] { Messages.getString("PanelDeParticipantes.4"), Messages.getString("PanelDeParticipantes.5") }; //$NON-NLS-1$ //$NON-NLS-2$
				int respuesta = JOptionPane.showOptionDialog(null,Messages.getString("PanelDeParticipantes.6"), //$NON-NLS-1$
						Messages.getString("PanelDeParticipantes.7"), JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, //$NON-NLS-1$
						null,seleccion,0); 
				if(respuesta == JOptionPane.YES_OPTION){
					
				}
				else{
					
				}
			}
		}
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}
