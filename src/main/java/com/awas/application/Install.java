package com.awas.application;

import java.nio.file.Files;
import java.nio.file.Path;

public class Install {
  private static final String[] ENV_VARS = { "ANDROID_HOME" };

  public static void main(String args[]) {
    for (String var : ENV_VARS) {
      if (!checkEnv(System.getenv(var))) {
        System.out.println(String.format("variable '%s' doesn't exist !", var));

        return;
      }
    }

    if (Files.notExists(Path.of(System.getenv(ENV_VARS[0]), "cmdline-tools", "latest", "bin", "avdmanager"))) {
      System.out.println("AVD Manager is not installed !");

      return;
    }

    System.out.println("Everything is OK ;]");
  }

  public static boolean checkEnv(String env) {
    if (env == null || env.isBlank() || env.isEmpty()) {
      return false;
    }

    return true;
  }
}
