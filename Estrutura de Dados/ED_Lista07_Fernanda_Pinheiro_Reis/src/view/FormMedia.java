package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.ListaDupla;
import controller.MetodosAdicionais;
import model.Aluno;
import model.Disciplina;
import model.Media;

public class FormMedia extends JPanel implements MetodosAdicionais {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ListenerFormMedia formListener;

	private JLabel labelIdAluno;
	private JTextField campoIdAluno;
	private JLabel labelIdDisciplina;
	private JTextField campoIdDisciplina;
	private JLabel labelMedia;
	private JTextField campoMedia;

	private JButton btnInicio;
	private JButton btnFinal;
	private JButton btnPosicao;

	public FormMedia(ListaDupla<Media> listaMedia, ListaDupla<Aluno> listaAluno,
			ListaDupla<Disciplina> listaDisciplina) {

		this.labelIdAluno = new JLabel("ID Aluno:");
		this.campoIdAluno = new JTextField(5);
		JPanel painelIdAluno = new JPanel();
		painelIdAluno.setLayout(new BoxLayout(painelIdAluno, BoxLayout.Y_AXIS));
		painelIdAluno.add(labelIdAluno);
		painelIdAluno.add(campoIdAluno);

		this.labelIdDisciplina = new JLabel("ID Disciplina:");
		this.campoIdDisciplina = new JTextField(5);
		JPanel painelIdDisciplina = new JPanel();
		painelIdDisciplina.setLayout(new BoxLayout(painelIdDisciplina, BoxLayout.Y_AXIS));
		painelIdDisciplina.add(labelIdDisciplina);
		painelIdDisciplina.add(campoIdDisciplina);

		this.labelMedia = new JLabel("Média final:");
		this.campoMedia = new JTextField(4);
		JPanel painelMedia = new JPanel();
		painelMedia.setLayout(new BoxLayout(painelMedia, BoxLayout.Y_AXIS));
		painelMedia.add(labelMedia);
		painelMedia.add(campoMedia);

		JPanel painelHorizontal = new JPanel();
		painelHorizontal.setLayout(new BoxLayout(painelHorizontal, BoxLayout.X_AXIS));
		painelHorizontal.add(painelIdAluno);
		painelHorizontal.add(painelIdDisciplina);
		painelHorizontal.add(painelMedia);

		this.btnInicio = new JButton("<html><p align=\"center\">Inserir no início</p></html>");
		this.btnFinal = new JButton("<html><p align=\"center\">Inserir no final</p></html>");
		this.btnPosicao = new JButton("<html><p align=\"center\">Inserir na posição</p></html>");

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
		painelBotoes.add(btnInicio);
		painelBotoes.add(btnFinal);
		painelBotoes.add(btnPosicao);

		// Inserir na primeira posição
		this.btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// verificação
				if(!MetodosAdicionais.verificaIdAluno(Integer.parseInt(campoIdAluno.getText()), listaAluno)) {
					JOptionPane.showMessageDialog(null, "Não existe aluno com o ID inserido.");
				} else if (!MetodosAdicionais.verificaIdDisciplina(Integer.parseInt(campoIdDisciplina.getText()),
						listaDisciplina)) {
					JOptionPane.showMessageDialog(null, "Não existe disciplina com o ID inserido.");
				} else if (MetodosAdicionais.verificaMediaExistente(Integer.parseInt(campoIdAluno.getText()),
								Integer.parseInt(campoIdDisciplina.getText()), listaMedia)) {
					JOptionPane.showMessageDialog(null, "Já existe uma média para este aluno, nessa disciplina.");
				} else if (MetodosAdicionais.verificaIdAluno(Integer.parseInt(campoIdAluno.getText()), listaAluno)
						&& MetodosAdicionais.verificaIdDisciplina(Integer.parseInt(campoIdDisciplina.getText()),
								listaDisciplina)
						&& !MetodosAdicionais.verificaMediaExistente(Integer.parseInt(campoIdAluno.getText()),
								Integer.parseInt(campoIdDisciplina.getText()), listaMedia)) {
					Media novaMedia = new Media(Integer.parseInt(campoIdAluno.getText()),
							Integer.parseInt(campoIdDisciplina.getText()), Double.parseDouble(campoMedia.getText()));
					listaMedia.adicionaPrimeira(novaMedia);
					EventoFormMedia ev = new EventoFormMedia(this, listaMedia.listaString());
					formListener.FormEventOcurred(ev);
					limpaCampos();
				}
			}
		});

		// Inserir na última posição
		this.btnFinal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// verificação
				if(!MetodosAdicionais.verificaIdAluno(Integer.parseInt(campoIdAluno.getText()), listaAluno)) {
					JOptionPane.showMessageDialog(null, "Não existe aluno com o ID inserido.");
				} else if (!MetodosAdicionais.verificaIdDisciplina(Integer.parseInt(campoIdDisciplina.getText()),
						listaDisciplina)) {
					JOptionPane.showMessageDialog(null, "Não existe disciplina com o ID inserido.");
				} else if (MetodosAdicionais.verificaMediaExistente(Integer.parseInt(campoIdAluno.getText()),
								Integer.parseInt(campoIdDisciplina.getText()), listaMedia)) {
					JOptionPane.showMessageDialog(null, "Já existe uma média para este aluno, nessa disciplina.");
				} else if (MetodosAdicionais.verificaIdAluno(Integer.parseInt(campoIdAluno.getText()), listaAluno)
						&& MetodosAdicionais.verificaIdDisciplina(Integer.parseInt(campoIdDisciplina.getText()),
								listaDisciplina)
						&& !MetodosAdicionais.verificaMediaExistente(Integer.parseInt(campoIdAluno.getText()),
								Integer.parseInt(campoIdDisciplina.getText()), listaMedia)) {
					Media novaMedia = new Media(Integer.parseInt(campoIdAluno.getText()),
							Integer.parseInt(campoIdDisciplina.getText()), Double.parseDouble(campoMedia.getText()));
					listaMedia.adicionaUltima(novaMedia);
					EventoFormMedia ev = new EventoFormMedia(this, listaMedia.listaString());
					formListener.FormEventOcurred(ev);
					limpaCampos();
				}
			}
		});
		
		// Inserir em qualquer posição
		this.btnPosicao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// verificação
				if(!MetodosAdicionais.verificaIdAluno(Integer.parseInt(campoIdAluno.getText()), listaAluno)) {
					JOptionPane.showMessageDialog(null, "Não existe aluno com o ID inserido.");
				} else if (!MetodosAdicionais.verificaIdDisciplina(Integer.parseInt(campoIdDisciplina.getText()),
						listaDisciplina)) {
					JOptionPane.showMessageDialog(null, "Não existe disciplina com o ID inserido.");
				} else if (MetodosAdicionais.verificaMediaExistente(Integer.parseInt(campoIdAluno.getText()),
								Integer.parseInt(campoIdDisciplina.getText()), listaMedia)) {
					JOptionPane.showMessageDialog(null, "Já existe uma média para este aluno, nessa disciplina.");
				} else if (MetodosAdicionais.verificaIdAluno(Integer.parseInt(campoIdAluno.getText()), listaAluno)
						&& MetodosAdicionais.verificaIdDisciplina(Integer.parseInt(campoIdDisciplina.getText()),
								listaDisciplina)
						&& !MetodosAdicionais.verificaMediaExistente(Integer.parseInt(campoIdAluno.getText()),
								Integer.parseInt(campoIdDisciplina.getText()), listaMedia)) {
					
					int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição da lista em que deseja inserir a média."));
					Media novaMedia = new Media(Integer.parseInt(campoIdAluno.getText()),
							Integer.parseInt(campoIdDisciplina.getText()), Double.parseDouble(campoMedia.getText()));
					if (posicao < 2) {
						JOptionPane.showMessageDialog(null, "A posição é inferior a 2.\n"
								+ "Inseriremos na primeira posição.");
						listaMedia.adicionaPrimeira(novaMedia);
					} else if (posicao > listaMedia.getQtdNo()) {
						JOptionPane.showMessageDialog(null, "A posição é maior do que a quantidade de itens na lista.\n"
								+ "Inseriremos na última posição.");
						listaMedia.adicionaUltima(novaMedia);
					} else {
						listaMedia.adicionaPosicao(novaMedia, posicao);
					}
					EventoFormMedia ev = new EventoFormMedia(this, listaMedia.listaString());
					formListener.FormEventOcurred(ev);
					limpaCampos();
				}
			}
		});

		Border margem = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Média");
		Border bordaComposta = BorderFactory.createCompoundBorder(margem, bordaTitulo);

		this.setPreferredSize(new Dimension(300, 240));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(bordaComposta);
		this.add(painelHorizontal);
		this.add(painelBotoes);

	}

	private void limpaCampos() {
		this.campoIdAluno.setText("");
		this.campoIdDisciplina.setText("");
		this.campoMedia.setText("");
	}

	public void setFormListener(ListenerFormMedia listener) {
		this.formListener = listener;
	}

}
