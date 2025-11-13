package com.manacode.feedthechick.data.settings;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class SettingsRepositoryImpl_Factory implements Factory<SettingsRepositoryImpl> {
  private final Provider<SharedPreferences> prefsProvider;

  public SettingsRepositoryImpl_Factory(Provider<SharedPreferences> prefsProvider) {
    this.prefsProvider = prefsProvider;
  }

  @Override
  public SettingsRepositoryImpl get() {
    return newInstance(prefsProvider.get());
  }

  public static SettingsRepositoryImpl_Factory create(Provider<SharedPreferences> prefsProvider) {
    return new SettingsRepositoryImpl_Factory(prefsProvider);
  }

  public static SettingsRepositoryImpl newInstance(SharedPreferences prefs) {
    return new SettingsRepositoryImpl(prefs);
  }
}
