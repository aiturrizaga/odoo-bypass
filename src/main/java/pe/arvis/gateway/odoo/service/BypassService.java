package pe.arvis.gateway.odoo.service;

import org.springframework.http.HttpEntity;

public interface BypassService {
    HttpEntity<String> resolveBypass(String url, Object req);
}
