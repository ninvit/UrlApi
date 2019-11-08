package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

}
