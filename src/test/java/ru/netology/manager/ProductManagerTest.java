package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    private Product firstBook = new Book(1, "Java Beginner", 500, "Author 1", 100, 2024);
    private Product secondBook = new Book(2, "Advanced Java", 700, "Author 2", 200, 2025);
    private Product smartphone = new Smartphone(3, "iPhone 15", 100000, "Apple");

    @BeforeEach
    public void setup() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(smartphone);
    }

    @Test
    public void shouldSearchWhenMultipleProductsFound() {
        Product[] expected = { firstBook, secondBook };
        Product[] actual = manager.searchBy("Java");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenOneProductFound() {
        Product[] expected = { smartphone };
        Product[] actual = manager.searchBy("iPhone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenZeroProductsFound() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Microsoft");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookAuthor() {
        Product[] expected = { firstBook };
        Product[] actual = manager.searchBy("Author 1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEmptyManager() {
        ProductRepository emptyRepo = new ProductRepository();
        ProductManager emptyManager = new ProductManager(emptyRepo);

        Product[] expected = {};
        Product[] actual = emptyManager.searchBy("Java");

        Assertions.assertArrayEquals(expected, actual);
    }
}