package com.prova.service;


import com.prova.model.Filme;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Component
public class FilmeService {

    private static List<Filme> filmes = new LinkedList<>();
    private static AtomicInteger counter = new AtomicInteger();

    static {
        try {
            InputStream in = new FileInputStream("src/main/resources/movielist.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            Integer count = 0;
            boolean first = true;
            while ((line = reader.readLine()) != null) {
                if (first) {
                    first = false;
                    continue;
                }

                String[] row = line.split(";");

                filmes.add(getEntity(++count, row));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Filme getEntity(Integer id, String[] row) {
        Integer year = null;
        try {
            year = Integer.parseInt(row[0]);
        } catch (Exception e) {
        }

        String title = row[1];
        List<String> listaEstudios = Arrays.asList(row[2].split(",\\s*"));
        List<String> listaProdutoras = Arrays.asList(row[3].split(",\\s*"));
        boolean vencedor = false;
        try {
            if (row[4].equalsIgnoreCase("yes")) {
                vencedor = true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            vencedor = false;
        }

        Filme filme = new Filme(id, year, title, listaEstudios, listaProdutoras, vencedor);

        return filme;
    }

    public static List<Filme> getFilmes() {
        return filmes;
    }

    public static void setFilmes(List<Filme> filmes) {
        FilmeService.filmes = filmes;
    }
}
