package com.example.ManyToMany;

import com.example.ManyToMany.model.Category;
import com.example.ManyToMany.model.Product;
import com.example.ManyToMany.repository.CategoryRepository;
import com.example.ManyToMany.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   // @Override
    @Transactional
    public void run(String... strings){
        // save a couple of books

        Category categoryA = new Category("Category A1");
        Category categoryB = new Category("Category B1");
        Category categoryC = new Category("Category C1");

        Set<Category> sc = new HashSet<Category>();
        sc.add(categoryA);
        sc.add(categoryB);

       // productRepository.save(new HashSet<Product>())
        Product A = new Product("Product A", "description A", sc);

        productRepository.save(A);

        /*productRepository.saveAll(new HashSet<Product>(){{
            add(new Product("Product A", "description A", new HashSet<Category>(){{
                add(categoryA);
                add(categoryB);
            }}));

            add(new Product("Product B", "description B", new HashSet<Category>(){{
                add(categoryA);
                add(categoryC);
            }}));
        }});*/

        // fetch all books
        for(Product product : productRepository.findAll()) {
            logger.info(product.toString());
        }

        // save a couple of publishers
        Product productA = new Product("Product A1", "description A1");
        Product productB = new Product("Product B1", "description B1");

        categoryRepository.save(/*new HashSet<Category>() {{
            add(*/new Category("Category D1", new HashSet<Product>() {{
                add(productA);
                add(productB);
            }}));

            /*add(new Category("Category B", new HashSet<Product>() {{
                add(productA);
                add(productB);
            }}));*/
       // }});

        // fetch all publishers
        for(Category publisher : categoryRepository.findAll()) {
            logger.info(publisher.toString());
        }
    }
}
