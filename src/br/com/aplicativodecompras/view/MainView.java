package br.com.aplicativodecompras.view;

import br.com.aplicativodecompras.controller.LojaController;

public class MainView extends LojaController {
    public static void main (String[] args){
        LojaController loja = new LojaController();
        loja.definirLimite();
        loja.iniciar();
    }
}
