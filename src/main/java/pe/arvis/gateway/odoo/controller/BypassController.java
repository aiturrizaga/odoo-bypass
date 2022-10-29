package pe.arvis.gateway.odoo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.arvis.gateway.odoo.service.BypassService;

@RestController
@RequestMapping("/v1/bypass")
public class BypassController {

    private final BypassService bypassService;

    public BypassController(BypassService bypassService) {
        this.bypassService = bypassService;
    }

    @PostMapping
    public ResponseEntity<Object> bypass(@RequestHeader String url, @RequestBody Object request) {
        HttpEntity<String> response = bypassService.resolveBypass(url, request);
        return ResponseEntity.ok()
                .headers(response.getHeaders())
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.getBody());
    }

}
