package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.ListaDupla;
import model.Aluno;

public class FormAluno extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel labelNome;
	private JTextField campoNome;
	private JLabel labelCurso;
	private JTextField campoCurso;
	private JLabel labelSemestre;
	private JComboBox<String> listaSemestre;

	private JButton btnInicio;
	private JButton btnFinal;
	private JButton btnPosicao;

	private ListenerFormAluno formListener;

	public FormAluno(ListaDupla<Aluno> listaAluno) {

		this.labelNome = new JLabel("Nome:");
		this.campoNome = new JTextField(64);
		this.labelCurso = new JLabel("Curso:");
		this.campoCurso = new JTextField(40);
		this.labelSemestre = new JLabel("Semestre:");
		this.listaSemestre = new JComboBox<String>();

		this.listaSemestre.addItem("1");
		this.listaSemestre.addItem("2");
		this.listaSemestre.addItem("3");
		this.listaSemestre.addItem("4");
		this.listaSemestre.addItem("5");
		this.listaSemestre.addItem("6");

		this.btnInicio = new JButton("<html><p align=\"center\">Inserir no in�cio</p></html>");
		this.btnFinal = new JButton("<html><p align=\"center\">Inserir no final</p></html>");
		this.btnPosicao = new JButton("<html><p align=\"center\">Inserir na posi��o</p></html>");

		JPanel painelSemestre = new JPanel();
		painelSemestre.setLayout(new BoxLayout(painelSemestre, BoxLayout.X_AXIS));
		painelSemestre.add(labelSemestre);
		painelSemestre.add(listaSemestre);

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
		painelBotoes.add(btnInicio);
		painelBotoes.add(btnFinal);
		painelBotoes.add(btnPosicao);

		// Inserir na primeira posi��o
		this.btnInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Aluno novoAluno = new Aluno(listaAluno.getContaId(), campoNome.getText(), campoCurso.getText(),
						(listaSemestre.getSelectedIndex() + 1));
				listaAluno.adicionaPrimeira(novoAluno);
				EventoFormAluno ev = new EventoFormAluno(this, listaAluno.listaString());
				formListener.FormEventOcurred(ev);
				limpaCampos();
			}
		});

		// Inserir na �ltima posi��o
		this.btnFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Aluno novoAluno = new Aluno(listaAluno.getContaId(), campoNome.getText(), campoCurso.getText(),
						(listaSemestre.getSelectedIndex() + 1));
				listaAluno.adicionaUltima(novoAluno);
				EventoFormAluno ev = new EventoFormAluno(this, listaAluno.listaString());
				formListener.FormEventOcurred(ev);
				limpaCampos();
			}
		});

		// Inserir em qualquer posi��o
		this.btnPosicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Aluno novoAluno = new Aluno(listaAluno.getContaId(), campoNome.getText(), campoCurso.getText(),
						(listaSemestre.getSelectedIndex() + 1));
				int posicao = Integer.parseInt(
						JOptionPane.showInputDialog("Digite a posi��o em que deseja inserir um novo aluno: "));
				if (posicao < 2) {
					JOptionPane.showMessageDialog(null,
							"A posi��o � inferior a 2.\n" + "Inseriremos na primeira posi��o.");
					listaAluno.adicionaPrimeira(novoAluno);
				} else if (posicao > listaAluno.getQtdNo()) {
					JOptionPane.showMessageDialog(null, "A posi��o � maior do que a quantidade de disciplinas na lista.\n"
							+ "Inseriremos na �ltima posi��o.");
					listaAluno.adicionaUltima(novoAluno);
				} else {
					listaAluno.adicionaPosicao(novoAluno, posicao);
				}
				EventoFormAluno ev = new EventoFormAluno(this, listaAluno.listaString());
				formListener.FormEventOcurred(ev);
				
				limpaCampos();
			}
		});

		Border margem = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Aluno");
		Border bordaComposta = BorderFactory.createCompoundBorder(margem, bordaTitulo);

		this.setPreferredSize(new Dimension(300, 360));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(bordaComposta);
		this.add(labelNome);
		this.add(campoNome);
		this.add(labelCurso);
		this.add(campoCurso);
		this.add(painelSemestre);
		this.add(painelBotoes);
	}

	private void limpaCampos() {
		this.campoNome.setText("");
		this.campoCurso.setText("");
		this.listaSemestre.setSelectedItem(0);
	}

	public void setFormListener(ListenerFormAluno listener) {
		this.formListener = listener;
	}

}
