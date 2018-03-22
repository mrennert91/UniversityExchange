package androidappteam.com.universityexchange.recyclerview.adapters;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidappteam.com.universityexchange.R;
import androidappteam.com.universityexchange.common.University;
import androidappteam.com.universityexchange.recyclerview.ListItemClickListener;
import androidappteam.com.universityexchange.recyclerview.holders.UniversitiesViewHolder;

/**
 * Created by Matej on 21/03/2018.
 */

public class UniversitiesAdapter extends RecyclerView.Adapter<UniversitiesViewHolder> {

    private ArrayList<University> universities;
    private final ListItemClickListener onItemClickListener;

    public UniversitiesAdapter(ArrayList<University> universities, ListItemClickListener onItemClickListener) {
        this.universities = universities;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public UniversitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutID = R.layout.university_picker_list_item;
        boolean shouldAttachToParentImmediately = false;

        View view = LayoutInflater.from(parent.getContext()).inflate(layoutID, parent, shouldAttachToParentImmediately);
        return new UniversitiesViewHolder(view, onItemClickListener);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(UniversitiesViewHolder holder, int position) {
        University university = universities.get(position);
        holder.name.setText(university.getName());
        holder.name.setTextColor(R.color.colorTextBlack);
        holder.picker.setImageResource(R.drawable.icon_arrow_right);
        holder.divider.setBackgroundColor(R.color.colorBackgroundDivider);
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }
}