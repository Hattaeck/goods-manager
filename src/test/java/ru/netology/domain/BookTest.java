package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

  @Test
  public void shouldCastFromBaseClass() {
    Product product = new Book();
    if (product instanceof Book) {
      Book book = (Book) product;
    }
  }

  @Test
  public void shouldUseOverridedMethod() {
    Product product = new Book();
    product.toString();
  }

  @Test
  public void shouldGetAndSetFields() {
    Smartphone smart = new Smartphone(1, "Nokia", 1000, "HMD");
    Assertions.assertEquals("HMD", smart.getManufacturer());
  }
}
