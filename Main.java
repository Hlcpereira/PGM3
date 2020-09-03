/*
 * Copyright 2020 - Henrique Pereira
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */


/*
 * Classe destinada a "execução".
 * Modificações podem vir a ser necessárias!
 */
package AV1;

public class Main {
    public static void main(String[] args) throws Exception {
        Pe pe = new Pe();

        pe.criarFrutaPe(false, "vermelha", "Maçã");

        System.out.println(pe.imprime());
    }
}
