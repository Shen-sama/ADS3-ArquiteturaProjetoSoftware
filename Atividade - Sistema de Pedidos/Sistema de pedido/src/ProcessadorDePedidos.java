import java.util.Scanner;

public final class ProcessadorDePedidos {

    private ProcessadorDePedidos() {
        throw new UnsupportedOperationException("Esta classe não pode ser instanciada");
    }

    public static void criarPedido(PedidoRepository repository, Scanner scanner) {
        System.out.println("----------------------------------------------");
        System.out.println("Informe o nome do cliente:");
        String nomeCliente = scanner.next();
        System.out.println("----------------------------------------------");
        System.out.println("Informe o CPF do cliente:");
        String cpfCliente = scanner.next();

        int numTipoCliente = -1;
        TipoCliente tipoCliente = null;
        System.out.println("----------------------------------------------");
        do {
            System.out.println("Tipos de Cliente:");
            System.out.println("1 - Normal");
            System.out.println("2 - VIP");
            System.out.println("----------------------------------------------");
            System.out.println("Digite o número correspondente ao tipo do cliente:");
            if (scanner.hasNextInt()) {
                numTipoCliente = scanner.nextInt();
                try {
                    tipoCliente = TipoCliente.fromInt(numTipoCliente);
                } catch(IllegalArgumentException error) {
                    System.out.println("----------------------------------------------");
                    System.out.println("Entrada inválida! Por favor, digite um número dentro dos limites mostrados.");
                    System.out.println("----------------------------------------------");
                }
            } else {
                System.out.println("----------------------------------------------");
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                System.out.println("----------------------------------------------");
                scanner.next();
            }
        } while (numTipoCliente < 1 || numTipoCliente > 2);

        double valorPedido = 0;
        boolean valorValido = false;
        System.out.println("----------------------------------------------");
        do {
            System.out.println("Digite o valor do pedido:");
            if (scanner.hasNextDouble()) {
                valorPedido = scanner.nextDouble();

                if (valorPedido > 0) {
                    valorValido = true;
                } else {
                    System.out.println("----------------------------------------------");
                    System.out.println("Entrada inválida! Por favor, digite um preço não negativo.");
                    System.out.println("----------------------------------------------");
                }
            } else {
                System.out.println("----------------------------------------------");
                System.out.println("Entrada inválida! Por favor, digite um preço correto.");
                System.out.println("----------------------------------------------");
                scanner.next();
            }

        } while (!valorValido);

        Cliente cliente = new Cliente(nomeCliente, tipoCliente, cpfCliente);
        Pedido pedido = new Pedido(cliente, valorPedido);
        System.out.println("----------------------------------------------");
        System.out.println("Aplicando desconto...");

        CalculadoraDesconto descontoCliente = null;
        switch (cliente.getTipoCliente())
        {
            case NORMAL -> {
                descontoCliente = new CalculadoraDesconto(new DescontoClienteComum());
            }

            case VIP -> {
                descontoCliente = new CalculadoraDesconto(new DescontoClienteVIP());
            }
        }
        pedido.setValorConta(descontoCliente.aplicarDesconto(pedido.getValorConta()));

        System.out.println("----------------------------------------------");
        System.out.println("Desconto aplicado.");
        System.out.println("----------------------------------------------");
        repository.salvarPedidos(pedido);
    }

    public static void finalizarPedido(PedidoRepository repository, Scanner scanner) {
        Pedido pedidoEscolhido = null;
        int entradaID = 0;

        do {
            System.out.println("----------------------------------------------");
            System.out.println("Digite o ID do pedido a ser finalizado:");
            if (scanner.hasNextInt()) {
                entradaID = scanner.nextInt();

                for (Pedido pedido : repository.getPedidos()) {
                    if (pedido.getId() == entradaID) {
                        pedidoEscolhido = pedido;
                        break;
                    }
                }

                if (pedidoEscolhido == null) {
                    System.out.println("----------------------------------------------");
                    System.out.println("Entrada inválida! Por favor, digite um ID existente.");
                }

            } else {
                System.out.println("----------------------------------------------");
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
            }
        } while(pedidoEscolhido == null);

        System.out.println("----------------------------------------------");
        System.out.println("Finalizando Pedido de ID P" + pedidoEscolhido.getId() + "...");

        pedidoEscolhido.setStatusPedido(StatusPedido.FINALIZADO);

        System.out.println("----------------------------------------------");
        System.out.println("Pedido Finalizado com sucesso.");
        System.out.println("----------------------------------------------");
        System.out.println("Mandando Notificações...\n");

        String mensagem = String.format("Pedido de ID P%d no nome de %s com a valor final de %.2f foi finalizado com sucesso.\n", pedidoEscolhido.getId(), pedidoEscolhido.getCliente().getNome(), pedidoEscolhido.getValorConta());

        NotificacaoCliente notificacaoCliente = new NotificacaoCliente(new EmailNotificador());
        notificacaoCliente.mandarNotificacao(mensagem);

        notificacaoCliente = new NotificacaoCliente(new SMSNotificador());
        notificacaoCliente.mandarNotificacao(mensagem);

    }
}
