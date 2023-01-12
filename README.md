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


Oppgaven er å finne antall forekomster av verdier 
1. starter fra rotnoden
2. hvis verdien er mindre enn nodens verdi, går vi til venstre, hvis verdien er lik eller større, går vi til høyre,
Dette gjentar seg til vi havner ut av treet
3. Hvis like verdier blir funnet, øker antall
4. Antall dupliserte verdier returneres.

*Tar utgangspunkt i kompendiets programkode: **Oppgaver til Avsnitt 5.2.6, oppgave 2***

 ## Oppgave 3
 
 <b>Lag hjelpemetodene private static <T> Node<T> førstePostorden(Node<T> p) og private 
private static <T> Node<T> nestePostorden(Node<T> p).</b>


 Førstepostorden skal returnere første node post  orden med p som rot, og nestePostorden skal returnere den noden som kommer 
etter p i postorden. Hvis p er den siste i postorden, skal metoden returnere null
 
 *Tar utgangspunkt i kompendiets programkode:  **5.1.7 h) og Programkode 5.1.15 b)***


 ## Oppgav4 
 
 <b>Lag hjelpemetodene 
  1. public void postorden(Oppgave <? super T> oppgave) og 
 2. private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) </b>

- 1) Traverserer et binær tre i iterativ postordren, ved bruk av forelder referansene 

 *Tar utgangspunkt i kompendiets programkode: **løsningsforsalget Oppgaver til Avsnitt 5.1.15 - opgave 1.***

- 2) Den traverserer et binærtre i postorden. Det er en privat rekursiv metode og en offentlig metode som kaller den private. 

*Tar utgangspunkt i kompendiets programkode: **Løsningsforslag - oppgaver i Avsnitt 5.1.7 i kompendie oppgave 7***




## Oppgave 5

<b>. I denne oppgaven skal du lage serialize som gjør om binærtreet til et array, og tilsvarende deserialize som tar et array og gjør om til et binært søketre. Lag hjelpemetoden: 
1. public ArrayList<T> serialize() og
2.  static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c)</b>

- 1)  Siden oppgaven nevner at metoden serialize bør bruke kø for å traversere treet i nivå orden,  jeg  *tok
utgangspunktet fra oppgaven: **Programkode 5.1.6 a)*** og modifisere den slik at den støttes av Interface Queue<E>


- 2) Deserialize-metode tar arrayet som en parameter, og legger inn alle verdiene (igjen i nivå orden) ved hjelp av en for 
løkke og legginn() metode.


## Oppgave 6

<b>

1. Lag metoden public boolean fjern(T verdi)
2. pLag så metoden public int fjernAlle(T verdi)
3. Lag så metoden public void nullstill()

</b>


- 1) Går ut på å fjerne duplikater.
Starter med å søke og sammenligne noder. Hvis verdi som skal fjernes er funnet skal den søkte verdien ligger i p, 
hvis ikke metoden returnerer false

Koden tar hensy til 3 ting:
1. p har ingen barn (p er en bladnode)
2. p har nøyaktig ett barn (venstre eller høyre barn)
3. p har to barn

Målet er å flytte pekere til riktige noder, refranse skal peke til dens forelder, slik kan vi få 
velykket fjerning. Hvis fjerning var vellykket returnerer metoden true og antall mynker siden vi har en node  mindre

*public boolean fjern(T verdi) - Tar utgangspunkt i kompendiets programkode: **Programkode 5.2 8 d)***

- 2) Fjerner alle forekomstene av verdi og returnere det antallet som ble fjernet. Det betyr spesielt at
den skal returnere 0 hvis treet ikke inneholder verdi.

*public int fjernAlle(T verdi) - Tar utgangspunkt i kompendiets programkode: **Løsningsforslag - oppgaver i Avsnitt 5.2.8 oppgave 3***

- 3) metoden  nullstill() tømmer treet.

 *Tar utgangspunkt i kompendiets programkode: **Oppgaver til Avsnitt 5.2.8  oppgave 5***
 
 
 ***Kilde: Algoritmer og datastrukturer med Java Nettbasert lærebok*** </br>
 ***Link:*** https://www.cs.hioa.no/~ulfu/appolonius/?fbclid=IwAR2DTWVDZ2qLxNY1SU6BHgtVg0J0pyZYsN1ZlkTxq34tTPfcHJeAdPnodSk






