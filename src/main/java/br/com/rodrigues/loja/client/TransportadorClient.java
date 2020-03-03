package br.com.rodrigues.loja.client;

import br.com.rodrigues.loja.service.EntregaDTO;
import br.com.rodrigues.loja.service.VoucherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("transportador")
public interface TransportadorClient {

    @PostMapping("/entrega")
    VoucherDTO reservaEntrega(EntregaDTO entrega);
}
