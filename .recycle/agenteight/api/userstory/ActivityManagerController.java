package digital.agenteight.api.userstory;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"activity-manager"})
public class ActivityManagerController {
   @Autowired
   ActivityTaskService activityTaskService;

   public ActivityManagerController() {
      System.out.println();
      System.out.println("*** ");
      System.out.println("*** init -- ActivityManagerController");
      System.out.println("*** ");
      System.out.println();
   }

   @GetMapping({"/"})
   public String hello() {
      return "ActivityManagerController";
   }

   @GetMapping({"/health-check"})
   public String returnHealthCheckContentJSON() {
      return "ActivityManagerController API Is Up!";
   }

   @GetMapping({"/all-activities"})
   public List<ActivityTask> getAllActivities() {
      System.out.println("enter > getAllActivities");
      List<ActivityTask> activityTaskList = this.activityTaskService.getAllActivityTasks();
      System.out.println("the list of activity task:");
      System.out.println(activityTaskList);
      System.out.println("exit < getAllActivities");
      return activityTaskList;
   }

   @PostMapping({"/add-activity"})
   public ActivityTask saveNewActivityTask(@RequestBody final String responseString) {
      System.out.println(">> save-new-activity " + responseString);
      System.out.println("in:  " + responseString);
      JSONObject jsonObject = new JSONObject(responseString);
      System.out.println("jsonObject: ");
      System.out.println(jsonObject);
      ActivityTask activityTask = new ActivityTask();
      activityTask.setCategory(jsonObject.getString("category"));
      activityTask.setDescription(jsonObject.getString("description"));
      activityTask.setStatus(jsonObject.getString("state"));
      ActivityTask activityTask1 = this.activityTaskService.saveActivityTask(activityTask);
      System.out.println("out: " + activityTask1);
      return activityTask1;
   }

   @GetMapping({"/delete-activity/{id}"})
   public String read(@PathVariable("id") int id) {
      System.out.println("id : " + id);
      this.activityTaskService.delete(id);
      return "DELETED";
   }
}
