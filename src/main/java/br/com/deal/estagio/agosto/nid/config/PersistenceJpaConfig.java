package br.com.deal.estagio.agosto.nid.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = {"br.com.deal.estagio.agosto.nid.persistence.entity"})
@EnableJpaRepositories(basePackages = {"br.com.deal.estagio.agosto.nid.persistence.repository"})
public class PersistenceJpaConfig {

}
