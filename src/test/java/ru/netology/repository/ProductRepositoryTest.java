package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book();

  @Test
  public void saveOneItem() {
    repository.save(coreJava);

    Product[] expected = new Product[]{coreJava};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void removeById() {
    ProductRepository repo = new ProductRepository();


    Product book1 = new Book(1, "Java core", 100, "Author1", 200, 2020);
    Product smart1 = new Smartphone(2, "Iphone 13", 1000, "Apple");

    repo.save(book1);
    repo.save(smart1);

    repo.removeById(1);

    Product[] expected = { smart1 };
    Product[] actual = repo.findAll();

    Assertions.assertArrayEquals(expected, actual);
  }



}
