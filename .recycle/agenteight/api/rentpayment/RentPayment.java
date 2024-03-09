package digital.agenteight.api.rentpayment;

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
   name = "rent-payment"
)
public class RentPayment {
   private static final Logger log = LoggerFactory.getLogger(RentPayment.class);
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Integer id;
   @Column(
      name = "type"
   )
   @NonNull
   private String type;
   @Column(
      name = "date"
   )
   @NonNull
   private String date;
   @Column(
      name = "amount"
   )
   @NonNull
   private String amount;

   public Integer getId() {
      return this.id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getDate() {
      return this.date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getAmount() {
      return this.amount;
   }

   public void setAmount(String amount) {
      this.amount = amount;
   }

   public String toString() {
      Integer var10000 = this.getId();
      return "RentPayment(id=" + var10000 + ", type=" + this.getType() + ", date=" + this.getDate() + ", amount=" + this.getAmount() + ")";
   }

   public RentPayment() {
   }

   public RentPayment(@NonNull final String type, @NonNull final String date, @NonNull final String amount) {
      if (type == null) {
         throw new NullPointerException("type is marked non-null but is null");
      } else if (date == null) {
         throw new NullPointerException("date is marked non-null but is null");
      } else if (amount == null) {
         throw new NullPointerException("amount is marked non-null but is null");
      } else {
         this.type = type;
         this.date = date;
         this.amount = amount;
      }
   }
}
