package br.com.aplicativodecompras.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public interface ProdutosModel {
    public HashMap<String, Integer> carrinhoDeCompras = new HashMap<>();
    public ArrayList<String> produtos = new ArrayList<>(Arrays.asList(
            "Sapato", "Mouse",
            "Camisa", "Blusa",
            "Armário", "Carteira",
            "Pendrive", "Celular"
    ));
    public ArrayList<Integer> precos = new ArrayList<>(Arrays.asList(
            170, 50,
            40, 50,
            500, 30,
            100, 800
    ));
}
