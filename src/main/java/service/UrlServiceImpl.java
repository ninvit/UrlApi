package service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Url;
import repository.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService {

	@Autowired
	private UrlRepository urlRepository;

	@Override
	public Optional<Url> findById(Long id) {

		return urlRepository.findById(id);
	}

	@Override
	public List<Url> findAll() {
		
		return urlRepository.findAll();
	}

	@Override
	public Url save(@Valid Url url) {
		
		return urlRepository.save(url);
	}

	@Override
	public void delete(Url url) {
		urlRepository.delete(url);
		
	}
}
