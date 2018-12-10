package GestoreLogin;

import java.util.ArrayList;

import Eccezioni.AccountGiaEsistenteException;

public class GestoreLogin {
	
	ArrayList<Utente> listaUtenti;
	
	public GestoreLogin() {
		listaUtenti = new ArrayList<Utente>();
	}
	
	public void aggiungiCliente(String usr, String pwd) throws AccountGiaEsistenteException{
		Cliente nuovo = new Cliente(usr, pwd);
		for (Utente ut : listaUtenti)
			if (ut.getUsername().equals(usr)) throw new AccountGiaEsistenteException();
		
		listaUtenti.add(nuovo);
	}
	
	public void aggiungiAmministratore(String usr, String pwd) throws AccountGiaEsistenteException{
		for (Utente ut : listaUtenti)
			if (ut.getUsername().equals(usr)) throw new AccountGiaEsistenteException("Amministratore gi� esistente");
		
		listaUtenti.add(new Amministratore(usr, pwd));
	}
	
	public void remove(Utente user) {
		listaUtenti.remove(user);
	}
	
	public Utente login(String usr, String pwd) {
		for(Utente user : listaUtenti)
			if (user.getUsername().equals(usr) && user.getPassword().equals(pwd)) return user;
		
		return null;
	}
	
}