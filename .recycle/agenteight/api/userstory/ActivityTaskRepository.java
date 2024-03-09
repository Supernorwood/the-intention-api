package digital.agenteight.api.userstory;

import java.util.Optional;
import digital.agenteight.api.userstory.ActivityTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTaskRepository extends JpaRepository<ActivityTask, Integer> {
   Optional<ActivityTask> findByIdAllIgnoreCase(Integer id);
}
