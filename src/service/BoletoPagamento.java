package service;

public class BoletoPagamento implements MetodoPagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via BOLETO: R$ " + valor);
    }
}
