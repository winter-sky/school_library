package mainpackage.service;

import mainpackage.dao.BooksDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BooksServiceImpl implements BooksService {
    private BooksDAO booksDAO;

    public void setBooksDAO(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @Override
    @Transactional
    public boolean checkContainsOrNot(int bookId){return this.booksDAO.checkContainsOrNot(bookId);}
}
