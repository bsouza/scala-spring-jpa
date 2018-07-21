package examples.jpa_integration_tests

import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import scala.beans.BeanProperty

@Component
class UsersService {

  @Autowired
  @BeanProperty
  var repository: UsersRepository = _

  @Transactional
  def findByNameWithTasks(name: String): UserEntity = {
    def user = repository.findByName(name).get()
    user.tasks.size()
    user
  }

}
