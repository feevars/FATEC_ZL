/**
 Fazer uma aplicação que rode 5 Threads que cada uma delas imprima no 
 console o seu número. 
 */
package view;
import controller.PrintThread;

/**
 * @author Fernanda
 *
 */
public class MainPrint {
	public static void main(String[] args) {
		int n = 0;
		for (int seq = 0; seq<5; seq++) {
				n += 1;
			PrintThread print = new PrintThread(n);
			print.start();
		}
	}

}
