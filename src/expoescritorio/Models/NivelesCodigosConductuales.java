package expoescritorio.Models;


import lombok.Data;

@Data
public class NivelesCodigosConductuales {
    int idNivelCodigoConductual;
    String nivelCodigoConductual;

    public NivelesCodigosConductuales(int idNivelCodigoConductual, String nivelCodigoConductual){
        this.idNivelCodigoConductual= idNivelCodigoConductual;
        this.nivelCodigoConductual= nivelCodigoConductual;
    }


}
