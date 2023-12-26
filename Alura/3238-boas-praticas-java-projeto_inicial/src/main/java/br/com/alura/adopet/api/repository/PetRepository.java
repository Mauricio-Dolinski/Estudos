package br.com.alura.adopet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByAdotadoFalse();

    List<Pet> findByAbrigo(Abrigo abrigo);
}