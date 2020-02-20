package br.com.rodrigues.loja.service;

import br.com.rodrigues.loja.controller.CompraDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {
    public void realizaCompra(CompraDTO compra) {
        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoFornecedorDTO> response = client.exchange("http://localhost:8081/info/" + compra.getEndereco().getEstado(),
                HttpMethod.GET, null, InfoFornecedorDTO.class);

        System.out.println(response.getBody().getEndereco());
    }
}
