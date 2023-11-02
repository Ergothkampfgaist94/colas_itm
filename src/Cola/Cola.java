package Cola;

public class Cola<Object> {
    
    private ListaSimple<Object> elementos;
    
    public Cola(){
        // Este elemento estaba malo en la última clase decia this.elementos = null, 
        // ahora se hace igual a la instacia de la lista
        this.elementos = new ListaSimple<Object>();
    }
    
    public void Encolar(Object elemento){
        this.elementos.Anadir(elemento);
    }
    
    public void Desencolar(){
        this.elementos.EliminarInicio();
    }
    
    public boolean EstaVacia(){
        return elementos.EstaVacia();
    }

    public Object getElementos() {
        return elementos.getElemento();
    }

    public void setElementos(ListaSimple<Object> elementos) {
        this.elementos = elementos;
    }

}
