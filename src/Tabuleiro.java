import java.util.Random;

public class Tabuleiro {
    private Integer[][] matrizSudoku = new Integer[9][9];
    private int[] linhasNaoRemoviveis;
    private int[] colunasNaoRemoviveis;

    public Tabuleiro() {

    }

    public Integer[][] getMatrizSudoku() {
        return matrizSudoku;
    }

    public void setMatrizSudoku(int linha, int coluna, int valor) {
        this.matrizSudoku[linha][coluna] = valor;
    }

    public int[] getLinhasNaoRemoviveis() {
        return linhasNaoRemoviveis;
    }

    public void setLinhasNaoRemoviveis(int[] linhasNaoRemoviveis) {
        this.linhasNaoRemoviveis = linhasNaoRemoviveis;
    }

    public int[] getColunasNaoRemoviveis() {
        return colunasNaoRemoviveis;
    }

    public void setColunasNaoRemoviveis(int[] colunasNaoRemoviveis) {
        this.colunasNaoRemoviveis = colunasNaoRemoviveis;
    }

    public void inserirCopia(Integer[][] matriz){
        this.matrizSudoku = matriz;
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

                int inicioLinha = (linha/3) * 3;
                int inicioColuna = (coluna/3) * 3;

                for(int i = inicioLinha; i < inicioLinha + 3; i++){
                    for(int j = inicioColuna; j < inicioColuna + 3; j++){
                        if(matrizSudoku[i][j] == valor)
                            contExiste++;
                    }
                }

                if(contExiste <= 0){
                    matrizSudoku[linha][coluna] = valorzin;
                    linhasNaoRemoviveis[contador] = linha;
                    colunasNaoRemoviveis[contador] = coluna;
                    contador++;
                }
            }
        }
    }
}
