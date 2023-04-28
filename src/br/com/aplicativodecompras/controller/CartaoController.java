package br.com.aplicativodecompras.controller;

import br.com.aplicativodecompras.model.CartaoModel;

import java.util.Scanner;

public class CartaoController extends CartaoModel {

    Scanner scanner = new Scanner(System.in);
    @Override
    public void setSaldoCredito(double saldoCredito) {
        super.setSaldoCredito(saldoCredito);
    }

    @Override
    public double getSaldoCredito() {
        return super.getSaldoCredito();
    }
    public boolean checarLimite (double valorDaCompra) {
        if ((this.getSaldoCredito() - valorDaCompra) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public void definirLimite() {
        System.out.println("Insira o limite do seu cartão de crédito: ");
        this.setSaldoCredito(scanner.nextDouble());
    }

    public void mostrarLimiteRestante () {
        System.out.printf("\nLimite de crédito restante: R$%.2f", this.getSaldoCredito());
    }
}
