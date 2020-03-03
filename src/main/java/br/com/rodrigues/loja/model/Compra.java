package br.com.rodrigues.loja.model;

import br.com.rodrigues.loja.service.InfoPedidoDTO;
import br.com.rodrigues.loja.service.VoucherDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Compra {

    @Id
    private Long pedidoId;
    private Integer tempoDePreparo;
    private String enderecoDestino;
    private LocalDate dataParaEntrega;
    private Long voucherId;

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

    public LocalDate getDataParaEntrega() {
        return dataParaEntrega;
    }

    public void setDataParaEntrega(LocalDate dataParaEntrega) {
        this.dataParaEntrega = dataParaEntrega;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }
}
