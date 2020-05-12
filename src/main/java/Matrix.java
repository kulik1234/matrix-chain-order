import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {

    private int sizeRows;
    private int sizeCols;
    private int[][] tab;



    public Matrix(int i, int j) {
        this.sizeRows = i;
        this.sizeCols = j;
        this.tab = new int[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                this.tab[k][l] = (int) (Math.random()*20-10);
            }
        }
    }
    public Matrix(int i, int j,int defaultValue) {
        this.sizeRows = i;
        this.sizeCols = j;
        this.tab = new int[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                this.tab[k][l] = defaultValue;
            }
        }
    }

    public int getSizeRows() {
        return sizeRows;
    }

    public int getSizeCols() {
        return sizeCols;
    }
    public int getSingleValue(int i, int j){
        return tab[i][j];
    }
    public void setSingleValue(int i,int j, int value){
        tab[i][j] = value;
    }

    public static Matrix multiply(Matrix m1,Matrix m2) throws WrongMatrixDimensionsException {
        if(m1.getSizeCols() != m2.getSizeRows()){
            throw new WrongMatrixDimensionsException();
        }
        Matrix m3 = new Matrix(m1.getSizeRows(),m2.getSizeCols(),0);

        for(int i = 0; i < m3.getSizeRows(); i++)
            for(int j = 0; j < m3.getSizeCols(); j++)
                for(int k = 0; k < m1.getSizeCols(); k++){
                    m3.setSingleValue(i,j,m3.getSingleValue(i,j) + m1.getSingleValue(i,k) * m2.getSingleValue(k,j));
                }
        return m3;
    }

    public static Matrix[] matrixChainOrder(int[] p){
        int n = p.length-1;
        Matrix m = new Matrix(n,n,0);
        Matrix s = new Matrix(n,n,0);
        for (int v = 1; v < n; v++) {
            for (int i = 0; i < n - v ; i++) {
                int j = i + v ;
                m.setSingleValue(i,j,Integer.MAX_VALUE);
                for(int k = i; k < j; k++) {
                    int q = m.getSingleValue(i,k)
                            + m.getSingleValue(k+1,j)
                            + p[i]*p[k+1]*p[j+1];
                    if( q < m.getSingleValue(i,j)) {
                        m.setSingleValue(i,j,q);
                        s.setSingleValue(i,j,k+1);
                    }
                }
            }
        }
        Matrix[] tab= {m,s};
        return  tab;
    }


    public void printMatrix(){
        for (int i = 0; i < this.sizeRows; i++) {
            for (int j = 0; j < this.sizeCols; j++) {
                System.out.printf("%20d",this.tab[i][j]);
            }
            System.out.printf("\n");

        }
    }

    @Override
    public String toString() {
        String tab = "";
        for(int[] t : this.tab){
            tab+= Arrays.toString(t)+"\n";
        }
        return "Matrix{" +
                "sizeRows=" + sizeRows +
                ", sizeCols=" + sizeCols +
                ", tab=\n" + tab +
                "}";
    }

}
