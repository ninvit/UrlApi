package service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import model.Url;

public interface UrlService {
    Optional<Url> findById(Long id);

	List<Url> findAll();

	Url save(@Valid Url url);

	void delete(Url url);
}
