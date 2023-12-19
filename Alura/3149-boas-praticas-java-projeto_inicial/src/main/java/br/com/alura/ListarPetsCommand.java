package br.com.alura;

import java.io.IOException;

import br.com.alura.client.HttpConfiguration;
import br.com.alura.service.PetService;

public class ListarPetsCommand implements Command{
    
    @Override
    public void execute() {
        try {
            HttpConfiguration client = new HttpConfiguration();
            PetService petService = new PetService(client);

            petService.listarPets();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
