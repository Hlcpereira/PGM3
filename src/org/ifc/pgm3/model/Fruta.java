/*
 * Copyright 2020 - Henrique Pereira
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package AV3.org.ifc.pgm3.model;

public class Fruta {

    // Propriedades
    private boolean citrica;

    private String cor;
    private String frutaNome;

    // Construtor
    public Fruta(boolean citrica, String cor, String frutaNome){
        this.citrica = citrica;
        this.cor = cor;
        this.frutaNome = frutaNome;
    }

    // Getters, auxiliam no retorno de info sobre a fruta    
    public boolean getCitrica(){
        return citrica;
    }

    public String getCor(){
        return cor;
    }

    public String getFrutaNome(){
        return frutaNome;
    }

    // Setters, auxiliam no "setamento" de valores as props do objeto
    public void setCitrica(boolean citrica){
        this.citrica = citrica;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public void setFrutaNome(String frutaNome){
        this.frutaNome = frutaNome;
    }
}