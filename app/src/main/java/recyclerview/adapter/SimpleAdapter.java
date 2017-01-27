package recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pamobo0609.R;

import java.util.ArrayList;

import model.Item;

/**
 * Created by pamobo0609 on 1/26/17.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {

    private ArrayList<Item> mData;

    public SimpleAdapter(ArrayList<Item> data) {
        if (data != null) {
            this.mData = data;
        }
        else {
            mData = new ArrayList<>();
        }
    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        holder.txtvId.setText(mData.get(position).getId());
        holder.txtvName.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

     static class SimpleViewHolder extends RecyclerView.ViewHolder {
         final TextView txtvName;
         final TextView txtvId;

         SimpleViewHolder(View view) {
            super(view);
             txtvName = (TextView) view.findViewById(R.id.txtv_name);
             txtvId = (TextView) view.findViewById(R.id.txtv_id);
        }
    }
}