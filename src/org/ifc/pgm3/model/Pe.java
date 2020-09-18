/*
 * Copyright 2020 - Henrique Pereira
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package AV3.org.ifc.pgm3.model;

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
    public void setFrutaPe(boolean citrica, String cor, String frutaNome, int quantidade){
        Fruta novaFruta = new Fruta(citrica, cor, frutaNome);
        this.fruta = novaFruta;
        this.quantidade = quantidade;
    }

    // Retorna a fruta do Pe.
    public Fruta getFrutaPe(){
        return fruta;
    }

    // Retorna a quantidade da fruta no Pe.
    public int getQuantidade(){
        return quantidade;
    }
}
