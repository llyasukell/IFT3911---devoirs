package App;

import Observateur.*;
import Voyage.*;
import enums.State;
import Compagnie.*;
import Port.*;
import Fabrique.*;
import Commande.*;
import java.util.*;

public class App implements Sujet {

	private HistoriqueCommandes historique;
	private List<Observateur> observateurs = new ArrayList<>();
	private BaseDeDonnees bd = new BaseDeDonnees();
	private static App instance;
	private static VueAdmin vueAdmin; // en static pour y accéder globalement
	private static Scanner scanner = new Scanner(System.in);

	// Observateur
	public void attacher(Observateur o) { observateurs.add(o); }
	public void detach(Observateur o) { observateurs.remove(o); }
	public void notifier() { for (Observateur o : observateurs) o.update(); }

	// Singleton
	public static App getInstance() { return instance; }
	public static void setInstance(App appInstance) { instance = appInstance; }
	public static Scanner getScanner() { return scanner; }

	// Getters
	public void setHistorique(HistoriqueCommandes historique) { this.historique = historique; }
	public HistoriqueCommandes getHistorique() { return historique; }
	public BaseDeDonnees getBaseDeDonnees() { return bd; }
	
	public static void afficherPortsDisponibles() {
		System.out.println("=== Ports disponibles ===");
		for (Port p : getInstance().getBaseDeDonnees().getPorts()) {
			System.out.println("- " + p.getId() + " (" + p.getVille() + ")");
		}
	}

	// Main
	public static void main(String[] args) {
		System.out.println("=== DÉMARRAGE SYSTÈME DE RÉSERVATION ===");
		App app = new App();
		App.setInstance(app);
		
		VueAdmin vueAdmin = new VueAdmin();
		VueClient vueClient = new VueClient(app);
		app.attacher(vueAdmin);
		app.attacher(vueClient); 
		app.setHistorique(new HistoriqueCommandes());

		System.out.println("[SYSTÈME DE RÉSERVATION]");
		System.out.println("1 - Vue Admin");
		System.out.println("2 - Vue Client");
		System.out.print("Choix : ");
		int vueChoisie = scanner.nextInt();
		scanner.nextLine();

		if (vueChoisie == 1) {
			int choix;
			do {
				System.out.println("\n[Menu Admin]");
				System.out.println("1 - Créer un voyage");
				System.out.println("2 - Annuler la dernière commande");
				System.out.println("3 - Créer une compagnie");
				System.out.println("4 - Créer un port");
				System.out.println("5 - Supprimer une compagnie");
				System.out.println("6 - Supprimer un port");
				System.out.println("7 - Supprimer un voyage");
				System.out.println("8 - Afficher les voyages");
				System.out.println("9 - Modifier une compagnie");
				System.out.println("10 - Modifier un port");
				System.out.println("11 - Modifier un voyage");
				System.out.println("12 - Assigner un tarif à une compagnie");
				System.out.println("0 - Quitter");
				System.out.print("Choix : ");
				choix = scanner.nextInt();
				scanner.nextLine();

				switch (choix) {
					case 1 -> {
						afficherPortsDisponibles();
						System.out.print("ID du voyage : ");
						String id = scanner.nextLine();
						System.out.print("Code départ : ");
						String depart = scanner.nextLine();
						System.out.print("Code arrivée : ");
						String arrivee = scanner.nextLine();
						System.out.print("Type (1=Avion, 2=Train, 3=Bateau) : ");
						int type = scanner.nextInt(); scanner.nextLine();
						switch (type) {
							case 1 -> FabriqueVoyage.setFabrique(new FabriqueAerienne());
							case 2 -> FabriqueVoyage.setFabrique(new FabriqueFerroviaire());
							case 3 -> FabriqueVoyage.setFabrique(new FabriqueNavale());
							default -> FabriqueVoyage.setFabrique(new FabriqueAerienne());
						}
						Commande cmd = new CreerVoyageCommande(id, depart, arrivee);
						app.getHistorique().executerCommande(cmd);
						app.notifier();
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 2 -> {
						app.getHistorique().annulerDerniereCommande();
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 3 -> {
						System.out.print("Nom : ");
						String nom = scanner.nextLine();
						System.out.print("Code : ");
						String code = scanner.nextLine();
						Commande cmd = new CreerCompagnieCommande(nom, code);
						app.getHistorique().executerCommande(cmd);
						app.notifier();
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 4 -> {
						System.out.print("Type de port (1 = Aérien, 2 = Ferroviaire, 3 = Maritime) : ");
						int type = scanner.nextInt();
						scanner.nextLine();
						switch (type) {
							case 1 -> FabriqueVoyage.setFabrique(new FabriqueAerienne());
							case 2 -> FabriqueVoyage.setFabrique(new FabriqueFerroviaire());
							case 3 -> FabriqueVoyage.setFabrique(new FabriqueNavale());
							default -> FabriqueVoyage.setFabrique(new FabriqueAerienne());
						}
						System.out.print("Code du port : ");
						String code = scanner.nextLine();
						System.out.print("Ville du port : ");
						String ville = scanner.nextLine();
						Commande cmd = new CreerPortCommande(code, ville);
						app.getHistorique().executerCommande(cmd);
						app.notifier();
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 5 -> {
						System.out.print("Code de la compagnie à supprimer : ");
						String code = scanner.nextLine();
						Commande cmd = new SupprimerCompagnieCommande(code);
						app.getHistorique().executerCommande(cmd);
						app.notifier();
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 6 -> {
						System.out.print("Code du port à supprimer : ");
						String code = scanner.nextLine();
						Commande cmd = new SupprimerPortCommande(code);
						app.getHistorique().executerCommande(cmd);
						app.notifier();
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 7 -> {
						System.out.print("ID du voyage à supprimer : ");
						String id = scanner.nextLine();
						Commande cmd = new SupprimerVoyageCommande(id);
						app.getHistorique().executerCommande(cmd);
						app.notifier();
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 8 -> {
						System.out.println("=== Voyages enregistrés ===");
						for (Voyage v : App.getInstance().getBaseDeDonnees().getVoyages()) {
							v.accept(vueAdmin);
						}
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 9 -> {
						System.out.print("Code compagnie : ");
						String code = scanner.nextLine();
						Compagnie c = app.getBaseDeDonnees().rechercherCompagnie(code);
						if (c != null) {
							System.out.print("Modifier (1=Nom, 2=Prix) : ");
							int choixModif = scanner.nextInt(); scanner.nextLine();
							State s = (choixModif == 1) ? State.NOM : State.PRIX;
							vueAdmin.modifierCompagnie(c, s);
							app.notifier();
						}
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 10 -> {
						System.out.print("Code port : ");
						String code = scanner.nextLine();
						Port p = app.getBaseDeDonnees().rechercherPort(code);
						if (p != null) {
							vueAdmin.modifierPort(p, State.VILLE);
							app.notifier();
						}
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 11 -> {
						System.out.print("ID voyage : ");
						String id = scanner.nextLine();
						Voyage v = app.getBaseDeDonnees().rechercherVoyage(id);
						if (v != null) {
							System.out.print("Modifier (1=Départ, 2=Arrivée) : ");
							int choixModif = scanner.nextInt(); scanner.nextLine();
							State s = (choixModif == 1) ? State.DEPART : State.ARRIVEE;
							vueAdmin.modifierVoyage(v, s);
							app.notifier();
						}
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
					case 12 -> {
						System.out.print("Code compagnie : ");
						String code = scanner.nextLine();
						Compagnie c = app.getBaseDeDonnees().rechercherCompagnie(code);
						if (c != null) {
							System.out.print("Nouveau plein tarif : ");
							float tarif = scanner.nextFloat();
							scanner.nextLine();
							Commande cmd = new AssignerPrixCommande(c, tarif);
							app.getHistorique().executerCommande(cmd);
						}
					}
					
					
					
					
					case 0 -> System.out.println("Déconnexion de l’admin.");
					default -> {
						System.out.println("Choix invalide.");
						System.out.println("Appuyez sur Entrée pour revenir au menu...");
						scanner.nextLine();
					}
				}
			} while (choix != 0);
		} else {
			vueClient.runCLI();
		}
		scanner.close();
	}

	public static VueAdmin getVueAdmin() {
		return vueAdmin;
	}
}