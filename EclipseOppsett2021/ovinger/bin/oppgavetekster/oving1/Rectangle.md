# Tilstand og oppførsel – Rectangle

Oppgaven handler om en `Rectangle`-klasse, som håndterer et firkantet område i et koordinatsystem, med sider parallelle med koordinataksene.

Tilstanden i `Rectangle`-objekter er ikke spesifisert eksplisitt, men må velges slik at metodene nedenfor kan implementerers. Merk at alle metodene jobber med heltallsstørrelser.

`Rectangle`-klassen har metoder for å spørre om tilstanden og endre tilstanden. Spørremetodene dekker høyde og bredde og koordinatene til øverste venstre og nederste høyre hjørne og om rektanglet inneholder spesifikke punkt(er). Endringsmetodene dekker utviding ved å legge til punkter.

**Merk**: `Rectangle`-klassen fungerer som om du krysser ut et rutenett, altså at et punkt ("kryss") har en lengde og bredde på 1, ikke som i matematikk der punkter ikke har størrelser. Bildeserien under viser et eksempel på hvordan bredde og høyde endres når man legger til punkter i rektangelet.

<img alt="Tomt rektangel" src="fig/rectangle/step1.png" width="500px" />
<br />

<img alt="Rektangel med et punkt" src="fig/rectangle/step2.png" width="500px" />
<br />

<img alt="Rektangel steg 3" src="fig/rectangle/step3.png" width="500px" />
<br />

<img alt="Rektangel steg 4" src="fig/rectangle/step4.png" width="500px" />
<br />

Logikken til metodene må tilfredsstille følgende krav:

- et `Rectangle`-objekt er tomt i starten
- et tomt `Rectangle`-objekt skal returnere $`0`$ for alle `get`-metodene (`minX`, `minY`, `maxX`, `maxY`), `true` for `isEmpty` og `false` for `contains`-metodene.
- et punkt har bredde og høyde lik $`1`$, så dersom en legger punktet $`(x,y)`$ til et tomt `Rectangle`-objekt, så skal `getMinX` og `getMaxX` returnere $`x`$, `getMinY` og `getMaxY` skal returnere $`y`$ og `getWidth` og `getHeight` skal returnere $`1`$.
- når en utvider et `Rectangle`-objekt med en av `add`-metodene, så skal ikke rektanglet bli større enn nødvendig.

Spørremetoder:

- `int getMinX()` og `int getMinY()` - returnerer henholdsvis $`x`$- og $`y`$-koordinatene til punktet med lavest $`(x,y)`$-verdier som er inneholdt i dette rektanglet. Dersom dette rektanglet er tomt, så skal $`0`$ returneres.
- `int getMaxX()` og `int getMaxY()` - returnerer henholdsvis $`x`$- og $`y`$-koordinatene til punktet med høyest $`(x,y)`$-verdier som er inneholdt i dette rektanglet. Dersom dette rektanglet er tomt, så skal $`0`$ returneres.
- `int getWidth()` og `int getHeight()` - returnerer henholdsvis bredden og høyden til rektanglet. Begge skal returnere $`0`$, dersom dette rektanglet er tomt.
- `boolean isEmpty()` - returnerer `true` om rektanglet er tomt, dvs. om bredden og/eller høyden er $`0`$.
- `boolean contains(int x, int y)` - returnerer `true` om punktet $`(x,y)`$ er inneholdt i dette rektanglet, og `false` ellers.
- `boolean contains(Rectangle rect)` - returnerer `true` om hele `rect`, dvs. alle punktene i `rect`, er inneholdt i dette rektanglet, og false ellers. Dersom `rect` er tomt, så skal `false` returneres.

Endringsmetoder:

- `boolean add(int x, int y)` - utvider (om nødvendig) dette rektanglet slik at det (akkurat) inneholder punktet $`(x,y)`$. Etter kallet skal altså `contains(x, y)` returnere `true`. Returnerer `true` om dette rektanglet faktisk ble endret, ellers `false`.
- `boolean add(Rectangle rect)` - utvider (om nødvendig) dette rektanglet slik at det (akkurat) inneholder hele `rect`-argumentet. Returnerer `true` om dette rektanglet faktisk ble endret, ellers `false`. Dersom `rect` er tomt, så skal dette rektanglet ikke endres.

Andre metoder:

- `Rectangle union(Rectangle rect)` - returnerer et nytt `Rectangle`-objekt som tilsvarer kombisjonen av dette rektanglet og `rect`-argumentet. Alle punktene som finnes i ett av rektanglene skal altså være inneholdt i rektanglet som returneres.

## Del 1 - Tilstandsdiagram

Tegn et objekttilstandsdiagram for en tenkt bruk av `Rectangle`-klassen. Velg en sekvens av kall som bruker alle fire endringsmetoder.

## Del 2 - Java-kode

Skriv Java-kode for `Rectangle`-klassen med oppførsel som er beskrevet over.

Lag en passende `toString()`-metode og et hovedprogram, slik at du kan sjekke at oppførselen stemmer med tilstandsdiagrammet (bruk samme sekvens av kall).

Testkode for denne oppgaven finner du her: [src/test/java/stateandbehavior/RectangleTest.java](../../src/test/java/stateandbehavior/RectangleTest.java).

## Ekstraoppgave

Implementer følgende metoder:

- `Rectangle intersection(Rectangle rect)` - returnerer et nytt `Rectangle`-objekt som tilsvarer overlappet mellom dette rektanglet og `rect`-argumentet. Alle punktene som finnes i begge rektanglene skal altså være inneholdt i rektanglet som returneres.
- `boolean intersects(Rectangle rect)` - returnerer `true` om dette rektanglet og `rect`-argumentet overlapper, dvs. om det finnes ett eller flere punkter som er inneholdt i begge disse rektanglene.
