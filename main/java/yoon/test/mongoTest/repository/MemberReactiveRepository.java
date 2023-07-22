package yoon.test.mongoTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yoon.test.mongoTest.domain.Members;

@Repository
public interface MemberReactiveRepository extends MongoRepository<Members, String> {
    Members findByEmail(String email);

}
