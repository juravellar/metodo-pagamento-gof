package service;

public class PixPagamento implements MetodoPagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via PIX: R$ " + valor);
    }
}
