//	Criar e carregar uma matriz [4][4] onde os valores da diagonal principal ser�o carregados
// 		pela aplica�ao conforme o gr�fico e os demais dados ser�o digitados pelo usu�rio.


public class Lista01_Ex05 {

	public static void main(String[] args) {

		int [][] matriz = new int [4][4];
		String string_matriz = "Matriz: \n";
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == j) {
					matriz[i][j] = (int) Math.pow(3, i);
				}else {
					matriz[i][j] = (int) (Math.random() * 100) - 50;
				}
				string_matriz += " [" + matriz[i][j] + "] ";
			}
			string_matriz += "\n";
		}
		System.out.println(string_matriz);
	}
}