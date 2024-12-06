import io.github.oshai.kotlinlogging.KotlinLogging
import utils.readNextInt
private val logger = KotlinLogging.logger {}

fun main() {
    runMenu()
}

fun mainMenu(): Int {
    print(""" 
         > ----------------------------------
         > |     LIBRARY MANAGEMENT APP     |
         > ----------------------------------
         > | MAIN MENU                      |
         > |   1) Manage Books              |
         > |   2) Manage Members            |
         > |   3) Borrow a Book             |
         > |   4) Return a Book             |
         > |   5) List All Borrowed Books   |
         > |   6) List Available Books      |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
          >""".trimMargin(">"))
    return readNextInt(" > ==>>")
}

fun runMenu() {
    do {
        when (val option = mainMenu()) {
            1  -> manageBooks()
            2  -> manageMembers()
            3  -> borrowBook()
            4  -> returnBook()
            5  -> listBorrowedBooks()
            6  -> listAvailableBooks()
            0  -> exitApp()
            else -> {
                println("Invalid option entered: ${option}")
            }
        }
    } while (true)
}


fun manageBooks() {
    logger.info { "manageBooks() function invoked" }
}

fun manageMembers() {
    logger.info { "manageMembers() function invoked" }
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

fun listAvailableBooks() {
    logger.info { "listAvailableBooks() function invoked" }
}

fun exitApp() {
    logger.info { "exitApp() function invoked" }
    println("Exiting...bye")
    kotlin.system.exitProcess(0)
}