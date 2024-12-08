import controllers.LibraryAPI
import io.github.oshai.kotlinlogging.KotlinLogging
import utils.readNextInt
import utils.readNextLine
import java.awt.print.Book


private val logger = KotlinLogging.logger {}
private val libraryAPI = LibraryAPI()

fun main() {
    runMenu()
}

fun mainMenu(): Int {
    print(""" 
         > ----------------------------------
         > |     LIBRARY MANAGEMENT APP     |
         > ----------------------------------
         > | MAIN MENU                      |
         > |   1) Add Books 
         > |   2) List All Books            |
         > |   3) Update a Book             |
         > |   4) Return a Book             |
         > |   5) List All Borrowed Books   |
         > |   6) Delete Books              |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
          >""".trimMargin(">"))
    return readNextInt(" > ==>>")
}

fun runMenu() {
    do {
        when (val option = mainMenu()) {
            1  -> addBook()
            2  -> listAllBooks()
            3  -> updateBook()
            4  -> returnBook()
            5  -> listBorrowedBooks()
            6  -> deleteBook()
            0  -> exitApp()
            else -> {
                println("Invalid option entered: ${option}")
            }
        }
    } while (true)
}


fun addBook() {
    val bookTitle = readNextLine("Enter the title of the book: ")
    val bookAuthor = readNextLine("Enter the author of the book: ")
    val bookGenre = readNextLine("Enter the genre of the book: ")
    val isAdded = libraryAPI.add(Library(bookTitle, bookAuthor, bookGenre))

    if (isAdded) {
        println("Book added successfully!")
    } else {
        println("Failed to add the book.")
    }
}

class Library(bookTitle: String, bookAuthor: String, bookGenre: String) : Book() {

}

fun listAllBooks() {
    println(libraryAPI.listAllBooks())
}

fun updateBook() {
    listAllBooks()
    if (libraryAPI.numberOfBooks() > 0) {
        // Ask for the index of the book to update
        val indexToUpdate = readNextInt("Enter the index of the book to update: ")
        if (libraryAPI.isValidIndex(indexToUpdate)) {
            // Ask for new details for the book
            val bookTitle = readNextLine("Enter the new title of the book: ")
            val bookAuthor = readNextLine("Enter the new author of the book: ")
            val bookGenre = readNextLine("Enter the new genre of the book: ")

            // Pass the updated book details to the libraryAPI
            val isUpdated = libraryAPI.updateBook(indexToUpdate, Library(bookTitle, bookAuthor, bookGenre))
            if (isUpdated) {
                println("Book updated successfully!")
            } else {
                println("Failed to update the book.")
            }
        } else {
            println("Invalid index. Please try again.")
        }
    } else {
        println("No books available to update.")
    }
}


fun returnBook() {
    logger.info { "returnBook() function invoked" }
}

fun listBorrowedBooks() {
    logger.info { "listBorrowedBooks() function invoked" }
}

fun deleteBook(){
    //logger.info { "deleteNotes() function invoked" }
    listAllBooks()
    if (libraryAPI.numberOfBooks() > 0) {
        //only ask the user to choose the note to delete if notes exist
        val indexToDelete = readNextInt("Enter the index of the note to delete: ")
        //pass the index of the note to NoteAPI for deleting and check for success.
        val bookToDelete = libraryAPI.deleteBook(indexToDelete)
        if (bookToDelete != null) {
            println("Delete Successful! Deleted book: ${bookToDelete.bookTitle}")
        } else {
            println("Delete NOT Successful")
        }
    }
}

private operator fun Unit.compareTo(i: Int): Int {
    return TODO("Provide the return value")
}
private val Boolean.bookTitle: String
    get() = Unit.toString()


fun exitApp() {
    logger.info { "exitApp() function invoked" }
    println("Exiting...bye")
    kotlin.system.exitProcess(0)
}