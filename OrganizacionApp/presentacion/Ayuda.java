package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class Ayuda extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrParaObtenerMs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda frame = new Ayuda();
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
	public Ayuda() {
		setResizable(false);
		setTitle(Messages.getString("Ayuda.this.title")); //$NON-NLS-1$
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ayuda.class.getResource("/presentacion/imagenes/logo.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			txtrParaObtenerMs = new JTextArea();
			txtrParaObtenerMs.setEditable(false);
			txtrParaObtenerMs.setText(Messages.getString("Ayuda.txtrParaObtenerMs.text")); //$NON-NLS-1$
			contentPane.add(txtrParaObtenerMs, BorderLayout.CENTER);
		}
	}

}
