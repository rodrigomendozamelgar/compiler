package org.ulasalle.compiler.semantyc.analizer;

import java.util.List;
import org.ulasalle.compiler.syntax.analizer.Cuadruplo;
import org.ulasalle.compiler.syntax.analizer.Bloque;
import org.ulasalle.compiler.syntax.analizer.Terminal;
        
public class AnalizadorSemantico 
{
    public void analizar(List<Cuadruplo> cuadruplos)
    {
        for( Cuadruplo cuadruplo : cuadruplos )
        {
            Terminal operacion = (Terminal)cuadruplo.getOperacion();
            
            Bloque contexto = cuadruplo.getBloque();
            
            switch( operacion.getLexema() )
            {
                case "D":
                    if(contexto.fueDecladara(""))
                    {
                        //Error Semantico
                    }
                    else
                    {
                        //Declarar en la tabla de simbolos
                    }
                    break;
                case "A":
                    //Revisar si fue declaracion
                    
                    break;
            }
        }
    }
}
