package mattiaconsiglio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento {
    private GenereConcerto genere;
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String nome, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location loocation, GenereConcerto genere, boolean inStreaming) {
        super(nome, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, loocation);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }
}
