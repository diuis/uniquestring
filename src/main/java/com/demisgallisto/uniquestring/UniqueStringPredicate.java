package com.demisgallisto.uniquestring;

import java.util.function.Predicate;

public class UniqueStringPredicate implements Predicate<String> {
  @Override
  public boolean test(String stringToValidate) {
    return false;
  }
}
