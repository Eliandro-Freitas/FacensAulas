package com.example.aula4recyclerview.dataset;

import com.example.aula4recyclerview.models.Curso;

import java.util.ArrayList;

public class CursoDataset {
    private static ArrayList<Curso> cursos;

    public static ArrayList<Curso> getItens(){
        cursos = new ArrayList<>();
        cursos.add(new Curso("Musicalização Infantil", "Nível I", "Preço: R$125,00", "Dias: segunda ou terça-feira de manhã"));
        cursos.add(new Curso("Musicalização Infantil", "Nível II", "Preço: R$135,00", "Dias: quarta ou quinta-feira de manhã"));
        cursos.add(new Curso("Musicalização Infantil", "Nível III", "Preço: R$145,00", "Dias: quinta ou sexta-feira a tarde"));
        cursos.add(new Curso("Piano clássico", "Nivel I", "Preço: R$200,00", "Dias: segunda, terça ou sexta de manhã"));

        /* Musicalização Infantil nível III - Valor: R$ 145,00 - dias: quinta ou sexta-feira de manhã
    Musicalização básica - Valor: R$ 150,00 - dias: quinta ou sexta-feira a tarde
    Piano clássico - Valor: R$ 200,00 - dias: segunda, terça ou sexta de manhã*/
        return cursos;
    }
    public static void AddCurso(Curso curso){
        cursos.add(curso);
    }
}
