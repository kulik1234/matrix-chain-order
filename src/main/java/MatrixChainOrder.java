public class MatrixChainOrder {

    public static void main(String[] args) {
        Matrix[] p = {
                new Matrix(5,3),
                new Matrix(3,1),
                new Matrix(1,4),
                new Matrix(4,6)
        };
        Matrix[] tab = Matrix.matrixChainOrder(new int[]{5,3,1,4,6});
        for(Matrix m :tab ){
            m.printMatrix();
            System.out.println("---------------------------------------");
        }

    }

    public void matrixChainOrder(Matrix[] p){

    }

}
