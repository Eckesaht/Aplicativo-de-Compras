package br.com.aplicacaodecompras.view;

import br.com.aplicacaodecompras.controller.Loja;

public class Main extends Loja {
    public static void main (String[] args){
        Loja loja = new Loja();
        loja.definirLimite();
        loja.iniciar();

    }
}
