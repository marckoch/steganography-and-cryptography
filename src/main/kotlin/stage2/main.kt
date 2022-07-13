package stage2

import java.awt.Color
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

fun main() {
    while (true) {
        println("Task (hide, show, exit):")

        when (val input = readLine()!!) {
            "exit" -> {
                println("Bye!")
                return
            }
            "hide" -> hide()
            "show" -> print("Obtaining message from image.")
            else -> println("Wrong task: $input")
        }
    }
}

fun hide() {
    println("Input image file:")
    val inputFile = readLine()!!

    println("Output image file:")
    val outputFile = readLine()!!

    println("Input Image: $inputFile")
    println("Output Image: $outputFile")

    try {
        val image = ImageIO.read(File(inputFile))

        for (x in 0 until image.width) {
            for (y in 0 until image.height) {
                val color = Color(image.getRGB(x, y))

                image.setRGB(x, y, updateColor(color).rgb)
            }
        }

        ImageIO.write(image, "png", File(outputFile))
        println("Image $outputFile is saved.")
    } catch (ex: IOException) {
        println(ex.message)
    }
}

fun updateColor(color: Color): Color {
    // setting least significant bit to 1 means: 'value or 1'
    return Color(color.red or 1, color.green or 1, color.blue or 1)
}