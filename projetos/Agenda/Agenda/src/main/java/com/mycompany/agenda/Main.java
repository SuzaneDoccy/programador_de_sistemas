package com.mycompany.agenda;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        
        String opcao;
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        
        do {
            
            System.out.println("Digite a opção que deseja executar:");
            System.out.println("1) Adicionar uma pessoa");
            System.out.println("2) Remover uma pessoa");
            System.out.println("3) Imprimir todos na agenda");
            System.out.println("4) Imprimir uma pessoa");
            System.out.println("5) Buscar uma pessoa");
            System.out.println("6) Sair do sistema.");
            
            opcao = scanner.nextLine();
            
            switch (opcao) {
                case "1":
                    
                    System.out.println("Digite o nome da pessoa:");
                    String nome = scanner.nextLine();
                    
                    System.out.println("Digite a idade da pessoa:");
                    String idade = scanner.nextLine();
                    int idadeTransformada = Integer.parseInt(idade);
                    
                    System.out.println("Digite a altura da pessoa:");
                    String altura = scanner.nextLine();
                    Double alturaTranformada = Double.parseDouble(altura);
                    
                    agenda.armazenaPessoa(nome, idadeTransformada, alturaTranformada);
                    break;
                case "2":
                    System.out.println("Digite o nome da pessoa a ser removida: ");
                    nome = scanner.nextLine();
                    agenda.removePessoa(nome);
                    break;
                case "3":
                    agenda.imprimeAgenda();
                    break;
                case "4":
                    int index;
                    
                    System.out.println("Digite a posição da pessoa na agenda: ");
                    String indexString = scanner.nextLine();
                    index = Integer.parseInt(indexString);
                    
                    try {
                        agenda.imprimePessoa(index);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Número informado não encontrado na agenda.");
                    }
                    break;
                case "5":
                    System.out.println("Digite o nome da pessoa a ser procurada: ");
                    nome = scanner.nextLine();
                    
                    int posicaoEncontrada = agenda.buscaPosicaoPessoa(nome);
                    
                    switch(posicaoEncontrada) {
                        case -1:
                            System.out.println("A agenda está vazia.");
                            break;
                        case 0:
                            System.out.println("Não foi encontrado o " + nome + " informado na agenda.");
                            break;
                        default:
                            System.out.println("A posição do " + nome + " na agenda é: " + posicaoEncontrada);
                            break;
                    }
                    break;
            }
            
        } while(!"6".equals(opcao));

        System.out.println("Sistema encerrado.");        
    }
    
}
