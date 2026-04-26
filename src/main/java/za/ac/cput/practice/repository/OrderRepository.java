package za.ac.cput.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.practice.domain.Order;


@Repository
public interface OrderRepository  extends JpaRepository<Order, String> {

}