package controller;

public class HeapSort {
	
	
	public void heapify(int[] vetor, int posicao, int tamanhodoVetor) {
		
		int tamanho = vetor.length;
		
		int iEsquerda = 2 * posicao + 1;
		int iDireita = iEsquerda + 1;
		
		//condicao de parada
		if (iEsquerda < tamanhodoVetor) {
			if (iDireita < tamanhodoVetor) {
				//se ainda estivermos dentro do vetor, verifica qual o maior filho
				
				if(lista[iEsquerda] < lista[iDireita]) {
					iEsquerda = iDireita;
				}
			}
		}
		int leftIndex = 2*rootElementIndex + 1;  
        int rightIndex = 2*rootElementIndex + 2;  
        
        int largest = rootElementIndex;
       
        if (leftIndex < arrayLength && arr[leftIndex] > arr[largest])
            largest = leftIndex;
        
        if (rightIndex < arrayLength && arr[rightIndex] > arr[largest])
            largest = rightIndex;
        
        if (largest != rootElementIndex){
           
            int swap = arr[rootElementIndex];
            arr[rootElementIndex] = arr[largest];
            arr[largest] = swap;
            
            heapify(arr, arrayLength, largest);
	
	}
	
	
	
}
