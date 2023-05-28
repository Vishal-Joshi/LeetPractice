package my.practice.ctci.leet;

/**
 * @author Vishal Joshi
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes zeroes = new SetMatrixZeroes();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println(zeroes.setZeroes(matrix));
    }

    public int[][] setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        //when two zeros appear? how will marker work?
        int[] rows = new int[m];
        int[] cols = new int[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows[i]==1 || cols[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
        return matrix;
    }

//    public int[][] setZeroes(int[][] matrix) {
//        int m=matrix.length;
//        int n=matrix[0].length;
//        //when two zeros appear? how will marker work?
//
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(matrix[i][j]==0){
//                    matrix[i][0]=0;
//                    matrix[0][j]=0;
//                }
//            }
//        }
//
//        for(int j=0; j<n; j++) {
//            if(matrix[0][j]==0){
//                nullifyCol(matrix, j);
//            }
//        }
//
//        for(int i=0; i<m; i++) {
//            if(matrix[i][0]==0){
//                nullifyRow(matrix, i);
//            }
//        }
//        return matrix;
//    }
//
//    private void nullifyRow(int[][] matrix, int row){
//        int n=matrix[0].length;
//        for(int j=0; j<n; j++){
//            matrix[row][j]=0;
//        }
//    }
//
//    private void nullifyCol(int[][] matrix, int col){
//        int m=matrix.length;
//        for(int i=0; i<m; i++){
//            matrix[i][col]=0;
//        }
//    }
}
