package Model;


public interface IGestionProduit {
    void ajouterProduit(Produit produit);
    Produit rechercherProduit(int id);
    void modifierProduit(Produit produit);
    void supprimerProduit(int id);
}
