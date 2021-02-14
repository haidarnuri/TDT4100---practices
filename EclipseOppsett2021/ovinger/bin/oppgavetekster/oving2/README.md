# Øving 2: Innkapsling og vali⁣dering

__Øvingsmål__:

- Lære å innkapsle klasser og metoder etter god programmeringsskikk
- Lære å validere argumenter for å sikre gyldig tilstand

__Øvingskrav__:

- Kunne forstå og implementere hvordan en klasse best bør innkapsles
- Kunne skrive kode for å validere argumenter for å sikre gyldig tilstand
- Kunne utløse exceptions ved ugyldige argumenter i en metode

## NB: Viktig beskjed!
Etter at du har hentet ned/pullet denne øvingen, **må** du høyreklikke på prosjektet og kjøre *Maven -> Update Project*. Vi har fikset problemet med *.classpath*-filene, og det er veldig viktig at dette blir gjort for at prosjektet fortsatt skal funke! Hvis du har gjort endringer i en *.classpath*-fil vil du få en merge-conflict når du puller øvingen. Løsning på dette problemet finner du [her.](../classpath_fix/README.md) 

## Dette må du gjøre

__Del 1: Teori__

Les [wikisiden om innkapsling](https://www.ntnu.no/wiki/display/tdt4100/Innkapsling) og svar på følgende:

- Hva er en **synlighetsmodifikator**?
- Hva er forskjellen på **private** og **public** og når brukes de?

Teori-oppgavene besvares i en tekstfil eller på papir, og gjennomgås med studass ved godkjenning.

__Del 2: Programmering__

Velg minst 2 av følgende oppgaver:

- [Innkapsling og validering av 3 eksisterende klasser](./Encapsulation.md) (Varierende)
- [Account](./Account.md) (Lett)
- [Person](./Person.md) (Medium)
- [Vehicle](./Vehicle.md) (Medium)

Oppgavene for denne delen skal du lagre i `ovinger/src/main/java/encapsulation`. Test-filene for å verifisere korrekt implementasjon ligger i `ovinger/src/test/java/encapsulation`.

Oppgavene er markert med en vanskeliggrad relativt til hverandre. Det er en god idé å begynne med de lettere oppgavene dersom du ikke er komfortabel med pensum så langt, men det er anbefalt å prøve seg på de vanskeligere oppgavene om du synes de første oppgavene er uproblematiske. Dersom du allerede føler deg trygg på punktene i øvingskravene kan du forsøke å gå rett på de vanskeligere oppgavene. Du er selvfølgelig velkommen til å løse flere oppgaver enn minstekravet, hvilket lurt gjøres med tanke på eksamen og et langt liv som programmerende.

Før du setter i gang kan det vært lurt å lese nevnte [wikiside om innkapsling](https://www.ntnu.no/wiki/display/tdt4100/Innkapsling) nøye. Forelesningene og tilhørende øvingsforelesning er selvsagt også lure å få med seg.

### Hjelp / mistanke om bugs

Ved spørsmål eller behov for hjelp konsulter studassen din i saltiden hans / hennes. Du kan også oppsøke andre studasser på sal eller legge ut et innlegg på Piazza.

### Godkjenning

Last opp kildekode på Blackboard innen den angitte innleveringsfristen. Innlevert kode skal demonstreres for stud.ass innen én uke etter innleveringsfrist. Se for øvrig Blackboard-sidene for informasjon rundt organisering av øvingsopplegget og det tilhørende øvingsreglementet.
