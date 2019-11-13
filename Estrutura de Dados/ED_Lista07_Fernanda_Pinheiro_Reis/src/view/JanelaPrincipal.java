package view;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ListaDupla;
import model.Aluno;
import model.Disciplina;
import model.Media;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private FormAluno formAluno;
	private FormDisciplina formDisciplina;
	private FormMedia formMedia;
	private PainelListas painelListas;
	private BarraDeFerramentas barraDeFerramentas;

	private ListaDupla<Aluno> listaAluno;
	private ListaDupla<Disciplina> listaDisciplina;
	private ListaDupla<Media> listaMedia;

	private EventoFormDisciplina eventoFormDisciplina;

	public JanelaPrincipal() {
		this.listaAluno = new ListaDupla<Aluno>();
		this.listaDisciplina = new ListaDupla<Disciplina>();
		this.listaMedia = new ListaDupla<Media>();

		this.formAluno = new FormAluno(listaAluno);
		this.formDisciplina = new FormDisciplina(listaDisciplina);
		this.formMedia = new FormMedia(listaMedia, listaAluno, listaDisciplina);
		this.painelListas = new PainelListas(listaAluno, listaDisciplina, listaMedia);
		this.barraDeFerramentas = new BarraDeFerramentas(listaMedia, listaAluno, listaDisciplina);

		//para o formulário ouvir o evento ocorrido em ALUNO (pressiona botão)
		this.formAluno.setFormListener(new ListenerFormAluno() {
			@Override
			public void FormEventOcurred(EventoFormAluno e) {
				painelListas.alteraTexto(e.getListaImpressa());	
			}
		});

		//para o formulário ouvir o evento ocorrido em DISCIPLINA (pressiona botão)
		this.formDisciplina.setFormListener(new ListenerFormDisciplina() {
			@Override
			public void FormEventOcurred(EventoFormDisciplina e) {
				painelListas.alteraTexto(e.getListaImpressa());
			}
		});

		//para ouvir o evento ocorrido em form MÉDIA (pressiona botão)
		this.formMedia.setFormListener(new ListenerFormMedia() {
			@Override
			public void FormEventOcurred(EventoFormMedia e) {
				painelListas.alteraTexto(e.getListaImpressa());
			}
		});
		
		//para ouvir o evento ocorrido em BARRA DE FERRAMENTAS (pressiona botão)
		this.barraDeFerramentas.setFormListener(new ListenerBarraDeFerramentas() {
			
			@Override
			public void FormEventOcurred(EventoBarraDeFerramentas e) {
				painelListas.alteraTexto(e.getListaImpressa());
			}
		});
		
		
		JPanel boxEsquerda = new JPanel();
		boxEsquerda.setLayout(new BoxLayout(boxEsquerda, BoxLayout.Y_AXIS));
		boxEsquerda.add(formAluno);
		boxEsquerda.add(formDisciplina);
		boxEsquerda.add(formMedia);


		this.setTitle("Estrutura de Dados - Lista 07/Exercício 3 - Fernanda Pinheiro Reis");
		this.setLayout(new BorderLayout());
		this.setSize(800, 600);
		this.setMinimumSize(this.getSize()); 
		this.setLocationRelativeTo(null); //centralizado
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(boxEsquerda, BorderLayout.WEST);
		this.add(painelListas, BorderLayout.CENTER);
		this.add(barraDeFerramentas, BorderLayout.NORTH);

		this.setVisible(true); //para aparecer
	}
}
