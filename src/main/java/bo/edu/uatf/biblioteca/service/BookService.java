package bo.edu.uatf.biblioteca.service;

import bo.edu.uatf.biblioteca.dto.BookRequest;
import bo.edu.uatf.biblioteca.dto.BookResponse;
import bo.edu.uatf.biblioteca.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    private long nextId = 1;

    public synchronized BookResponse create(BookRequest request) {
        Book book = new Book();
        book.setId(nextId++);
        apply(book, request);
        books.add(book);
        return BookResponse.from(book);
    }

    public synchronized List<BookResponse> findAll() {
        return books.stream().map(BookResponse::from).toList();
    }

    public synchronized BookResponse findById(Long id) {
        return BookResponse.from(requireBook(id));
    }

    public synchronized BookResponse update(Long id, BookRequest request) {
        Book book = requireBook(id);
        apply(book, request);
        return BookResponse.from(book);
    }

    public synchronized void delete(Long id) {
        books.remove(requireBook(id));
    }

    private Book requireBook(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));
    }

    private void apply(Book book, BookRequest request) {
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setIsbn(request.isbn());
        book.setPublicationYear(request.publicationYear());
        book.setCategory(request.category());
        book.setAvailable(request.available());
    }
}
