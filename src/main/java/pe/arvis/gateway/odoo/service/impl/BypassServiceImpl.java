package pe.arvis.gateway.odoo.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.arvis.gateway.odoo.service.BypassService;

@Service
public class BypassServiceImpl implements BypassService {

    private final RestTemplate restTemplate;

    public BypassServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public HttpEntity<String> resolveBypass(String url, Object req) {
        HttpEntity<Object> request = new HttpEntity<>(req);
        return restTemplate.exchange(url, HttpMethod.POST, request, String.class);
    }

}
