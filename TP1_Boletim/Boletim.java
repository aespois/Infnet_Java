package tp1;

import java.util.Arrays;
import java.util.Scanner;

public class Boletim {
	
	private static String[] nomes;
	private static float[] av1;
	private static float[] av2;
	
	private static final int QTDE = 100;

	private static float calcularMedia(int id) {
		return (av1[id] + av2[id])/2;
	}

	private static String situacaoFinal(float sf) {
		if (sf < 4) {
			return "Reprovado";
		} else	if (sf >= 7) {
			return "Aprovado";
			} else {
				return "Prova final";
			}
	}
	
	private static void imprimir(int id) {
		
		float mediaFinal = calcularMedia(id);
		String situacao = situacaoFinal(mediaFinal);
		
		System.out.printf("[%d] Aluno: %s - AV1: %.1f - AV2: %.1f || Média Final = %.1f (%s)\n", 
				id, nomes[id], av1[id], av2[id], mediaFinal, situacao);
	}
	
	private static void imprimir() {
		for (int i = 0; i < QTDE; i++) {
			if(nomes[i] != null) {
				imprimir(i);
			}
		}
	}
	
	public static void main(String[] args) {
		nomes = new String[QTDE];
		av1 = new float[QTDE];
		av2 = new float[QTDE];

		Scanner in = new Scanner(System.in);
		
		Integer[] opcoes = {1,2,3,4};
		
		int i = 0;
		int opcao;
		do {			
			System.out.println("----------------------------------------");
			System.out.println("           CONTROLE ACADÊMICO           ");
			System.out.println("----------------------------------------");
			System.out.println("[1] Registrar as notas de um novo aluno");
			System.out.println("[2] Consultar boletim de um aluno");
			System.out.println("[3] Consultar notas da turma");
			System.out.println("[4] Sair");
			System.out.println("                                        ");
			System.out.print("Digite a opção desejada: ");
			
			opcao = in.nextInt();
			
			if(Arrays.asList(opcoes).contains(opcao)) {
				if(opcao == 1) {
	
					if(i < QTDE) {
						System.out.println("----------------------------------------");
						System.out.print("Nome do aluno: ");
						nomes[i] = in.next();
						
						System.out.print("Nota da AV1: ");
						av1[i] = in.nextInt();
						
						System.out.print("Nota da AV2: ");
						av2[i] = in.nextFloat();

						System.out.println("                                        ");
						System.out.println("###### REGISTRO SALVO COM SUCESSO ######");
						System.out.println("----------------------------------------");
						imprimir(i);
						System.out.println("----------------------------------------");
						System.out.println("                                        ");
						
						i++;
					} else {
						System.out.println("                                           ");
						System.out.println("###### LIMITE DE 100 ALUNOS ATINGIDO ######");
						System.out.println("-------------------------------------------");
						System.out.println("Não é possível salvar o registro.");
						System.out.println("-------------------------------------------");
						System.out.println("                                           ");
					}
					
				} else if (opcao == 2) {
					System.out.print("Informe a matrícula do aluno: ");
					int id = in.nextInt();
	
					if(id >= 0 && id < i) {
						System.out.println("                                        ");
						System.out.println("########## BOLETIM INDIVIDUAL ##########");
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
					
				} else if (opcao == 3) {
					System.out.println("                                        ");
					System.out.println("########### BOLETIM DA TURMA ###########");
					System.out.println("----------------------------------------");
					imprimir();
					System.out.println("---------------------------------------");
					System.out.println("                                       ");
				}
			} else {
				System.out.println("                            ");
				System.out.println("###### OPÇÃO INVÁLIDA ######");
				System.out.println("----------------------------");
				System.out.println("Tente novamente.");
				System.out.println("----------------------------");
				System.out.println("                            ");
				
			}
		} while (opcao != 4);

		System.out.println("Sistema encerrado com sucesso!");
		
		in.close();
	}
}