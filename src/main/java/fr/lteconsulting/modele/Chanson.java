package fr.lteconsulting.modele;

public class Chanson
{
	private int id=-1;
	private String disqueId;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisqueId() {
		return disqueId;
	}

	public void setDisqueId(String disqueId) {
		this.disqueId = disqueId;
	}

	private String nom;
	private int dureeEnSecondes;

	public Chanson()
	{
	}

	public Chanson( String nom, int dureeEnSecondes )
	{
		this.nom = nom;
		this.dureeEnSecondes = dureeEnSecondes;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public int getDureeEnSecondes()
	{
		return dureeEnSecondes;
	}

	public void setDureeEnSecondes( int dureeEnSecondes )
	{
		this.dureeEnSecondes = dureeEnSecondes;
	}

	public void afficher()
	{
		System.out.println( nom + " (" + dureeEnSecondes + " sec.)" );
	}
}
