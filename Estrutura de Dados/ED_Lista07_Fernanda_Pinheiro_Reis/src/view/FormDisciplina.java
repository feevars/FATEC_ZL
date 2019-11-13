package view;

import java.awt.Dimension;
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
import model.Disciplina;

import java.awt.event.ActionEvent;

public class FormDisciplina extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ListenerFormDisciplina formListener;
	
	private JLabel labelDisciplina;
	private JTextField campoDisciplina;
	private JButton btnInicio;
	private JButton btnFinal;
	private JButton btnPosicao;
	
	public FormDisciplina(ListaDupla<Disciplina> listaDisciplina) {
		
		this.labelDisciplina = new JLabel("Nome: ");
		this.campoDisciplina = new JTextField(40);
		this.btnInicio = new JButton("<html><p align=\"center\">Inserir no início</p></html>");
		this.btnFinal = new JButton("<html><p align=\"center\">Inserir no final</p></html>");
		this.btnPosicao = new JButton("<html><p align=\"center\">Inserir na posição</p></html>");
	
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
		painelBotoes.add(btnInicio);
		painelBotoes.add(btnFinal);
		painelBotoes.add(btnPosicao);
		
		//Inserir na primeira posição
		this.btnInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Disciplina novaDisciplina = new Disciplina(listaDisciplina.getContaId(), campoDisciplina.getText());
				listaDisciplina.adicionaPrimeira(novaDisciplina);
				
				EventoFormDisciplina ev = new EventoFormDisciplina(this, listaDisciplina.listaString());
				formListener.FormEventOcurred(ev);
				
				limpaCampos();
				
			}
		});
		
		//Adiciona em qualquer posição
		this.btnPosicao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Disciplina novaDisciplina = new Disciplina(listaDisciplina.getContaId(), campoDisciplina.getText());
				int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição em que deseja inserir uma nova disciplina: "));
				
				
				if (posicao < 2) {
					JOptionPane.showMessageDialog(null, "A posição é inferior a 2.\n"
							+ "Inseriremos na primeira posição.");
					listaDisciplina.adicionaPrimeira(novaDisciplina);
				} else if (posicao > listaDisciplina.getQtdNo()) {
					JOptionPane.showMessageDialog(null, "A posição é maior do que a quantidade de disciplinas na lista.\n"
							+ "Inseriremos na última posição.");
					listaDisciplina.adicionaUltima(novaDisciplina);
				} else {
					listaDisciplina.adicionaPosicao(novaDisciplina, posicao);
				}
				
				
				EventoFormDisciplina ev = new EventoFormDisciplina(this, listaDisciplina.listaString());
				formListener.FormEventOcurred(ev);
				
				limpaCampos();
			}
		});
		
		//Inserir na última posição
		this.btnFinal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Disciplina novaDisciplina = new Disciplina(listaDisciplina.getContaId(), campoDisciplina.getText());
				listaDisciplina.adicionaUltima(novaDisciplina);
				
				EventoFormDisciplina ev = new EventoFormDisciplina(this, listaDisciplina.listaString());
				formListener.FormEventOcurred(ev);
				
				limpaCampos();
				
			}
		});
		Border margem = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Disciplina");
		Border bordaComposta = BorderFactory.createCompoundBorder(margem, bordaTitulo);
		
		this.setPreferredSize(new Dimension(300, 200));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(bordaComposta);
		this.add(labelDisciplina);
		this.add(campoDisciplina);
		this.add(painelBotoes);
	}
	
	private void limpaCampos() {
		this.campoDisciplina.setText("");
	}

	public void setFormListener(ListenerFormDisciplina listener) {
		this.formListener = listener;
	}
}
