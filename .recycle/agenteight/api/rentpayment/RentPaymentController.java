package digital.agenteight.api.rentpayment;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"rent-payment"})
public class RentPaymentController {
   @Autowired
   RentPaymentService rentPaymentService;

   public RentPaymentController() {
      System.out.println();
      System.out.println("*** ");
      System.out.println("*** init -- RentPaymentController");
      System.out.println("*** ");
      System.out.println();
   }

   @GetMapping({"/"})
   public String hello() {
      return "RentPaymentCosssntroller";
   }

   @GetMapping({"/health-check"})
   public String returnHealthCheckContentJSON() {
      return "RentPaymentsssController API Is Up!";
   }

   @PostMapping({"/add-rent-payment"})
   public RentPayment saveColdApproach(@RequestBody final String responseString) {
      System.out.println("enter > saveColdApproach");
      System.out.println("in:  " + responseString);
      JSONObject jsonObject = new JSONObject(responseString);
      System.out.println("jsonObject: ");
      System.out.println(jsonObject);
      RentPayment rentPayment = new RentPayment();
      rentPayment.setType(jsonObject.getString("paymentType"));
      rentPayment.setAmount(jsonObject.getString("paymentAmount"));
      rentPayment.setDate(jsonObject.getString("paymentDate"));
      this.rentPaymentService.saveColdApproach(rentPayment);
      System.out.println("exit < saveColdApproach");
      return null;
   }

   @GetMapping({"/all-rent-payments"})
   public List<RentPayment> fetchAllColdApproaches() {
      System.out.println("enter > fetchAllColdApproaches");
      List<RentPayment> activityTaskList = this.rentPaymentService.fetchAllColdApproaches();
      System.out.println("the list of cold approaches");
      System.out.println(activityTaskList);
      System.out.println("exit < fetchAllColdApproaches");
      return activityTaskList;
   }
}
