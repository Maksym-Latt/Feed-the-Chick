package com.manacode.feedthechick.audio;

import android.content.Context;
import com.manacode.feedthechick.data.settings.SettingsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DefaultAudioController_Factory implements Factory<DefaultAudioController> {
  private final Provider<Context> contextProvider;

  private final Provider<SettingsRepository> settingsRepositoryProvider;

  public DefaultAudioController_Factory(Provider<Context> contextProvider,
      Provider<SettingsRepository> settingsRepositoryProvider) {
    this.contextProvider = contextProvider;
    this.settingsRepositoryProvider = settingsRepositoryProvider;
  }

  @Override
  public DefaultAudioController get() {
    return newInstance(contextProvider.get(), settingsRepositoryProvider.get());
  }

  public static DefaultAudioController_Factory create(Provider<Context> contextProvider,
      Provider<SettingsRepository> settingsRepositoryProvider) {
    return new DefaultAudioController_Factory(contextProvider, settingsRepositoryProvider);
  }

  public static DefaultAudioController newInstance(Context context,
      SettingsRepository settingsRepository) {
    return new DefaultAudioController(context, settingsRepository);
  }
}
