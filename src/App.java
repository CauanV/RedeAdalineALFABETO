public class App {
    public static void main(String[] args) throws Exception {

        /*
         * ReconhecimentoLetrasUI ui = new ReconhecimentoLetrasUI();
         * ui.setVisible(true);
         */
        // treinar os neuronios como eu tenho 7 neuronios vou chamar um for ate 7
        for (int i = 0; i < 7; i++) {
            int ciclos = RedeAdaline.treinar(i);
            System.out.println("Esse neuronio " + i + " levou " + ciclos + " ciclos");
        }
        for (int k = 0; k < 21; k++) {
            System.out.println("Foto " + k + " -> " + RedeAdaline.testar(RedeAdaline.X_matrizTreinamento[k]).trim());
        }

        // printando a matriz de treinamento
        System.out.println("Matriz de Treinamento:");
        for (int i = 0; i < RedeAdaline.X_matrizTreinamento.length; i++) {
            System.out.println(
                    "***********************************************************************************************************************");
            for (int j = 0; j < RedeAdaline.X_matrizTreinamento[i].length; j++) {
                System.out.print(RedeAdaline.X_matrizTreinamento[i][j] + " ");
                // separacao entre as linhas da matriz

            }
            System.out.println();
        }

    }
}
