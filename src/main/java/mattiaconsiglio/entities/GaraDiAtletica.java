package mattiaconsiglio.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento {
    @ManyToMany
    @JoinTable(name = "garaalettica_persone",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private List<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitrice_id", nullable = false)
    private Persona vincitrice;


    public GaraDiAtletica(String nome, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, Location location, int numeroMassimoPartecipanti, List<Persona> atleti, Persona vincitrice) {
        super(nome, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitrice = vincitrice;
    }
}
