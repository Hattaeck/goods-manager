package ru.netology.manager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Java core", 100, "Author1", 200, 2020);
    Product smart1 = new Smartphone(2, "Iphone 13", 1000, "Apple");


    @Test
    public void searchByText() {
        manager.add(book1);
        manager.add(smart1);

        Product[] expected = { smart1 };
        Product[] actual = manager.searchBy("Iphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufacturerWhenNameNotMatch() {
        manager.add(smart1);

        Product[] expected = { smart1 };
        Product[] actual = manager.searchBy("Apple");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBaseProduct() {
        Product baseProduct = new Product(5, "Просто товар", 100);
        manager.add(baseProduct);

        Product[] expected = { baseProduct };
        Product[] actual = manager.searchBy("Просто");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufacture() {

        Product galaxy = new Smartphone(3, "Galaxy", 5000, "Samsung");
        manager.add(galaxy);

        Product[] expected = { galaxy };
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noResultSearchPhone() {
        manager.add(smart1);
        manager.add(book1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("ТоварНеНайден");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWhenMultipleProductsMatch() {
        Book book2 = new Book(3, "Java beginner", 200, "Author2", 200, 2026);
        manager.add(book1);
        manager.add(book2);

        Product[] expected = { book1, book2 };
        Product[] actual = manager.searchBy("Java");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noResultSearch () {
        manager.add(smart1);
        manager.add(book1);

        Product[] expected = {};

        Product[] actual = manager.searchBy("Puma");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void fewResultSearch () {
        manager.add(book1);
        manager.add(book1);

        Product[] expected = {book1, book1};
        Product[] actual = manager.searchBy("Java");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByAuthor() {
        manager.add(book1);

        Product[] expected = { book1 };
        Product[] actual = manager.searchBy("Author1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorWhenNameNotMatch() {
        manager.add(book1);

        Product[] expected = { book1 };
        Product[] actual = manager.searchBy("Author1");

        Assertions.assertArrayEquals(expected, actual);
    }
}