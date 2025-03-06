import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        PedidoRepository pedidoRepository = new PedidoRepository();

        int opcaoMenu;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("----------------------------------------------");
            System.out.println("1 - Criar Pedido");
            System.out.println("2 - Finalizar Pedido");
            System.out.println("3 - Listar Pedidos Registrados");
            System.out.println("4 - Sair do Aplicativo");
            System.out.println("----------------------------------------------");
            System.out.println("Digite o número da opção desejada:");
            if (input.hasNextInt()) {
                opcaoMenu = input.nextInt();
            } else {
                opcaoMenu = 0;
                input.next();
            }

            switch(opcaoMenu)
            {
                case 1:
                    ProcessadorDePedidos.criarPedido(pedidoRepository, input);
                    break;
                case 2:
                    ProcessadorDePedidos.finalizarPedido(pedidoRepository, input);
                    break;
                case 3:
                    System.out.println("----------------------------------------------");
                    System.out.println("Lista de Pedidos Registrados:\n");
                    pedidoRepository.listarPedidos();
                    break;
                case 4:
                    System.out.println("----------------------------------------------");
                    System.out.println("Obrigado por utilizar o programa!");
                    System.out.println("----------------------------------------------");
                    break;
                default:
                    System.out.println("----------------------------------------------");
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcaoMenu != 4);

        input.close();

    }
}
