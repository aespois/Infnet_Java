package dominio;

public class Instituicao {

	private String nomeInstituicao;
	
	public Instituicao(){
		this.nomeInstituicao("INFNET - Sistemas de Informa��o");
	}
	
	private void nomeInstituicao(String nomeInstituicao) {
		// TODO Auto-generated method stub
		this.nomeInstituicao = nomeInstituicao;
	}
	
	@Override
	public String toString() {
		return String.format("%-15s", this.nomeInstituicao);
	}

}