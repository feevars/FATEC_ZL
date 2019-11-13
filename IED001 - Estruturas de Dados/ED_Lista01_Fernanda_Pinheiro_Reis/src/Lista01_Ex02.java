//	Carregar um vetor[5] inteiro. 
//	Enviar cada elemento para uma função e esta irá retornar o seu fatorial 
//	que será armazenado em um outro vetor. 
//	Exibir os dados dos vetores.	
	


public class Lista01_Ex02 {


	public static void main (String[] args) {

		int [] numero = new int [5];
		String resultado = "";
		int [] fatorial = new int [5];
		
		
		for(int i = 0; i < 5; i++) {
			numero[i] = (int)(1 + Math.random() * 13);
			
			resultado += "Fatorial de " + numero[i] + ": ";
			fatorial[i] = funcaofatorial(numero[i]);
			resultado += fatorial[i] + "\n";
		}

		System.out.println(resultado);

	}

	static int funcaofatorial(int numero) {

		int fat = 1;

		for(int i = numero; i > 1 ; i--) {
			fat *= i;
		}

		return fat;
	}
}