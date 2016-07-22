package ru.katkalov.yamblz.hackathon.ui.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Named;

import ru.katkalov.yamblz.hackathon.App;
import ru.katkalov.yamblz.hackathon.R;
import ru.katkalov.yamblz.hackathon.developer_settings.DeveloperSettingsModule;
import ru.katkalov.yamblz.hackathon.ui.fragments.ContentFragment;
import ru.katkalov.yamblz.hackathon.ui.other.ViewModifier;
import ru.yandex.speechkit.SpeechKit;

public class MainActivity extends BaseActivity {

    @Inject @Named(DeveloperSettingsModule.MAIN_ACTIVITY_VIEW_MODIFIER)
    ViewModifier viewModifier;

    @SuppressLint("InflateParams") // It's okay in our case.
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.get(this).applicationComponent().inject(this);

        setContentView(viewModifier.modify(getLayoutInflater().inflate(R.layout.activity_main, null)));
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame_layout, new ContentFragment())
                    .commit();
        }

        SpeechKit.getInstance().configure(getApplicationContext(), getString(R.string.key_ya_speechkit));
    }
}
