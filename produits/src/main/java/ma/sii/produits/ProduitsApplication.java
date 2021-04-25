package ma.sii.produits;

import ma.sii.produits.enteties.Produit;
import ma.sii.produits.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
public class ProduitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProduitRepository produitRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Produit.class);


        return args -> {
            produitRepository.save(new Produit(null, "prod1", 16, 46));
            produitRepository.save(new Produit(null, "prod2", 140, 3));
            produitRepository.save(new Produit(null, "prod3", 80, 25));

            produitRepository.findAll().forEach(p -> {
                System.out.println(p.getName());
            });
        };
    }
}
