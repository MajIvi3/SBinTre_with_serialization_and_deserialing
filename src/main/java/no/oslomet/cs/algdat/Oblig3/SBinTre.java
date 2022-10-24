package no.oslomet.cs.algdat.Oblig3;


import java.util.*;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {

        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot;               // p starter i roten
        Node<T> q = null;
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren

            if (cmp < 0){ p = p.venstre;  }              // flytter p
            else
            {
                p = p.høyre;
            }

        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi,q);                   // oppretter en ny node
        // Jeg har legget til q, slik at referansen forelder får verdi

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;
    }

    public boolean fjern(T verdi) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        if (verdi == null) return false;  // treet har ingen nullverdier

        Node<T> p = rot, q = null;   // q skal være forelder til p

        while (p != null)            // leter etter verdi
        {
            int cmp = comp.compare(verdi,p.verdi);      // sammenligner
            if (cmp < 0) {
                q = p;
                p = p.venstre;
            }      // går til venstre
            else if (cmp > 0) {
                q = p;
                p = p.høyre;
            }   // går til høyre

            else break;    // den søkte verdien ligger i p
        }
        if (p == null) return false;   // finner ikke verdi

        if (p.venstre == null || p.høyre == null)  // Tilfelle 1) og 2)
        {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b for barn

            if (p == rot) {
                rot = b;
            }

            else if (p == q.venstre) {
                q.venstre = b;
            }
            else {
                q.høyre = b;
            }
            if ( b != null){
                b.forelder = q;     // sørger for riktig peker
            }

        }
        else  // Tilfelle 3)
        {
            Node<T> s = p, r = p.høyre;   // finner neste i inorden
            while (r.venstre != null)
            {
                s = r;    // s er forelder til r
                r = r.venstre;
            }

            p.verdi = r.verdi;   // kopierer verdien i r til p


            if (s != p) {
                s.venstre = r.høyre;
            }
            else {
                s.høyre = r.høyre;
            }
            if (r.høyre != null) {
                r.høyre.forelder = s;       // sørger for riktig peker
            }
        }

        antall--;   // det er nå én node mindre i treet
        return true;


    }

    public int fjernAlle(T verdi) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        if (tom()){     // sjekker om tree er tomt
            return 0;
        }
        int verdiAntall = 0;
        while (fjern(verdi)) verdiAntall++;
        return verdiAntall;
    }

    public int antall(T verdi) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        Node<T> p = rot;        // starter fra root
        int antallVerdi = 0;    // antall av like verdier starter fra 0
        while (p != null)
        {
            int cmp = comp.compare(verdi,p.verdi);  // sammenligner
            if (cmp < 0) {p = p.venstre;}
            else
            {
                if (cmp == 0) antallVerdi++;        // antall øker, vi har fant like verdier
                p = p.høyre;
            }
        }
        return antallVerdi;                 // returnerer antall
    }

    public void nullstill() {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        if (!tom()) nullstill(rot);  // nullstiller
        rot = null; antall = 0;      // treet er nå tomt

    }
    private void nullstill(Node<T> p)
    {
        if (p.venstre != null)
        {
            nullstill(p.venstre);      // venstre subtre
            p.venstre = null;          // nuller peker
        }
        if (p.høyre != null)
        {
            nullstill(p.høyre);        // høyre subtre
            p.høyre = null;            // nuller peker
        }
        p.verdi = null;              // nuller verdien
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        while (true)
        {
            if (p.venstre != null) p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else return p;
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");

        if (p.forelder == null) {
            return null;        // siste node, ikke mulig å gå høyere en dette
        }
        if (p.forelder.høyre == p || p.forelder.høyre == null) {
            return p.forelder;              // returnerer forelder hvis høyre node  er selve p verdien eller er det tom for noder
        } else {
            return førstePostorden(p.forelder.høyre);   //rekrusiv kall til førstePostordensom
        }
    }

    public void postorden(Oppgave<? super T> oppgave) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");

        if (tom()) return;  // tomt tre

        Node<T> p = rot;

        while (true) // flytter p til den første i postorden
        {
            if (p.venstre != null) p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else break;
        }

        oppgave.utførOppgave(p.verdi);

        while (true)
        {
            if (p == rot) break;  // den siste i postorden

            Node<T> f = p.forelder;
            if (f.høyre == null || p == f.høyre) p = f;
            else
            {
                p = f.høyre;
                while (true)
                {
                    if (p.venstre != null) p = p.venstre;
                    else if (p.høyre != null) p = p.høyre;
                    else break;
                }
            }
            oppgave.utførOppgave(p.verdi);
        }

    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        if (rot != null) { // sjekker om treet er tomt
            postordenRecursive(rot, oppgave);
        }
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");

        if (p.venstre != null) postordenRecursive(p.venstre,oppgave);// rekursiv p venster node
        if (p.høyre != null) postordenRecursive(p.høyre,oppgave);   // rekursiv p høyre node
        oppgave.utførOppgave(p.verdi);      //kjører opgaven

    }

    public ArrayList<T> serialize() {

        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        //if (tom()) return;                   // tomt tre
        ArrayList<T> ret = new ArrayList<>();       // skal returneres

        Queue<Node<T>> kø = new ArrayDeque<>(antall);   // den skal gå gjennom noder

        kø.add(rot);            // legger rot først

        while (!kø.isEmpty())    // hvis empty da returneres true og løkka stopper
        {

            Node<T> p = kø.poll();  //fjerner noden- øverst node

            ret.add(p.verdi);

            if (p.venstre != null) kø.add(p.venstre);
            if (p.høyre != null) kø.add(p.høyre);

        }

        return ret;

    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");

        SBinTre tree = new SBinTre(c);  // sammenligner elementer /verdier

        for (K liste : data){

            tree.leggInn(liste);        // siden legg inn tar seg av hele tree til og med root, holder det bare å kjøre den i løkke og legge inn data

        }
        return tree;

    }


} // ObligSBinTre
