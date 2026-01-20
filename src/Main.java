import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("JOGO DE SUDOKU");
        System.out.println("Então, vamos começar?");
        System.out.println("1- Iniciar Jogo");
        System.out.println("2- Sair do Jogo");
        int opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                Tabuleiro tabuleiro = new Tabuleiro();
                Jogo jogo = new Jogo(tabuleiro);
                Random random = new Random();
                jogo.getTabuleiro().gerarNumeros(random.nextInt(1,9));
                jogo.iniciarJogo();
                int auxiliar = 0, linha = 0, coluna = 0, valor = 0;

                while(jogo.getStatus() != Situacao.COMPLETO){
                    System.out.println("Agora que o jogo começou, escolha uma das opções abaixo");
                    System.out.println(" 1-Adicionar um Número no Tabuleiro \n 2- Remover um dos números adicionados \n 3- Sair \n 4- Verificar tabuleiro atual");
                    auxiliar = scanner.nextInt();

                    if(auxiliar == 3){
                        jogo.finalizarJogo();
                    }
                    if(auxiliar == 4){
                        jogo.imprimirTabuleiro();
                    }
                    if(auxiliar == 1){
                        int cont = 0;
                        while(cont == 0){
                            System.out.println("Digite a posição horizontal onde você quer colocar o valor");
                            linha = scanner.nextInt();

                            System.out.println("Digite a posição vertical onde você quer colocar o valor");
                            coluna = scanner.nextInt();

                            System.out.println("Digite um valor para colocar no tabuleiro: ");
                            valor = scanner.nextInt();

                            int contExiste = 0;

                            for(int i = 0; i < 9; i++){
                                for(int j = 0; j < 9; j++){
                                    if(jogo.getTabuleiro().getMatrizSudoku()[linha][j] == valor || jogo.getTabuleiro().getMatrizSudoku()[i][coluna] == valor)
                                        contExiste++;
                                }
                            }
                            if(contExiste <= 0){
                                jogo.inserir(linha, coluna, valor);
                                cont++;
                            }
                        }
                    }
                }
            case 2:
                System.exit(0);
            default:
                System.out.println("Digite uma opção válida na próxima!");
                System.exit(0);
          }
      }
    }