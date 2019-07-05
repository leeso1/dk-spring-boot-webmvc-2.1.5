package me.learning.bootstrap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "integration")
public class IntegrationProperties {

    /**
     * properties map to list collection
     */
    private final List<IntegratedServerInformation> servers = new ArrayList<>();

    /**
     * proerties map to map collection
     */
    private final Map<String, IntegratedServerInformation> map = new HashMap<>();

    public List<IntegratedServerInformation> getServers() {
        return servers;
    }

    public Map<String, IntegratedServerInformation> getMap() {
        return map;
    }

    public static final class IntegratedServerInformation {

        private String name;
        private String baseUrl;
        private String description;

        public String getName() {
            return name;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "IntegratedServerInformation{" +
                    "name='" + name + '\'' +
                    ", baseUrl='" + baseUrl + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
