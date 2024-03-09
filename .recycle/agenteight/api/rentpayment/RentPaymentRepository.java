package digital.agenteight.api.rentpayment;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentPaymentRepository extends JpaRepository<RentPayment, Integer> {
   Optional<RentPayment> findByIdAllIgnoreCase(Integer id);
}
