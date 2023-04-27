package br.com.aplicativodecompras.view;

import br.com.aplicativodecompras.controller.Loja;

public class Main extends Loja {
    public static void main (String[] args){
        Loja loja = new Loja();
        loja.definirLimite();
        loja.iniciar();
    }
}
