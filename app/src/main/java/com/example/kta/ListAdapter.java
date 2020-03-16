package com.example.kta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    //private LayoutInflater mLayoutInflater;

    //SE CAMBIA TIPO DE LISTA A STRING
    //private List<BreedListResponse> dogList =new ArrayList<>();  //DATOS A VISUALIZAR
    List<String> dogList = new ArrayList<>();

    //private Context mContext;
    private OnItemClickListener listener;

    //SE AGREGA CONSTRUCTOR
    public ListAdapter(List<String> dogList) {
        this.dogList = dogList;
    }

    public ListAdapter(List<String> dogList, OnItemClickListener listener) {
        this.dogList = dogList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        //AQUI EL ID DEBE HACER REFERENCIA AL ID DE UN ITEM LIST XML, QUE TENDRA UN OBJETO TEXT VIEW QUE SE DEFINE EN LA CLASE VIEW HOLDER
        //NO AL FRAGMENTO A MOSTRAR
        //view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_breed_list,parent,false);
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_razas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {

        holder.data(dogList.get(position));
    }

    @Override
    public int getItemCount() {

        return dogList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView item;
        // private ArrayList<String> dogs;

      public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //menuList = itemView.findViewById(R.id.menuList);
            //ESTE ITEM VIEW DEBE HACER REFERENCIA AL ITEM A MOSTRAR DEFINIDO EN ITEM LISTA RAZAS YA QUE SE REPETIRA POR CADA ITERACION
            //itemView = (TextView) itemView.findViewById(R.id.textView);

            item = (TextView) itemView.findViewById(R.id.textoAmostrar);

            // item = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }

        //AQUI LO CAMBIO PARA RECIBA UN STRING
        //public void data(BreedListResponse breedListResponse) {

        public void data(String datosss) {
            item.setText(datosss);
        }
    }

    public int getItemCount(List<BreedListResponse> menuList) {

        return dogList.size();
    }
    public interface OnItemClickListener {
        public void OnClick(ListAdapter.ViewHolder viewHolder, String dog, String URL);
    }
}
