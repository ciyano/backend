package backend.demo.service;

import backend.demo.entity.Produit;
import backend.demo.repository.ProduitRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class ProduitServiceRepo  implements IPrdouitService{
    @Autowired
    private ProduitRepository produitRepo ;
    @Override
    public List<Produit> getProduits() {
        return produitRepo.findAll();
    }

    @Override
    public void addProduit(Produit produit) {
        produitRepo.save(produit);

    }

    @Override
    public void updateProduit(Produit produit) {
        produitRepo.save(produit);

    }

    @Override
    public void deleteProduit(Long id) {
   Produit produit = new Produit();
   produit.setId(id);
        produitRepo.delete(produit);

    }
}
