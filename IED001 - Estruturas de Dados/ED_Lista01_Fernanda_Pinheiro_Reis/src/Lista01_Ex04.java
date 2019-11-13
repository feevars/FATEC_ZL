// Carregar uma matriz [4x4] inteiro. Apresentar
// Soma dos valores no intervalo de 1 a 100.
// Quantidade de números impares entre 30 a 50.
// Quantidade de números divisíveis por 8.
// Quantidades de números ímpares divisíveis por 3.
// Fatorial do maior número informado na matriz.

public class Lista01_Ex04 {

	public static void main(String[] args) {

		int [][] matriz = new int[4][4];
		int cont_impares = 0;
		int cont_div8 = 0;
		int soma1a100 = 0;
		int cont_impdiv3 = 0;
		int fat = 1;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = (int)(1 + Math.random() * 200);


				if (matriz[i][j] >= 1 && matriz[i][j] < 100) {
					soma1a100 += matriz[i][j]; //soma dos valores entre 1 e 100
				}

				if (matriz[i][j] >= 30 && matriz[i][j] <= 50 && matriz[i][j] % 2 == 1) {
					cont_impares += 1; // ímpares entre 30 e 50
				}

				if (matriz[i][j] % 8 == 0) {
					cont_div8 += 1; //divisiveis por 8
				}

				if (matriz[i][j] % 2 == 1 && matriz[i][j] % 3 == 0) {
					cont_impdiv3 += 1; //impares divisíveis por 3
				}
			}
		}

		int maior = matriz[0][0];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (matriz[i][j] > maior) {
					maior = matriz[i][j];
				}
			}
		}
		
		for (int i = maior; i > 1; i--) {
			fat *= i;
		} 

		
		System.out.println("Soma dos valores entre 1 e 100: " + soma1a100);
		System.out.println("Ímpares entre 30 e 50: " + cont_impares);
		System.out.println("Divisíveis por 8: " + cont_div8);
		System.out.println("Ímpares divisíveis por 3: " + cont_impdiv3);
		System.out.println("Maior número: " + maior + "   fatorial: " + fat);
	}

}
