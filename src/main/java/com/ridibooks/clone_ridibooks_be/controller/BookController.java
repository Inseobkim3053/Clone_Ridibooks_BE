package com.ridibooks.clone_ridibooks_be.controller;

import com.ridibooks.clone_ridibooks_be.model.Book;
import com.ridibooks.clone_ridibooks_be.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1. Book_책api"}) // Swagger # 1. Book
@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @ApiOperation(value = "카테고리별 책 pageable조회", notes = "카테고리별 책을 page로 조회합니다.")
    @GetMapping("/book/{category}")
    public Page<Book> getBookCategoryPage(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                          @RequestParam(value = "size", required = false, defaultValue = "24") int size,
                                          @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
                                          @RequestParam(value = "isAsc", required = false, defaultValue = "false") boolean isAsc,
                                          @PathVariable Long category) {
        page = page - 1;
        return bookService.getBooks(category, page, size, sortBy, isAsc);
    }
}