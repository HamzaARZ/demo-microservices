package ma.sii.produits.controllers;

import ma.sii.produits.enteties.Produit;
import ma.sii.produits.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestController {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "/produits")
    public List<Produit> getProduits(){
        return produitRepository.findAll();
    }

    @GetMapping(value = "/produits/{id}")
    public Produit getProduit(@PathVariable Long id){
        return produitRepository.findById(id).get();
    }

    @PostMapping(value = "/produits")
    public Produit saveProduit(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }

    @PutMapping(value = "/produits/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit){
        produit.setId(id);
        return produitRepository.save(produit);
    }

    @DeleteMapping(value = "/produits/{id}")
    public void deleteProduit(@PathVariable Long id){
        produitRepository.deleteById(id);
    }
}