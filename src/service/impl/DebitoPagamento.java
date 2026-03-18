package service.impl;

import service.MetodoPagamento;

public class DebitoPagamento implements MetodoPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via CARTÃO DE DÉBITO: R$ " + valor);
    }
}
