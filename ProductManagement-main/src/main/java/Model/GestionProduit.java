package Model;
import DAO.ProduitDAO;

public class GestionProduit implements IGestionProduit{
    private ProduitDAO produitdao=new ProduitDAO();
    @Override
    public void ajouterProduit(Produit produit)
    {
        if(produit.getPrix() <= 0) {
            throw new IllegalArgumentException("Le prix doit être positif");
        }

        produitdao.ajouterProduit(produit);
    }
    @Override
    public Produit rechercherProduit(int id) {
        return produitdao.getProduitById(id);
    }

    @Override
    public void modifierProduit(Produit produit) {
        if(produitdao.getProduitById(produit.getId()) == null) {
            throw new IllegalStateException("Article introuvable");
        }
        produitdao.modifierProduit(produit);
    }

    @Override
    public void supprimerProduit(int id) {
        produitdao.supprimerProduit(id);
    }
}
