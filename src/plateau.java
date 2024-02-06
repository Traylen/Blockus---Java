class plateau {
    /**
     *
     * @param
     */
    public static void main(String[] arg) {
        int[][] tableau;
        int i, j;
        tableau = new int[10][11];
        for (i = 0; i < tableau.length; i++) {
            for (j = 0; j < tableau[i].length; j++) {

                System.out.print(tableau[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
