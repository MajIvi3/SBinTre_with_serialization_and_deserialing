package no.oslomet.cs.algdat.Oblig3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;

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
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
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
        throw new UnsupportedOperationException("Ikke kodet ennå!");
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
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
