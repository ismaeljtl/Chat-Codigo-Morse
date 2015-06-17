package com.ucab.javachat.Cliente.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VentIniciarSesion extends JFrame{

	public JFrame frmInicioDeSesion;
	public JTextField txtUsuario;
	public JPasswordField txtClave;
	public JButton btnContrasena, btnArchivo, btnEnviar, btnRegistro;
	
	
	public VentIniciarSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicioDeSesion = new JFrame();
		frmInicioDeSesion.setTitle("Inicio de sesión");
		frmInicioDeSesion.setBounds(100, 100, 257, 325);
		frmInicioDeSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicioDeSesion.getContentPane().setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("Inicio de Sesión");
		lblIniciarSesion.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIniciarSesion.setBounds(40, 21, 200, 15);
		frmInicioDeSesion.getContentPane().add(lblIniciarSesion);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(20, 80, 70, 15);
		frmInicioDeSesion.getContentPane().add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(20, 106, 70, 15);
		frmInicioDeSesion.getContentPane().add(lblClave);
		
		JLabel lblFoto = new JLabel("Foto:");
		lblFoto.setBounds(20, 132, 70, 15);
		frmInicioDeSesion.getContentPane().add(lblFoto);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(84, 78, 128, 17);
		frmInicioDeSesion.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(84, 103, 128, 19);
		frmInicioDeSesion.getContentPane().add(txtClave);
		txtClave.setColumns(10);
		
		btnContrasena = new JButton("Recuperar contraseña");
		btnContrasena.setBounds(20, 178, 200, 25);
		frmInicioDeSesion.getContentPane().add(btnContrasena);
		
		btnEnviar = new JButton("Iniciar sesión");
		btnEnviar.setBounds(20, 250, 200, 25);
		frmInicioDeSesion.getContentPane().add(btnEnviar);
		
		btnArchivo = new JButton("Seleccionar");
		btnArchivo.setBounds(84, 127, 128, 25);
		frmInicioDeSesion.getContentPane().add(btnArchivo);
		
		btnRegistro = new JButton("Registrar");
		btnRegistro.setBounds(20, 214, 200, 25);
		frmInicioDeSesion.getContentPane().add(btnRegistro);
	}
}
