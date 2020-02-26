package br.com.rodrigues.loja.model;

import br.com.rodrigues.loja.service.InfoPedidoDTO;

public class Compra {

    private Long pedidoId;
    private Integer tempoDePreparo;
    private String enderecoDestino;

    public Compra(InfoPedidoDTO pedido) {
        this.pedidoId = pedido.getId();
        this.tempoDePreparo = pedido.getTempoDePreparo();
    }

    public Compra() {

    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(Integer tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }
}
