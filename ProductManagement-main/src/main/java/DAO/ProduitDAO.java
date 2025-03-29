package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Produit;
import  DAO.IGestionProduitDAO;
public class ProduitDAO implements IGestionProduitDAO {

    @Override
    public List<Produit> getAllProduits() {
        List<Produit> liste = new ArrayList<>();
        String sql = "SELECT * FROM produits";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setPrix(rs.getDouble("prix"));
                p.setImage(rs.getString("image"));
                liste.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(liste);
        return liste;
    }
    @Override
    public Produit getProduitById(int id) {
        Produit p = null;
        String sql = "SELECT * FROM produits WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setPrix(rs.getDouble("prix"));
                p.setImage(rs.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    @Override
    public void ajouterProduit(Produit p) {
        System.out.println("Attempting to add product: " + p.getNom());

        String sql = "INSERT INTO produits (nom, description, prix, image) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrix());
            ps.setString(4, p.getImage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void modifierProduit(Produit p) {
        System.out.println("Attempting to update product ID: " + p.getId());
        String sql = "UPDATE produits SET nom = ?, description = ?, prix = ?, image = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrix());
            ps.setString(4, p.getImage());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void supprimerProduit(int id) {
        String sql = "DELETE FROM produits WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
