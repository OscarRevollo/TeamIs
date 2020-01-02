package t2company.com.uy.teamis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import t2company.com.uy.teamis.Model.Comentario;

import t2company.com.uy.teamis.R;


public class ComentarioProAdapter extends RecyclerView.Adapter<ComentarioProAdapter.ViewHolder> {





    ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<String> image = new ArrayList<String>();
    ArrayList<Integer> counter = new ArrayList<Integer>();
    ArrayList<ArrayList> itemNameList = new ArrayList<ArrayList>();
    Context context;

    public ComentarioProAdapter(Context context,
                                         ArrayList<String> nameList,
                                         ArrayList<ArrayList> itemNameList) {
        this.nameList = nameList;
        this.itemNameList = itemNameList;
        this.context = context;


        for (int i = 0; i < nameList.size(); i++) {
            counter.add(0);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageButton dropBtn;
        RecyclerView cardRecyclerView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.autor_or);
            dropBtn = itemView.findViewById(R.id.categoryExpandBtn);
            cardRecyclerView = itemView.findViewById(R.id.innerRecyclerView);
            cardView = itemView.findViewById(R.id.foro_card_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comentario_item, parent, false);

        ComentarioProAdapter.ViewHolder vh = new ComentarioProAdapter.ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(nameList.get(position));

        ExpandableComentarioAdapter itemInnerRecyclerView = new ExpandableComentarioAdapter(itemNameList.get(position));


        holder.cardRecyclerView.setLayoutManager(new GridLayoutManager(context, 1));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (counter.get(position) % 2 == 0) {
                    holder.cardRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    holder.cardRecyclerView.setVisibility(View.GONE);
                }

                counter.set(position, counter.get(position) + 1);


            }
        });
        holder.cardRecyclerView.setAdapter(itemInnerRecyclerView);

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }




    /*private List <Comentario> comentarioList;
    private Context mContext;
    ArrayList<Integer> counter = new ArrayList<Integer>();
    ArrayList<ArrayList> itemNameList = new ArrayList<ArrayList>();

    public ComentarioProAdapter(List<Comentario> comentario){

        this.comentarioList=comentario;
        ArrayList<String> nameList = new ArrayList<>();


        nameList.add("Fruits & Vegetables");
        nameList.add("Beverages & Health");
        nameList.add("Home & Kitchen");
        for (int i = 0; i < nameList.size(); i++) {
            counter.add(0);
        }

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        ArrayList<String> childList = new ArrayList<>();
        childList.add("Apple");
        childList.add("Mango");
        childList.add("Banana");

        itemNameList.add(childList);

        childList = new ArrayList<>();
        childList.add("Red bull");
        childList.add("Maa");
        childList.add("Horlicks");

        itemNameList.add(childList);

        childList = new ArrayList<>();
        childList.add("Knife");
        childList.add("Vessels");
        childList.add("Spoons");

        itemNameList.add(childList);

        final Comentario comentario =comentarioList.get(position);
        holder.textViewComentario.setText("Comentario:" + comentario.getComentario());
        holder.textViewAutor.setText("Autor: "+comentario.getAutorOriginal());
        holder.textViewtitulo.setText("Titulo: "+comentario.getTitulo());
        holder.textViewEmisor.setText("Emisor: "+comentario.getEmisorComentario());
        ExpandableComentarioAdapter itemInnerRecyclerView = new ExpandableComentarioAdapter(itemNameList.get(position));
        holder.cardRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (counter.get(position) % 2 == 0) {
                    holder.cardRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    holder.cardRecyclerView.setVisibility(View.GONE);
                }

                counter.set(position, counter.get(position) + 1);


            }
        });
        holder.cardRecyclerView.setAdapter(itemInnerRecyclerView);
    }

    @Override
    public int getItemCount() {
        return comentarioList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewtitulo,textViewAutor,textViewComentario,textViewEmisor;
        public LinearLayout parentLayout;
        CardView cardView;
        RecyclerView cardRecyclerView;
        public ViewHolder(View itemView){
            super(itemView);

            textViewtitulo=(TextView)itemView.findViewById(R.id.titulo);
            textViewAutor=(TextView) itemView.findViewById(R.id.autor_or);
            textViewComentario=(TextView) itemView.findViewById(R.id.comentario);
            textViewEmisor=(TextView) itemView.findViewById(R.id.emisor);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            cardView = itemView.findViewById(R.id.foro_card_view);
            cardRecyclerView = itemView.findViewById(R.id.innerRecyclerView);
        }

    }*/

}





