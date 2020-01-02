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
import t2company.com.uy.teamis.R;

public class ExpandableComentarioAdapter extends RecyclerView.Adapter<ExpandableComentarioAdapter.ViewHolder> {
    public ArrayList<String> nameList = new ArrayList<String>();

    public ExpandableComentarioAdapter(ArrayList<String> nameList) {

        this.nameList = nameList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemTextView);
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

        holder.name.setText(nameList.get(position));

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


}
