package br.com.alura.adopet.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.repository.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<PetDto> buscarPetsDisponiveis() {
        return petRepository
                .findAllByAdotadoFalse()
                .stream()
                .map(PetDto::new)
                .toList();
    }
    
}
