import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {

    private List<Pedido> pedidos;

    public PedidoRepository(){
        this.pedidos = new ArrayList<>();
    }

    public void salvarPedidos(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido Salvo!\n" + pedido);
    }

    public void listarPedidos() {
        for(Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
