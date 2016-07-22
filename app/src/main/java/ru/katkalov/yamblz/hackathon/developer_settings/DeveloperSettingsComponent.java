package ru.katkalov.yamblz.hackathon.developer_settings;

import android.support.annotation.NonNull;

import ru.katkalov.yamblz.hackathon.ui.fragments.DeveloperSettingsFragment;

import dagger.Subcomponent;

@Subcomponent
public interface DeveloperSettingsComponent {
    void inject(@NonNull DeveloperSettingsFragment developerSettingsFragment);
}
