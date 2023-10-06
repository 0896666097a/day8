package mvc.repository;


import mvc.enity.OrderDetails;
import mvc.enity.Orders;
import mvc.enity.ProductEnity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEnity,Integer> {



}
