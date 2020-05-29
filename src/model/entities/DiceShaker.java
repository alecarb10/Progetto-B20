package model.entities;

import java.util.Arrays;


public class DiceShaker {
	
	private Die die1;
	private Die die2;
	private Die die3;
	private Die die4;
	private Die die5;
	private Die die6;
	
	private int[] atkResults;			
	private int[] defResults;
	private int[] loss;

	
	public DiceShaker() {		//costruttore bussolotto con 6 dadi
		die1 = new Die();
		die2 = new Die();
		die3 = new Die();
		die4 = new Die();
		die5 = new Die();
		die6 = new Die();
		
		loss = new int[2];			//array contenente i carrarmati persi da attacco e difesa
		atkResults = new int[3];	//array contenente i risultati dei lanci dell'attacco 
		defResults = new int[3];	//array contenente i risultati dei lanci della difesa

	}
	
	public int[] rollDices(int atk, int def) {		//metodo per il tiro dei dadi, vengono passati il numero di dadi da lanciare rispettivamente di attacco e difesa
		
		loss[0] = 0;
		loss[1] = 0;
		
		switch(atk) {								//switch per tirare 1,2 o 3 dadi dell'attaccante
		case 1:
			atkResults[0] = die1.roll();
			break;
		case 2:
			atkResults[0] = die1.roll();
			atkResults[1] = die2.roll();
			break;
		case 3:
			atkResults[0] = die1.roll();
			atkResults[1] = die2.roll();
			atkResults[2] = die3.roll();
			break;
		}
		
		switch(def) {								//switch per tirare 1,2 o 3 dadi del difensore
		case 1:
			defResults[0] = die4.roll();
			break;
		case 2:
			defResults[0] = die4.roll();
			defResults[1] = die5.roll();
			break;
		case 3:
			defResults[0] = die4.roll();
			defResults[1] = die5.roll();
			defResults[2] = die6.roll();
			break;
		}
		
		//Sorting methods for arrays (We used an array of int, a primitive type, so we had to sort the Array in the ascending order, then swap it using a for).
		Arrays.sort(atkResults);
		Arrays.sort(defResults);
		 for (int i = 0, j = 3 - 1, tmp; i < j; i++, j--) {
	            tmp = atkResults[i];
	            atkResults[i] = atkResults[j];
	            atkResults[j] = tmp;
	        }
		 for (int i = 0, j = 3 - 1, tmp; i < j; i++, j--) {
	            tmp = defResults[i];
	            defResults[i] = defResults[j];
	            defResults[j] = tmp;
	        }
		 
		
		/*System.out.println("atkArray:\n");
		for(int k=0; k < atkResults.length; k++) {
			System.out.println(atkResults[k]);
		}
		System.out.println("defArray:\n");
		for(int k=0; k < defResults.length; k++) {
			System.out.println(defResults[k]);
		}*/
		
		for(int i=0; i < Math.min(atk, def); i++) {			//ciclo for per confrontare uno ad uno i risultati dei lanci e incrementare il numero dei carrarmati persi
			
			if(atkResults[i] > defResults[i]) {
				loss[1]++;
			} else {
				loss[0]++;
			}
		}
		
		return loss;
		
	}

	
		/*public static void main(String[] args){
		
		DiceShaker bussolotto = new DiceShaker();
		int[] loss = bussolotto.rollDices(3, 3);
		
		System.out.println("Perdite\n" + "Atk: " + loss[0] + "\n" + "Def: " + loss[1]);
		
	
	
		}*/
}
