package GestoreLogin;

import Eccezioni.AccountGiaEsistenteException;
import GestoreSale.GestoreSale;

public class Cinema {
	
	GestoreLogin gestoreLogin;
	GestoreSale gestoreSale;
	Utente utente;
	
	public Cinema() {
		gestoreLogin = new GestoreLogin();
		gestoreSale = new GestoreSale();
	}
	
	public void registraCliente(String usr, String pwd) throws AccountGiaEsistenteException{
		gestoreLogin.aggiungiCliente(usr, pwd);
	}
	
	public void registraAmministratore(String usr, String pwd) throws AccountGiaEsistenteException{
		gestoreLogin.aggiungiAmministratore(usr, pwd);
	}
	
	public void aggiungiSala(int rows, int columns) {
		gestoreSale.aggiungiSala(rows, columns);
	}
	
	public Utente getUtente() {
		return utente;
	}
	
	public boolean login(String usr, String pwd) {
		utente = gestoreLogin.login(usr, pwd);
		if (utente != null) return true;
		return false;
	}
}
