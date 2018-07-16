/**
 * 
 */
package com.ibm.att.spa01.bean;

import java.util.ArrayList;

/**
 * @author ADMIN
 *
 */
public class Usuario {

    
    private String nome;
    private int idade;
    private String cidade;
    private ArrayList<String> lista;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    
    public ArrayList<String> getLista() {
	return lista;
    }
    public void setLista(ArrayList<String> lista) {
	this.lista = lista;
    }
    
    
    
    
}
