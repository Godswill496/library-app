package controllers

import Library
import java.awt.print.Book




class LibraryAPI {
    private val books = ArrayList<Book>()

    fun add(book: Library): Boolean {
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



    fun updateBook(index: Int, updatedBook: Book, function: () -> Unit): Boolean {
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

    fun numberOfBooks() {

    }

    fun isValidIndex(indexToUpdate: Int): Boolean {
        TODO("Not yet implemented")
    }

    fun updateBook(index: Int, updatedBook: Book): Boolean {
        TODO("Not yet implemented")
    }
}
fun updateBook(indexToUpdate: Int, book: Book?): Boolean {
    // Find the book object by the index number
    val foundBook = findBook(indexToUpdate)

    // If the book exists, use the book details passed as parameters to update the found book in the ArrayList
    if ((foundBook != null) && (book != null)) {
        foundBook.title = book.title
        foundBook.author = book.author
        foundBook.genre = book.genre
        return true
    }

    // If the book was not found, return false, indicating that the update was not successful
    return false
}

fun findBook(indexToUpdate: Int): Any {
    TODO("Not yet implemented")
}
private var Any.genre: Any
    get() = Unit
    set(value) {}
private var Any.title: Any
    get() = Unit
    set(value) {}
private var Any.author: Any
    get() = Unit
    set(value) {}

data class Book(
    var booktitle: String,
    var author: String,
    var genre: String,
    var isArchived: Boolean
)





