package mattiaconsiglio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mattiaconsiglio.dao.EventiDAO;
import mattiaconsiglio.dao.LocationsDAO;
import mattiaconsiglio.dao.PersoneDAO;
import mattiaconsiglio.entities.*;
import mattiaconsiglio.exceptions.EventNotFoundException;
import mattiaconsiglio.exceptions.RecordNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventiDAO ed = new EventiDAO(em);
        LocationsDAO ld = new LocationsDAO(em);
        PersoneDAO pd = new PersoneDAO(em);
        Location location = null;
        try {
            location = ld.getById(1);
        } catch (RecordNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Persona p1 = null;
        Persona p2 = null;
        try {
            p1 = pd.getById(1);
            p2 = pd.getById(2);
        } catch (EventNotFoundException e) {
            System.out.println(e.getMessage());
        }

        List<Persona> atleti = List.of(p1, p2);

        PartitaDiCalcio pdc = new PartitaDiCalcio("hei", LocalDate.now(), "hei", TipoEvento.PUBBLICO, 1000, location, "suqdracasa", "sqaudraospite", 5, 5);
        GaraDiAtletica gda = new GaraDiAtletica("Gara atletica", LocalDate.now(), "hei", TipoEvento.PUBBLICO, location, 1000, atleti, p1);
        Concerto concerto = new Concerto("concerto privato", LocalDate.now(), "concertoooo!!!", TipoEvento.PRIVATO, 100, location, GenereConcerto.CLASSICO, true);
//        ed.save(pdc);
//        ed.save(gda);
//        ed.save(concerto);

        System.out.println("Concenti non in streaming");
        ed.getConcertiInStreaming(false).forEach(System.out::println);
        System.out.println("Concerti per genere");
        ed.getConcertiPerGenere(GenereConcerto.CLASSICO).forEach(System.out::println);
    }
}
