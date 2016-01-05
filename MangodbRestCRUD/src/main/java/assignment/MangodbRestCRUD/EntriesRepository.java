package assignment.MangodbRestCRUD;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface EntriesRepository extends MongoRepository<Entry, String> {
	List<Entry> findByName(@Param("name") String name);
	
}
