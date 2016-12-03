package br.com.projetointegrador.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetointegrador.entity.Aviso;
import br.com.projetointegrador.repository.AvisoRepository;
import br.com.projetointegrador.service.AvisoService;
import lombok.Data;

@Service("avisoService")
@Transactional
@Data
public class AvisoServiceImpl implements AvisoService{
	
	@Autowired
	private AvisoRepository avisoRepo;

	@Override
	public List<Aviso> buscarAvisos(String destinatario) {
		try{
			List<Aviso> avisos = new ArrayList<Aviso>();
			System.out.println("BUSCANDO AVISOS");
			avisos = avisoRepo.findByDestinatario(destinatario);
			System.out.println("AVISOS BUSCADOS");
			return avisos;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void salvar(Aviso aviso) {
		try{
			System.out.println("SALVANDO AVISO");
			avisoRepo.save(aviso);
			System.out.println("AVISO SALVO");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
