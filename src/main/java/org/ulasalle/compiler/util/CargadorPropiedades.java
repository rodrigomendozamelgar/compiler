package org.ulasalle.compiler.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author francisco
 */
public class CargadorPropiedades
{

    public void escribirJSON(Object object, String rutaArchivo) throws IOException
    {
        new ObjectMapper().writeValue(new FileOutputStream(rutaArchivo), object);
    }

    public Object leerJSON(Class<?> clase, String rutaArchivo) throws FileNotFoundException, IOException
    {
        return new ObjectMapper().readValue(new FileInputStream(rutaArchivo), clase);
    }
}
