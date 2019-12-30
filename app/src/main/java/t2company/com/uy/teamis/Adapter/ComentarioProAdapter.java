package t2company.com.uy.teamis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import t2company.com.uy.teamis.Model.Comentario;

import t2company.com.uy.teamis.R;


public class ComentarioProAdapter extends RecyclerView.Adapter<ComentarioProAdapter.ViewHolder> {

    private List <Comentario> comentarioList;
    private Context mContext;


    public ComentarioProAdapter(List<Comentario> comentario){

        this.comentarioList=comentario;
    }




    public ComentarioProAdapter(Context mContext, List<Comentario> comentarioList){
        this.mContext=mContext;
        this.comentarioList=comentarioList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.comentario_item,parent,false);
        return new ComentarioProAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Comentario comentario =comentarioList.get(position);
        holder.textViewComentario.setText("Comentario:" + comentario.getComentario());
        holder.textViewAutor.setText("Autor: "+comentario.getAutorOriginal());
        holder.textViewtitulo.setText("Titulo: "+comentario.getTitulo());
        holder.textViewEmisor.setText("Emisor: "+comentario.getEmisorComentario());
    }

    @Override
    public int getItemCount() {
        return comentarioList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewtitulo,textViewAutor,textViewComentario,textViewEmisor;
        public LinearLayout parentLayout;
        public ViewHolder(View itemView){
            super(itemView);

            textViewtitulo=(TextView)itemView.findViewById(R.id.titulo);
            textViewAutor=(TextView) itemView.findViewById(R.id.autor_or);
            textViewComentario=(TextView) itemView.findViewById(R.id.comentario);
            textViewEmisor=(TextView) itemView.findViewById(R.id.emisor);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }

    }

}





