package br.com.rodrigues.loja.service;

import br.com.rodrigues.loja.client.FornecedorClient;
import br.com.rodrigues.loja.controller.CompraDTO;
import br.com.rodrigues.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private static final Logger log = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient client;

    public Compra realizaCompra(CompraDTO compra) {
        String estado = compra.getEndereco().getEstado();

        log.info("Buscando informações do forncedor no estado {}", estado);
        InfoFornecedorDTO fornecedorDTO = client.getInfoPorEstado(estado);

        log.info("Realizando um pedido");
        InfoPedidoDTO pedido = client.realizaPedido(compra.getItens());
        Compra compraRealizada = new Compra(pedido);
        compraRealizada.setEnderecoDestino(fornecedorDTO.getEndereco());
        return compraRealizada;
    }
}
