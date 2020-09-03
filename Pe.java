/*
 * Copyright 2020 - Henrique Pereira
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package AV1;

public class Pe {
    // Props
    private Fruta fruta;
    private int quantidade;

    public Pe(){
        this.fruta = null;
        this.quantidade = 0;
    }

    /* Insere uma fruta no pé. Talvez mudar o modificador da prop de quantidade
     * para receber valores além de uma fruta de cada vez? */
    public Fruta criarFrutaPe(boolean citrica, String cor, String frutaNome){
        Fruta novaFruta = new Fruta(citrica, cor, frutaNome);
        this.fruta = novaFruta;
        this.quantidade += 1;
        return novaFruta;
    }

    // Retorna os valores como strings em frases para imprimir no terminal mais a frente.
    public String imprime(){
        String s = "";

        s += "O pé contém " + this.fruta.getFrutaNome() + " de cor " + this.fruta.getCor() + " com " + this.quantidade + " em quantidade.";
        if (this.fruta.getCitrica() == true){
            s += " Aviso " + this.fruta.getFrutaNome() + " pode ser azedo(a)!";
        }

        return s;
    }
}
