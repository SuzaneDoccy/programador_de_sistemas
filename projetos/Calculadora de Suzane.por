programa
{
	
inclua biblioteca Matematica --> mat
	
	
funcao inicio()
	{
		
real soma, subtracao, multiplicacao, divisao, operacao, resultado
		
real numero1, numero2
		
		
escreva("Inicialmente escolha o primeiro número: \n")
		
leia(numero1)

		
escreva("Agora digite o segundo número: \n")
		
leia(numero2)
		
		
escreva("Agora escolha a operação que deseja calcular com os números escolhidos anteriormente \n")
		
escreva("\n 1 = soma \n\n")
		
escreva(" 2 = subtracao \n\n")
		
escreva(" 3 = multiplicacao \n\n")
		
escreva(" 4 = divisao \n\n")
		
leia(operacao)

			
se (operacao == 1) {
				
resultado = numero1 + numero2 
				
escreva("A soma dos números é: ", resultado)
			
}
			
senao se (operacao == 2) { 
			 	
resultado = numero1 - numero2
			 	
escreva("A subtracao dos números é: ", resultado)
			
}
			
senao se (operacao == 3) { 
				
resultado = numero1 * numero2
				
escreva("A multiplicação dos números é: ", resultado)
			
}
			
senao se (operacao == 4) { 
				
resultado = numero1/numero2
				
escreva("A divisão dos números é: ", resultado)
			
}
			
senao { 
				
escreva("Operação invalida pela falta de escolha, volte novamente e escolha uma operação \n")
			
}

			
	
}



/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 433; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */