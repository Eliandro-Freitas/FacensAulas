package com.example.aula4recyclerview.recyclerpessoa;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula4recyclerview.R;
import com.example.aula4recyclerview.dataset.CursoDataset;
import com.example.aula4recyclerview.models.Curso;

import java.util.ArrayList;

public class PessoaAdapter extends RecyclerView.Adapter<PessoaHolder> {
    private ArrayList<Curso> cursos;

    public PessoaAdapter(ArrayList<Curso> cursos){
        this.cursos = cursos;
    }

    @NonNull
    @Override
    public PessoaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PessoaHolder(
        LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_item_pessoa,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PessoaHolder holder, int position) {
        holder.nome.setText(cursos.get(position).getNome());
        holder.nivel.setText(cursos.get(position).getNivel());
        holder.preco.setText(cursos.get(position).getPreco());
        holder.dias.setText(cursos.get(position).getDias());
        holder.buttonExcluir.setOnClickListener(
                                            view -> excluirItem(position));
    }
    public void addItem(Curso curso){
        CursoDataset.AddCurso(curso);
        notifyItemInserted(getItemCount());
    }
    private void excluirItem(int position){
        cursos.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, cursos.size());
    }

    @Override
    public int getItemCount() {
        return cursos != null ? cursos.size() : 0;
    }
}
