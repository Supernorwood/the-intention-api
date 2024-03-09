package digital.agenteight.api.userstory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(
   name = "activities"
)
public class ActivityTask {
   private static final Logger log = LoggerFactory.getLogger(ActivityTask.class);
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Integer id;
   @Column(
      name = "date"
   )
   @NonNull
   private String date;
   @Column(
      name = "project"
   )
   @NonNull
   private String project;
   @Column(
      name = "category"
   )
   @NonNull
   private String category;
   @Column(
      name = "description"
   )
   @NonNull
   private String description;
   @Column(
      name = "status"
   )
   @NonNull
   private String status;

   public String toString() {
      Integer var10000 = this.getId();
      return "ActivityTask(id=" + var10000 + ", date=" + this.getDate() + ", project=" + this.getProject() + ", category=" + this.getCategory() + ", description=" + this.getDescription() + ", status=" + this.getStatus() + ")";
   }

   public ActivityTask() {
   }

   public Integer getId() {
      return this.id;
   }

   @NonNull
   public String getDate() {
      return this.date;
   }

   @NonNull
   public String getProject() {
      return this.project;
   }

   @NonNull
   public String getCategory() {
      return this.category;
   }

   @NonNull
   public String getDescription() {
      return this.description;
   }

   @NonNull
   public String getStatus() {
      return this.status;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setDate(@NonNull final String date) {
      if (date == null) {
         throw new NullPointerException("date is marked non-null but is null");
      } else {
         this.date = date;
      }
   }

   public void setProject(@NonNull final String project) {
      if (project == null) {
         throw new NullPointerException("project is marked non-null but is null");
      } else {
         this.project = project;
      }
   }

   public void setCategory(@NonNull final String category) {
      if (category == null) {
         throw new NullPointerException("category is marked non-null but is null");
      } else {
         this.category = category;
      }
   }

   public void setDescription(@NonNull final String description) {
      if (description == null) {
         throw new NullPointerException("description is marked non-null but is null");
      } else {
         this.description = description;
      }
   }

   public void setStatus(@NonNull final String status) {
      if (status == null) {
         throw new NullPointerException("status is marked non-null but is null");
      } else {
         this.status = status;
      }
   }

   public ActivityTask(@NonNull final String date, @NonNull final String project, @NonNull final String category, @NonNull final String description, @NonNull final String status) {
      if (date == null) {
         throw new NullPointerException("date is marked non-null but is null");
      } else if (project == null) {
         throw new NullPointerException("project is marked non-null but is null");
      } else if (category == null) {
         throw new NullPointerException("category is marked non-null but is null");
      } else if (description == null) {
         throw new NullPointerException("description is marked non-null but is null");
      } else if (status == null) {
         throw new NullPointerException("status is marked non-null but is null");
      } else {
         this.date = date;
         this.project = project;
         this.category = category;
         this.description = description;
         this.status = status;
      }
   }
}
