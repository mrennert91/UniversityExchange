package androidappteam.com.universityexchange.recyclerview.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidappteam.com.universityexchange.R;
import androidappteam.com.universityexchange.recyclerview.ListItemClickListener;

/**
 * Created by Matej on 21/03/2018.
 */

public class UniversitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView name;
    public ImageView picker;
    public RelativeLayout divider;
    public ListItemClickListener onItemClickListener;

    public UniversitiesViewHolder(View itemView, ListItemClickListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;

        name = (TextView) itemView.findViewById(R.id.university_name);
        picker = (ImageView) itemView.findViewById(R.id.university_pick);
        divider = (RelativeLayout) itemView.findViewById(R.id.university_divider);
        
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int clickedPosition = getAdapterPosition();
        onItemClickListener.onListItemClickListener(clickedPosition);
    }
}
