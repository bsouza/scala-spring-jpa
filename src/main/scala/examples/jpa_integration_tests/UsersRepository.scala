package examples.jpa_integration_tests

import java.util.Optional

import org.springframework.data.jpa.repository.{JpaRepository, Query}

trait UsersRepository extends JpaRepository[UserEntity, Long] {

  def findByName(name: String): Optional[UserEntity]

  @Query("SELECT u FROM UserEntity u LEFT JOIN FETCH u.tasks WHERE u.name = (:name)")
  def findByNameAndFetchTasks(name: String): Optional[UserEntity]

}
