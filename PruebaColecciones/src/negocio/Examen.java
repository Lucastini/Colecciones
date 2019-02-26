
package negocio;

public class Examen {
    private int nroExamen;
    private String tema;
    private int nota;
    
    public Examen(int nroExamen, String tema, int nota){
        this.nroExamen=nroExamen;
        this.tema=tema;
        if (nota<1||nota>10)
            this.nota=0;
        else
            this.nota=nota;
    }
    public int getNroExamen() {
        return nroExamen;
    }
    public String getTema() {
        return tema;
    }
    public int getNota() {
        return nota;
    }
    public void setNroExamen(int nroExamen) {
        this.nroExamen = nroExamen;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public void setNota(int nota) {
        if (nota<1||nota>10)
            this.nota=0;
        else
            this.nota = nota;
    }
    public String toString(){
        String aviso=".";
        if(nota==0)
            aviso="/ATENCION: nota mal cargada/.";
        return "Nº de examen: "+nroExamen+", Tema: "+tema+", Nota: "+nota+"("+resultado()+")"+aviso;
    }
    public boolean aprobado(){
        return nota>=6;
    }
    public String resultado(){
        if(aprobado())
            return "Aprobado";
        else
            return "Reprobado";
    }
    
}
