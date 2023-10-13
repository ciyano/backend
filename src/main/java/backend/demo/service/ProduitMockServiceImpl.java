package backend.demo.service;

import backend.demo.entity.Produit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProduitMockServiceImpl implements IPrdouitService{
    ProduitMockServiceImpl(){
        produits = new ArrayList<>();
        produits.add(new Produit("livre", 50, 22));
        produits.add(new Produit("cahier", 550, 7));
        produits.add(new Produit("stylo", 150, 72));
        produits.add(new Produit("cartable", 550, 42));
    }
    private List<Produit> produits;

    @Override
    public List<Produit> getProduits() {
        return produits;
    }

    @Override
    public void addProduit(Produit produit) {
           produits.add(produit);
    }

    @Override
    public void updateProduit(Produit produit) {
         produits.remove(produit);
         produits.add(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        Produit produit= new Produit();
        produit.setId(id);
        produits.remove(produit);
    }
}
