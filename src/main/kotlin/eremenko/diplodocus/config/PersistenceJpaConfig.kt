package eremenko.diplodocus.config

import com.zaxxer.hikari.HikariDataSource
import liquibase.integration.spring.SpringLiquibase
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@Configuration
@EnableJpaRepositories(basePackages = ["eremenko.diplodocus.repos"])
@EnableAutoConfiguration
class PersistenceJpaConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Primary
    fun dataSource(properties: DataSourceProperties): HikariDataSource? {
        val dataSource: HikariDataSource = properties.initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
        dataSource.poolName = properties.name
        return dataSource
    }

    @Bean
    fun liquibasePG(dataSource: HikariDataSource?): SpringLiquibase? {
        val liquibase = SpringLiquibase()
        liquibase.changeLog = "classpath:changelogs/db-changelog.xml"
        liquibase.dataSource = dataSource
        return liquibase
    }
}