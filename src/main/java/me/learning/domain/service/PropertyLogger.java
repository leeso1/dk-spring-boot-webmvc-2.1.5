package me.learning.domain.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@Slf4j
@Component
public class PropertyLogger {

    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent event) {
        final AbstractEnvironment env = (AbstractEnvironment) event.getApplicationContext().getEnvironment();
        log.info("--------------- Application Configuration ---------------");
        log.info("{}{}", spotPaddedKey("ActiveProfile"), env.getActiveProfiles());
        log.info("{}{}", spotPaddedKey("DefaultProfile"), env.getDefaultProfiles());

        final MutablePropertySources sources = env.getPropertySources();
        StreamSupport.stream(sources.spliterator(), false)
                .filter(ps -> ps instanceof EnumerablePropertySource)
                .map(ps -> ((EnumerablePropertySource<?>) ps).getPropertyNames())
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(prop -> {
                    log.info("{}{}", spotPaddedKey(prop), env.getProperty(prop));
                });
    }

    private String spotPaddedKey(String key) {
        int targetSize = 60;
        int keySize = key.length();
        if (keySize > targetSize) {
            return key.concat("...");
        }
        for(int i=keySize; i<targetSize; i++) {
            key = key.concat(".");
        }
        return key;
    }
}
