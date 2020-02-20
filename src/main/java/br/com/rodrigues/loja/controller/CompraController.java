package br.com.rodrigues.loja.controller;

import br.com.rodrigues.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private final CompraService service;

    @Autowired
    public CompraController(CompraService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void compra(@RequestBody CompraDTO compra) {
        service.realizaCompra(compra);
    }

}
