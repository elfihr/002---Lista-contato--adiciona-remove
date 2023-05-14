import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        Scanner leiaString = new Scanner(System.in);

        String nome, sobrenome,telefone;
        int menu = 1;
        Pessoa objContato;
        boolean validacao;


        while (menu != 0) {
            exibeMenu();
            System.out.print("DIGITE A OPÇÂO >> ");
            menu = leia.nextInt();

            if (menu == 1) {
                System.out.println("--------CADASTRO---------");
                System.out.print("NOME: ");
                nome = leiaString.nextLine();

                System.out.print("SOBRENOME: ");
                sobrenome = leiaString.nextLine();

                do{

                    System.out.print("TELEFONE: ");
                    telefone = leiaString.nextLine();
                    validacao = telefone.matches("[0-9]{8}");
                    if (! validacao) {
                        System.out.println("Numero Invalido. Digite novamente");
                    }
                    }while (! validacao);

                objContato = new Pessoa(nome, sobrenome, telefone);

                Agenda.adiciona(objContato);

            } else if (menu == 2) {
                System.out.println("---------LISTA DE CONTATO--------");
                System.out.println(Agenda.listar());
            }
            else if (menu == 3) {
                System.out.println("REMOVE---------");
                System.out.println("DIgete o nome: ");
                nome = leiaString.nextLine();
                if (!(Agenda.getListaPessoa()).isEmpty()) {
                    if (Agenda.remove(nome)) {
                        System.out.println("Contato removido");
                    } else {
                        System.out.println("COntato nao existe na Lista de Contato");
                    }
                }

            }

            else {
                System.out.println("Digite um comando valido");
            }
        }
        System.out.println("\nFIM DO PROGRAMA");


    }private static void exibeMenu () {
        System.out.println("=========MENU========");
        System.out.println("[1] - ADICIONAR CONTATO");
        System.out.println("[2] - LISTAR CONTATO");
        System.out.println("[3] - REMOVER CONTATO");
        System.out.println("[0] - FINALIZAR PROGRAMA");
    }
}