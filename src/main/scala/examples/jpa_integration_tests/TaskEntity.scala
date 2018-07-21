package examples.jpa_integration_tests

import javax.persistence._

@Entity
@Table(name = "tasks")
class TaskEntity(_name: String, _description: String) {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="task_id_sequence")
  @SequenceGenerator(name="task_id_sequence", sequenceName="task_id_seq", allocationSize=1)
  var id: Long = _

  @Column(name = "name")
  var name: String = _name

  @Column(name = "description")
  var description: String = _description

  @Version
  var version: Long = _

  @ManyToOne
  var user: UserEntity = _

  def this() = this (null, null)
}
