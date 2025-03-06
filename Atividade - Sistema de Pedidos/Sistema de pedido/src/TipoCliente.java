public enum TipoCliente {
    NORMAL(1), VIP(2);

    private final int valor;

    TipoCliente(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoCliente fromInt(int valor)
    {
        for (TipoCliente tipo : TipoCliente.values())
        {
            if (tipo.getValor() == valor)
            {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + valor);
    }
}
