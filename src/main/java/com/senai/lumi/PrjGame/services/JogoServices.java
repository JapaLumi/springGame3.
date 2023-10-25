package com.senai.lumi.PrjGame.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.senai.lumi.PrjGame.entities.Jogo;
import com.senai.lumi.PrjGame.repositories.JogoRepository;

@Service
public class JogoServices {

	private final JogoRepository jogoRepository;
	
	public JogoServices(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	//inserir produto
    public Jogo savejogo(Jogo jogo) {
	    return jogoRepository.save(jogo);
		}

	// listar produto por id
	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}

	// listar todos os produtos
	public List<Jogo> getAllJogos() {
		return jogoRepository.findAll();
	}

	// apagar produto
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}

	// fazendo o update do jogo com o optional
		public Jogo updateJogo(Long id, Jogo novoJogo) {
	        Optional<Jogo> jogoOptional = jogoRepository.findById(id);
	        if (jogoOptional.isPresent()) {
	        	Jogo jogoExistente = jogoOptional.get();
	           	jogoExistente.setName(novoJogo.getName());
	        	jogoExistente.setPlataform(novoJogo.getPlataform());          
	            return jogoRepository.save(jogoExistente); 
	        } else {
	            return null; 
	        }
	    }
		
	    }


