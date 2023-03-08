package com.demisgallisto.uniquestring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueStringPredicateTest {

  private UniqueStringPredicate sut;

  @BeforeEach
  void setUp() {
    sut = new UniqueStringPredicate();
  }

  @Test
  void theStringIsUnique() {

    // given
    var stringToValidate = "xioez5unlc";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isTrue();
  }

  @Test
  void theStringIsNotUnique() {

    // given
    var stringToValidate = "xioeu5unle";

    // when
    var result = sut.test(stringToValidate);

    // then
    assertThat(result).isFalse();
  }
}
