package edu.galileo.android.tipcalc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.net.ContentHandler;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.tipcalc.R;
import edu.galileo.android.tipcalc.models.TipRecord;

/**
 * Created by user2 on 14-jun-16.
 */
public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder> {

    Context context;
    List<TipRecord> dataset;

    public TipAdapter(Context context, List<TipRecord> dataset) {
        this.context = context;
        this.dataset = dataset;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("TAG","onCreateViewHolder called");
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TipRecord element = dataset.get(position);
        Log.d("TAG","onBindViewHolder called");
        String strTip = String.format(context.getString(R.string.global_message_tip),
                element.getTip());
        if (!strTip.isEmpty()){
            holder.txtContent.setText(strTip);
        }

    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void add(TipRecord record){

        dataset.add(0,record);
        notifyDataSetChanged();
    }

    public void clear(){
        dataset.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.txtContent)
        TextView txtContent;

        public ViewHolder(View itemView){
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
