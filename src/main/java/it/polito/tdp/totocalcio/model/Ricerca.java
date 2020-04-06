package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {

	private Pronostico pronostico;
	private int N;
	private List<Risultato> soluzione;
	
	/**
	 * crea l'ambiente grazie al quale la procedura ricorsiva può funzionare
	 * 
	 * @param pronostico
	 * @return la soluzione dell'algoritmo ricorsivo
	 */
	public List<Risultato> cerca(Pronostico pronostico) {
		this.pronostico = pronostico;
		this.N = pronostico.size();
		
		List<RisultatoPartita> parziale = new ArrayList<>();
		int livello =0;
		
		this.soluzione = new ArrayList<Risultato>();
		
		ricorsiva(parziale,livello);
		
		return this.soluzione;
	}
	
	
	private void ricorsiva(List<RisultatoPartita> parziale, int  livello) {
		
		//caso terminale?
		if(livello == N) {
			
			//questa soluzione parziale è una soluzione completa!
			
//			System.out.println(parziale);
			this.soluzione.add(new Risultato(parziale));
			
			//TODO: restituire al chiamante!
		}else {
			//caso generale
			
//			[parziale da 0 a livello-1] [livello] [livello+1 in poi]
			
			PronosticoPartita pp = pronostico.get(livello);
			//pp sono i sottoproblemi da provare
			
			for(RisultatoPartita ris : pp.getRisultati()) {
				//provo a mettere ris nella posizione 'livelo' della soluzione parziale
				
				//costruzione della soluzione parziale(sottoproblema)
				parziale.add(ris);
				//chiamata riscorsiva
				ricorsiva(parziale,livello+1);
				//backtracking
				parziale.remove(parziale.size()-1);
			}
		}
	}
	
	
/*	
 * LIVELLO = indica il numero di partite che sto considerando
 * 			 le partite da a livello-1 sono gia state decise
 * 			 la partita di indice livello la devo decidere io 
 *			 le partite da livello+1 in poi le decideranno le procedure ricorsive sottostanti
 * 
 * SOLUZIONE PARZIALE = elenco di RisultatoPartita di lunghezza pari al livello
 * 
 * SOLUZIONE TOTALE = ho N risultati;
 * 
 * CONDIZIONE TERMINAZIONE = livello == N
 * 
 * GENERAZIONE DELLE SOLUZIONI DEL LIVELLO = provo tutti i pronostici definiti per quel livello
 * 
 * 
 * [ "2X", "1", "1X2", "12" ]
	
		2	 1	   X	  2 	[]
	
	[ "2X"] + [ "1", "1X2", "12"]

			[ "1"] + ["1X2", "12"]
			
			*/
}
