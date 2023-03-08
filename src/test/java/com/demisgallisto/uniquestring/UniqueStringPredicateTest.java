package com.demisgallisto.uniquestring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class UniqueStringPredicateTest {

  private UniqueStringPredicate sut;

  @BeforeEach
  void setUp() {
    sut = new UniqueStringPredicate();
  }

  @Test
  void whenTheStringIsNullThrowsNPE() {

    assertThatNullPointerException().isThrownBy(() -> sut.test(null));
  }

  @Test
  void whenTheAsciiStringIsEmptyReturnsTrue() {

    // given
    var stringToValidate = "";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isTrue();
  }

  @Test
  void whenTheAsciiStringHasLengthEqualsToOneReturnsTrue() {

    // given
    var stringToValidate = "a";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isTrue();
  }

  @Test
  void whenTheAsciiStringIsUniqueReturnsTrue() {

    // given
    var stringToValidate = "xioez5unlc";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isTrue();
  }

  @Test
  void whenTheAsciiStringIsNotUniqueReturnsFalse() {

    // given
    var stringToValidate = "xioeu5unle";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isFalse();
  }

  @Test
  void whenTheAsciiStringIsBlankAndTheLengthIsOneReturnsTrue() {

    // given
    var stringToValidate = " ";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isTrue();
  }

  @Test
  void whenTheAsciiStringIsBlankAndTheLengthIsGreaterThanOneReturnsTrue() {

    // given
    var stringToValidate = "  ";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isFalse();
  }

  @Test
  void whenTheUnicodeStringIsUniqueReturnsTrue() {

    // given
    var stringToValidate = "\uD801\uDC00";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isTrue();
  }

  @Test
  void whenTheUnicodeStringIsNotUniqueReturnsFalse() {

    // given
    var stringToValidate = "\uD801\uDC00\uD801";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isFalse();
  }
}
