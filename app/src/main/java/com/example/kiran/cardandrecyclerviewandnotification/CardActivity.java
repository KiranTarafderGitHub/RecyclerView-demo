package com.example.kiran.cardandrecyclerviewandnotification;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Kiran on 14-09-2016.
 */
public class CardActivity extends AppCompatActivity implements  RecyclerView.OnItemTouchListener {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapterCard mAdapter;
    public static int  dynamicFlag;
    Context context;
    Timer t;
    TimerTask task;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_card);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);

        dynamicFlag=1;

        //preparing list of movies using prepareMovieData function
        movieList=prepareMovieData(dynamicFlag);

        //creating adapter and passing movie list to it
        mAdapter = new MovieAdapterCard(this,movieList,dynamicFlag);

        //setting up layout manager and animation controller for recycler view
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        //assigning onItemtouch listner to the recycler view
      //  recyclerView.addOnItemTouchListener(this);

        context=this;



        startTimer();

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent event) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent event) {

        Toast.makeText(getApplicationContext()," item clicked ",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent (boolean disallowIntercept){

    }

    public void startTimer(){
        t=new Timer();
        task=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        dynamicFlag++;

                        movieList=prepareMovieData(dynamicFlag);
                        Movie movie1=new Movie();
                        Movie movie2 = new Movie();
                        movie1=movieList.get(0);
                        movie2=movieList.get(2);

                        mAdapter.updateDataAtLocation(movie1,0);
                        mAdapter.updateDataAtLocation(movie2,2);
                        //mAdapter.changeMovieDatas(movieList);

                        if (dynamicFlag==3){
                            dynamicFlag=0;
                        }
                    }
                });
            }
        };
        t.scheduleAtFixedRate(task,10000,5000);
    }


    public Context getCustomContext(){
        return this.context;
    }


    private List<Movie> prepareMovieData(int dynamicFlag) {

       List<Movie> listOfMovies=new ArrayList<>();
        if (dynamicFlag==1) {


            Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", R.drawable.madmax);
            listOfMovies.add(movie);
            movie = new Movie("Inside Out", "Animation, Kids & Family", "2015", R.drawable.insideout);
            listOfMovies.add(movie);
            movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015", R.drawable.starwar);
            listOfMovies.add(movie);
            movie = new Movie("Shaun the Sheep", "Animation", "2015", R.drawable.shaunsheep);
            listOfMovies.add(movie);
            movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015", R.drawable.martian);
            listOfMovies.add(movie);
            movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015", R.drawable.missionimpossible);
            listOfMovies.add(movie);
            movie = new Movie("Up", "Animation", "2009", R.drawable.up);
            listOfMovies.add(movie);
            movie = new Movie("Star Trek", "Science Fiction", "2009", R.drawable.startrek);
            listOfMovies.add(movie);
            movie = new Movie("The LEGO Movie", "Animation", "2014", R.drawable.lego);
            listOfMovies.add(movie);
            movie = new Movie("Iron Man", "Action & Adventure", "2008", R.drawable.ironmam);
            listOfMovies.add(movie);
            movie = new Movie("Aliens", "Science Fiction", "1986", R.drawable.aliens);
            listOfMovies.add(movie);
            movie = new Movie("Chicken Run", "Animation", "2000", R.drawable.chickenrun);
            listOfMovies.add(movie);
            movie = new Movie("Back to the Future", "Science Fiction", "1985", R.drawable.back2future);
            listOfMovies.add(movie);
            movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981", R.drawable.lostark);
            listOfMovies.add(movie);
            movie = new Movie("Goldfinger", "Action & Adventure", "1965", R.drawable.goldfinger);
            listOfMovies.add(movie);
            movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014", R.drawable.guardianofgalaxy);
            listOfMovies.add(movie);
        }else if (dynamicFlag==2){
            Movie movie = new Movie("Mad Max: Fury Road 2 Coming soon", "Action & Adventure", "2015", R.drawable.madmax2);
            listOfMovies.add(movie);
            movie = new Movie("Inside Out", "Animation, Kids & Family", "2015", R.drawable.insideout2);
            listOfMovies.add(movie);
            movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015", R.drawable.starwar2);
            listOfMovies.add(movie);
            movie = new Movie("Shaun the Sheep", "Animation", "2015", R.drawable.shaunsheep2);
            listOfMovies.add(movie);
            movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015", R.drawable.martian2);
            listOfMovies.add(movie);
            movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015", R.drawable.missionimpossible2);
            listOfMovies.add(movie);
            movie = new Movie("Up", "Animation", "2009", R.drawable.up2);
            listOfMovies.add(movie);
            movie = new Movie("Star Trek", "Science Fiction", "2009", R.drawable.startrek2);
            listOfMovies.add(movie);
            movie = new Movie("The LEGO Movie", "Animation", "2014", R.drawable.lego2);
            listOfMovies.add(movie);
            movie = new Movie("Iron Man", "Action & Adventure", "2008", R.drawable.ironmam2);
            listOfMovies.add(movie);
            movie = new Movie("Aliens", "Science Fiction", "1986", R.drawable.aliens2);
            listOfMovies.add(movie);
            movie = new Movie("Chicken Run", "Animation", "2000", R.drawable.chickenrun2);
            listOfMovies.add(movie);
            movie = new Movie("Back to the Future", "Science Fiction", "1985", R.drawable.back2future2);
            listOfMovies.add(movie);
            movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981", R.drawable.lostark2);
            listOfMovies.add(movie);
            movie = new Movie("Goldfinger", "Action & Adventure", "1965", R.drawable.goldfinger2);
            listOfMovies.add(movie);
            movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014", R.drawable.guardianofgalaxy2);
            listOfMovies.add(movie);
        }else {
            Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", R.drawable.madmax3);
            listOfMovies.add(movie);
            movie = new Movie("Inside Out", "Animation, Kids & Family", "2015", R.drawable.insideout3);
            listOfMovies.add(movie);
            movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015", R.drawable.starwar3);
            listOfMovies.add(movie);
            movie = new Movie("Shaun the Sheep", "Animation", "2015", R.drawable.shaunsheep3);
            listOfMovies.add(movie);
            movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015", R.drawable.martian3);
            listOfMovies.add(movie);
            movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015", R.drawable.missionimpossible3);
            listOfMovies.add(movie);
            movie = new Movie("Up", "Animation", "2009", R.drawable.up3);
            listOfMovies.add(movie);
            movie = new Movie("Star Trek", "Science Fiction", "2009", R.drawable.startrek3);
            listOfMovies.add(movie);
            movie = new Movie("The LEGO Movie", "Animation", "2014", R.drawable.lego3);
            listOfMovies.add(movie);
            movie = new Movie("Iron Man", "Action & Adventure", "2008", R.drawable.ironmam3);
            listOfMovies.add(movie);
            movie = new Movie("Aliens", "Science Fiction", "1986", R.drawable.aliens3);
            listOfMovies.add(movie);
            movie = new Movie("Chicken Run", "Animation", "2000", R.drawable.chickenrun3);
            listOfMovies.add(movie);
            movie = new Movie("Back to the Future", "Science Fiction", "1985", R.drawable.back2future3);
            listOfMovies.add(movie);
            movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981", R.drawable.lostark3);
            listOfMovies.add(movie);
            movie = new Movie("Goldfinger", "Action & Adventure", "1965", R.drawable.goldfinger3);
            listOfMovies.add(movie);
            movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014", R.drawable.guardianofgalaxy3);
            listOfMovies.add(movie);
        }

        return listOfMovies;
    }
}
