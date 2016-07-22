package ru.katkalov.yamblz.hackathon;

import android.os.Handler;
import android.support.annotation.NonNull;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import ru.katkalov.yamblz.hackathon.developer_settings.DevMetricsProxy;
import ru.katkalov.yamblz.hackathon.developer_settings.DeveloperSettingsComponent;
import ru.katkalov.yamblz.hackathon.developer_settings.DeveloperSettingsModule;
import ru.katkalov.yamblz.hackathon.developer_settings.LeakCanaryProxy;
import ru.katkalov.yamblz.hackathon.ui.activities.MainActivity;
import ru.katkalov.yamblz.hackathon.developer_settings.DeveloperSettingsModel;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        DeveloperSettingsModule.class,
})
public interface ApplicationComponent {

    // Provide LeakCanary without injection to leave.
    @NonNull
    LeakCanaryProxy leakCanaryProxy();

    @NonNull
    DeveloperSettingsComponent plusDeveloperSettingsComponent();

    DeveloperSettingsModel developerSettingModel();

    DevMetricsProxy devMetricsProxy();

    @NonNull @Named(ApplicationModule.MAIN_THREAD_HANDLER)
    Handler mainThreadHandler();

    void inject(@NonNull MainActivity mainActivity);
}
