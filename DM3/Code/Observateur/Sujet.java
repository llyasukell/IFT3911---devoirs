package Observateur;

public interface Sujet {

	/**
	 * 
	 * @param o
	 */
	void attacher(Observateur o);

	/**
	 * 
	 * @param o
	 */
	void detach(Observateur o);

	void notifier();

}