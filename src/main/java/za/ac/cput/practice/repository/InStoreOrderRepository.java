package za.ac.cput.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.practice.domain.InStoreOrder;

@Repository
public interface InStoreOrderRepository  extends JpaRepository<InStoreOrder, String> {

}
