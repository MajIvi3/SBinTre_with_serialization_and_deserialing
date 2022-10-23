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

private static <T> Node<T> førstePostorden(Node<T> p) 

Førstepostorden returnerer første node post orden med p som rot
er bygget av kombinasjon av Programkode 5.1.7 h) og Programkode 5.1.15 b) i kompendiet



