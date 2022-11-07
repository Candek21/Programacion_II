package Candela_Grosso.Centro_medico.Entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Medicos")
public class Medicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "nombre_apellido")
    private String nombre_apellido;

    @Column(nullable = false, length = 10)
    private String matricula;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    List<Turno>turno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
