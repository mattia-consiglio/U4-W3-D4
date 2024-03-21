package mattiaconsiglio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partite_di_calcio")
public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;

    private String squadraVincente;
    private Integer golSquadraDiCasa;
    private Integer golSquadraOspite;


    public PartitaDiCalcio(String nome,
                           LocalDate dataEvento,
                           String descrizione,
                           TipoEvento tipoEvento,
                           int numeroMassimoPartecipanti,
                           Location loocation,
                           String squadraDiCasa,
                           String squadraOspite,
                           Integer golSquadraDiCasa,
                           Integer golSquadraOspite) {
        super(nome, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, loocation);
        this.squadraOspite = squadraOspite;
        this.squadraDiCasa = squadraDiCasa;
        if (golSquadraDiCasa > golSquadraOspite) {
            this.squadraVincente = squadraDiCasa;
        } else {
            this.squadraVincente = squadraOspite;
        }
        this.golSquadraDiCasa = golSquadraDiCasa;
        this.golSquadraOspite = golSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public Integer getGolSquadraDiCasa() {
        return golSquadraDiCasa;
    }

    public void setGolSquadraDiCasa(Integer golSquadraDiCasa) {
        this.golSquadraDiCasa = golSquadraDiCasa;
    }

    public Integer getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(Integer golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSquadraDiCasa=" + golSquadraDiCasa +
                ", golSquadraOspite=" + golSquadraOspite +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", partecipazioni=" + partecipazioni +
                ", location=" + location +
                '}';
    }
}
