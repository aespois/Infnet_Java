package testes;

import exceptions.DadosIncorretosException;

import java.util.Arrays;
import java.util.Scanner;

import auxiliar.Constante;
import dominio.Aluno;
import dominio.Professor;
import negocio.Pessoa;

public class TP3 {
	
	private static Pessoa[] pessoas; //aluno e professor
		
		private static void imprimir(int id) {
			System.out.println("["+ id + "] " + pessoas[id].toString());
		}
		
		private static void imprimir() {
			for (int i = 0; i < Constante.QTDE; i++) {
				if(pessoas[i] != null) {
					imprimir(i);
				}
			}
		}
	
	public static void main(String[] args) throws DadosIncorretosException {
		pessoas = new Pessoa[Constante.QTDE];

		Scanner in = new Scanner(System.in);
		
		int i = 0;
		int opcao;
		do {			
			System.out.println("----------------------------------------");
			System.out.println("           CONTROLE ACADÊMICO           ");
			System.out.println("----------------------------------------");
			System.out.println("[1] Cadastrar Aluno");
			System.out.println("[2] Cadastrar Professor");
			System.out.println("[3] Consultar por Matrícula");
			System.out.println("[4] Consultar Todos");
			System.out.println("[5] Sair");
			System.out.println("                                        ");
			System.out.print("Informe a opção desejada: ");
			
			opcao = in.nextInt();
			
			if(Arrays.asList(Constante.OPCOES).contains(opcao)) {
				
				switch (opcao) {
				case 1:
					if(i < Constante.QTDE) {
						
						Aluno al = new Aluno(null, opcao);
						
						System.out.println("----------------------------------------");
						System.out.print("Nome Completo: ");
						
						al.setNome(in.next());
						
						if(al.getNome().length() < 3) {
							throw new DadosIncorretosException("O preenchimento do campo 'nome' está incorreto");
						}
						
						System.out.print("Idade: ");
						al.setIdade(in.nextInt());
						
						System.out.print("Nota da AV1: ");
						al.setAv1(in.nextFloat());

						System.out.print("Nota da AV2: ");
						al.setAv2(in.nextFloat());
						
						pessoas[i] = al;

						System.out.println("                                        ");
						System.out.println("###### REGISTRO SALVO COM SUCESSO ######");
						System.out.println("----------------------------------------");
						imprimir(i);
						System.out.println("----------------------------------------");
						System.out.println("                                        ");
						i++;
						
					} else {
						System.out.println("                                           ");
						System.out.println("###### LIMITE DE 100 REGISTROS ATINGIDO ######");
						System.out.println("-------------------------------------------");
						System.out.println("Não é possível salvar o registro.");
						System.out.println("-------------------------------------------");
						System.out.println("                                           ");
					}					
					break;

				case 2:
					if(i < Constante.QTDE) {
						
						Professor prof = new Professor(null, opcao);
						
						System.out.println("----------------------------------------");
						System.out.print("Nome Completo: ");
						prof.setNome(in.next());
						
						System.out.print("Idade: ");
						prof.setIdade(in.nextInt());
						
						if(prof.getIdade() < 18) {
							throw new DadosIncorretosException("Não é possível cadastrar professores menores de idade");
						}
						
						System.out.print("Pós Graduado: ");
						prof.setPosGraducao(in.nextBoolean());
						
						// inserir erro caso a pessoa digite sim/não ao invés de true/false
						
						System.out.print("Disciplina: ");
						prof.setDisciplina(in.next());
						
						pessoas[i] = prof;

						System.out.println("                                        ");
						System.out.println("###### REGISTRO SALVO COM SUCESSO ######");
						System.out.println("----------------------------------------");
						imprimir(i);
						System.out.println("----------------------------------------");
						System.out.println("                                        ");
						
						i++;
						
					} else {
						System.out.println("                                           ");
						System.out.println("###### LIMITE DE 100 REGISTROS ATINGIDO ######");
						System.out.println("-------------------------------------------");
						System.out.println("Não é possível salvar o registro.");
						System.out.println("-------------------------------------------");
						System.out.println("                                           ");
					}		
					
					break;

				case 3:
					System.out.print("Informe a Matrícula: ");
					int id = in.nextInt();
	
					if(id >= 0 && id < i) {
						System.out.println("                                        ");
						System.out.println("########## CONSULTA POR MATRÍCULA ##########");
						System.out.println("----------------------------------------");
						imprimir(id);
						System.out.println("----------------------------------------");
						System.out.println("                                       ");
						
					} else {
						System.out.println("                                    ");
						System.out.println("######## MATRÍCULA INVÁLIDA ########");
						System.out.println("------------------------------------");
						System.out.println("Não é possível consultar o registro.");
						System.out.println("------------------------------------");
						System.out.println("                                    ");
					}
					
					break;
					
				case 4:
					System.out.println("                                        ");
					System.out.println("########### CONSULTA TOTAL ###########");
					System.out.println("----------------------------------------");
					imprimir();
					System.out.println("---------------------------------------");
					System.out.println("                                       ");
					
					break;
				}
				
			} else {
				System.out.println("                            ");
				System.out.println("###### OPÇÃO INVÁLIDA ######");
				System.out.println("----------------------------");
				System.out.println("Tente novamente.");
				System.out.println("----------------------------");
				System.out.println("                            ");
			}
			
		} while (opcao != 5);

		System.out.println("Sistema encerrado com sucesso!");		
		
		in.close();
	}
}
