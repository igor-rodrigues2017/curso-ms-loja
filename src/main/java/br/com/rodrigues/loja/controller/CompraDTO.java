package br.com.rodrigues.loja.controller;

import java.util.List;

public class CompraDTO {

    private List<ItensDTO> itens;
    private EnderecoDTO endereco;

    public List<ItensDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItensDTO> itens) {
        this.itens = itens;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
