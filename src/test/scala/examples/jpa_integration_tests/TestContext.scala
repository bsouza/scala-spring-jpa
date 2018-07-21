package examples.jpa_integration_tests

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJpaRepositories(Array("examples.jpa_integration_tests"))
@EntityScan(Array("examples.jpa_integration_tests"))
@EnableTransactionManagement
class TestContext {}
