package androidappteam.com.universityexchange.recyclerview.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidappteam.com.universityexchange.R;

/**
 * Created by Matej on 21/03/2018.
 */

public class UniversitiesViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public ImageView picker;
    public RelativeLayout divider;

    public UniversitiesViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.university_name);
        picker = (ImageView) itemView.findViewById(R.id.university_pick);
        divider = (RelativeLayout) itemView.findViewById(R.id.university_divider);
    }
}
