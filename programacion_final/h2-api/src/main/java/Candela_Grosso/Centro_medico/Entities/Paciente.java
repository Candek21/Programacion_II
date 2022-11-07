package Candela_Grosso.Centro_medico.Entities;

import javax.persistence.*;
import java.util.List;


@Entity
    @Table(name="pacientes")

    public class Paciente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(nullable = false, name = "nombre_apellido")
        private String nombre_apellido;

        @Column(nullable = false, length = 60)
        private String direccion;

        @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
         List<Turno>turnos;

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

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }


    }

