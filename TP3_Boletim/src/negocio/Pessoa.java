package negocio;

//import exceptions.NomeIncompletoException;

public abstract class Pessoa {
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public void exibir() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {

		return String.format("%s - %02d", 
				this.nome, 
				this.idade
			);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
