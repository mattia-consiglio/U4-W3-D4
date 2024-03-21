package mattiaconsiglio.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "eventi")
public abstract class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected String nome;
    protected LocalDate dataEvento;
    protected String descrizione;
    @Enumerated(EnumType.STRING)
    protected TipoEvento tipoEvento;
    protected int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento")
    protected List<Partecipazione> partecipazioni;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    protected Location location;

    public Evento() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public Evento(String nome, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location loocation) {
        this.nome = nome;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = loocation;
    }
}
