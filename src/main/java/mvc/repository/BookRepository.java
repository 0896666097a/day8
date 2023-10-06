package mvc.repository;

import mvc.enity.BookEnity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEnity, Integer> {
    List<BookEnity> findByNameContainingOrAuthorContaining(String name, String author);

//    void delete(int id);
}