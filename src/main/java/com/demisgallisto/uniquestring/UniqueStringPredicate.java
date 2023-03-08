package com.demisgallisto.uniquestring;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public class UniqueStringPredicate implements Predicate<String> {

  @Override
  public boolean test(String stringToValidate) {

    requireNonNull(stringToValidate, () -> "the string to validate must be not null");
    return switch (stringToValidate.length()) {
      case 0, 1 -> true;
      default -> stringDistinctCharsHasTheSameLengthOfStringToValidate(stringToValidate);
    };
  }

  private boolean stringDistinctCharsHasTheSameLengthOfStringToValidate(String stringToValidate) {
    return distinctChars(stringToValidate).length == stringToValidate.length();
  }

  private int[] distinctChars(String stringToValidate) {
    return stringToValidate.chars()
                           .distinct()
                           .toArray();
  }
}
