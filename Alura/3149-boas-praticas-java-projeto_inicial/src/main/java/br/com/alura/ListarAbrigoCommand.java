package br.com.alura;

import java.io.IOException;

import br.com.alura.client.HttpConfiguration;
import br.com.alura.service.AbrigoService;

public class ListarAbrigoCommand implements Command {

    @Override
    public void execute() {

        try {
            HttpConfiguration client = new HttpConfiguration();
            AbrigoService abrigoService = new AbrigoService(client);
            
            abrigoService.listarAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        
    
    }
    
}
