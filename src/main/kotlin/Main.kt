import java.lang.System.exit

fun main() {
    runMenu()
}

fun mainMenu(): Int {
    println("")
    println("--------------------")
    println("LIBRARY MANAGEMENT APP")
    println("--------------------")
    println("MAIN MENU")
    println("  1) Manage Books")
    println("  2) Manage Members")
    println("  3) Borrow a Book")
    println("  4) Return a Book")
    println("  5) List All Borrowed Books")
    println("  6) List Available Books")
    println("--------------------")
    println("  0) Exit")
    println("--------------------")
    print("==>> ")
    return readlnOrNull()?.toIntOrNull() ?: -1
}

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1  -> manageBooks()
            2  -> manageMembers()
            3  -> borrowBook()
            4  -> returnBook()
            5  -> listBorrowedBooks()
            6  -> listAvailableBooks()
            0  -> exitApp()
            else -> println("Invalid option entered: $option")
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