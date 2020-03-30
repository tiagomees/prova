package com.prova.controller;


import com.prova.model.*;
import com.prova.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/filmes")
    public ResponseEntity<Object> getMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getFilmes());
    }

    @GetMapping("/filmes/{id}")
    public ResponseEntity<Object> getFilmeById(@PathVariable Integer id) {
        Filme filme = null;
        for (Filme f : filmeService.getFilmes()) {
            if (f.getId() == id) {
                filme = f;
            }
        }

        if (filme == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(filme);
    }

    @GetMapping("/vencedores")
    public ResponseEntity<Object> getVencedores() {
        List<Filme> vencedores = new LinkedList<>();
        for (Filme m : filmeService.getFilmes()) {
            if (m.isWinner()) {
                vencedores.add(m);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(vencedores);
    }

    @GetMapping("/vencedores/{ano}")
    public ResponseEntity<Object> getWinnersByYear(@PathVariable Integer ano) {
        List<Filme> vencedorAno = new LinkedList<>();
        for (Filme m : filmeService.getFilmes()) {
            if (m.getYear() == ano && m.isWinner()) {
                vencedorAno.add(m);
            }
        }

        if (vencedorAno.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(vencedorAno);
    }

    @PostMapping(name ="/inserir", consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<Object> inserir(@RequestBody Filme filme){
        Filme filmeAux = filmeService.getFilmes().get(filmeService.getFilmes().size() -1);
        if(filme != null){
            Integer id = filmeAux.getId();
            filme.setId(++id);
            filmeService.getFilmes().add(filme);
            return ResponseEntity.status(HttpStatus.OK).body(filme);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/produtoras")
    public ResponseEntity<Object> getEstatisticasProdutoras() {
        HashMap<String, List<Integer>> mapProdutoras = new HashMap<>();
        Produtora produtora = new Produtora();

        filmeService.getFilmes().stream()
                .filter(m -> m.isWinner())
                .forEach(a -> {
                    for (String b : a.getProducers()) {
                        List<Integer> aux = mapProdutoras.get(b);
                        if (aux == null) {
                            aux = new LinkedList<>();
                            aux.add(a.getYear());
                            mapProdutoras.put(b, aux);
                        } else {
                            aux.add(a.getYear());
                            mapProdutoras.put(b, aux);
                        }
                    }
                });

        List<Produtora.Item> list = new ArrayList<>();
        mapProdutoras.entrySet().stream()
                .filter(m -> m.getValue().size() > 1)
                .forEach(i -> {
                    
                    Produtora.Item minItem = null;
                    List<Integer> aux = i.getValue();
                    Integer min = null, previous = null, next = null, diff = null;

                    for (int a = 0; a < (aux.size() - 1); a++) {
                        previous = aux.get(a);
                        next = aux.get(a + 1);
                        diff = next - previous;
                        if (min == null) {
                            min = diff;
                        } else if (min > diff) {
                            min = diff;
                        }
                    }
                    
                    minItem = new Produtora.Item(i.getKey(), diff, previous, next);
                    list.add(minItem);
                });

        Produtora.Item minByInterval = list
                .stream()
                .min(Comparator.comparing(Produtora.Item::getInterval))
                .orElseThrow(NoSuchElementException::new);
        
        list.clear();
        mapProdutoras.entrySet().stream()
                .filter(m -> m.getValue().size() > 1)
                .forEach(i -> {
                    
                    Produtora.Item minItem = null;
                    List<Integer> aux = i.getValue();
                    Integer max = null, previous = null, next = null, diff = null;

                    for (int a = 0; a < (aux.size() - 1); a++) {
                        previous = aux.get(a);
                        next = aux.get(a + 1);
                        diff = next - previous;
                        if (max == null) {
                            max = diff;
                        } else if (max < diff) {
                            max = diff;
                        }
                    }
                    
                    minItem = new Produtora.Item(i.getKey(), diff, previous, next);
                    list.add(minItem);
                });

        Produtora.Item maxByInterval = list
                .stream()
                .max(Comparator.comparing(Produtora.Item::getInterval))
                .orElseThrow(NoSuchElementException::new);

        produtora.setMin(minByInterval);
        produtora.setMax(maxByInterval);
        return ResponseEntity.status(HttpStatus.OK).body(produtora);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Object> deletarFilme(@PathVariable Integer id) {
        Filme filme = filmeService.getFilmes().stream()
                .filter(m -> m.getId() == id)
                .collect(Collectors.toList()).get(0);
        filmeService.getFilmes().remove(filme);
        return ResponseEntity.status(HttpStatus.OK).body(filme);
    }
}
