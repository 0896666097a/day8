package mvc.repository;

import mvc.enity.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderDetailRepo extends CrudRepository<OrderDetails,Integer> {
}
