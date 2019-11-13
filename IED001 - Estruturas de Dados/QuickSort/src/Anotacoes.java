
public class Anotacoes {
	/*
	*		Algoritmos de Ordenação
	*
	*
	*------	MERGE SORT -------
	*
	* intercalação - precisa necessariamente de um vetor auxiliar
	*	Tamanho (modo estático) ou vetores auxiliares (modo dinâmico, o modo "certo")
	*   São divididos em N vetores. Não particionado.
	*   NÃO É TÃO PERFORMÁTICO quanto o Quick Sort - tem mais comparações
	*	unir dois arrays já ordenados.   
	*  
	*
	*	divide um vetor original em N subpartes de tamanho 1
	*
	* 	*complexidade assintótica*
	* 
	* mergesort(A[0..n - 1], inicio, fim)
	* 	se (inicio < fim)
	* 		meio <- (inicio + fim) / 2
	* 		mergesort(A, inicio, meio) 
	* 		mergesort (A, meio + 1, fim)
	* 		mergesort(A, inicio, meio, fim)
	* fim_se
	* 
	* trabalha com o conceito de pop da pilha.
	*
	*conteúdo de 2 arquivos pode ser ordenado por mergesort 
	*
	*Divisão - divide o vetor original em N vetores 
	*Conquista - verifica qual é maior que o outro e troca as posições
	*
	*~principio básico~ 
	*Merge Sort --> intercalação para ordenar registros
	*Quick Sort --> particionamento
	*
	*
	*(13572468)
	*(1357)(2468)
	*(13)(57)(24)(68)
	*(1)(3)(5)(7)(2)(4)(6)(8)
	*(13)(57)(24)(68)
	*(1357)(2468)
	*(1257)(3468)
	*(12347)(568)
	*(1234)(5678)
	*(12345678)
	*
	*21/11 - TRABALHO
	*28/11 - PROVA
	*
	*2 SEMANAS PARA CADA LISTA A PARTIR DE AGORA!!!11111!!!11UM
	*
	*------QUICK SORT-------
	* Não possui vetor adicional 
	* define um pivô
	* Classificado por troca!!!!!!!
	* 
	* 
	* 
	* para a lista dinâmica, é melhor o merge sort
	* 
	* -----------------------------------------------------------------------------
	* 
	*								AULA 24/10/19
	*
	*	Recursão é mais performático
	*
	*	
	*	HEAPSORT
	*	- fila - começa pelo final pesquisando os maiores elementos
	*	
	* 
	* 
	* 
	*
	*
	*/
}
