package t2company.com.uy.teamis.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import t2company.com.uy.teamis.ForoProjectActivity;
import t2company.com.uy.teamis.Model.Comentario;
import t2company.com.uy.teamis.Model.Foro;
import t2company.com.uy.teamis.R;


public class ComentarioProAdapter extends RecyclerView.Adapter<ComentarioProAdapter.ViewHolder> {


    // private String[] mDataset;
//    private Context mCtx;
    private List <Comentario> comentarioList;

    public class ViewHolder extends  RecyclerView.ViewHolder{
        //        public TextView mTextView;
        TextView textViewtitulo,textViewAutor,textViewComentario,textViewEmisor;
        LinearLayout parentLayout;

        public ViewHolder(View itemView){
            super(itemView);

            textViewtitulo=(TextView)itemView.findViewById(R.id.titulo);
            textViewAutor=(TextView) itemView.findViewById(R.id.autor_o);
            textViewComentario=(TextView) itemView.findViewById(R.id.comentario);
            textViewEmisor=(TextView) itemView.findViewById(R.id.emisor);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

    }

    public ComentarioProAdapter(List<Comentario> comentario){

        this.comentarioList=comentario;
    }

    @Override
    public ComentarioProAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view

        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.foro_item,parent,false);
        ComentarioProAdapter.ViewHolder holder= new ComentarioProAdapter.ViewHolder(view);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ComentarioProAdapter.ViewHolder holder, final int position) {

        final Comentario comentario = comentarioList.get(position);

        holder.textViewComentario.setText("Categoria:" + comentario.getComentario());
        holder.textViewAutor.setText("Autor: "+comentario.getAutorOriginal());
        holder.textViewtitulo.setText("Titulo: "+comentario.getTitulo());
        holder.textViewEmisor.setText("Descripcion: "+comentario.getEmisorComentario());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return comentarioList.size();
    }



}
