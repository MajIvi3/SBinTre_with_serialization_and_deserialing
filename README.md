# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer


> Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
> Oppgaven er levert av følgende student:
> * Navn: Majda ivic, S362095, s362095@oslomet.no
>
>
>
> # Oppgavebeskrivelse




## Oppgave 1

<b>Lag metoden public boolean leggInn(T verdi)</b>

En ny verdi skal legges inn i binært søketre

1. Starter fra rotnoden
2. hvis verdien er mindre enn nodens verdi, går vi til venstre, hvis verdien er lik eller større, går vi til høyre, 
Dette gjentas til vi havner ut av treet
3. Igjen går vi enten til venstre eller høyre , men det er ingen noder. Derfor oppretter vi en ny node. Denne noden
er barn av noden som ble passert og skal settes på venstre eller høyre side, avhengig av verdien

 ## Oppgave 2
 
 <b>Lag kode for metoden public int antall(T verdi)</b>

*Hovedkoden er hentet fra kompendiet fra **Oppgaver til Avsnitt 5.2.6, oppgave 2***

Oppgaven er å finne antall forekomster av verdier 
1. starter fra rotnoden
2. hvis verdien er mindre enn nodens verdi, går vi til venstre, hvis verdien er lik eller større, går vi til høyre,
Dette gjentar seg til vi havner ut av treet
3. Hvis like verdier blir funnet, øker antall
4. Antall dupliserte verdier returneres.

 ## Oppgave 3

Koden er bygget av kombinasjon av Programkode 5.1.7 h) og Programkode 5.1.15 b) i kompendiet

Førstepostorden returnerer første node postorden med p som rot. nestePostorden returnerere den noden som kommer
etter p i postorden. 


 ## Oppgav4 

rekrusiv modell er tatt fra Løsningsforslag - oppgaver i Avsnitt 5.1.7 i kompendie oppgave 7
Traverserer et binærtre i postorden. Det aer en privat rekursiv metode og en offentlig metode som kaller den private.

Je har tatt kode iterativ versjon av public void postorden(Oppgave<? super T> oppgave) fra løsningsforsalget
Oppgaver til Avsnitt 5.1.15 - opgave 1.

Traverserer et binærtre i iterativ postorden, ved bruk av forelderreferansene


## Oppgave 5

Siden oppgaver nevner at metoden serialize skal bruke kø til å traversere treet i nivå orden tok jeg
utgangspunktet fra oppgave Programkode 5.1.6 a) og bytter til metoder som er støttet av Interface Queue<E>

Deserialize metode tar arrayet som parameter, og legge inn alle verdiene (igjen i nivå orden) ved bruk av en for 
løkke og legginn() metode.


## Oppgave 6

metoden  nullstill() tømmer treet. Rekursiv traversering i postorden å traversere treet og så fortløpende nulle verdier og refranser.

 koden er tatt fra Oppgaver til Avsnitt 5.2.8  oppgave 5

public int fjernAlle(T verdi) - er tatt fra Løsningsforslag - oppgaver i Avsnitt 5.2.8 oppgave 3
Fjerner alle forekomstene av verdi og returnere det antallet som ble fjernet. Det betyr spesielt at
den skal returnere 0 hvis treet ikke inneholder verdi.

public boolean fjern(T verdi) - er tatt fra kompendiet som anbefal  Programkode 5.2 8 d)

Går ut på å fjerne duplikater.
Starter med å søke og sammenligne noder. Hvis verdi som skal fjernes er funnet skal den søkte verdien ligger i p, 
hvis ikke metoden returnerer false
Koden tar hensy til 3 ting:
1. p har ingen barn (p er en bladnode)
2. p har nøyaktig ett barn (venstre eller høyre barn)
3. p har to barn

Målet er å flytte pekere til riktige noder, refranse skal peke til dens forelder, slik kan vi få 
velykket fjerning. Hvis fjerning var vellykket returnerer metoden true og antall mynker siden vi har en node  mindre



