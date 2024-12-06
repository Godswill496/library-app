import java.lang.System.exit

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
         > ==>> """.trimMargin(">"))
    return readln().toInt()
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
    println("You chose Manage Books")

}


fun manageMembers() {
    println("You chose Manage Members")

}


fun borrowBook() {
    println("You chose Borrow a Book")

}


fun returnBook() {
    println("You chose Return a Book")

}


fun listBorrowedBooks() {
    println("You chose List All Borrowed Books")

}


fun listAvailableBooks() {
    println("You chose List Available Books")

}

fun exitApp() {
    println("Exiting...bye")
    kotlin.system.exitProcess(0)
}