package org.springframework.samples.petclinic.system;

import io.hypersistence.optimizer.HypersistenceOptimizer;
import io.hypersistence.optimizer.core.config.JpaConfig;
import io.hypersistence.optimizer.hibernate.event.mapping.identifier.IdentityGeneratorEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class HypersistenceConfiguration {

    @Bean
    public HypersistenceOptimizer hypersistenceOptimizer(
            EntityManagerFactory entityManagerFactory) {
        return new HypersistenceOptimizer(
            new JpaConfig(entityManagerFactory)
                .setEventFilter(
                    event -> !(event instanceof IdentityGeneratorEvent)
                )
        );
    }
}
