package com.xuyonghong.profiler.profilepage;

/**
 * Created by xuyonghong on 2017/6/16.
 */

public class ProfilePageContract {

    /**
     * the view interface is implemented in fragment/activity,
     * refered/called in presenter
     */
    interface View {
        void setPresenter(Presenter presenter);
        void setName(String name);
        void setEmail(String email);
        void setBio(String bio);
        void setInterests(String interests);
        void setProfilePhotoURL(String profilePhotoURL);
        void setDefaultProfilePhoto();
        void startPhotoGalleryActivity();
        void startProfileDetailActivity();
        void startProfileSettingsActivity();
        void showLogoutSnackbar();
        void startLoginActivity();
        void setThumbnailLoadingIndicator(boolean show);
        void setDetailLoadingIndicator(boolean show);
        void makeToast(String message);

    }

    /**
     * the presenter is implemented in a concrete presenter,
     * is refered/called in view(actiivty/fragment)
     */
    interface Presenter {
        void subscribe();
        void unsubscribe();
        void onThumbnailClick();
        void onEditProfileClick();
        void onLogoutClick();
        void onAccountSettingsClick();
        void onThumbnailLoaded();
    }
}
