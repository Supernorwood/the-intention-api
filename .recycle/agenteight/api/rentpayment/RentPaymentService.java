package digital.agenteight.api.rentpayment;

import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(
   rollbackOn = {SQLException.class}
)
public class RentPaymentService {
   RentPaymentRepository rentPaymentRepository;

   @Autowired
   public RentPaymentService(RentPaymentRepository rentPaymentRepository) {
      this.rentPaymentRepository = rentPaymentRepository;
   }

   public RentPayment saveColdApproach(RentPayment rentPayment) {
      return (RentPayment)this.rentPaymentRepository.save(rentPayment);
   }

   public List<RentPayment> fetchAllColdApproaches() {
      return this.rentPaymentRepository.findAll();
   }

   public void deleteColdApproach(Integer id) {
      this.rentPaymentRepository.deleteById(id);
   }
}
