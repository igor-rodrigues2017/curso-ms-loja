package br.com.rodrigues.loja.service;

import br.com.rodrigues.loja.client.FornecedorClient;
import br.com.rodrigues.loja.controller.CompraDTO;
import br.com.rodrigues.loja.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient client;

    public Compra realizaCompra(CompraDTO compra) {
        InfoFornecedorDTO fornecedorDTO = client.getInfoPorEstado(compra.getEndereco().getEstado());

        InfoPedidoDTO pedido = client.realizaPedido(compra.getItens());
        Compra compraRealizada = new Compra(pedido);
        compraRealizada.setEnderecoDestino(compra.getEndereco().toString());
        return compraRealizada;
    }
}
