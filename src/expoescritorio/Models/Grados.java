package expoescritorio.Models;

import lombok.Data;

@Data
public class Grados {
    int idGrado;
    int idNivelAcademico;
    int idSeccion;
    int idSeccionBachillerato;
    int idDocenteEncargado;
    int idEspecialidad;
    int idGrupoTecnico;

    public Grados(int idGrado, int  idNivelAcademico, int idSeccion,int idSeccionBachillerato, int idDocenteEncargado, int idEspecialidad, int idGrupoTecnico ) {
        this.idGrado = idGrado;
        this.idNivelAcademico = idNivelAcademico;
        this.idSeccion = idSeccion;
        this. idSeccionBachillerato = idSeccionBachillerato;
        this.idDocenteEncargado = idDocenteEncargado;
        this. idEspecialidad = idEspecialidad;
        this.idGrupoTecnico  = idGrupoTecnico;
    }

}
