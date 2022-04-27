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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class APP_PSEGURA_REGISTRO extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCodigo;
	JComboBox cboCarrera;
	private JTextField txtNombre;
	private JTextField txtSexo;
	private JTextField txtEdad;
	private JTextField txtApellido;
	private JTextField txtPeso;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APP_PSEGURA_REGISTRO frame = new APP_PSEGURA_REGISTRO();
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
	public APP_PSEGURA_REGISTRO() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(536, 251, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 188, 506, 187);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char M = e.getKeyChar();
				
				if(M<'0' || M>'9') {
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingrese solo números");
				}
			}
		});
		txtCodigo.setBounds(104, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo Alumno:");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCarrera = new JComboBox();
		cboCarrera.setBounds(439, 134, 186, 22);
		contentPane.add(cboCarrera);
		
		JLabel lblCarrera = new JLabel("Carrera :");
		lblCarrera.setBounds(327, 138, 102, 14);
		contentPane.add(lblCarrera);
		
		JLabel lblNombre = new JLabel("Nombres :");
		lblNombre.setBounds(10, 45, 102, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length() >= 50)
			    {
			        e.consume();
			        JOptionPane.showMessageDialog(null, "Solo puede ingresar 50 carácteres");
			    }
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(104, 39, 144, 20);
		contentPane.add(txtNombre);
		
		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setBounds(10, 86, 89, 14);
		contentPane.add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtSexo.getText().length() >= 50)
			    {
			        e.consume();
			        JOptionPane.showMessageDialog(null, "Solo puede ingresar 50 carácteres");
			    }
			}
		});
		txtSexo.setColumns(10);
		txtSexo.setBounds(104, 83, 144, 20);
		contentPane.add(txtSexo);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setBounds(327, 86, 102, 14);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char M = e.getKeyChar();
				
				if(M<'0' || M>'9') {
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingrese solo números");
				}
			}
		});
		txtEdad.setColumns(10);
		txtEdad.setBounds(439, 83, 77, 20);
		contentPane.add(txtEdad);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(327, 40, 102, 14);
		contentPane.add(lblApellidos);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtApellido.getText().length() >= 50)
			    {
			        e.consume();
			        JOptionPane.showMessageDialog(null, "Solo puede ingresar 50 carácteres");
			    }			    	
			}
		});
		txtApellido.setColumns(10);
		txtApellido.setBounds(438, 37, 213, 20);
		contentPane.add(txtApellido);
		
		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setBounds(10, 138, 89, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char M = e.getKeyChar();
				
				if((M<'0' || M>'9') && (M == '.' )){
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingrese solo números");
				}
					
			}
		});
		txtPeso.setColumns(10);
		txtPeso.setBounds(104, 135, 77, 20);
		contentPane.add(txtPeso);
		
		llenaCombo();
	}
	

	void llenaCombo() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();

		// -- combo categorias

		TypedQuery<Carrera> consulta = 

				em.createQuery("select u from Carrera u", Carrera.class);

		List<Carrera> lstCarrera = consulta.getResultList();

		cboCarrera.addItem("Seleccionar...");
		for(Carrera c : lstCarrera){
			cboCarrera.addItem(c.getIdescripcion());
		}
		
		em.close();
		
	}
	
	void registrar() {
		
		// entradas

				int idcodigo = Integer.parseInt(txtCodigo.getText());

				String nombre = txtNombre.getText();
				
				String apellido = txtApellido.getText();
				
				String sexo = txtSexo.getText();

				int edad = Integer.parseInt(txtEdad.getText());
				
				double peso = Double.parseDouble(txtPeso.getText());

				int carrera = cboCarrera.getSelectedIndex();


				Alumnos p = new Alumnos();

				p.setIdcod(idcodigo);

				p.setInombre(nombre);

				p.setIapellido(apellido);

				p.setIsexo(sexo);
				
				p.setIedad(edad);

				p.setIpeso(peso);

				p.setIdcar(carrera);

				

				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

				EntityManager em = fabrica.createEntityManager();

				em.getTransaction().begin();

				em.persist(p);

				em.getTransaction().commit();


				em.close();

				txtSalida.setText("Alumno registrado..!");

	}
}
