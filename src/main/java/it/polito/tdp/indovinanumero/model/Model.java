package it.polito.tdp.indovinanumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Model {
	
	private final int NMAX = 100;
	private final int TMAX = 8;
	
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco;
	
	private Set<Integer> tentativi;
	
	public Model() {
		this.inGioco = false;
		this.tentativiFatti = 0;
	}
	
	public void nuovaPartita() {
		this.segreto = (int)(Math.random() * NMAX) + 1;
		this.tentativiFatti = 0;
		this.inGioco = true;
		this.tentativi = new HashSet<Integer>();
	}
	
	// questo metodo non sarà 'void' perchè il controller, tramite questo metodo, dovrà 'scoprire' l'esito del tentativo
	// come parametro dovrà ricevere in tentativo che l'utente ha effettuato
	
	public int tentativo(int tentativo) {
		// controllo se la partita è effettivamente in corso
		if(!inGioco)
			throw new IllegalStateException("La partita è terminata \n");
		
		// CONVIENE CREARE UN METODO PER IL CONTROLLO DELL'INPUT!
		
		if(!tentativoValido(tentativo))
			throw new InvalidParameterException("Devi inserire un numero che non hai ancora utilizzato " +
														"compreso tra 1 e " + NMAX + "\n");
		
		// se arrivo qui il tentativo è valido ---> comincia il gioco 
		this.tentativiFatti++;
		
		this.tentativi.add(tentativo);
		
		if(this.tentativiFatti == TMAX) {
			this.inGioco = false;
		}
		
		// HO VINTO
		if(tentativo == this.segreto) {
			this.inGioco = false; 
			return 0; 
		}
		
		if(tentativo < this.segreto) {
			return -1;
		} else {
			return 1;
		}
		
		
		
	}
	
	private boolean tentativoValido(int tentativo) {
		if(tentativo < 1 || tentativo > NMAX) {
			return false;
		} else {
			if(this.tentativi.contains(tentativo)) {
				return false;
			}
		}
		return true;
	}

	public int getSegreto() {
		return segreto;
	}


	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public int getTMAX() {
		return TMAX;
	}
	
	

}

