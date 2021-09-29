package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repositiry.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product first = new Book(1, "hamlet", 1, "shakespeare");
    private Product second = new Book(2, "harry potter", 1, "joan rowling");
    private Product third = new Book(3, "idiot", 1, "dostoevsky");
    private Product fourth = new Smartphone(4, "S10", 1, "samsung");
    private Product fifth = new Smartphone(5, "3310", 1, "nokia");
    private Product sixth = new Smartphone(6, "s20", 1, "samsung");
    private Product seventh = new Book(7, "instruction", 1, "samsung");
    private Product eighth = new Smartphone(8, "a90", 1, "samsung");

    @Test
    void removeById() {
        manager.save(eighth);
        manager.save(sixth);
        manager.save(fourth);
        manager.removeById(6);
        Product[] expected = {new Smartphone(4, "S10", 1, "samsung"),
                new Smartphone(8, "a90", 1, "samsung")};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeNoExistent() {
        manager.save(eighth);
        manager.save(sixth);
        manager.save(fourth);
        manager.removeById(1);
        Product[] expected = {new Smartphone(4, "S10", 1, "samsung"),
                new Smartphone(8, "a90", 1, "samsung")};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
