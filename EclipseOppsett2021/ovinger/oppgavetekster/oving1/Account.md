# Tilstand og oppførsel – Account

Oppgaven handler om en `Account`-klasse, som håndterer data i en konto.
Tilstanden i `Account`-objekter er som følger:

- `balance` - et desimaltall som angir beløpet som er på kontoen
- `interestRate` - et desimaltall som angir rentefot som prosentpoeng.

`Account`-klassen har fem metoder, med følgende oppførsel:

- `deposit(double)` - øker konto-beløpet med den angitte argument-verdien (et desimaltall), men kun dersom det er positivt
- `addInterest()` - beregner renta og legger det til konto-beløpet
- `getBalance()` - returnerer beløpet som er på kontoen. 
- `getInterestRate()` - returnerer rentefoten
- `setInterestRate(double)` - oppdaterer renten til å være den nye verdien

## Del 1 - Tilstandsdiagram

Tegn et objekttilstandsdiagram for en tenkt bruk av `Account`-klassen. Velg selv en passende start-tilstand for `Account`-objektet og sekvens av kall.

## Del 2 - Java-kode

Skriv Java-kode for `Account`-klassen med oppførsel som er beskrevet over.

Lag en passende `toString()`-metode og en `main`-metode, slik at du kan sjekke at oppførselen stemmer med tilstandsdiagrammet (bruk samme start-tilstand og sekvens av kall)

Testkode for denne oppgaven finner du her: [src/test/java/stateandbehavior/AccountTest.java](../../src/test/java/stateandbehavior/AccountTest.java).