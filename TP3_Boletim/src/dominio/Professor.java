package dominio;

import negocio.Pessoa;

public class Professor extends Pessoa {
	private boolean posGraduacao;
	private String disciplina;
	
	public Professor(String nome, int idade) {
		super(nome, idade);
	}

	public Professor(String nome, int idade, boolean posGraduacao, String disciplina) {
		super(nome, idade);
		this.posGraduacao = posGraduacao;
		this.disciplina = disciplina;
	}
	
	public void exibir() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
	
		return String.format("%s | %s - %s", 
				super.toString(),
				this.posGraduacao ? "Sim" : "N�o",
				this.disciplina
				); 
	}

	public boolean isPosGraducao() {
		return posGraduacao;
	}

	public void setPosGraducao(boolean posGraduacao) {
		this.posGraduacao = posGraduacao;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
	