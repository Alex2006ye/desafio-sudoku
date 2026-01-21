import java.util.Arrays;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Situacao status;


    public Jogo(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.status = Situacao.NAO_INICIADO;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Situacao getStatus() {
        return status;
    }

    public void setStatus(Situacao status) {
        this.status = status;
    }

    public void iniciarJogo(){
        this.status = Situacao.IMCOMPLETO;
    }

    public void finalizarJogo(){
        this.status = Situacao.COMPLETO;
    }

    public void imprimirTabuleiro(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(this.getTabuleiro().getMatrizSudoku()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void inserir(int linha, int coluna, int valor){
        this.tabuleiro.setMatrizSudoku(linha, coluna, valor);
    }

    public void remover(int linha, int coluna){
        Integer[][] matrizCopia = new Integer[9][9];
        for(int i = 0; i < this.tabuleiro.getMatrizSudoku().length; i++){
            for(int j = 0; j < this.tabuleiro.getMatrizSudoku().length; j++){
                if(i != linha || j != coluna)
                    matrizCopia[i][j] = this.tabuleiro.getMatrizSudoku()[i][j];
            }
        }
        this.tabuleiro.inserirCopia(matrizCopia);
    }

    public boolean cheio(){
        for(int i = 0; i < this.tabuleiro.getMatrizSudoku().length; i++){
            for(int j = 0; j < this.tabuleiro.getMatrizSudoku().length; j++){
                if(this.tabuleiro.getMatrizSudoku()[i][j] == null)
                    return false;
            }
        }
        return true;
    }
}
