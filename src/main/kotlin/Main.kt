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
         > |   2) List All Books           |
         > |   3) Borrow a Book             |
         > |   4) Return a Book             |
         > |   5) List All Borrowed Books   |
         > |   6) Manage Members      |
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
            3  -> borrowBook()
            4  -> returnBook()
            5  -> listBorrowedBooks()
            6  -> manageMembers()
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

fun borrowBook() {
    logger.info { "borrowBook() function invoked" }
}

fun returnBook() {
    logger.info { "returnBook() function invoked" }
}

fun listBorrowedBooks() {
    logger.info { "listBorrowedBooks() function invoked" }
}

fun manageMembers() {
    logger.info { "manageMembers() function invoked" }
}

fun exitApp() {
    logger.info { "exitApp() function invoked" }
    println("Exiting...bye")
    kotlin.system.exitProcess(0)
}