package e2p1_jesusr;

import java.util.ArrayList;

public class Maquina_Constructor {
    public ArrayList<String> Estados;
    public ArrayList<String> Aceptacion;
    public ArrayList<String> Aristas;
    public String Estado_actual;

    public ArrayList<String> getEstados() {
        return Estados;
    }

    public void setEstados(ArrayList<String> Estados) {
        this.Estados = Estados;
    }

    public ArrayList<String> getAceptacion() {
        return Aceptacion;
    }

    public void setAceptacion(ArrayList<String> Aceptacion) {
        this.Aceptacion = Aceptacion;
    }

    public ArrayList<String> getAristas() {
        return Aristas;
    }

    public void setAristas(ArrayList<String> Aristas) {
        this.Aristas = Aristas;
    }

    public String getEstado_actual() {
        return Estado_actual;
    }

    public void setEstado_actual(String Estado_actual) {
        this.Estado_actual = Estado_actual;
    }
    
    public ArrayList<String> split(String str, char delim) {
        ArrayList<String> ayuda = new ArrayList<>();
        
        while (!str.equals("")) {
            
            int index = str.indexOf(delim);
        if(index>-1){
            ayuda.add(str.substring(0, index));
        }
            if(index + 1 < str.length() - 1) {
                
                str = str.substring(index + 1);
            } else {
                str = "";
            }
        }
        
        return ayuda;
}
    public Maquina_Constructor(String Estados, String Aristas){
        this.Estados= split(Estados,';');
        extractAcceptNodes();
        this.Aristas= split(Aristas, ';');
        this.Estado_actual= this.Estados.get(0);
    }
    
    public void extractAcceptNodes(){
        
        for (int i = 0; i < Estados.size(); i++) {
            
        
        if (Estados.get(i).contains(".")) {
            Aceptacion.add(Estados.get(i).substring(1));
            Estados.set(i,Estados.get(i).substring(1));
        
                    }
        }
    }
    
    public String computeStr (String str){
        
   Estado_actual= Estados.get(0);     
    String Op="";
    
        for (int i = 0; i < str.length(); i++) {
            String x = Estado_actual+","+ str.charAt(i);
            String y = getArista(x);
            if (!y.equals("")) {
                Op += Estado_actual +":" +str.charAt(i)+"->";
                String [] arr = y.split(",");
                Estado_actual= arr[2];
                Op = Estado_actual+"\n Aceptado";
                
            }
            else{
                Op= "Nada";
                
            }
            
                
                
            }
        
        return Op;
    }
        
    
    
    
    public String getArista (String str){
        for (int i = 0; i < str.length(); i++) {
            if (Aristas.get(i).contains(str)) {
            return Aristas.get(i);
                
            }
        }
        return "";
    }

}
