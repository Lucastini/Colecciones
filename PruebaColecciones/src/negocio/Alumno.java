
package negocio;

import java.util.ArrayList;

public class Alumno {
    private int legajo;
    private static int nro=1;
    private String nombre;
    private String apellido;
    private ArrayList examenes;

    public Alumno(){
        legajo=nro;
        nro++;
        nombre="Sin nombre";
        apellido="Sin apellido";
        examenes=new ArrayList(30);
    }
    public Alumno(String nom,String ape){
        legajo=nro;
        nro++;
        nombre=nom;
        apellido=ape;
        examenes=new ArrayList(30);
    }
    public void setNombre(String nom){
        nombre=nom;
    }
    public void setApellido(String ape){
        apellido=ape;
    }
    public int getLegajo(){
        return legajo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public int tamArray(){
        return examenes.size();
    }
    
    @Override
    public String toString(){
        return "Legajo Nº: "+legajo+", Nombre: "+nombre+", Apellido: "+apellido+"\n"+getExamenes();
    }
    
    public boolean addExamen(Examen e){
        return examenes.add(e);
        }
    
    public Examen buscarExamen(int nroExamen){
        Examen aux, res=null;
        int tamañoArray=examenes.size();
        for(int i=0;i<tamañoArray;i++){
            aux=(Examen)examenes.get(i);
            if(aux.getNroExamen()==nroExamen)
                res=aux;
            break;
            }
        return res;
    }
    
    public boolean removeExamen(int nroExamen){
        Examen aux=buscarExamen(nroExamen);
        boolean res=false;
        if (aux!=null)
            res=examenes.remove(aux);
        return res;                
    }
    
    public boolean modExamen(int nroExamen, int nuevaNota){
        boolean aux=false;
        Examen ex=buscarExamen(nroExamen);
        if(ex!=null&&nuevaNota>=1&&nuevaNota<=10){
            ex.setNota(nuevaNota);
            aux=true;
        }
        return aux;
    }
    
    public float notaPromedio(){
        float aux=0f, prom=0f;
        Examen ex;
        if(examenes.size()>0){
            for(int i=0;i<examenes.size();i++){
                ex=(Examen)examenes.get(i);
                aux+=ex.getNota();
            }
            prom=aux/examenes.size();
        }
        return prom;
    }
    public int mayorNota(){
        int may=0;
        int tamArray=examenes.size();
        if(tamArray>=1){
            Examen ex;
            for(int i=0;i<tamArray;i++){
                ex=(Examen)examenes.get(i);
                if(ex.getNota()>may)
                    may=ex.getNota();
            }
        }
        return may;
    }
    public int menorNota(){
        int men=10;
        int tamArray=examenes.size();
        if(tamArray>=1){
            Examen ex;
            for(int i=0;i<tamArray;i++){
                ex=(Examen)examenes.get(i);
                if(ex.getNota()<men)
                    men=ex.getNota();
            }
        }
        else
            men=0;
        return men;
    }
    public int difMayMen(){
        int dif=-1;
        if(examenes.size()>=2)
            dif=mayorNota()-menorNota();
        return dif;
    }
    
    public double porcAprobacion(){
        double porc=0d;
        int tamArray=examenes.size();
        if(tamArray>0){
            int contAprob=0;
            for(int i=0;i<tamArray;i++){
                Examen ex=(Examen)examenes.get(i);
                if(ex.aprobado())
                        contAprob++;
            }
            porc=contAprob*100/tamArray;
        }
        return (double)porc;
    }
    
    public String getExamenes(){
        String aux="Datos de examenes: ";
        String aux2=aux;
        int tamArray=examenes.size();
        for(int i=0;i<tamArray;i++){
            Examen ex=(Examen)examenes.get(i);
            aux+="\nExamen "+ex.toString();
        }
        if(aux2.equals(aux))
            aux+="El Alumno aun no tiene examenes cargados";
        return aux;            
    }
    public String otrosDatosExamenes(){
        return "Promedio examenes cargados: "+notaPromedio()+", Nota mayor: "+mayorNota()+", Nota menor: "+menorNota()+", Dispercion: "+difMayMen()+", Porcentaje aprob: "+porcAprobacion()+"%";
    }
    public String todosLosDatos(){
        return toString()+"\n"+otrosDatosExamenes();
    }
    
    
    }
    
