package br.com.projetointegrador.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetointegrador.repository.SerieRepository;
import br.com.projetointegrador.service.SerieService;
import lombok.Data;

@Service("serieService")
@Transactional
@Data
public class SerieServiceImpl implements SerieService{
	
	@Autowired
	private SerieRepository serieRepo;

}
