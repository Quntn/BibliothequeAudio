package fr.lteconsulting.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.lteconsulting.dao.DisqueDAO;
import fr.lteconsulting.outils.Saisie;

public class Bibliotheque
{
	private Map<String, Disque> disques = new HashMap<>();

	public void ajouterDisque( Disque disque )
	{
		disques.put( disque.getCodeBarre(), disque );
	}

	public List<Disque> getDisques()
	{
		return new ArrayList<>( disques.values() );
	}

	public Disque rechercherDisqueParCodeBarre( String codeBarre )
	{
		return disques.get( codeBarre );
	}

	public List<Disque> rechercherDisqueParNom( String recherche )
	{
		recherche = recherche.toLowerCase();

		List<Disque> resultat = new ArrayList<>();

		for( Disque disque : disques.values() )
		{
			if( disque.getNom().toLowerCase().contains( recherche ) )
				resultat.add( disque );
		}

		return resultat;
	}

	public List<Disque> rechercherDisqueParNom( List<String> termes )
	{
		List<Disque> resultat = new ArrayList<>();

		for( Disque disque : disques.values() )
		{
			boolean estValide = true;
			for( String terme : termes )
			{
				if( !disque.getNom().toLowerCase().contains( terme.toLowerCase() ) )
				{
					estValide = false;
					break;
				}
			}

			if( estValide )
				resultat.add( disque );
		}

		return resultat;
	}

	public void afficher()
	{
		System.out.println( "BIBLIOTHEQUE avec " + disques.size() + " disques" );
		for( Disque disque : disques.values() )
			disque.afficher();
	}
public static void main(String[] args) {
		
		Bibliotheque biblio = new Bibliotheque();

		while (true) {
			System.out.println("1. Afficher la liste des disques");
			System.out.println("2. Afficher un disque");
			System.out.println("3. Ajouter un disque");
			System.out.println("4. Supprimer un disque");
			System.out.println("5. Quitter l'application");
			
			DisqueDAO dao = new DisqueDAO();

			String saisie = Saisie.saisie("Faites un choix :");
			switch (saisie) {
			case "1":
				List<Disque> listDisk=dao.findAll();
				System.out.println(listDisk);
				
				break;
			
			case "2":
				String id = Saisie.saisie("Quel Id cherchez vous ?");
				Disque disqueCherche = dao.findById(id);
				System.out.println(disqueCherche);
				break;
				
			case "3":
				String idAdd = Saisie.saisie("Id du nouveau disque :");
				String nom = Saisie.saisie("Nom du nouveau disque :");
				
				Disque nouveauDisque = dao.add(idAdd, nom);

				System.out.println("Le disque "+nouveauDisque+" a bien été ajouté");
				break;
				
			case "4":
				String idDelete = Saisie.saisie("Quel est l'id du disque à supprimer ?");
				dao.delete(idDelete);
				System.out.println("Le disque "+idDelete+" a bien été supprimé");
				break;

			case "5":
			
				System.exit(0);
				
				break;
			default:
				System.out.println("Ce choix n'existe pas");
			}
		}
	}
}
