package com.manacode.feedthechick.ui.main.settings;

import com.manacode.feedthechick.audio.AudioController;
import com.manacode.feedthechick.data.settings.SettingsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<SettingsRepository> repoProvider;

  private final Provider<AudioController> audioProvider;

  public SettingsViewModel_Factory(Provider<SettingsRepository> repoProvider,
      Provider<AudioController> audioProvider) {
    this.repoProvider = repoProvider;
    this.audioProvider = audioProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(repoProvider.get(), audioProvider.get());
  }

  public static SettingsViewModel_Factory create(Provider<SettingsRepository> repoProvider,
      Provider<AudioController> audioProvider) {
    return new SettingsViewModel_Factory(repoProvider, audioProvider);
  }

  public static SettingsViewModel newInstance(SettingsRepository repo, AudioController audio) {
    return new SettingsViewModel(repo, audio);
  }
}
