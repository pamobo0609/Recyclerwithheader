package recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pamobo0609.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pamobo0609 on 1/26/17.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {

    private final Context mContext;
    private List<String> mData;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;

        public SimpleViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txtv_name);
        }
    }

    public SimpleAdapter(Context context, String[] data) {
        mContext = context;
        if (data != null) {
            mData = new ArrayList<>(Arrays.asList(data));
        }
        else {
            mData = new ArrayList<>();
        }
    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_row, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        holder.title.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}