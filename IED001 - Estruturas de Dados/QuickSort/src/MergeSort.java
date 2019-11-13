
public class MergeSort {
	int meio;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//public void merge(int[] vetor, int primeiro, int ultimo, )
	
	void mergeSort (int [] vetor, int inicial, int fim) {
		if (inicial < fim) {
			meio = (inicial + fim)/2;
		}
		
		mergeSort(vetor, inicial, meio);
		mergeSort(vetor, meio+1, fim);
		//mergeSort(vetor, inicial, meio);
	}
}
