package ejercicio6;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.*;

import javax.swing.JTextArea;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Calculadora extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_pantalla;
	private String historial = "";
	private JTextField txt_resultado;
	private String texto = "";
	private boolean yaoperado = false;
	
	private Operacion o = new Operacion();
	private JTextArea txt_historial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculadora() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_pantalla = new JTextField();
		txt_pantalla.setEditable(false);
		txt_pantalla.setBounds(10, 11, 199, 35);
		contentPane.add(txt_pantalla);
		txt_pantalla.setColumns(10);
		
		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(this);
		btn_1.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_1.setBounds(10, 99, 40, 40);
		contentPane.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(this);
		btn_2.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_2.setBounds(59, 99, 40, 40);
		contentPane.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(this);
		btn_3.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_3.setBounds(109, 99, 40, 40);
		contentPane.add(btn_3);
		
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(this);
		btn_4.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_4.setBounds(10, 150, 40, 40);
		contentPane.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(this);
		btn_5.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_5.setBounds(59, 150, 40, 40);
		contentPane.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(this);
		btn_6.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_6.setBounds(109, 150, 40, 40);
		contentPane.add(btn_6);
		
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(this);
		btn_7.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_7.setBounds(10, 201, 40, 40);
		contentPane.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(this);
		btn_8.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_8.setBounds(59, 201, 40, 40);
		contentPane.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(this);
		btn_9.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_9.setBounds(109, 201, 40, 40);
		contentPane.add(btn_9);
		
		JButton btn_punto = new JButton(".");
		btn_punto.addActionListener(this);
		btn_punto.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_punto.setBounds(10, 252, 40, 40);
		contentPane.add(btn_punto);
		
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(this);
		btn_0.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_0.setBounds(59, 252, 40, 40);
		contentPane.add(btn_0);
		
		JButton btn_igual = new JButton("M");
		btn_igual.setBackground(new Color(255, 153, 102));
		btn_igual.addActionListener(this);
		btn_igual.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_igual.setBounds(109, 252, 50, 40);
		contentPane.add(btn_igual);
		
		JButton btn_suma = new JButton("+");
		btn_suma.addActionListener(this);
		btn_suma.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_suma.setBounds(169, 99, 40, 40);
		contentPane.add(btn_suma);
		
		JButton btn_resta = new JButton("-");
		btn_resta.addActionListener(this);
		btn_resta.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_resta.setBounds(169, 150, 40, 40);
		contentPane.add(btn_resta);
		
		JButton btn_multiplicacion = new JButton("*");
		btn_multiplicacion.addActionListener(this);
		btn_multiplicacion.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_multiplicacion.setBounds(169, 201, 40, 40);
		contentPane.add(btn_multiplicacion);
		
		JButton btn_division = new JButton("/");
		btn_division.addActionListener(this);
		btn_division.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btn_division.setBounds(169, 252, 40, 40);
		contentPane.add(btn_division);
		
		txt_resultado = new JTextField();
		txt_resultado.setEditable(false);
		txt_resultado.setColumns(10);
		txt_resultado.setBounds(10, 53, 139, 35);
		contentPane.add(txt_resultado);
		
		JLabel lblNewLabel = new JLabel("operacion en el historial:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel.setBounds(228, 22, 193, 24);
		contentPane.add(lblNewLabel);
		
		JButton btn_borrar = new JButton("CE");
		btn_borrar.setBackground(new Color(51, 204, 51));
		btn_borrar.addActionListener(this);
		btn_borrar.setFont(new Font("Arial", Font.BOLD, 10));
		btn_borrar.setBounds(159, 53, 50, 35);
		contentPane.add(btn_borrar);
		
		JLabel lblPulsePara = new JLabel("Pulse \"M\" para guardar la");
		lblPulsePara.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblPulsePara.setBounds(228, 11, 193, 19);
		contentPane.add(lblPulsePara);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 48, 165, 216);
		contentPane.add(scrollPane);
		
		txt_historial = new JTextArea();
		scrollPane.setViewportView(txt_historial);
		txt_historial.setEditable(false);
		
		JButton btn_borrarHistorial = new JButton("Limpiar Historial");
		btn_borrarHistorial.addActionListener(this);
		btn_borrarHistorial.setBackground(new Color(51, 153, 255));
		btn_borrarHistorial.setBounds(219, 269, 165, 23);
		contentPane.add(btn_borrarHistorial);
		
	
	}
	private void colocaNumero(int num) {
		texto += num;
		txt_pantalla.setText(texto);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		switch(b.getText()) {
			case "1":
				colocaNumero(1);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "2":
				colocaNumero(2);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "3":
				colocaNumero(3);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "4":
				colocaNumero(4);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "5":
				colocaNumero(5);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "6":
				colocaNumero(6);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "7":
				colocaNumero(7);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "8":
				colocaNumero(8);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "9":
				colocaNumero(9);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "0":
				colocaNumero(0);
				txt_resultado.setText(o.dameResultado(texto));
				break;
			case "+":
				siguienteOperacion(yaoperado, "+");
				break;
			case "-":
				siguienteOperacion(yaoperado, "-");
				break;
			case "*":
				siguienteOperacion(yaoperado, "*");
				break;
			case "/":
				siguienteOperacion(yaoperado, "/");
				break;
			case ".":
				if(o.getOperador() != null && !o.getOperador().isBlank()) {
					String[] aux = texto.split("\\" + o.getOperador());
					if(!aux[aux.length - 1].contains(".") && !aux[aux.length - 1].isBlank()) {
						texto += ".";
						txt_pantalla.setText(texto);
						txt_resultado.setText(o.dameResultado(texto));
					}
				}else if (!texto.contains(".") && texto.length() > 0) {
					texto += ".";
					txt_pantalla.setText(texto);
					txt_resultado.setText(o.dameResultado(texto));
				}
				break;
			case "M":
				txt_pantalla.setText(texto);
				txt_resultado.setText(o.dameResultado(texto));
				if(!texto.isBlank()) {
				historial += o.getOperacion() + o.dameResultado(texto) + "\n";
				txt_historial.setText(historial);
				}
				break;
			case "CE":
				o.vaciarOperador();
				texto = "";
				txt_pantalla.setText(texto);
				txt_resultado.setText(texto);
				break;
			case "Limpiar Historial":
				texto = "";
				historial = "";
				txt_historial.setText(texto);
				txt_pantalla.setText(texto);
				txt_resultado.setText(texto);
		}
	}
	
	private void siguienteOperacion(boolean yaOperado, String operacion) {
		if(yaoperado) {
			texto = txt_resultado.getText().replace("= ", "") + " " + operacion + " ";
			txt_pantalla.setText(texto);
		}else {
			texto += " " + operacion + " ";
			txt_pantalla.setText(texto);
			yaoperado = true;
		}
	}
}
