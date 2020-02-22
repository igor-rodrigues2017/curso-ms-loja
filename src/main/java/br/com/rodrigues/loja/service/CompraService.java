package br.com.rodrigues.loja.service;

import br.com.rodrigues.loja.client.FornecedorClient;
import br.com.rodrigues.loja.controller.CompraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient client;

    public void realizaCompra(CompraDTO compra) {
        InfoFornecedorDTO fornecedorDTO = client.getInfoPorEstado(compra.getEndereco().getEstado());
        System.out.println(fornecedorDTO.getEndereco());
    }
}
