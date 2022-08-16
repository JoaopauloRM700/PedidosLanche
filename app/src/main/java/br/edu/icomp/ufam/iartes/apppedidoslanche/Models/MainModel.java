package br.edu.icomp.ufam.iartes.apppedidoslanche.Models;

public class MainModel {
    int image;
    String nome, preco, descricao;

    public MainModel(int imageLanche, String nome, String preco, String descricao) {
        this.image = imageLanche;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }
    public MainModel(){

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
