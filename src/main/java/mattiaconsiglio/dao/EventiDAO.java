package mattiaconsiglio.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import mattiaconsiglio.entities.Concerto;
import mattiaconsiglio.entities.Evento;
import mattiaconsiglio.entities.GenereConcerto;
import mattiaconsiglio.exceptions.EventNotFoundException;

import java.util.List;

public class EventiDAO {
    // DAO (Data Access Object)
    private EntityManager em;

    public EventiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getNome() + " salvato con successo!");
    }

    public Evento getById(int id) throws EventNotFoundException {
        Evento evento = em.find(Evento.class, id);
        if (evento == null) {
            throw new EventNotFoundException(id);
        }
        return evento;
    }

    public void delete(int id) throws EventNotFoundException {
        Evento evento = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(evento);
        transaction.commit();
        System.out.println("Evento" + evento.getNome() + " eliminato con successo!");
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genereConcerto) {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genereConcerto", Concerto.class);
        query.setParameter("genereConcerto", genereConcerto);
        return query.getResultList();
    }
}
