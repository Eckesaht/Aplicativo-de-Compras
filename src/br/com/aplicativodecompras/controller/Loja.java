package br.com.aplicativodecompras.controller;

import br.com.aplicativodecompras.model.Produtos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;

public class Loja extends CartaoDeCredito implements Produtos {
    Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        this.mostrarProdutosDisponiveis();
        this.escolherProduto();
        System.out.println("\nAdicionar mais itens ao carrinho [Y] | Finalizar compra [N]");
        String confirmacao = "";
        while (confirmacao!="y" || confirmacao !="n") {
            confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("y")) {
                this.iniciar();
                break;
            } else if (confirmacao.equalsIgnoreCase("n")) {
                this.finalizar();
                return;
            }
        }
    }

    private void finalizar() {
        Set<String> keys = carrinhoDeCompras.keySet();
        System.out.println("COMPRAS REALIZADAS");
        double valorTotal = 0;
        ArrayList<Integer> valores = new ArrayList<>();
        for(String key : keys){
            valores.add(carrinhoDeCompras.get(key));
            valorTotal += carrinhoDeCompras.get(key);
        }
        Collections.sort(valores);
        for(double valor : valores) {
            for(String key : keys) {
                if(carrinhoDeCompras.get(key) == valor) {
                    System.out.printf("| %s - R$%.2f ", key, valor);
                    break;
                }
            }
        }
        System.out.printf("\nVALOR TOTAL: R$%.2f\n", valorTotal);
        this.mostrarLimiteRestante();
    }

    private void escolherProduto() {
        System.out.println("Escolha um produto: ");
        int escolha = scanner.nextInt();
        escolha -= 1;
        this.adicionarAoCarrinhoDeCompras(escolha);
        this.atualizarProdutosDisponiveis(produtos, precos, escolha);

        this.mostrarProdutosDisponiveis();
        System.out.println();

        System.out.println("Seu carrinho de compras: ");
        this.mostrarCarrinhoDeCompras();
        this.mostrarLimiteRestante();
    }

    private void atualizarProdutosDisponiveis(ArrayList produtos, ArrayList precos, int indice) {
        produtos.remove(indice); precos.remove(indice);
    }
    private void mostrarCarrinhoDeCompras() {
        Set keys = carrinhoDeCompras.keySet();
        double valorTotal = 0;
        for(Object key:keys) {
            System.out.printf("| %s - R$%d ", key, carrinhoDeCompras.get(key));
            valorTotal += carrinhoDeCompras.get(key);
        }
        System.out.printf("\nVALOR TOTAL: R$%.2f", valorTotal);

    }

    private void mostrarProdutosDisponiveis() {
        System.out.println(
                        "==============================================\n" +
                        "             PRODUTOS DISPONÍVEIS             \n" +
                        "==============================================\n"
        );

        for (var x = 0; x < produtos.size(); x++){
            System.out.printf("%s - R$%d [Opcao %d]\n", produtos.get(x), precos.get(x), x+1);
        }
    }

    private void adicionarAoCarrinhoDeCompras(int indice) {
        if (checarLimite(precos.get(indice)) == true) {
            this.carrinhoDeCompras.put(produtos.get(indice), precos.get(indice));
            this.setSaldoCredito(getSaldoCredito() - precos.get(indice));
        } else {
            System.out.println("Saldo insuficiente para realizar a compra.\n");
        }
    }
}
