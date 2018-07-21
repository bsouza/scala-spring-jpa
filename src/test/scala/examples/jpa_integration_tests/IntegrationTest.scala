package examples.jpa_integration_tests

import com.github.springtestdbunit.DbUnitTestExecutionListener
import org.flywaydb.test.FlywayTestExecutionListener
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.{ContextConfiguration, TestExecutionListeners};

@ContextConfiguration(classes = Array(classOf[TestContext]))
@DataJpaTest
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AUTO_CONFIGURED)
@TestExecutionListeners(Array(
  classOf[DependencyInjectionTestExecutionListener],
  classOf[DbUnitTestExecutionListener],
  classOf[FlywayTestExecutionListener],
  classOf[TransactionalTestExecutionListener]
))
class IntegrationTest {}
