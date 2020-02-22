package br.com.rodrigues.loja.service;

import br.com.rodrigues.loja.controller.CompraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate client;

    @Autowired
    private DiscoveryClient discoveryClient;

    public void realizaCompra(CompraDTO compra) {
        ResponseEntity<InfoFornecedorDTO> response = client.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado(),
                HttpMethod.GET, null, InfoFornecedorDTO.class);

        discoveryClient.getInstances("fornecedor").stream().forEach(serviceInstance -> System.out.println(serviceInstance.getPort()));

        System.out.println(response.getBody().getEndereco());
    }
}
