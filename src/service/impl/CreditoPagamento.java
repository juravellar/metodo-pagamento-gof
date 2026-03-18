package service.impl;

import service.MetodoPagamento;

public class CreditoPagamento implements MetodoPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via CARTÃO DE CRÉDITO: R$ " + valor);
    }
}
