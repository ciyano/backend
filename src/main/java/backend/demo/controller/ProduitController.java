package backend.demo.controller;

import backend.demo.entity.Produit;
import backend.demo.service.IPrdouitService;
import backend.demo.service.ProduitServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("/api/produit")
public class ProduitController {
    @Autowired
//private IPrdouitService produitService;

    private ProduitServiceRepo produitService;
    @GetMapping

    public List<Produit> getProduits(){
      return produitService.getProduits();
    }
@PostMapping
    public void addProduit( @RequestBody Produit produit){
        produitService.addProduit(produit);
    }
    @PutMapping
    public void updateProduit(@RequestBody Produit produit){
        produitService.updateProduit(produit);
    }
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id){
        produitService.deleteProduit(id);
    }
}
