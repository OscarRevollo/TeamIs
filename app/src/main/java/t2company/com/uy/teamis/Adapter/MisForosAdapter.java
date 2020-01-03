package t2company.com.uy.teamis.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import t2company.com.uy.teamis.ForoProjectActivity;
import t2company.com.uy.teamis.Model.Foro;
import t2company.com.uy.teamis.R;

public class MisForosAdapter extends RecyclerView.Adapter<MisForosAdapter.ViewHolder> {
    // private String[] mDataset;
//    private Context mCtx;
    private List <Foro> foroList;

    public class ViewHolder extends  RecyclerView.ViewHolder{
        //        public TextView mTextView;
        TextView textViewFecha,textViewtitulo,textViewAutor,textViewDescripcion,textViewTematica;
        LinearLayout parentLayout;
        ImageView delete;

        public ViewHolder(View itemView){
            super(itemView);
            textViewFecha=(TextView) itemView.findViewById(R.id.fecha);
            textViewTematica=(TextView)itemView.findViewById(R.id.categoria);
            textViewAutor=(TextView) itemView.findViewById(R.id.Autor);
            textViewtitulo=(TextView) itemView.findViewById(R.id.titulo);
            textViewDescripcion=(TextView) itemView.findViewById(R.id.descripcion);
            parentLayout = itemView.findViewById(R.id.parent_layout1);
            delete = itemView.findViewById(R.id.delete);
//            delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int position = getAdapterPosition();
//                    if(position!= RecyclerView.NO_POSITION){
//                        listener.onDeleteClick(position);
//                    }
//                }
//            });

        }

    }

    public MisForosAdapter(List<Foro> foro){

        this.foroList=foro;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view

        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.foro_itemed,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder( ViewHolder holder, final int position) {

        final Foro foro = foroList.get(position);
        holder.textViewFecha.setText("Fecha: "+ foro.getFecha());
        holder.textViewTematica.setText("Tematica:" + foro.getTematica());
        holder.textViewAutor.setText("Autor: "+foro.getAutor());
        holder.textViewtitulo.setText("Titulo: "+foro.getTitulo());
        holder.textViewDescripcion.setText("Descripcion: "+foro.getDescripcion());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ForoProjectActivity.class);
                intent.putExtra("titulo", foro.getTitulo());
                intent.putExtra("descripcion",foro.getDescripcion());
                intent.putExtra("fecha",foro.getFecha());
                intent.putExtra("autor",foro.getAutor());
                intent.putExtra("tematica",foro.getTematica());
                intent.putExtra("key",foro.getKey());
                intent.putExtra("categoria",foro.getCategoria());


                view.getContext().startActivity(intent);
            }
        });
//        holder.textView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return foroList.size();
    }
    public interface OnItemClickListener{
        void  onDeleteClick(int position);
    }

}
