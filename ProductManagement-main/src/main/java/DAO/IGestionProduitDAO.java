package DAO;
import Model.Produit;
import java.util.List;

public interface IGestionProduitDAO {
    List<Produit> getAllProduits();
    Produit getProduitById(int id);
    void ajouterProduit(Produit p);
    void modifierProduit(Produit p);
    void supprimerProduit(int id);
}
