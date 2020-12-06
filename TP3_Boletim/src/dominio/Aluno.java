package dominio;

import negocio.Pessoa;

public class Aluno extends Pessoa {
	private float av1;
	private float av2;
	
	public Aluno(String nome, int idade) {
		super(nome, idade);
	}

	public Aluno(String nome, int idade, float av1, float av2) {
		this(nome, idade);
		this.av1 = av1;
		this.av2 = av2;
	}

	public void exibir() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {

		return String.format("%s | AV1: %.1f - AV2: %.1f", 
			super.toString(),
			this.av1, 
			this.av2
		);		
	}

	public float getAv1() {
		return av1;
	}

	public void setAv1(float av1) {
		this.av1 = av1;
	}

	public float getAv2() {
		return av2;
	}

	public void setAv2(float av2) {
		this.av2 = av2;
	}
}
