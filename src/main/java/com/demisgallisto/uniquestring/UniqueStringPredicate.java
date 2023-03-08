package com.demisgallisto.uniquestring;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public class UniqueStringPredicate implements Predicate<String> {
  @Override
  public boolean test(String stringToValidate) {

    requireNonNull(stringToValidate, () -> "the string to validate must be not null");
    if (stringToValidate.isEmpty()) {
      return true;
    }
    if (stringToValidate.length() == 1) {
      return true;
    }
    var distinctChars = stringToValidate.chars().distinct().toArray();
    var isUnique = distinctChars.length == stringToValidate.length();
    return isUnique;
  }
}
