package com.example.kiran.cardandrecyclerviewandnotification;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.List;

/**
 * Created by Kiran on 15-09-2016.
 */
public class MyItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    private MoviesAdapter moviesAdapter;
    private MovieAdapterCard movieAdapterCard;
    public static int from,to;

    public MyItemTouchHelper(MoviesAdapter moviesAdapter){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.ACTION_STATE_DRAG);
        this.moviesAdapter = moviesAdapter;
    }
    public MyItemTouchHelper(MovieAdapterCard movieAdapterCard){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.ACTION_STATE_DRAG);
        this.movieAdapterCard=movieAdapterCard;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //TODO: Not implemented here
        moviesAdapter.swap(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }



    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //Remove item
        moviesAdapter.remove(viewHolder.getAdapterPosition());
    }
    @Override
    public boolean canDropOver (RecyclerView recyclerView,
                         RecyclerView.ViewHolder current,
                         RecyclerView.ViewHolder target){


        return true;
    }


}
