package ru.katkalov.yamblz.hackathon;

import android.app.Application;
import android.support.annotation.NonNull;

import ru.katkalov.yamblz.hackathon.App;
import ru.katkalov.yamblz.hackathon.developer_settings.DevMetricsProxy;
import ru.katkalov.yamblz.hackathon.developer_settings.DeveloperSettingsModule;
import ru.katkalov.yamblz.hackathon.DaggerApplicationComponent;

public class UnitTestApp extends App {

    @NonNull
    @Override
    protected DaggerApplicationComponent.Builder prepareApplicationComponent() {
        return super.prepareApplicationComponent()
                .developerSettingsModule(new DeveloperSettingsModule() {
                    @NonNull
                    public DevMetricsProxy provideDevMetricsProxy(@NonNull Application application) {
                        return () -> {
                            //No Op
                        };
                    }
                });
    }
}
