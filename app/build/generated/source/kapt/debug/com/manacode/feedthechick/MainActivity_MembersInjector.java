package com.manacode.feedthechick;

import com.manacode.feedthechick.audio.AudioController;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<AudioController> audioProvider;

  public MainActivity_MembersInjector(Provider<AudioController> audioProvider) {
    this.audioProvider = audioProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<AudioController> audioProvider) {
    return new MainActivity_MembersInjector(audioProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectAudio(instance, audioProvider.get());
  }

  @InjectedFieldSignature("com.manacode.feedthechick.MainActivity.audio")
  public static void injectAudio(MainActivity instance, AudioController audio) {
    instance.audio = audio;
  }
}
