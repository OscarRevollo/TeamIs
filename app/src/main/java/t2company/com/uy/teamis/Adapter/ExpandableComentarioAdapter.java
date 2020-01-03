package t2company.com.uy.teamis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import t2company.com.uy.teamis.Model.Respuesta;
import t2company.com.uy.teamis.R;

public class ExpandableComentarioAdapter extends RecyclerView.Adapter<ExpandableComentarioAdapter.ViewHolder> {
    public ArrayList<Respuesta> nameList = new ArrayList<Respuesta>();

    public ExpandableComentarioAdapter(ArrayList<Respuesta> nameList) {

        this.nameList = nameList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,comentario;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemTextView);
            comentario = itemView.findViewById(R.id.comentarioRespuesta);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comentario_respuesta, parent, false);


        ExpandableComentarioAdapter.ViewHolder vh = new ExpandableComentarioAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(nameList.get(position).getUsuario());
        holder.comentario.setText(nameList.get(position).getComentario());

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


}
