package harisbrulicita2024.healthcheck.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class HealthCheckGatewayService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, String> checkAllServices() {
        Map<String, String> healthStatus = new HashMap<>();
        healthStatus.put("service1", checkService("http://localhost:3050/api/jobs"));
        healthStatus.put("service2", checkService("http://localhost:3050/api/users"));
        healthStatus.put("service3", checkService("http://localhost:3050/api/tracking"));
        return healthStatus;
    }

    private String checkService(String url) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return "Healthy";
            } else {
                return "Unhealthy";
            }
        } catch (Exception e) {
            return "Unhealthy";
        }
    }
}
