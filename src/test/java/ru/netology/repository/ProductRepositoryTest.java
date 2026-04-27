package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
  private ProductRepository repo = new ProductRepository();
  private Product book = new Book(1, "Java", 100, "Author", 500, 2022);
  private Product phone = new Smartphone(2, "iPhone", 1000, "Apple");

  @Test
  public void shouldSaveOneProduct() {
    repo.save(book);

    Product[] expected = { book };
    Product[] actual = repo.findAll();

    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldRemoveExistingProduct() {
    repo.save(book);
    repo.save(phone);

    repo.removeById(1);

    Product[] expected = { phone };
    Product[] actual = repo.findAll();

    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldFindAllInEmptyRepository() {
    Product[] expected = {};
    Product[] actual = repo.findAll();

    Assertions.assertArrayEquals(expected, actual);
  }
}