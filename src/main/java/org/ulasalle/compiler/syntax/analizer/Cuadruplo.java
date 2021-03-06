package org.ulasalle.compiler.syntax.analizer;

import org.ulasalle.compiler.util.Simbolo;

public class Cuadruplo 
{
    private Bloque bloque;
    private int idRegla;
    private int indiceRegla;

    private Simbolo resultado;
    private Simbolo operando1;
    private Simbolo operacion;
    private Simbolo operando2;

    public Cuadruplo()
    {
    }

    public Bloque getBloque()
    {
        return bloque;
    }

    public void setBloque(Bloque bloque)
    {
        this.bloque = bloque;
    }
        
    public int getIndiceRegla()
    {
        return indiceRegla;
    }

    public void setIndiceRegla(int indiceRegla)
    {
        this.indiceRegla = indiceRegla;
    }

    public int getIdRegla()
    {
        return idRegla;
    }

    public void setIdRegla(int idRegla)
    {
        this.idRegla = idRegla;
    }
    

    public Simbolo getResultado()
    {
        return resultado;
    }

    public void setResultado(Simbolo resultado)
    {
        this.resultado = resultado;
    }

    public Simbolo getOperando1()
    {
        return operando1;
    }

    public void setOperando1(Simbolo operando1)
    {
        this.operando1 = operando1;
    }

    public Simbolo getOperacion()
    {
        return operacion;
    }

    public void setOperacion(Simbolo operacion)
    {
        this.operacion = operacion;
    }

    public Simbolo getOperando2()
    {
        return operando2;
    }

    public void setOperando2(Simbolo operando2)
    {
        this.operando2 = operando2;
    }
    
    
}
