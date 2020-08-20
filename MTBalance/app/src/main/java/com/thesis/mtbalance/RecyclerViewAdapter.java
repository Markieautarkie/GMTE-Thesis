package com.thesis.mtbalance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.RidesViewHolder> {

    /* Variables */
    private Context mContext;
    ArrayList<RidesItem> mRidesData;

    /**
     * Constructer for the view adapter, used by the recyclerview to link data.
     *
     * @param context   - the application context.
     * @param ridesData - the data to connect to the recyclerview.
     */
    public RecyclerViewAdapter(Context context, ArrayList<RidesItem> ridesData) {
        mContext = context;
        mRidesData = ridesData;
    }

    /**
     * Creates the viewholder for an item element in the recyclerview.
     *
     * @param parent   - the parent of the viewholder (recyclerview).
     * @param viewType - what type of view we are dealing with.
     * @return retuns the viewholder.
     */
    @NonNull
    @Override
    public RidesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RidesViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_rides, parent, false));
    }

    /**
     * Binds the data to the viewholder elements.
     *
     * @param holder   - the holder to connect the data to.
     * @param position - the position of the card to get the correct element.
     */
    @Override
    public void onBindViewHolder(@NonNull RidesViewHolder holder, int position) {

        holder.mCompTimeTextView.setText(mRidesData.get(position).getCompletionTime());
        holder.mDateTimeTextView.setText(mRidesData.get(position).getDateTime());

        holder.mFeedbackTextView.setText(mRidesData.get(position).getFeedbackMethod());
        holder.mBalPerfTextView.setText(mRidesData.get(position).getBalancePerformance());
        holder.mBalDevTextView.setText(mRidesData.get(position).getBalanceDeviation());
        holder.mRespTimeTextView.setText(mRidesData.get(position).getResponseTime());
    }

    /**
     * Gets the amount of items in the recyclerview.
     *
     * @return An integer representing the amount of items.
     */
    @Override
    public int getItemCount() {
        return mRidesData.size();
    }

    /**
     * Custom viewholder for the rides data.
     */
    public static class RidesViewHolder extends RecyclerView.ViewHolder {

        /* Views */
        private TextView mCompTimeTextView;
        private TextView mDateTimeTextView;

        private TextView mFeedbackTextView;
        private TextView mBalPerfTextView;
        private TextView mBalDevTextView;
        private TextView mRespTimeTextView;

        /**
         * Setup the textview elements for the viewholder.
         *
         * @param itemView - the current item we are feeding data.
         */
        public RidesViewHolder(@NonNull View itemView) {
            super(itemView);

            mCompTimeTextView = itemView.findViewById(R.id.comptime_textview);
            mDateTimeTextView = itemView.findViewById(R.id.datetime_textview);

            mFeedbackTextView = itemView.findViewById(R.id.feedback_textview);
            mBalPerfTextView = itemView.findViewById(R.id.balperf_textview);
            mBalDevTextView = itemView.findViewById(R.id.baldev_textview);
            mRespTimeTextView = itemView.findViewById(R.id.resptime_textview);
        }
    }
}