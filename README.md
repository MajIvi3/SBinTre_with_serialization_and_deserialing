# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Navn Navnesen, S123456, s123456@oslomet.no


# Oppgavebeskrivelse

Oppgave 1

En ny verdi skal legges inn i binær søketre
1 starter fra rotnoden
2 hvis verdi er mindre en node sin verdi går vi til venstre, hvis verdi er lik eller større går vi til høyre, 
dette gjntas til vi havner ut av tree
3 igjen skal vi enten til venstre eller høyre , men det er ingen noder. Derfor oppretter vi ny node. Denne noden
er barn til noden som ble passert og skal settes på venstre eller høyre side, avhengig av vedien sin

Oppgave 2

Koden er tatt fra kompendiet i Oppgaver til Avsnitt 5.2.6, oppgave 2

Oppgaven går ut på å finne antall forekomster av verdier
1 starter fra rotnoden
2 hvis verdi er mindre en node sin verdi går vi til venstre, hvis verdi er lik eller større går vi til høyre,
dette gjntas til vi havner ut av tree
3. Hvis like verdier er funnet antall øker
4. Antall like verdier returneres.

Oppgave 3

Koden er bygget av kombinasjon av Programkode 5.1.7 h) og Programkode 5.1.15 b) i kompendiet

Førstepostorden returnerer første node postorden med p som rot. nestePostorden returnerere den noden som kommer
etter p i postorden. 


Oppgav4 

rekrusiv modell er tatt fra Løsningsforslag - oppgaver i Avsnitt 5.1.7 i kompendie
Traverserer et binærtre i postorden. Det aer en privat rekursiv metode og en offentlig metode som kaller den private.

Je har tatt kode iterativ versjon av public void postorden(Oppgave<? super T> oppgave) fra løsningsforsalget
Oppgaver til Avsnitt 5.1.15 - opgave 1.

Traverserer et binærtre i iterativ postorden, ved bruk av forelderreferansene



Oppgave 6

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


