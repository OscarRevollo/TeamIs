package t2company.com.uy.teamis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import t2company.com.uy.teamis.R;
import t2company.com.uy.teamis.modelos.Foro;

public class ForoAdapter extends RecyclerView.Adapter<ForoAdapter.ViewHolder> {
   // private String[] mDataset;
//    private Context mCtx;
    private List <Foro> foroList;

    public class ViewHolder extends  RecyclerView.ViewHolder{
//        public TextView mTextView;
        TextView textViewFecha,textViewtitulo,textViewAutor,textViewDescripcion;

        public ViewHolder(View itemView){
            super(itemView);
            textViewFecha=(TextView) itemView.findViewById(R.id.fecha);
            textViewAutor=(TextView) itemView.findViewById(R.id.Autor);
            textViewtitulo=(TextView) itemView.findViewById(R.id.titulo);
            textViewDescripcion=(TextView) itemView.findViewById(R.id.descripcion);
        }

    }

    public ForoAdapter( List<Foro> foro){

        this.foroList=foro;
    }

     @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view

        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.foro_item,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Foro foro = foroList.get(position);
        holder.textViewFecha.setText("Fecha: "+ foro.getFecha());
        holder.textViewAutor.setText(foro.getCategoria());
        holder.textViewtitulo.setText(foro.getTitulo());
        holder.textViewDescripcion.setText(foro.getDescripcion());
//        holder.textView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return foroList.size();
    }



}
