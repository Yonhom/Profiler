package com.xuyonghong.profiler.profilepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.xuyonghong.profiler.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * this fragment represent the view in MVP
 * the view's responsibility is to show the ui element correctly and make presenter to react to event
 */
public class ProfilePageFragment extends Fragment implements ProfilePageContract.View {

    @BindView(R.id.imb_page_logout)
    ImageButton btnLogout;

    @BindView(R.id.imb_page_user_settings)
    ImageButton btnSettings;

    @BindView(R.id.imb_page_thumbnail)
    CircleImageView thumbnail;

    @BindView(R.id.lbl_page_user_name)
    TextView txtName;

    @BindView(R.id.lbl_page_user_email)
    TextView txtEmail;

    @BindView(R.id.pro_profile_page_thumbnail)
    ProgressBar proThumbnail;

    @BindView(R.id.lbl_page_user_bio_sub)
    TextView txtBioSub;

    @BindView(R.id.lbl_page_user_bio)
    TextView txtBio;

    @BindView(R.id.pro_profile_page_bio)
    ProgressBar proBio;

    @BindView(R.id.lbl_page_user_interests_sub)
    TextView txtInterestSub;

    @BindView(R.id.lbl_page_user_interests)
    TextView txtInterest;

    @BindView(R.id.pro_profile_page_interests)
    ProgressBar proInterest;

    @BindView(R.id.fab_edit_profile_details)
    FloatingActionButton fabDetails;


    /**
     * the presenter interface for the fragment view to talk to the actual presenter
     */
    private ProfilePageContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_profile_page, container, false);

        ButterKnife.bind(view);

        // set button click listener
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send present the clog out button click event, let presenter deal with log out
                presenter.onLogoutClick();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAccountSettingsClick();
            }
        });

        fabDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEditProfileClick();
            }
        });



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new ProfilePagePresenter();
    }

    @Override
    public void setPresenter(ProfilePageContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setName(String name) {
        txtName.setText(name);
    }

    @Override
    public void setEmail(String email) {
        txtEmail.setText(email);
    }

    @Override
    public void setBio(String bio) {
        txtBio.setText(bio);
    }

    @Override
    public void setInterests(String interests) {
        txtInterest.setText(interests);
    }

    @Override
    public void setProfilePhotoURL(String profilePhotoURL) {
        Picasso.with(getActivity())
                .load(profilePhotoURL)
                .noFade()
                .fetch(new Callback() {
                    @Override
                    public void onSuccess() {
                        // tell the presenter the thumb image loaded sucessfully

                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    @Override
    public void setDefaultProfilePhoto() {
        Picasso.with(getActivity())
                .load(R.drawable.default_profile_pic)
                .noFade()
                .fetch(new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    @Override
    public void startPhotoGalleryActivity() {

    }

    @Override
    public void startProfileDetailActivity() {

    }

    @Override
    public void startProfileSettingsActivity() {

    }

    @Override
    public void showLogoutSnackbar() {

    }

    @Override
    public void startLoginActivity() {

    }

    @Override
    public void setThumbnailLoadingIndicator(boolean show) {
        if (show)
            proThumbnail.setVisibility(View.VISIBLE);
        proThumbnail.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setDetailLoadingIndicator(boolean show) {
        if (show)
            proBio.setVisibility(View.VISIBLE);
        proBio.setVisibility(View.INVISIBLE);
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
