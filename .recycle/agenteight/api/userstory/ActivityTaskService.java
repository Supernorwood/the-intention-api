package digital.agenteight.api.userstory;

import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import digital.agenteight.api.userstory.ActivityTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(
   rollbackOn = {SQLException.class}
)
public class ActivityTaskService {
   ActivityTaskRepository activityTaskRepository;

   @Autowired
   public ActivityTaskService(ActivityTaskRepository activityTaskRepository) {
      this.activityTaskRepository = activityTaskRepository;
   }

   public ActivityTask saveActivityTask(ActivityTask activityTask) {
      return (ActivityTask)this.activityTaskRepository.save(activityTask);
   }

   public List<ActivityTask> getAllActivityTasks() {
      return this.activityTaskRepository.findAll();
   }

   public void delete(Integer id) {
      this.activityTaskRepository.deleteById(id);
   }
}
