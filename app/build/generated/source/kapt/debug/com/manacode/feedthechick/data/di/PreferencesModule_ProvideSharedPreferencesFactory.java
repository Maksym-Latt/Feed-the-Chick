package com.manacode.feedthechick.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class PreferencesModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
  private final Provider<Context> contextProvider;

  public PreferencesModule_ProvideSharedPreferencesFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreferences(contextProvider.get());
  }

  public static PreferencesModule_ProvideSharedPreferencesFactory create(
      Provider<Context> contextProvider) {
    return new PreferencesModule_ProvideSharedPreferencesFactory(contextProvider);
  }

  public static SharedPreferences provideSharedPreferences(Context context) {
    return Preconditions.checkNotNullFromProvides(PreferencesModule.INSTANCE.provideSharedPreferences(context));
  }
}
