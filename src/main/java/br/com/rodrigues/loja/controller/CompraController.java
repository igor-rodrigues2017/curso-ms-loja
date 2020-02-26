package br.com.rodrigues.loja.controller;

import br.com.rodrigues.loja.model.Compra;
import br.com.rodrigues.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private final CompraService service;

    @Autowired
    public CompraController(CompraService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Compra getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Compra compra(@RequestBody CompraDTO compra) {
        return service.realizaCompra(compra);
    }

}
