package br.com.rodrigues.loja.client;

import br.com.rodrigues.loja.controller.ItensDTO;
import br.com.rodrigues.loja.service.InfoFornecedorDTO;
import br.com.rodrigues.loja.service.InfoPedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoDTO realizaPedido(List<ItensDTO> itens);
}
