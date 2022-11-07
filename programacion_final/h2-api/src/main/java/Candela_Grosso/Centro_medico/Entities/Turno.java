package Candela_Grosso.Centro_medico.Entities;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.LocalDate;

@Table(name= "Turnos")
@Entity
@NoArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //Con esto aclaramos que muchos turnos pueden corresponder a un paciente
    @JoinColumn(name = "id_paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_medico", referencedColumnName = "id", nullable = false)
    private Medicos medicos;

    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="hora")
    private LocalTime hora;

    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medicos getMedicos() {
        return medicos;
    }

    public void setMedicos(Medicos medicos) {
        this.medicos = medicos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }


}
