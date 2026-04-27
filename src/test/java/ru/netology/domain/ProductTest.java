package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

  @Test
  public void shouldUseEquals() {
    Product first = new Product(1, "Java I", 1000);
    Product second = new Product(1, "Java I", 1000);
    assertEquals(first, second);
  }

  @Test
  public void shouldGetAndSetFields() {
    Smartphone smart = new Smartphone(1, "Nokia", 1000, "HMD");
    Assertions.assertEquals("HMD", smart.getManufacturer());
  }
}
