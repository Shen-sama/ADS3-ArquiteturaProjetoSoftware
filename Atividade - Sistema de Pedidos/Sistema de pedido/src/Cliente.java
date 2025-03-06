public class Cliente {

    private static int contadorId = 1;
    private int id;
    private String nome;
    private TipoCliente tipoCliente;
    private String cpf;

    public Cliente(String nome, TipoCliente tipoCliente, String cpf) {
        this.id = contadorId++;
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.cpf = cpf;
    }

    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nTipo Cliente: " + tipoCliente + "\nCPF: " + cpf;
    }

}
