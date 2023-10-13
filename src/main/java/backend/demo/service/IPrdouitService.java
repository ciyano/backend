package backend.demo.service;

import backend.demo.entity.Produit;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPrdouitService {
    List<Produit> getProduits();
    void addProduit(Produit produit);
    void updateProduit(Produit produit);
    void deleteProduit(Long id);

}
