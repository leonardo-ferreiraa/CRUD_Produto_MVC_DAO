/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alunos
 */
public class Produto {

    private int id;
    private String descricao;
    private double preco;
    private int quantidade;
    private String fornecedor;
    private int setor;
    private String data;
    private String tipo;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public String getFornecedor(){
        return fornecedor;
    }

    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }

    public int getSetor(){
        return setor;
    }

    public void setSetor(int setor){
        this.setor = setor;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

}
