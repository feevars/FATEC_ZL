package view;

import javax.swing.JPanel;

import controller.ListaDupla;
import controller.MetodosAdicionais;
import model.Aluno;
import model.Disciplina;
import model.Media;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BarraDeFerramentas extends JPanel implements MetodosAdicionais {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ListenerBarraDeFerramentas formListener;

	private JButton btnRemoveAlunoInicio;
	private JButton btnRemoveAlunoFinal;
	private JButton btnRemoveAlunoPosicao;

	private JButton btnRemoveDisciplinaInicio;
	private JButton btnRemoveDisciplinaFinal;
	private JButton btnRemoveDisciplinaPosicao;

	private JButton btnRemoveMediaInicio;
	private JButton btnRemoveMediaFinal;
	private JButton btnRemoveMediaPosicao;

	private JButton btnOrdenarMedias;
	private JButton btnAlunosAprovados;
	private JButton btnAlunosReprovados;

	public BarraDeFerramentas(ListaDupla<Media> listaMedia, ListaDupla<Aluno> listaAluno,
			ListaDupla<Disciplina> listaDisciplina) {

		this.btnRemoveAlunoInicio = new JButton("<html>Remove Aluno do Início</html>");
		this.btnRemoveAlunoFinal = new JButton("<html>Remove Aluno do Final</html>");
		this.btnRemoveAlunoPosicao = new JButton("<html>Remove Aluno da Posição</html>");
		JPanel painelBtnAluno = new JPanel();
		painelBtnAluno.setLayout(new BoxLayout(painelBtnAluno, BoxLayout.Y_AXIS));
		painelBtnAluno.add(btnRemoveAlunoInicio);
		painelBtnAluno.add(btnRemoveAlunoFinal);
		painelBtnAluno.add(btnRemoveAlunoPosicao);

		// Ação do BOTÃO que remove aluno do início da lista
		this.btnRemoveAlunoInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaAluno.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível remover aluno.");
				} else {
					listaAluno.removePrimeiro();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Primeiro item da lista removido.\n Lista de alunos:\n\n" + listaAluno.listaString());
					formListener.FormEventOcurred(ev);
				}
			}
		});

		// Ação do BOTÃO que remove aluno da posição da lista
		this.btnRemoveAlunoPosicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaAluno.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível remover aluno.");
				} else {
					int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do aluno que deseja remover: "));
					if (posicao < 1 || posicao > listaAluno.getQtdNo()) {
						JOptionPane.showMessageDialog(null, "A posição não existe.");
					} else {
						if(posicao == 1) {
							listaAluno.removePrimeiro();
						} else if (posicao == listaAluno.getQtdNo()) {
							listaAluno.removeUltimo();
						}	else {
							listaAluno.removePosicao(posicao);
						}
						EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
								"Item removido.\n\n Lista de alunos:\n\n" + listaAluno.listaString());
						formListener.FormEventOcurred(ev);
					}
				}
			}
		});

		// Ação do BOTÃO que remove aluno do final da lista
		this.btnRemoveAlunoFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaAluno.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível remover aluno.");
				} else {
					listaAluno.removeUltimo();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Último item da lista removido.\n\n Lista de alunos:\n\n" + listaAluno.listaString());
					formListener.FormEventOcurred(ev);
				}

			}
		});

		this.btnRemoveDisciplinaInicio = new JButton("<html>Remove Disciplina do Início</html>");
		this.btnRemoveDisciplinaFinal = new JButton("<html>Remove Disciplina do Final</html>");
		this.btnRemoveDisciplinaPosicao = new JButton("<html>Remove Disciplina da Posição</html>");
		JPanel painelBtnDisciplina = new JPanel();
		painelBtnDisciplina.setLayout(new BoxLayout(painelBtnDisciplina, BoxLayout.Y_AXIS));
		painelBtnDisciplina.add(btnRemoveDisciplinaInicio);
		painelBtnDisciplina.add(btnRemoveDisciplinaFinal);
		painelBtnDisciplina.add(btnRemoveDisciplinaPosicao);

		// Ação do BOTÃO que remove disciplina do início da lista
		this.btnRemoveDisciplinaInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaDisciplina.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível remover disciplina.");
				} else {
					listaDisciplina.removePrimeiro();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Primeiro item da lista removido.\n Lista de disciplina:\n\n" + listaDisciplina.listaString());
					formListener.FormEventOcurred(ev);
				}
			}
		});

		// Ação do BOTÃO que remove Disciplina da posição da lista
		this.btnRemoveDisciplinaPosicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaDisciplina.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível remover disciplina.");
				} else {
					int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição da disciplina que deseja remover: "));
					if (posicao < 1 || posicao > listaDisciplina.getQtdNo()) {
						JOptionPane.showMessageDialog(null, "A posição não existe.");
					} else {
						if(posicao == 1) {
							listaDisciplina.removePrimeiro();
						} else if (posicao == listaDisciplina.getQtdNo()) {
							listaDisciplina.removeUltimo();
						}	else {
							listaDisciplina.removePosicao(posicao);
						}
						EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
								"Item removido.\n\n Lista de disciplina:\n\n" + listaDisciplina.listaString());
						formListener.FormEventOcurred(ev);
					}
				}
			}
		});

		// Ação do BOTÃO que remove Disciplina do final da lista
		this.btnRemoveDisciplinaFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaDisciplina.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível remover disciplina.");
				} else {
					listaDisciplina.removeUltimo();
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Último item da lista removido.\n\n Lista de disciplinas:\n\n" + listaDisciplina.listaString());
					formListener.FormEventOcurred(ev);
				}

			}
		});

		this.btnRemoveMediaInicio = new JButton("<html>Remove Média do Início</html>");
		this.btnRemoveMediaFinal = new JButton("<html>Remove Média do Final</html>");
		this.btnRemoveMediaPosicao = new JButton("<html>Remove Média da Posição</html>");
		JPanel painelBtnMedia = new JPanel();
		painelBtnMedia.setLayout(new BoxLayout(painelBtnMedia, BoxLayout.Y_AXIS));
		painelBtnMedia.add(btnRemoveMediaInicio);
		painelBtnMedia.add(btnRemoveMediaFinal);
		painelBtnMedia.add(btnRemoveMediaPosicao);
		
		// Ação do BOTÃO que remove disciplina do início da lista
				this.btnRemoveMediaInicio.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						if (listaMedia.estaVazia()) {
							JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível remover média.");
						} else {
							listaMedia.removePrimeiro();
							EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
									"Primeiro item da lista removido.\n Lista de Médias:\n\n" + listaMedia.listaString());
							formListener.FormEventOcurred(ev);
						}
					}
				});

				// Ação do BOTÃO que remove Media de uma posição da lista
				this.btnRemoveMediaPosicao.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						if (listaMedia.estaVazia()) {
							JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível remover média.");
						} else {
							int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição da disciplina que deseja remover: "));
							if (posicao < 1 || posicao > listaMedia.getQtdNo()) {
								JOptionPane.showMessageDialog(null, "A posição não existe.");
							} else {
								if(posicao == 1) {
									listaMedia.removePrimeiro();
								} else if (posicao == listaDisciplina.getQtdNo()) {
									listaMedia.removeUltimo();
								}	else {
									listaMedia.removePosicao(posicao);
								}
								EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
										"Item removido.\n\n Lista de disciplina:\n\n" + listaMedia.listaString());
								formListener.FormEventOcurred(ev);
							}
						}
					}
				});

				// Ação do BOTÃO que remove Media do final da lista
				this.btnRemoveMediaFinal.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (listaMedia.estaVazia()) {
							JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível remover média.");
						} else {
							listaMedia.removeUltimo();
							EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
									"Último item da lista removido.\n\n Lista de médias:\n\n" + listaMedia.listaString());
							formListener.FormEventOcurred(ev);
						}

					}
				});

		this.btnOrdenarMedias = new JButton("<html>Ordenar Médias</html>");
		this.btnAlunosAprovados = new JButton("<html>Alunos Aprovados</html>");
		this.btnAlunosReprovados = new JButton("<html>Alunos Reprovados</html>");
		JPanel painelBtnStatus = new JPanel();
		painelBtnStatus.setLayout(new BoxLayout(painelBtnStatus, BoxLayout.Y_AXIS));
		painelBtnStatus.add(btnOrdenarMedias);
		painelBtnStatus.add(btnAlunosAprovados);
		painelBtnStatus.add(btnAlunosReprovados);
		
		// Ação do BOTÃO que ordena médias 
		this.btnOrdenarMedias.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaMedia.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia. Impossível ordenar médias.");
				} else {
					Media [] vetorMedia = new Media[listaMedia.getQtdNo()];
					vetorMedia = MetodosAdicionais.vetorMedias(listaMedia, vetorMedia);
					MetodosAdicionais.mergeSortMedia(vetorMedia);
					
			
					EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
							"Lista de médias ordenadas:\n\n" + MetodosAdicionais.vetorMediaPrint(vetorMedia, listaAluno, listaDisciplina));
					formListener.FormEventOcurred(ev);
				}

			}
		});
		
		// Ação do BOTÃO que exibe alunos aprovados
				this.btnAlunosAprovados.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (listaMedia.estaVazia()) {
							JOptionPane.showMessageDialog(null, "A lista está vazia. Não há o que exibir");
						} else {
							Media [] vetorMedia = new Media[listaMedia.getQtdNo()];
							vetorMedia = MetodosAdicionais.vetorMedias(listaMedia, vetorMedia);
							MetodosAdicionais.mergeSortMedia(vetorMedia);
							
					
							EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
									"Lista de alunos aprovados:\n\n" + MetodosAdicionais.alunosAprovados(vetorMedia, listaAluno, listaDisciplina));
							formListener.FormEventOcurred(ev);
						}

					}
				});
				
				// Ação do BOTÃO que exibe alunos reprovados
				this.btnAlunosReprovados.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (listaMedia.estaVazia()) {
							JOptionPane.showMessageDialog(null, "A lista está vazia. Não há o que exibir.");
						} else {
							Media [] vetorMedia = new Media[listaMedia.getQtdNo()];
							vetorMedia = MetodosAdicionais.vetorMedias(listaMedia, vetorMedia);
							MetodosAdicionais.mergeSortMedia(vetorMedia);
							
					
							EventoBarraDeFerramentas ev = new EventoBarraDeFerramentas(this,
									"Lista de alunos reprovados:\n\n" + MetodosAdicionais.alunosReprovados(vetorMedia, listaAluno, listaDisciplina));
							formListener.FormEventOcurred(ev);
						}

					}
				});

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(painelBtnAluno);
		this.add(painelBtnDisciplina);
		this.add(painelBtnMedia);
		this.add(painelBtnStatus);
	}

	public void setFormListener(ListenerBarraDeFerramentas listener) {
		this.formListener = listener;
	}

}
