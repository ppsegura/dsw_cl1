package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Alumnos;
import model.Carrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class APP_PSEGURA_CONSULTA extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCodigo;
	private JTextField txtApellido;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APP_PSEGURA_CONSULTA frame = new APP_PSEGURA_CONSULTA();
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
	public APP_PSEGURA_CONSULTA() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnListado = new JButton("Listar");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnListado.setBounds(511, 186, 89, 23);
		contentPane.add(btnListado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 470, 270);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(132, 39, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo Alumno:");
		lblCodigo.setBounds(10, 42, 102, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(299, 42, 102, 14);
		contentPane.add(lblApellidos);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(387, 39, 213, 20);
		contentPane.add(txtApellido);

	}

	void llenaCombo() {
		
	}
	
	void registrar() {
		

	}
	
	void listado() {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		// -- combo categorias

		TypedQuery<Alumnos> consulta = 

				em.createQuery("select u from alumnos u", Alumnos.class);

		List<Alumnos> lstAlumnos = consulta.getResultList();

		txtSalida.setText("");

		for (Alumnos p : lstAlumnos) {

			txtSalida.append("Código....: " + p.getIdcod()+"\n");

			txtSalida.append("Nombre....: " + p.getInombre()+"\n");

			txtSalida.append("Precio....: " + p.getIapellido()+"\n");
			
			txtSalida.append("Proveedor.: " + p.getIedad()+"\n");

			txtSalida.append("Categoría.: " + p.getIsexo()+"\n");
			
			txtSalida.append("Categoría.: " + p.getIdcar()+"\n");

			txtSalida.append("****************************************\n");

		}

	}
}
