import builder.PagamentoFactory;
import builder.TipoPagamentoFactory;
import model.TipoPagamento;
import service.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Map<TipoPagamento, Supplier<MetodoPagamento>> tipoPagamentoSupplierMap = new HashMap<>();
        tipoPagamentoSupplierMap.put(TipoPagamento.PIX, PixPagamento::new);
        tipoPagamentoSupplierMap.put(TipoPagamento.BOLETO, BoletoPagamento::new);
        tipoPagamentoSupplierMap.put(TipoPagamento.CREDITO, CreditoPagamento::new);
        tipoPagamentoSupplierMap.put(TipoPagamento.DEBITO, DebitoPagamento::new);
        tipoPagamentoSupplierMap.put(TipoPagamento.DINHEIRO, DinheiroPagamento::new);

        PagamentoFactory factory = new TipoPagamentoFactory(tipoPagamentoSupplierMap);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEMA DE PAGAMENTO ===");

            for (TipoPagamento tipo : TipoPagamento.values()) {
                System.out.println("- " + tipo);
            }

            System.out.println("Digite o tipo de pagamento (ou 'sair'):");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando...");
                break;
            }

            try {
                TipoPagamento tipo = TipoPagamento.valueOf(entrada.toUpperCase());

                System.out.println("Digite o valor:");
                double valor = Double.parseDouble(scanner.nextLine());

                factory.processarPagamento(tipo, valor);

            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de pagamento inválido!");
            }
        }

        scanner.close();
    }
}