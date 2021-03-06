package org.ulasalle.compiler.lexical.analizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.ulasalle.compiler.util.TipoToken;
import org.ulasalle.compiler.util.Token;

public class AnalizadorLexico
{

    private Automata automata;
    private List<String> palabrasReservadas;

    public AnalizadorLexico()
    {
        automata = new Automata();
        llenarPalabrasReservadas();
    }

    private void llenarPalabrasReservadas()
    {
        palabrasReservadas = new ArrayList<>();
        palabrasReservadas.add("Programa");
        palabrasReservadas.add("entero");
        palabrasReservadas.add("Si");
        palabrasReservadas.add("Osino");
        palabrasReservadas.add("Mientras");
        palabrasReservadas.add("Hacer");
        palabrasReservadas.add("LeerTeclado");
        palabrasReservadas.add("EscribirPantalla");
    }

    private String leerArchivo(String rutaArchivo) throws IOException
    {
        StringBuilder sourceCode = new StringBuilder();
        try (Stream<String> sourceFileStream = Files.lines((new File(rutaArchivo)).toPath()))
        {
            sourceFileStream.forEach(lineStream -> sourceCode.append(lineStream).append("\n"));
        }
        return sourceCode.toString().trim();
    }

    private void agregarToken(StringBuilder buffer, List<Token> tokens, int linea)
    {
        String lexema = buffer.toString();
        buffer.delete(0, buffer.length());
        TipoToken tipoToken = automata.obtenerTipo();
        automata.reiniciar();
        if (tipoToken != TipoToken.COMENTARIO && tipoToken != TipoToken.COMENTARIO_MULTILINEA)
        {
            if (tipoToken == TipoToken.IDENTIFICADOR && palabrasReservadas.stream().filter(p -> p.equals(lexema)).count() > 0)
                tipoToken = TipoToken.PALABRA_RESERVADA;
            tokens.add(new Token(tipoToken, lexema, linea));

        }
    }

    private boolean esBlanco(char caracter)
    {
        return caracter == ' ' || caracter == '\t' || caracter == '\n';
    }

    public List<Token> analizar(String rutaArchivo) throws IOException
    {
        List<Token> tokens = new ArrayList<>();
        List<Error> errores = new ArrayList<>();
        String codigoFuente = leerArchivo(rutaArchivo);
        StringBuilder buffer = new StringBuilder();
        int linea = 1;
        for (int index = 0; index < codigoFuente.length();)
        {
            char caracter = codigoFuente.charAt(index);
            if (automata.mover(caracter))
            {
                buffer.append(caracter);
                if (index++ == codigoFuente.length() - 1)
                    agregarToken(buffer, tokens, linea);
            } else if (automata.esFinal())
                agregarToken(buffer, tokens, linea);
            else if (esBlanco(caracter))
                do
                {
                    if (caracter == '\n')
                        linea++;
                    caracter = codigoFuente.charAt(++index);
                } while (esBlanco(caracter));
            else
            {
                errores.add(new Error(buffer + "" + caracter, caracter, linea));
                index++;
            }
        }
        if (errores.size() > 0)
            imprimirErrores(errores);
        return tokens;
    }

    private void imprimirErrores(List<Error> errores)
    {
        errores.forEach((error) -> System.out.println(error.getDescripcion()));
    }

}
