package com.jrsosadev.greeter;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class GreetFragment extends Fragment {

    public static final String ARG_GREET = "arg.greet";

    public GreetFragment() {
        // Required empty public constructor
    }

    public static GreetFragment instance(Greet greet) {
        greet.validate();
        Bundle args = new Bundle();
        args.putParcelable(ARG_GREET, greet);

        GreetFragment fragment = new GreetFragment();
        fragment.setArguments(args);
        return fragment;
    }


    Greet greet;

    TextView title, subtitle;
    ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        greet = getArguments().getParcelable(ARG_GREET);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_greet, container, false);
        title = v.findViewById(R.id.greet_title_textview);
        subtitle = v.findViewById(R.id.greet_subtitle_textview);
        imageView = v.findViewById(R.id.greet_imageview);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title.setText(greet.getTitle());
        subtitle.setText(greet.getSubtitle());

        Picasso.get()
                .load(Uri.decode(greet.getImgUrl()))
                .error(android.R.color.black)
                .fit()
                .centerCrop()
                .placeholder(R.color.gray_300)
                .into(imageView);

    }
}
