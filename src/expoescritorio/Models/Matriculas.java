/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expoescritorio.Models;

import lombok.Data;

/**
 *
 * @author thatsgonzalez
 */

@Data
public class Matriculas {
    int idMatricula;
    int idEstudiante;
    int idGradoAcademico;
    int idGradoTecnico;
    byte[] horario;
    
    public Matriculas(){
        
    }
    
    public Matriculas(int idMatricula, int idEstudiante, int idGradoAcademico, int idGradoTecnico, byte[] horario){
        this.idMatricula = idMatricula;
        this.idEstudiante = idEstudiante;
        this.idGradoAcademico = idGradoAcademico;
        this.idGradoTecnico = idGradoTecnico;
        this.horario = horario;
    }
}
