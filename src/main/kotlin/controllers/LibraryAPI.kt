package controllers

import java.awt.print.Book


class LibraryAPI {
    private val books = ArrayList<Book>()

    fun add(book: Book): Boolean {
        return books.add(book)
    }

    // List all books
    fun listAllBooks(): String {
        return if (books.isEmpty()) {
            "No books available"
        } else {
            var listOfBooks = ""
            for (i in books.indices) {
                listOfBooks += "${i}: ${books[i]} \n"
            }
            listOfBooks
        }
    }



    fun updateBook(index: Int, updatedBook: Book): Boolean {
        return if (index in books.indices) {
            books[index] = updatedBook
            true
        } else {
            false
        }
    }


    fun deleteBook(index: Int): Boolean {
        return if (index in books.indices) {
            books.removeAt(index)
            true
        } else {
            false
        }
    }
}


