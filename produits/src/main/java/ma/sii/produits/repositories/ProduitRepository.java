package ma.sii.produits.repositories;

import ma.sii.produits.enteties.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}

/*@Projection(name = "proj1", types = Produit.class)
interface ProduitProjection{
    String getName();
    double getPrice();
}*/