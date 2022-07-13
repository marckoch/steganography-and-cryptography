package stage1

fun main() {
    while (true) {
        println("Task (hide, show, exit):")

        when (val input = readLine()!!) {
            "exit" -> {
                println("Bye!")
                return
            }
            "hide" -> println("Hiding message in image.")
            "show" -> print("Obtaining message from image.")
            else -> println("Wrong task: $input")
        }
    }
}