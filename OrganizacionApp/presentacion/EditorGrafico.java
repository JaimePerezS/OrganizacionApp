package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditorGrafico extends JFrame {

	private JPanel contentPane;
	private JToolBar tbBarraDibujo;
	private JButton btnBtnrectangulo;
	private JButton btnComentario;
	private JScrollPane scrollPane;
	private MiAreaDibujo miAreaDibujo;
	private JPanel pnlBotones;
	private JButton btnGuardar;
	
	private String rutaMapa;

	public void setRutaMapa(String rutaMapa) {
		this.rutaMapa = rutaMapa;
		mostrarMapa();
	}
	
	private void mostrarMapa() {
		miAreaDibujo.setIcon( new ImageIcon(getClass().getClassLoader().getResource(rutaMapa)));
		
	}

	//Variable que almacena el modo de dibujado seleccionado por el usuario
		int modo = -1;
		
		private final int PARADA = 1;
		private final int CRITICO = 2;
		private final int RECTANGULO = 3;
		private final int TEXTO = 4;
		private final int LINEA = 7;
		private final int INICIO = 6;
		private final int META = 5;
		
		//Cursores e imagenes
		private Toolkit toolkit;
		private Image imagRectangulo;
		private Image imagTexto;
		private Image imagParada;
		private Image imagCritico;
		private Image imagLinea;
		private Image imagInicio;
		private Image imagMeta;
		private Image imagLineaPuntero;
		private Cursor cursorRectangulo;
		private Cursor cursorTexto;
		private Cursor cursorParada;
		private Cursor cursorCritico;
		private Cursor cursorLinea;
		private Cursor cursorInicio;
		private Cursor cursorMeta;
		
		//Variables para almacenar las coordenadas actuales
		private int x, y;
		
		//Componente de entrada de texto que permitirá añadir anotaciones (dibujar texto) sobre la imagen
		private JTextField txtTexto = new JTextField();
		private JButton btnLinea;
		private JButton btnInicio;
		private JButton btnMeta;
		private JButton btnPuntoParada;
		private JButton btnPuntoCrtico;
		private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorGrafico frame = new EditorGrafico();
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
	public EditorGrafico() {
		addWindowListener(new ThisWindowListener());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			tbBarraDibujo = new JToolBar();
			tbBarraDibujo.setRollover(true);
			contentPane.add(tbBarraDibujo, BorderLayout.NORTH);
			{
				btnBtnrectangulo = new JButton(Messages.getString("EditorGrafico.btnBtnrectangulo.text")); //$NON-NLS-1$
				btnBtnrectangulo.setToolTipText(Messages.getString("EditorGrafico.btnBtnrectangulo.toolTipText")); //$NON-NLS-1$
				btnBtnrectangulo.addActionListener(new BtnBtnrectanguloActionListener());
				btnBtnrectangulo.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/imagenes/rectangulo.png"))); //$NON-NLS-1$
				tbBarraDibujo.add(btnBtnrectangulo);
			}
			{
				btnComentario = new JButton(Messages.getString("EditorGrafico.btnComentario.text")); //$NON-NLS-1$
				btnComentario.setToolTipText(Messages.getString("EditorGrafico.btnComentario.toolTipText")); //$NON-NLS-1$
				btnComentario.addActionListener(new BtnComentarioActionListener());
				btnComentario.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/imagenes/aniadirAnotacion.png"))); //$NON-NLS-1$
				tbBarraDibujo.add(btnComentario);
			}
			{
				btnLinea = new JButton(Messages.getString("EditorGrafico.btnLinea.text")); //$NON-NLS-1$
				btnLinea.setToolTipText(Messages.getString("EditorGrafico.btnLinea.toolTipText")); //$NON-NLS-1$
				btnLinea.addActionListener(new BtnLineaActionListener());
				btnLinea.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/imagenes/pencil1.png"))); //$NON-NLS-1$
				tbBarraDibujo.add(btnLinea);
			}
			{
				btnInicio = new JButton(Messages.getString("EditorGrafico.btnInicio.text")); //$NON-NLS-1$
				btnInicio.setToolTipText(Messages.getString("EditorGrafico.btnInicio.toolTipText")); //$NON-NLS-1$
				btnInicio.addActionListener(new BtnInicioActionListener());
				btnInicio.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/imagenes/iconoInicio.png"))); //$NON-NLS-1$
				tbBarraDibujo.add(btnInicio);
			}
			{
				btnMeta = new JButton(Messages.getString("EditorGrafico.btnMeta.text")); //$NON-NLS-1$
				btnMeta.setToolTipText(Messages.getString("EditorGrafico.btnMeta.toolTipText")); //$NON-NLS-1$
				btnMeta.addActionListener(new BtnMetaActionListener());
				btnMeta.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/imagenes/red-dot.png"))); //$NON-NLS-1$
				tbBarraDibujo.add(btnMeta);
			}
			{
				btnPuntoParada = new JButton(Messages.getString("EditorGrafico.btnPuntoParada.text")); //$NON-NLS-1$
				btnPuntoParada.setToolTipText(Messages.getString("EditorGrafico.btnPuntoParada.toolTipText")); //$NON-NLS-1$
				btnPuntoParada.addActionListener(new BtnPuntoParadaActionListener());
				btnPuntoParada.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/imagenes/55-flag.png"))); //$NON-NLS-1$
				tbBarraDibujo.add(btnPuntoParada);
			}
			{
				btnPuntoCrtico = new JButton(Messages.getString("EditorGrafico.btnPuntoCrtico.text")); //$NON-NLS-1$
				btnPuntoCrtico.setToolTipText(Messages.getString("EditorGrafico.btnPuntoCrtico.toolTipText")); //$NON-NLS-1$
				btnPuntoCrtico.addActionListener(new BtnPuntoCrticoActionListener());
				btnPuntoCrtico.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/imagenes/redpushpin.png"))); //$NON-NLS-1$
				tbBarraDibujo.add(btnPuntoCrtico);
			}
			{
				btnBorrar = new JButton(Messages.getString("EditorGrafico.button.text")); //$NON-NLS-1$
				btnBorrar.setToolTipText(Messages.getString("EditorGrafico.btnBorrar.toolTipText")); //$NON-NLS-1$
				btnBorrar.addActionListener(new BtnBorrarActionListener());
				btnBorrar.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/imagenes/iconoBorrarElementosMapa.png"))); //$NON-NLS-1$
				tbBarraDibujo.add(btnBorrar);
			}
		}
		{
			scrollPane = new JScrollPane();
			contentPane.add(scrollPane, BorderLayout.CENTER);
			
			miAreaDibujo = new MiAreaDibujo();
			miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
			miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
				
			scrollPane.setViewportView(miAreaDibujo);
				
				
			//Creación de imágenes y cursores
			toolkit = Toolkit.getDefaultToolkit();
			imagRectangulo =
			toolkit.getImage(getClass().getClassLoader().getResource("presentacion/imagenes/rectangulo.png")); //$NON-NLS-1$
			imagTexto =
			toolkit.getImage(getClass().getClassLoader().getResource("presentacion/imagenes/aniadirAnotacion.png")); //$NON-NLS-1$
			imagParada =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/imagenes/55-flag.png")); //$NON-NLS-1$
			imagCritico =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/imagenes/redpushpin.png")); //$NON-NLS-1$
			imagLinea =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/imagenes/pencil1.png")); //$NON-NLS-1$
			imagInicio =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/imagenes/iconoInicio.png")); //$NON-NLS-1$
			imagMeta =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/imagenes/red-dot.png")); //$NON-NLS-1$
			imagLineaPuntero = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/imagenes/pencil.png")); //$NON-NLS-1$

				
			//Creación de los cursores
			cursorRectangulo = toolkit.createCustomCursor(imagRectangulo,new Point(0,0),"CURSOR_RECTANGULO"); //$NON-NLS-1$
			cursorTexto= toolkit.createCustomCursor(imagTexto,new Point(0,0),"CURSOR_TEXTO"); //$NON-NLS-1$
			cursorParada= toolkit.createCustomCursor(imagParada,new Point(0,0),"CURSOR_PARADA"); //$NON-NLS-1$
			cursorCritico= toolkit.createCustomCursor(imagCritico,new Point(0,0),"CURSOR_CRITICO"); //$NON-NLS-1$
			cursorLinea= toolkit.createCustomCursor(imagLineaPuntero,new Point(0,0),"CURSOR_LINEA"); //$NON-NLS-1$
			cursorInicio= toolkit.createCustomCursor(imagInicio,new Point(0,0),"CURSOR_INICIO"); //$NON-NLS-1$
			cursorMeta= toolkit.createCustomCursor(imagMeta,new Point(0,0),"CURSOR_META"); //$NON-NLS-1$
				
			
		}
		{
			pnlBotones = new JPanel();
			contentPane.add(pnlBotones, BorderLayout.SOUTH);
			GridBagLayout gbl_pnlBotones = new GridBagLayout();
			gbl_pnlBotones.columnWidths = new int[]{560, 0, 0};
			gbl_pnlBotones.rowHeights = new int[]{23, 0};
			gbl_pnlBotones.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			gbl_pnlBotones.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pnlBotones.setLayout(gbl_pnlBotones);
			{
				btnGuardar = new JButton(Messages.getString("EditorGrafico.btnGuardar.text")); //$NON-NLS-1$
				btnGuardar.setToolTipText(Messages.getString("EditorGrafico.btnGuardar.toolTipText")); //$NON-NLS-1$
				btnGuardar.addActionListener(new BtnGuardarActionListener());
				btnGuardar.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/imagenes/iconoGuardar.png"))); //$NON-NLS-1$
				GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
				gbc_btnGuardar.gridx = 1;
				gbc_btnGuardar.gridy = 0;
				pnlBotones.add(btnGuardar, gbc_btnGuardar);
			}
		}
	}
	
	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			toolkit = Toolkit.getDefaultToolkit();
			if (rutaMapa != null){
				switch (modo){
						
					case RECTANGULO:
						miAreaDibujo.addObjetoGrafico(new RectanguloGrafico(x,y,x,y,Color.RED));
						break;
					case PARADA:
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagParada));
						miAreaDibujo.repaint();
						break;
					case CRITICO:
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagCritico));
						miAreaDibujo.repaint();
						break;
					case LINEA:
						miAreaDibujo.addObjetoGrafico(new LineaGrafico(x,y,x,y,Color.BLUE));
						break;
					case INICIO:
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagInicio));
						miAreaDibujo.repaint();
						break;
					case META:
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagMeta));
						miAreaDibujo.repaint();
						break;
						
					case TEXTO:
						txtTexto.setBounds(x, y, 200,30);
						txtTexto.setVisible(true);
						txtTexto.requestFocus();
						txtTexto.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg) {
								if(!txtTexto.getText().equals("")) //$NON-NLS-1$
									miAreaDibujo.addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText(), Color.BLUE));
								txtTexto.setText(""); //$NON-NLS-1$
								txtTexto.setVisible(false);
								miAreaDibujo.repaint();
							}
						});
						miAreaDibujo.add(txtTexto);
				}
			}
		}
	}
	
	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == RECTANGULO && rutaMapa!=null) {
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
			}
			if (modo == LINEA && rutaMapa!=null) {
				((LineaGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((LineaGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
			}
		}
	}
	
	private class BtnBtnrectanguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = RECTANGULO;
			contentPane.setCursor(cursorRectangulo);
		}
	}
	private class BtnComentarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = TEXTO;
			contentPane.setCursor(cursorTexto);
		}
	}
	private class BtnLineaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = LINEA;
			contentPane.setCursor(cursorLinea);
		}
	}
	private class BtnInicioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = INICIO;
			contentPane.setCursor(cursorInicio);
		}
	}
	private class BtnMetaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = META;
			contentPane.setCursor(cursorMeta);
		}
	}
	private class BtnPuntoParadaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = PARADA;
			contentPane.setCursor(cursorParada);
		}
	}
	private class BtnPuntoCrticoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = CRITICO;
			contentPane.setCursor(cursorCritico);
		}
	}
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			Object[] seleccion = new Object[] { Messages.getString("EditorGrafico.0"), Messages.getString("EditorGrafico.1") }; //$NON-NLS-1$ //$NON-NLS-2$
			int respuesta = JOptionPane.showOptionDialog(null,Messages.getString("EditorGrafico.25"),Messages.getString("EditorGrafico.26"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,null,
					seleccion,0); //$NON-NLS-1$ //$NON-NLS-2$
			if(respuesta == JOptionPane.YES_OPTION){
				miAreaDibujo.removeObjetosGraficos();
				miAreaDibujo.repaint();
				dispose();
			}
			else{
				
			}
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Object[] seleccion = new Object[] { Messages.getString("EditorGrafico.4"), Messages.getString("EditorGrafico.5") }; //$NON-NLS-1$ //$NON-NLS-2$
			int respuesta = JOptionPane.showOptionDialog(null,Messages.getString("EditorGrafico.27"),Messages.getString("EditorGrafico.28"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,null,
					seleccion,0); 
			if(respuesta == JOptionPane.YES_OPTION){
				dispose();
				miAreaDibujo.removeObjetosGraficos();
				miAreaDibujo.repaint();
			}
			else{
				
			}
		}
	}
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Object[] seleccion = new Object[]{Messages.getString("EditorGrafico.3"),Messages.getString("EditorGrafico.6")}; //$NON-NLS-1$ //$NON-NLS-2$
			int respuesta = JOptionPane.showOptionDialog(null, Messages.getString("EditorGrafico.7") //$NON-NLS-1$
					,Messages.getString("EditorGrafico.8"), JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,null, //$NON-NLS-1$
					seleccion,0);
			if(respuesta == JOptionPane.YES_OPTION){
			    miAreaDibujo.removeObjetosGraficos();
			    miAreaDibujo.repaint();
			   }
			   else{
				   
			   }
		}
	}
}
