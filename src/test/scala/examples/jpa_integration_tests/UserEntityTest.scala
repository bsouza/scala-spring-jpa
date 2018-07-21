package examples.jpa_integration_tests

import java.util.{List => JList}

import com.github.springtestdbunit.annotation.DatabaseSetup
import org.flywaydb.test.annotation.FlywayTest
import org.junit.Assert.{assertEquals, assertNotNull}
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@DatabaseSetup(Array("/dbunit/user.xml"))
@FlywayTest(locationsForMigrate = Array("/db/migration"))
class UserEntityTest extends IntegrationTest {

  val FIXTURE_USER_NAME = "User Test 1"

  @Autowired
  var repository: UsersRepository = _

  @Test
  def should_save_new_user(): Unit = {
    val user = new UserEntity("Bruno")
    repository.save(user)

    assertNotNull(user.id)

    val savedUser: UserEntity = repository.findById(user.id).get()
    assertEquals(user.name, savedUser.name)
  }

  @Test
  def should_retrive_saved_user(): Unit = {
    val users: JList[UserEntity] = repository.findAll()
    val user = users.iterator().next()

    assertEquals(FIXTURE_USER_NAME, user.name)
    assertEquals(1, users.size())
  }

  @Test
  def should_add_task_to_user(): Unit = {
    val user = repository.findByNameAndFetchTasks(FIXTURE_USER_NAME).get()
    val task = new TaskEntity("Task", "Task description")

    user.addTask(task)
    repository.save(user)

    val updatedUser = repository.findByNameAndFetchTasks(FIXTURE_USER_NAME).get()
    assertEquals(1, updatedUser.tasks.size())
  }

}
