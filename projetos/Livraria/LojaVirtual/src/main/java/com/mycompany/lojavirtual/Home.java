package com.mycompany.lojavirtual;

import java.util.Scanner;

public class Home {

    public static void main(String[] args) {
        //Trabalho bom, trabalho bonito, trabalho bem feito

        String opcaoN, opcaoL;
        Scanner scanner = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        Livraria livraria = new Livraria();
        Caixa caixa = new Caixa();
        BancodeDados bancodeDados = new BancodeDados();
        Tabela_BD tbd = new Tabela_BD();

        do {
            System.out.println("__________________________________________________");
            System.out.println("         Olá querido(a) Cliente (o^-^o)");
            System.out.println("  Seja muito bem-vindo(a) a Livraria Virtual.");
            System.out.println(" Aqui tu pode se cadastrar e vender teus livros.   ");
            System.out.println("___________________________________________________");
            System.out.println("|           Digite o que deseja fazer:           |");
            System.out.println("|       1) Cadastrar-se como cliente.            |");
            System.out.println("|       2) Remover login.                        |");
            System.out.println("|       3) Imprimir lista de clientes.           |");
            System.out.println("|       4) Imprimir um cliente da lista.         |");
            System.out.println("|       5) Buscar um cliente.                    |");
            System.out.println("|       6) Adicionar livros.                     |");
            System.out.println("|       7) Comprar livros.                       |");
            System.out.println("|       8) Atualizar cadastro.                   |");
            System.out.println("|       9) Sair do Menu e/ou Venda.             |");
            System.out.println("__________________________________________________");

            opcaoN = scanner.nextLine();

            switch (opcaoN) {

                case "1":
                    System.out.println("Ótimo! faremos o teu cadastro, inicialmente digite teu nome:");
                    String nomeC = scanner.nextLine();

                    System.out.println("Digite a sua idade:");
                    String idade = scanner.nextLine();
                    int idadeTransformada = Integer.parseInt(idade);

                    System.out.println("Digite teu telefone:");
                    String telefone = scanner.nextLine();

                    System.out.println("Digite teu e-mail:");
                    String email = scanner.nextLine();
                    System.out.println("Você foi cadastrado(a) com sucesso.");

                    cadastro.armazenaCliente(nomeC, idadeTransformada, telefone, email);
                    break;

                case "2":
                    System.out.println("Quem deseja remover?");
                    nomeC = scanner.nextLine();
                    cadastro.removeCliente(nomeC);
                    break;

                case "3":
                    cadastro.imprimeClientes();
                    break;

                case "4":
                    int index;

                    System.out.println("Digite a posição na Lista de Login:");
                    String indexString = scanner.nextLine();
                    index = Integer.parseInt(indexString);

                    try {
                        cadastro.imprimeCliente(index);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Número informado não foi encontrado(a) na Lista de Login.");
                    }
                    break;

                case "5":
                    System.out.println("Digite o nome da pessoa a ser procurada: ");
                    nomeC = scanner.nextLine();

                    int posicaoEncontrada = cadastro.buscaPosicaoCliente(nomeC);

                    switch (posicaoEncontrada) {
                        case -1:
                            System.out.println("A agenda está vazia.");
                            break;
                        case 0:
                            System.out.println("Não foi encontrado(a) " + nomeC + " informado na agenda.");
                            break;
                        default:
                            System.out.println("A posição do " + nomeC + " na agenda é: " + posicaoEncontrada);
                    }
                    break;

                case "6":
                    System.out.println("Digite o nome do livro:");
                    String nomeLivro = scanner.nextLine();

                    System.out.println("Digite o preço unitário do livro:");
                    String preco = scanner.nextLine();
                    double precoUnitario = Double.parseDouble(preco);

                    livraria.armazenaLivro(nomeLivro, precoUnitario);
                    break;

                case "7":

                    do {
                        System.out.println("|A) Adicionar Produto.        |");
                        System.out.println("|B) Remover Produto.          |");
                        System.out.println("|C) Mostrar itens do caixa.   |");
                        System.out.println("|E) Encerrar Compra.          |");

                        opcaoL = scanner.nextLine();

                        switch (opcaoL) {

                            case "A":
                                String opcaoSaida;
                                do {
                                    System.out.println("Recomendamos que escolha a opção C para ver ");
                                    System.out.println("todos os itens do caixa antes de finalizar a compra.");
                                    System.out.println("____________________________");
                                    livraria.imprimeLivraria();
                                    System.out.println("Selecione um livro ou a opção 'S' para finalizar");
                                    opcaoSaida = scanner.nextLine();

                                    if (opcaoSaida.equals("S")) {
                                        continue;
                                    }

                                    System.out.println("Informe qual a quantidade desejada:");
                                    String qtd = scanner.nextLine();
                                    int quantidade = Integer.parseInt(qtd);
                                    int lugarLivro = Integer.parseInt(opcaoSaida);

                                    Livro livro = livraria.temLivroNaPosicao(lugarLivro);
                                    
                                    if (livro == null) {
                                        System.out.println("Livro não foi encontrado.");
                                        continue;
                                    }

                                    caixa.armazenaProduto(livro, quantidade);
                                    System.out.println("Livro adicionado no caixa.");
                                } while (!"S".equals(opcaoSaida));
                                break;

                            case "B":
                                caixa.imprimeCaixa();
                                System.out.println("______________________________________");
                                System.out.println("Diga o nome do produto para removê-lo:");

                                String nomep = scanner.nextLine();
                                caixa.removeProduto(nomep);
                                break;

                            case "C":
                                caixa.imprimeCaixa();
                                break;
                        }
                    } while (!"E".equals(opcaoL));
                    System.out.println("Compra armazenada.");
                    break;

                case "8":
                    System.out.println("Digite a posição a ser atualizada:");
                    String posicao = scanner.nextLine();
                    index = Integer.parseInt(posicao);
                    System.out.println("Atualizaremos o teu cadastro, inicialmente digite teu nome:");
                    nomeC = scanner.nextLine();

                    System.out.println("Digite a sua idade:");
                    idade = scanner.nextLine();
                    idadeTransformada = Integer.parseInt(idade);

                    System.out.println("Digite teu telefone:");
                    telefone = scanner.nextLine();

                    System.out.println("Digite teu e-mail:");
                    email = scanner.nextLine();

                    System.out.println("Você foi cadastrado(a) com sucesso.");
                    cadastro.atualizaCadastro(index, nomeC, idadeTransformada, telefone, email);

            }

        } while (!"10".equals(opcaoN));
        System.out.println("Menu e/ou venda finalizado(a).");
    }
}
