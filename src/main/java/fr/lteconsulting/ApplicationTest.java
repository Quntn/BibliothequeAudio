package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.dao.DisqueDAO;
import fr.lteconsulting.modele.Disque;

public class ApplicationTest {
	public static void main(String[] args) {
		DisqueDAO dao = new DisqueDAO();

		chercherEtAfficherDisque(dao, "ddd");
		//chercherEtAfficherDisque(dao, "ppttdddd");
		// supprimerDisque(dao, "ddd");
		ajouterDisque(dao, "FFF", "DeepFFF");
		afficherTout(dao);
		//updaterDisque(dao, "eee", "Deeper");
		//afficherTout(dao);
	}

	private static void chercherEtAfficherDisque(DisqueDAO dao, String id) {
		Disque disque = dao.findById(id);
		if (disque != null) {
			System.out.println("Le disque " + id + " a été trouvé :");
			disque.afficher();
		} else {
			System.out.println("Le disque " + id + "n'existe pas");
		}
	}

	private static void supprimerDisque(DisqueDAO dao, String id) {
		Disque disque = dao.findById(id);
		if (disque != null) {
			System.out.println("Le disque " + id + " a été supprimé");
			dao.delete(id);
		} else {
			System.out.println("Le disque " + id + "n'existe pas");
		}

	}

	private static void ajouterDisque(DisqueDAO dao, String id, String name) {
		Disque disque = dao.add(id, name);
		

		System.out.println("Le disque :" + name + " a été ajouté");
	}
	
	private static void afficherTout(DisqueDAO dao){
	List<Disque> d = new ArrayList<>();
	d = dao.findAll();
	if (d != null) {
		System.out.println("BIBLIOTHEQUE avec " + d.size() + " disques");
		System.out.println("Voici la liste des disques:" + d.toString());
		

	} else {
		System.out.println("Les disques n'ont pas été trouvé");
	}
	}
	
	
	private static void updaterDisque(DisqueDAO dao, String id, String nom) {
		Disque disque = new Disque (id, nom);
		dao.update(disque);
		if (nom != null) {
			System.out.println("le disque " + disque.toString() + " a été updaté");
		}
		else{
			System.out.println("Vous ne modifiez pas la");
		}
	}
	
}


