import java.util.Random;

public class Tabuleiro {
    private Integer[][] matrizSudoku = new Integer[9][9];

    public Tabuleiro() {
        this.matrizSudoku = null;
    }

    public Integer[][] getMatrizSudoku() {
        return matrizSudoku;
    }

    public void setMatrizSudoku(int linha, int coluna, int valor) {
        this.matrizSudoku[linha][coluna] = valor;
    }

    public void gerarNumeros(int valor){
        int contador = 0;
        int linha = 0, coluna = 0;
        while(contador <= valor){
            Random random = new Random();
            linha = random.nextInt(10);
            coluna = random.nextInt(10);

            if(matrizSudoku[linha][coluna] == null){
                matrizSudoku[linha][coluna] = random.nextInt();
                contador++;
            }
        }
    }
}
