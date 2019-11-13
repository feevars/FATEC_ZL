package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class QuadroPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private FormFuncionario formFuncionario;
	public QuadroPrincipal() {
		
		super("Funcionários");
		
		setLayout(new BorderLayout());
		
		formFuncionario = new FormFuncionario();
		
		add(formFuncionario, BorderLayout.WEST);
		
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}