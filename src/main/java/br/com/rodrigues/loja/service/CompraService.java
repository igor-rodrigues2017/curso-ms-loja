package br.com.rodrigues.loja.service;

import br.com.rodrigues.loja.client.FornecedorClient;
import br.com.rodrigues.loja.controller.CompraDTO;
import br.com.rodrigues.loja.model.Compra;
import br.com.rodrigues.loja.repository.CompraRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private static final Logger log = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient client;

    @Autowired
    private CompraRepository repository;

    @HystrixCommand(threadPoolKey = "getByIdThreadPoll")
    public Compra getById(Long id) {
        return repository.findById(id).orElse(new Compra());
    }

    @HystrixCommand(fallbackMethod = "realizaCompraFallBack", threadPoolKey = "realizaCompraThreadPoll")
    public Compra realizaCompra(CompraDTO compra) {
        String estado = compra.getEndereco().getEstado();

        log.info("Buscando informações do forncedor no estado {}", estado);
        InfoFornecedorDTO fornecedorDTO = client.getInfoPorEstado(estado);

        log.info("Realizando um pedido");
        InfoPedidoDTO pedido = client.realizaPedido(compra.getItens());
        Compra compraRealizada = new Compra(pedido);
        compraRealizada.setEnderecoDestino(fornecedorDTO.getEndereco());
        repository.save(compraRealizada);
        return compraRealizada;
    }

    //o método chamado pelo hystrix, poderia ser algum com uma resposta melhor para o cliente
    public Compra realizaCompraFallBack(CompraDTO compra) {
        Compra compraFallBack = new Compra();
        compraFallBack.setEnderecoDestino("endereço do fallback poderia ser melhor");
        return compraFallBack;
    }

}
