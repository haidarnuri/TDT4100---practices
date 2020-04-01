/*Del 3 a) 

Man kan ikke ha konstruktører i et grensesnitt, og det er heller ikke anbefalt å bruke statiske metoder i et grensesnitt. Derfor er det alternativ 3 som er riktig. 

b) 

Man kan utvide et grensesnitt med et annet grensesnitt, men man må ikke implemetere metodene i grensesnittet. 

c) 

Hvis man har en situasjon der en klasse arver egenskaper til en annen klasse, se eksempel. 

class Game1 extends Game2{
	
	public void computeScoresGame2(Dice dice){
		....computation...
	}
	
}

Man vet at for eksempel poengberegningene er like og derfor skal man ikke trenge å skrive en helt ny(lik) kode i begge klassene. 

I tillegg kan en metode som å beregne poeng bli deklarert i en abstrakt klasse(tenker at Game2 er en abstrakt klasse). Dette fordi at score er en generell metode som andre spill også kan få bruk for. 


*/


