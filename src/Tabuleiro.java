import java.util.Random;

public class Tabuleiro {
    private Integer[][] matrizSudoku = new Integer[9][9];

    public Tabuleiro() {

    }

    public Integer[][] getMatrizSudoku() {
        return matrizSudoku;
    }

    public void setMatrizSudoku(int linha, int coluna, int valor) {
        this.matrizSudoku[linha][coluna] = valor;
    }

    public void gerarNumeros(int valor){
        int contador = 0;
        int linha = 0, coluna = 0, contExiste = 0;
        while(contador <= valor){
            Random random = new Random();
            linha = random.nextInt(9);
            coluna = random.nextInt(9);

            if(matrizSudoku[linha][coluna] == null){
                int valorzin = random.nextInt(1, 10);
                for(int i = 0; i < 9; i++){
                    for(int j = 0; j < 9; j++){
                        if(matrizSudoku[linha][j] == valorzin || matrizSudoku[i][coluna] == valorzin)
                            contExiste++;
                    }
                }
                if(contExiste <= 0){
                    matrizSudoku[linha][coluna] = valorzin;
                    contador++;
                }
            }
        }
    }
}
