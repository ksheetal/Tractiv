package com.example.tractiv;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class MainHomeScreenFragment extends Fragment {


    public ImageView likeButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_home_screen,container,false);

        likeButton = rootView.findViewById(R.id.imageView7);

        // Once User click on like button imange has to changed but its not working in here.

       /* likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(likeButton.getDrawable().equals(getResources().getDrawable(
                        R.drawable.ic_favorite_border_black_24dp))) {
                    Toast.makeText(getActivity(),"Hello world",Toast.LENGTH_SHORT);
                }else{
                    //likeButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Toast.makeText(getActivity(),"bye world",Toast.LENGTH_SHORT);
                }
            }
        });
*/

        return rootView;
    }
}
