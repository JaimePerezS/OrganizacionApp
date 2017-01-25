package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;


import javax.swing.table.TableRowSorter;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
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

import javax.swing.SwingConstants;



public class PanelDeCompeticiones extends JInternalFrame {
	private JPanel pnlCompeticiones;
	private JPanel pnlInformaciónCompeticiones;
	private JScrollPane spCompeticiones;
	private JTable tablaCompeticiones;
	private TextArea taInformacionCompeticion;
	private JScrollPane spCartel;
	private JLabel lblCartel;
	private JButton btnAnadirCompeticion;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnVerMapa;
	private JPopupMenu popupMenu;
	private JMenuItem mntmAadir;
	private JMenuItem mntmBorrar;
	private JMenuItem mntmVerMapa;
	
	EditorGrafico editorMapa = new EditorGrafico();
	
	
	/* Listas de Competiciones y Participantes */
	
	private ArrayList<Competicion> listCompeticiones = new ArrayList<Competicion>();
	
	public ArrayList<Competicion> getListaCompeticiones () {
		return listCompeticiones;
	}

	public void setCompeticiones (ArrayList<Competicion> listCompeticiones) {
		this.listCompeticiones = listCompeticiones;
		mostrarInformacion();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDeCompeticiones frame = new PanelDeCompeticiones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param listCompeticiones 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelDeCompeticiones() {
		
		setFrameIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoCompeticiones.png"))); //$NON-NLS-1$
		setMaximizable(true);
		setClosable(true);
		setTitle(Messages.getString("PanelDeCompeticiones.this.title")); //$NON-NLS-1$
		setBounds(100, 100, 755, 416);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{798, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{61, 0, 125, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			pnlCompeticiones = new JPanel();
			GridBagConstraints gbc_pnlCompeticiones = new GridBagConstraints();
			gbc_pnlCompeticiones.gridwidth = 5;
			gbc_pnlCompeticiones.fill = GridBagConstraints.BOTH;
			gbc_pnlCompeticiones.insets = new Insets(0, 0, 5, 0);
			gbc_pnlCompeticiones.gridx = 0;
			gbc_pnlCompeticiones.gridy = 0;
			getContentPane().add(pnlCompeticiones, gbc_pnlCompeticiones);
			GridBagLayout gbl_pnlCompeticiones = new GridBagLayout();
			gbl_pnlCompeticiones.columnWidths = new int[]{460, 0};
			gbl_pnlCompeticiones.rowHeights = new int[]{125, 0};
			gbl_pnlCompeticiones.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_pnlCompeticiones.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			pnlCompeticiones.setLayout(gbl_pnlCompeticiones);
			{
				spCompeticiones = new JScrollPane();
				GridBagConstraints gbc_spCompeticiones = new GridBagConstraints();
				gbc_spCompeticiones.fill = GridBagConstraints.BOTH;
				gbc_spCompeticiones.gridx = 0;
				gbc_spCompeticiones.gridy = 0;
				pnlCompeticiones.add(spCompeticiones, gbc_spCompeticiones);
				{
					tablaCompeticiones = new JTable();
					tablaCompeticiones.addMouseListener(new TablaCompeticionesMouseListener());
					tablaCompeticiones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					spCompeticiones.setViewportView(tablaCompeticiones);
					tablaCompeticiones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
					MiTablaCompeticiones modeloTabla = new MiTablaCompeticiones();
					tablaCompeticiones.setModel(modeloTabla);
					
					{
						popupMenu = new JPopupMenu();
						addPopup(spCompeticiones, popupMenu);
						{
							mntmAadir = new JMenuItem(Messages.getString("PanelDeCompeticiones.mntmAadir.text_1")); //$NON-NLS-1$
							mntmAadir.addActionListener(new BtnAnadirCompeticionActionListener());//TRans 32
							mntmAadir.setIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoAñadir.png"))); //$NON-NLS-1$
							popupMenu.add(mntmAadir);
						}
						{
							mntmBorrar = new JMenuItem(Messages.getString("PanelDeCompeticiones.mntmBorrar.text_1")); //$NON-NLS-1$
							mntmBorrar.addActionListener(new BtnBorrarActionListener());//TRans 32
							mntmBorrar.setIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoBorrar.png"))); //$NON-NLS-1$
							popupMenu.add(mntmBorrar);
						}
						{
							mntmVerMapa = new JMenuItem(Messages.getString("PanelDeCompeticiones.mntmVerMapa.text_1")); //$NON-NLS-1$
							mntmVerMapa.addActionListener(new BtnVerMapaActionListener());//TRans 32
							mntmVerMapa.setIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoVerMapa.png"))); //$NON-NLS-1$
							popupMenu.add(mntmVerMapa);
						}
					}
					
					addPopup(tablaCompeticiones, popupMenu); 
					

				}
			}
		}
		{
			btnAnadirCompeticion = new JButton(Messages.getString("PanelDeCompeticiones.btnAnadirCompeticion.text")); //$NON-NLS-1$
			btnAnadirCompeticion.setToolTipText(Messages.getString("PanelDeCompeticiones.btnAnadirCompeticion.toolTipText")); //$NON-NLS-1$
			btnAnadirCompeticion.setIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoAñadir.png"))); //$NON-NLS-1$
			btnAnadirCompeticion.addActionListener(new BtnAnadirCompeticionActionListener());
			GridBagConstraints gbc_btnAnadirCompeticion = new GridBagConstraints();
			gbc_btnAnadirCompeticion.insets = new Insets(0, 0, 5, 5);
			gbc_btnAnadirCompeticion.gridx = 1;
			gbc_btnAnadirCompeticion.gridy = 1;
			getContentPane().add(btnAnadirCompeticion, gbc_btnAnadirCompeticion);
		}
		{
			btnModificar = new JButton(Messages.getString("PanelDeCompeticiones.btnModificar.text")); //$NON-NLS-1$
			btnModificar.setToolTipText(Messages.getString("PanelDeCompeticiones.btnModificar.toolTipText")); //$NON-NLS-1$
			btnModificar.setEnabled(false);
			btnModificar.addActionListener(new BtnModificarActionListener());
			btnModificar.setIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoModificar.png"))); //$NON-NLS-1$
			GridBagConstraints gbc_btnModificar = new GridBagConstraints();
			gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
			gbc_btnModificar.gridx = 2;
			gbc_btnModificar.gridy = 1;
			getContentPane().add(btnModificar, gbc_btnModificar);
		}
		{
			btnBorrar = new JButton(Messages.getString("PanelDeCompeticiones.btnBorrar.text")); //$NON-NLS-1$
			btnBorrar.setToolTipText(Messages.getString("PanelDeCompeticiones.btnBorrar.toolTipText")); //$NON-NLS-1$
			btnBorrar.setEnabled(false);
			btnBorrar.setIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoBorrar.png"))); //$NON-NLS-1$
			btnBorrar.addActionListener(new BtnBorrarActionListener());
			GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
			gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
			gbc_btnBorrar.gridx = 3;
			gbc_btnBorrar.gridy = 1;
			getContentPane().add(btnBorrar, gbc_btnBorrar);
		}
		{
			btnVerMapa = new JButton(Messages.getString("PanelDeCompeticiones.btnVerMapa.text")); //$NON-NLS-1$
			btnVerMapa.setToolTipText(Messages.getString("PanelDeCompeticiones.btnVerMapa.toolTipText")); //$NON-NLS-1$
			btnVerMapa.addActionListener(new BtnVerMapaActionListener());
			btnVerMapa.setEnabled(false);
			btnVerMapa.setIcon(new ImageIcon(PanelDeCompeticiones.class.getResource("/presentacion/imagenes/iconoVerMapa.png"))); //$NON-NLS-1$
			GridBagConstraints gbc_btnVerMapa = new GridBagConstraints();
			gbc_btnVerMapa.insets = new Insets(0, 0, 5, 0);
			gbc_btnVerMapa.gridx = 4;
			gbc_btnVerMapa.gridy = 1;
			getContentPane().add(btnVerMapa, gbc_btnVerMapa);
		}
		{
			pnlInformaciónCompeticiones = new JPanel();
			GridBagConstraints gbc_pnlInformaciónCompeticiones = new GridBagConstraints();
			gbc_pnlInformaciónCompeticiones.gridwidth = 5;
			gbc_pnlInformaciónCompeticiones.fill = GridBagConstraints.BOTH;
			gbc_pnlInformaciónCompeticiones.gridx = 0;
			gbc_pnlInformaciónCompeticiones.gridy = 2;
			getContentPane().add(pnlInformaciónCompeticiones, gbc_pnlInformaciónCompeticiones);
			GridBagLayout gbl_pnlInformaciónCompeticiones = new GridBagLayout();
			gbl_pnlInformaciónCompeticiones.columnWidths = new int[]{184, 29, 406, 0};
			gbl_pnlInformaciónCompeticiones.rowHeights = new int[]{138, 0};
			gbl_pnlInformaciónCompeticiones.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_pnlInformaciónCompeticiones.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			pnlInformaciónCompeticiones.setLayout(gbl_pnlInformaciónCompeticiones);
			{
				spCartel = new JScrollPane();
				GridBagConstraints gbc_spCartel = new GridBagConstraints();
				gbc_spCartel.insets = new Insets(0, 0, 0, 5);
				gbc_spCartel.fill = GridBagConstraints.BOTH;
				gbc_spCartel.gridx = 0;
				gbc_spCartel.gridy = 0;
				pnlInformaciónCompeticiones.add(spCartel, gbc_spCartel);
				{
					lblCartel = new JLabel(""); //$NON-NLS-1$
					lblCartel.setHorizontalAlignment(SwingConstants.CENTER);
					spCartel.setColumnHeaderView(lblCartel);
				}
			}
			{
				taInformacionCompeticion = new TextArea();
				taInformacionCompeticion.setEditable(false);
				GridBagConstraints gbc_taInformacionCompeticion = new GridBagConstraints();
				gbc_taInformacionCompeticion.fill = GridBagConstraints.BOTH;
				gbc_taInformacionCompeticion.gridx = 2;
				gbc_taInformacionCompeticion.gridy = 0;
				pnlInformaciónCompeticiones.add(taInformacionCompeticion, gbc_taInformacionCompeticion);
			}
		}
		
		ListSelectionModel rowSM =  tablaCompeticiones.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	   ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		        if (!lsm.isSelectionEmpty()) {
		        	
		        	MiTablaCompeticiones modeloTabla = (MiTablaCompeticiones) tablaCompeticiones.getModel();
		            int n= tablaCompeticiones.getSelectedRow();
		            if (n != -1) 
		            {
		            	String contenido = Messages.getString("PanelDeCompeticiones.9"); //$NON-NLS-1$
		                contenido += (Boolean) modeloTabla.getValueAt(n, 0)?Messages.getString("PanelDeCompeticiones.3"): Messages.getString("PanelDeCompeticiones.4"); //$NON-NLS-1$ //$NON-NLS-2$
		                contenido +="\n" + Messages.getString("PanelDeCompeticiones.12")+ modeloTabla.getValueAt(n, 1) +"\n"+  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		                Messages.getString("PanelDeCompeticiones.14")+ modeloTabla.getValueAt(n, 2) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeCompeticiones.16")+ modeloTabla.getValueAt(n, 3) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeCompeticiones.18")+ modeloTabla.getValueAt(n,4) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeCompeticiones.20")+ modeloTabla.getValueAt(n, 5) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeCompeticiones.22")+ modeloTabla.getValueAt(n, 6) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeCompeticiones.24")+ modeloTabla.getValueAt(n, 7) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeCompeticiones.26")+ modeloTabla.getValueAt(n, 8) +"\n"+ //$NON-NLS-1$ //$NON-NLS-2$
		                Messages.getString("PanelDeCompeticiones.28")+ modeloTabla.getValueAt(n,11); //$NON-NLS-1$
		                
		                taInformacionCompeticion.setText(contenido);
		        		lblCartel.setIcon((ImageIcon)modeloTabla.getValueAt(n, 9));
		            }    

		        }
		    }
		 });
		
		TableColumn columnaFinalizada = tablaCompeticiones.getColumnModel().getColumn(0);
		JCheckBox finalizada = new JCheckBox();
		columnaFinalizada.setCellEditor(new DefaultCellEditor(finalizada));
		
		TableColumn columnaModalidad = tablaCompeticiones.getColumnModel().getColumn(2);
		JComboBox modalidad = new JComboBox();
		modalidad.setModel(new DefaultComboBoxModel(new String[] {Messages.getString("PanelDeCompeticiones.29"), "Biathlon", Messages.getString("PanelDeCompeticiones.0"), Messages.getString("PanelDeCompeticiones.1")})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		columnaModalidad.setCellEditor(new DefaultCellEditor(modalidad));
		
		TableColumn columnaCartel = tablaCompeticiones.getColumnModel().getColumn(9);
		columnaCartel.setCellEditor(new ColumnaFotoEditor());
		
		TableColumn columnaMapa = tablaCompeticiones.getColumnModel().getColumn(10);
		columnaMapa.setCellEditor(new ColumnaFotoEditor());
		
		spCompeticiones.setViewportView(tablaCompeticiones);

	}

	private class BtnAnadirCompeticionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnModificar.setEnabled(true);
			btnBorrar.setEnabled(true);
			btnVerMapa.setEnabled(true);
			MiTablaCompeticiones modeloTabla = (MiTablaCompeticiones) tablaCompeticiones.getModel();
			Object[] nuevaFila ={false, "...", "...","DD/MM/AAAA HH:MM","DD/MM/AAAA",null,"...","...","...", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
					new ImageIcon(getClass().getClassLoader().getResource("presentacion/imagenes/iconoCartel.png")), //$NON-NLS-1$
					new ImageIcon(getClass().getClassLoader().getResource("presentacion/imagenes/iconoMapa.png")),"..."}; //$NON-NLS-1$ //$NON-NLS-2$
			
			modeloTabla.aniadeFila(nuevaFila);
			modeloTabla.fireTableDataChanged();
		}
	}
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tablaCompeticiones.getSelectedRow()!=-1){
				Object[] seleccion = new Object[] { Messages.getString("PanelDeCompeticiones.6"), Messages.getString("PanelDeCompeticiones.7") }; //$NON-NLS-1$ //$NON-NLS-2$
				int respuesta = JOptionPane.showOptionDialog(null,Messages.getString("PanelDeCompeticiones.2"), //$NON-NLS-1$
						Messages.getString("PanelDeCompeticiones.44"), JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, //$NON-NLS-1$
						null,seleccion,0); //$NON-NLS-1$ //$NON-NLS-2$
				if(respuesta == JOptionPane.YES_OPTION){
					MiTablaCompeticiones modeloTabla = (MiTablaCompeticiones) tablaCompeticiones.getModel();
					int n= tablaCompeticiones.getSelectedRow();
					if (n != -1) modeloTabla.eliminaFila(tablaCompeticiones.getSelectedRow());
					modeloTabla.fireTableDataChanged();
				
					taInformacionCompeticion.setText(" "); //$NON-NLS-1$
					lblCartel.setIcon(null);
				
				}
			}
			else{
				JOptionPane.showMessageDialog(null, Messages.getString("PanelDeCompeticiones.46"), Messages.getString("PanelDeCompeticiones.47"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}

		}
	}
	private class TablaCompeticionesMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			String competicionSeleccionada;
			int id = 0;
			
			btnModificar.setEnabled(true);
			btnBorrar.setEnabled(true);
			btnVerMapa.setEnabled(true);
				
			competicionSeleccionada = (String) tablaCompeticiones.getValueAt(tablaCompeticiones.getSelectedRow(), 1);
			
			for(int i = 0; i < listCompeticiones.size(); i++)
				if(listCompeticiones.get(i).getNombre().equals(competicionSeleccionada))
					id = listCompeticiones.get(i).getIdCompeticion();
			
			Principal.mostrarParticipantes(id);
			
		
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object[] seleccion = new Object[] { Messages.getString("PanelDeCompeticiones.11"), Messages.getString("PanelDeCompeticiones.13") }; //$NON-NLS-1$ //$NON-NLS-2$
			int respuesta = JOptionPane.showOptionDialog(null,Messages.getString("PanelDeCompeticiones.48"),Messages.getString("PanelDeCompeticiones.49"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,null,seleccion,0); //$NON-NLS-1$ //$NON-NLS-2$
			if(respuesta == JOptionPane.YES_OPTION){
				/*Se guardan los cambios*/
			}
			else{
				/*No se guardan los cambios*/
			}
		}
	}
	private class BtnVerMapaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(tablaCompeticiones.getSelectedRow() != -1){
				editorMapa.setBounds(100, 100, 700, 700);
				String competicionSeleccionada = (String) tablaCompeticiones.getValueAt(tablaCompeticiones.getSelectedRow(), 1);
				String mapa = null;
				for(int i = 0; i < listCompeticiones.size(); i++)
					if(listCompeticiones.get(i).getNombre().equals(competicionSeleccionada))
						mapa = listCompeticiones.get(i).getMapa();

				editorMapa.setRutaMapa(mapa);
				editorMapa.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, Messages.getString("PanelDeCompeticiones.50"), Messages.getString("PanelDeCompeticiones.51"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}
	
	public void mostrarInformacion() {
		
		for (int i = 0; i < listCompeticiones.size(); i++){
			MiTablaCompeticiones modeloTabla = (MiTablaCompeticiones) tablaCompeticiones.getModel();
			
			Object[] competicion = {listCompeticiones.get(i).isFinalizada(),listCompeticiones.get(i).getNombre(),
					listCompeticiones.get(i).getModalidad(), listCompeticiones.get(i).getFechaHora(),
					listCompeticiones.get(i).getFechaLimite(), listCompeticiones.get(i).getDistancia(),
					listCompeticiones.get(i).getLocalidad(), listCompeticiones.get(i).getEntidadorganizadora(),
					listCompeticiones.get(i).getWeb(), new ImageIcon(getClass().getClassLoader().getResource(listCompeticiones.get(i).getCartel())),
					new ImageIcon(getClass().getClassLoader().getResource(listCompeticiones.get(i).getMapa())), listCompeticiones.get(i).getDescripcion()};
			
			modeloTabla.aniadeFila(competicion);
			
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
