package examples.jpa_integration_tests

import java.util.{ArrayList => JArrayList, List => JList}

import javax.persistence.CascadeType.ALL
import javax.persistence.FetchType.LAZY
import javax.persistence._

@Entity
@Table(name = "users")
class UserEntity(_name: String) {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_sequence")
  @SequenceGenerator(name="user_id_sequence", sequenceName="user_id_seq", allocationSize=1)
  var id: Long = _

  @Column(name = "name")
  var name: String = _name

  @Version
  var version: Long = _

  @OneToMany(mappedBy = "user", fetch = LAZY, cascade = Array(ALL))
  var tasks: JList[TaskEntity] = new JArrayList[TaskEntity]()

  def this() = this (null)

  def addTask(task: TaskEntity): Unit = {
    task.user = this
    this.tasks.add(task)
  }
}
