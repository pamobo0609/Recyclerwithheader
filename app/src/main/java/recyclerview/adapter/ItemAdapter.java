package recyclerview.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pamobo0609.R;

import java.util.ArrayList;

import model.Item;

/**
 * Created by pamobo0609 on 1/26/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ROW = 1;
    private static final int TYPE_SEPARATOR = -1;

    private ArrayList<Item> mDataSet;

    public ItemAdapter(ArrayList<Item> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

        switch (viewType) {
            case TYPE_HEADER:
                 itemView = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_drawer_header,
                        parent, false);

                return new ItemViewHolder(itemView, TYPE_HEADER);

            case TYPE_ROW:
                 itemView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,
                        parent, false);
                return new ItemViewHolder(itemView, TYPE_ROW);

            case TYPE_SEPARATOR:
                itemView = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_separator,
                        parent, false);

                return new ItemViewHolder(itemView, TYPE_SEPARATOR);
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (TYPE_HEADER == position) {
            return TYPE_HEADER;
        } else if (position != mDataSet.size() && position == 3) {
            return TYPE_SEPARATOR;
        } else {
            return TYPE_ROW;
        }
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (TYPE_ROW == holder.getHolderId()) {
            Item i = mDataSet.get(position-1);

            holder.getImgUser().setImageResource(i.getUserImage());
            holder.getTxtvId().setText(i.getId());
            holder.getTxtvName().setText(i.getName());
        } else if (TYPE_SEPARATOR == holder.getHolderId()) {
            holder.getTxtvSeparator().setText("Hello separator");
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.size()+1;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        /** The header is not necessary to add here, but we need the separator.*/
        private TextView txtvSeparator;
        /** Default attributes for the rows. */
        private ImageView imgUser;
        private TextView txtvId;
        private TextView txtvName;

        private int holderId;

        ItemViewHolder(View itemView, int viewType) {
            super(itemView);

            if (viewType == TYPE_HEADER) {
                holderId = TYPE_HEADER;

            } else if (viewType == TYPE_ROW) {
                this.imgUser = (ImageView) itemView.findViewById(R.id.img_user_image);
                this.txtvId = (TextView) itemView.findViewById(R.id.txtv_id);
                this.txtvName = (TextView) itemView.findViewById(R.id.txtv_name);

                holderId = TYPE_ROW;
            } else if (viewType == TYPE_SEPARATOR) {
                this.txtvSeparator = (TextView) itemView.findViewById(R.id.txtv_separator);
                holderId = TYPE_SEPARATOR;
            }

        }

        TextView getTxtvSeparator() {
            return txtvSeparator;
        }

        int getHolderId() {
            return holderId;
        }

        ImageView getImgUser() {
            return imgUser;
        }

        TextView getTxtvId() {
            return txtvId;
        }

        TextView getTxtvName() {
            return txtvName;
        }
    }

}
