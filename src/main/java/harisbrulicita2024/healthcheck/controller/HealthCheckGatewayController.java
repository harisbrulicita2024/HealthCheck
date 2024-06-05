package harisbrulicita2024.healthcheck.controller;

import harisbrulicita2024.healthcheck.service.HealthCheckGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckGatewayController {

    @Autowired
    private HealthCheckGatewayService healthCheckGatewayService;

    @GetMapping
    public ResponseEntity<Map<String, String>> checkHealth() {
        Map<String, String> healthStatus = healthCheckGatewayService.checkAllServices();
        return new ResponseEntity<>(healthStatus, HttpStatus.OK);
    }
}
