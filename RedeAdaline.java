public class RedeAdaline {
        public static double[][] X_matrizTreinamento = {
                        { // A na fonte 1
                                        -1, -1, 1, 1, -1, -1, -1, // linha 1
                                        -1, -1, -1, 1, -1, -1, -1, // linha 2
                                        -1, -1, -1, 1, -1, -1, -1, // linha 3
                                        -1, -1, 1, -1, 1, -1, -1, // linha 4
                                        -1, -1, 1, -1, 1, -1, -1, // linha 5
                                        -1, 1, 1, 1, 1, 1, -1, // linha 6
                                        -1, 1, -1, -1, -1, 1, -1, // linha 7
                                        -1, 1, -1, -1, -1, 1, -1, // linha 8
                                        1, 1, 1, -1, 1, 1, 1, 1 // linha 9 + viés
                        },

                        { // B na fonte 1
                                        1, 1, 1, 1, 1, 1, -1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, 1, 1, 1, 1, -1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        1, 1, 1, 1, 1, 1, -1, 1 // linha 9 + viés
                        },

                        { // C na fonte 1
                                        -1, -1, 1, 1, 1, 1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, -1, 1, 1, 1, 1, -1, 1 // linha 9 + viés
                        },

                        { // D na fonte 1
                                        1, 1, 1, 1, 1, -1, -1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        1, 1, 1, 1, 1, -1, -1, 1 // linha 9 + viés
                        },

                        { // E na fonte 1
                                        1, 1, 1, 1, 1, 1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, -1,
                                        -1, 1, -1, 1, -1, -1, -1,
                                        -1, 1, 1, 1, -1, -1, -1,
                                        -1, 1, -1, 1, -1, -1, -1,
                                        -1, 1, -1, -1, -1, -1, -1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        1, 1, 1, 1, 1, 1, 1, 1 // linha 9 + viés
                        },

                        { // J na fonte 1
                                        -1, -1, -1, 1, 1, 1, 1,
                                        -1, -1, -1, -1, -1, 1, -1,
                                        -1, -1, -1, -1, -1, 1, -1,
                                        -1, -1, -1, -1, 1, 1, -1,
                                        -1, -1, -1, -1, 1, 1, -1,
                                        -1, -1, -1, -1, -1, 1, -1,
                                        1, 1, -1, -1, 1, 1, -1,
                                        -1, 1, -1, -1, 1, 1, -1,
                                        -1, -1, 1, 1, 1, -1, -1, 1 // linha 9 + viés
                        },

                        { // K na fonte 1
                                        1, 1, 1, -1, -1, 1, 1,
                                        -1, 1, -1, -1, 1, -1, -1,
                                        -1, 1, -1, 1, -1, -1, -1,
                                        -1, 1, -1, -1, -1, -1, -1,
                                        -1, 1, -1, -1, -1, -1, -1,
                                        -1, 1, -1, 1, -1, -1, -1,
                                        -1, 1, -1, -1, 1, -1, -1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        1, 1, 1, -1, -1, 1, 1, 1 // linha 9 + viés
                        },

                        { // A na fonte 2
                                        -1, -1, -1, 1, -1, -1, -1,
                                        -1, -1, -1, 1, -1, -1, -1,
                                        -1, -1, -1, 1, -1, -1, -1,
                                        -1, -1, 1, -1, 1, -1, -1,
                                        -1, -1, 1, -1, 1, -1, -1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        -1, 1, 1, 1, 1, 1, -1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        -1, 1, -1, -1, -1, 1, -1, 1 // linha 9 + viés
                        },

                        { // B na fonte 2
                                        1, 1, 1, 1, 1, 1, -1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, 1, 1, 1, 1, 1, -1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, 1, 1, 1, 1, 1, -1, 1 // linha 9 + viés
                        },

                        { // C na fonte 2
                                        -1, -1, 1, 1, 1, -1, -1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        -1, -1, 1, 1, 1, -1, -1, 1 // linha 9 + viés
                        },

                        { // D na fonte 2
                                        1, 1, 1, 1, 1, -1, -1,
                                        1, -1, -1, -1, -1, 1, -1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, 1, -1,
                                        1, 1, 1, 1, 1, -1, -1, 1 // linha 9 + viés
                        },

                        { // E na fonte 2
                                        1, 1, 1, 1, 1, 1, 1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, 1, 1, 1, 1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, 1, 1, 1, 1, 1, 1, 1 // linha 9 + viés
                        },

                        { // J na fonte 2
                                        -1, -1, -1, -1, -1, 1, -1,
                                        -1, -1, -1, -1, -1, 1, -1,
                                        -1, -1, -1, -1, -1, 1, -1,
                                        -1, -1, -1, -1, -1, 1, -1,
                                        -1, -1, -1, -1, -1, 1, -1,
                                        -1, -1, -1, -1, -1, 1, -1,
                                        -1, -1, -1, -1, -1, 1, -1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        -1, -1, 1, 1, 1, -1, -1, 1 // linha 9 + viés
                        },

                        { // K na fonte 2
                                        1, -1, -1, -1, -1, 1, -1,
                                        1, -1, -1, -1, 1, -1, -1,
                                        1, -1, -1, 1, -1, -1, -1,
                                        1, -1, 1, -1, -1, -1, -1,
                                        1, 1, -1, -1, -1, -1, -1,
                                        1, -1, 1, -1, -1, -1, -1,
                                        1, -1, -1, 1, -1, -1, -1,
                                        1, -1, -1, -1, 1, -1, -1,
                                        1, -1, -1, -1, -1, 1, -1, 1 // linha 9 + viés
                        },

                        { // A na fonte 3
                                        -1, -1, -1, 1, -1, -1, -1,
                                        -1, -1, -1, 1, -1, -1, -1,
                                        -1, -1, 1, -1, 1, -1, -1,
                                        -1, -1, 1, -1, 1, -1, -1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        -1, 1, 1, 1, 1, 1, -1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, 1, -1, -1, -1, 1, 1, 1 // linha 9 + viés
                        },

                        { // B na fonte 3
                                        1, 1, 1, 1, 1, 1, -1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, 1, 1, 1, 1, -1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        1, 1, 1, 1, 1, 1, -1, 1 // linha 9 + viés
                        },

                        { // C na fonte 3
                                        -1, -1, 1, 1, 1, -1, 1,
                                        -1, 1, -1, -1, -1, 1, 1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, -1,
                                        1, -1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, 1, 1,
                                        -1, -1, 1, 1, 1, -1, -1, 1 // linha 9 + viés
                        },

                        { // D na fonte 3
                                        1, 1, 1, 1, 1, 1, -1,
                                        -1, 1, -1, -1, -1, 1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        1, 1, -1, -1, -1, 1, -1,
                                        1, 1, 1, 1, 1, -1, -1, 1 // linha 9 + viés
                        },

                        { // E na fonte 3
                                        1, 1, 1, 1, 1, 1, 1,
                                        -1, 1, 1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, 1, -1, -1,
                                        -1, 1, 1, 1, 1, -1, -1,
                                        -1, 1, -1, -1, 1, -1, -1,
                                        -1, 1, -1, -1, -1, -1, -1,
                                        -1, 1, -1, -1, -1, -1, -1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        1, 1, 1, 1, 1, 1, 1, 1 // linha 9 + viés
                        },

                        { // J na fonte 3
                                        -1, -1, -1, -1, 1, 1, 1,
                                        -1, -1, -1, -1, -1, -1, 1,
                                        -1, -1, -1, -1, -1, -1, 1,
                                        -1, -1, -1, -1, -1, -1, 1,
                                        -1, -1, -1, -1, -1, -1, 1,
                                        -1, -1, -1, -1, -1, -1, 1,
                                        -1, -1, -1, -1, -1, -1, 1,
                                        -1, -1, 1, -1, -1, -1, 1,
                                        -1, -1, -1, 1, 1, 1, -1, 1 // linha 9 + viés
                        },

                        { // K na fonte 3. Isso e a linha 21 da matriz de treinamento. Cada dessas linhas
                          // representa uma letra, e cada letra tem 64 pixels, que sao representados por
                          // -1 e 1.
                                        1, 1, 1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        -1, 1, -1, -1, -1, 1, -1,
                                        -1, 1, -1, -1, 1, -1, -1,
                                        -1, 1, 1, 1, -1, -1, -1,
                                        -1, 1, -1, -1, 1, -1, -1,
                                        -1, 1, -1, -1, 1, 1, -1,
                                        -1, 1, -1, -1, -1, -1, 1,
                                        1, 1, 1, -1, -1, -1, 1, 1 // linha 9 + viés
                        }
        };

        public static double[][] Y_saidaEsperada = {
                        // Cada posição dela corresponde a uma linha de X_matrizTreinamento, nesta
                        // ordem:

                        { // Saída A
                                        1, -1, -1, -1, -1, -1, -1, // Fonte 1: os 1 estao exatamente na posicao 0 7 e
                                                                   // 14, que sao as
                                                                   // posicoes das letras A na matriz de treinamento. O
                                                                   // resto sao -1, porque
                                                                   // nao sao A.
                                        1, -1, -1, -1, -1, -1, -1, // Fonte 2:
                                        1, -1, -1, -1, -1, -1, -1 // Fonte 3:
                        },
                        // Saida B
                        {
                                        -1, 1, -1, -1, -1, -1, -1, // Fonte 1
                                        -1, 1, -1, -1, -1, -1, -1, // Fonte 2
                                        -1, 1, -1, -1, -1, -1, -1 // Fonte 3
                        },
                        { // Saída C
                                        -1, -1, 1, -1, -1, -1, -1, // Fonte 1
                                        -1, -1, 1, -1, -1, -1, -1, // Fonte 2
                                        -1, -1, 1, -1, -1, -1, -1 // Fonte 3
                        },
                        { // Saída D
                                        -1, -1, -1, 1, -1, -1, -1, // Fonte 1
                                        -1, -1, -1, 1, -1, -1, -1, // Fonte 2
                                        -1, -1, -1, 1, -1, -1, -1 // Fonte 3
                        },
                        { // Saída E
                                        -1, -1, -1, -1, 1, -1, -1, // Fonte 1
                                        -1, -1, -1, -1, 1, -1, -1, // Fonte 2
                                        -1, -1, -1, -1, 1, -1, -1 // Fonte 3
                        },
                        { // Saída J
                                        -1, -1, -1, -1, -1, 1, -1, // Fonte 1
                                        -1, -1, -1, -1, -1, 1, -1, // Fonte 2
                                        -1, -1, -1, -1, -1, 1, -1 // Fonte 3
                        },
                        { // Saída K
                                        -1, -1, -1, -1, -1, -1, 1, // Fonte 1
                                        -1, -1, -1, -1, -1, -1, 1, // Fonte 2
                                        -1, -1, -1, -1, -1, -1, 1 // Fonte 3
                        }
        };// Saídas esperadas para cada letra

        public static double[][] Pesos = new double[7][64];
        public static double TaxaAprendizagem = 0.002;
        public static int QuantidadeMaximaCiclos = 1000;
        public static double ErroMinimo = 0.0001;
        public static int ciclos = 0;

        static {
                for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 64; j++) {
                                Pesos[i][j] = Math.random() * 2 - 1;
                        }
                }
        }/*
          * Math.random() → gera um valor entre 0.0 e 0.999....
          *
          * Math.random() * 2 → multiplica esse valor por 2, resultando em um número
          * entre 0.0 e 1.999....
          * 
          * Math.random() * 2 - 1 → subtrai 1, deslocando o intervalo para -1.0 até
          * 0.999....
          */

        public static double calcularEQM(int neuronio) {
                double somaTotal = 0;

                for (int k = 0; k < 21; k++) { // percorre as 21 letras ou fotos
                        double u = 0; // reinicia "u" pra cada letra nova | u significa a soma ponderada dos pixels da
                                      // letra atual, multiplicados pelos pesos do neuronio atual

                        for (int j = 0; j < 64; j++) { // percorre as 64 posições (pixels + bias)
                                u += Pesos[neuronio][j] * X_matrizTreinamento[k][j];// u é a opiniao do juiz. Se u for
                                                                                    // bem positivo, o juiz está
                                                                                    // "convencido de que sim". Se for
                                                                                    // bem negativo, está "convencido de
                                                                                    // que não".
                        }

                        double d = Y_saidaEsperada[neuronio][k];
                        somaTotal += Math.pow(d - u, 2);
                }

                return somaTotal / 21;
        }

        public static int treinar(int neuronio) {
                double erro;
                // u é o juiz em cada dos pixels, e d e a saída esperada. A cada ciclo, o erro é
                // calculado e os pesos são atualizados.
                double eqmAnterior;
                double eqmAtual;

                int rodada = 0;
                do {
                        eqmAnterior = calcularEQM(neuronio);// eqm significa erro quadratico medio
                        for (int k = 0; k < 21; k++) {
                                double u = 0; // reinicia "u" pra cada letra nova

                                for (int j = 0; j < 64; j++) {// 64 pixesl
                                        u += Pesos[neuronio][j] * X_matrizTreinamento[k][j];

                                }
                                erro = Y_saidaEsperada[neuronio][k] - u;

                                for (int j = 0; j < 64; j++) {
                                        Pesos[neuronio][j] += TaxaAprendizagem * erro * X_matrizTreinamento[k][j];
                                }
                        }
                        rodada++;
                        eqmAtual = calcularEQM(neuronio);
                } while (Math.abs(eqmAnterior - eqmAtual) > ErroMinimo && (rodada < QuantidadeMaximaCiclos));

                return rodada;
        }

        // public static String testar(double[] foto) {
        // String[] letras = { "A", "B", "C", "D", "E", "J", "K" };
        // String resposta = "";

        // for (int i = 0; i < 7; i++) {
        // double somatorio = 0;
        // for (int j = 0; j < 64; j++) {
        // somatorio += Pesos[i][j] * foto[j];
        // }
        // if (somatorio >= 0) {
        // resposta = resposta + letras[i] + " ";
        // }
        // }

        // return resposta;
        // }
        public static String testar(double[] foto) {
                String[] letras = { "A", "B", "C", "D", "E", "J", "K" };
                String resposta = "";

                double maiorOpiniao = Double.NEGATIVE_INFINITY; // lacuna 1: com que valor começar?
                int juizMaisConvencido = -1;

                for (int i = 0; i < 7; i++) {
                        double somatorio = 0;
                        for (int j = 0; j < 64; j++) {
                                somatorio += Pesos[i][j] * foto[j];
                        }

                        if (somatorio >= 0) {
                                resposta = resposta + letras[i] + " ";
                        }

                        if (somatorio > maiorOpiniao) { // lacuna 2: quando esse juiz "bate o recorde"?
                                maiorOpiniao = somatorio;
                                juizMaisConvencido = i;
                        }
                }

                System.out.println("Juiz mais convencido: " + letras[juizMaisConvencido] + " cuja opinião foi: "
                                + maiorOpiniao);

                return resposta;

        }
}
