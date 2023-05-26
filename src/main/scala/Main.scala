object Main extends App {
  var shopping = true

  while(shopping) {
    println("Please input your items in the command line")
    val a = scala.io.StdIn.readLine()
    val b = a.split(" ").toList
    println(b)
    shopping = false
  }
}