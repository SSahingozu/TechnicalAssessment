object Main extends App {
  var shopping = true

  val itemPrices: Map[String, Double] = Map(
    "soup" -> 0.65,
    "bread" -> 0.80,
    "milk" -> 1.30,
    "apples" -> 1.00
  )

  val specialOffers: Map[String, (String, Int, Double)] = Map(
    "Apples" -> ("Apples", 1, 0.10),
    "Soup" -> ("Bread", 2, 0.50)
  )

  def calculateSubtotal(items: List[String]): Double = {
    items.flatMap(itemPrices.get).sum
  }



  def oneShopping  = {
//    var appleCount = 0
//    var soupCount = 0
//    var milkCount = 0
//    var breadCount = 0
    while (shopping) {
      println("Please input your items in the command line first input should be PriceBasket")
      val shoppingItems = scala.io.StdIn.readLine().toLowerCase()
      val shoppingList = shoppingItems.split(" ").toList
//      shoppingList.foreach { x =>
//        x match
//        {
//          case "apples" => appleCount += 1
//          case "soup" => soupCount += 1
//          case "milk" => milkCount += 1
//          case "bread" => breadCount += 1
//          case _ => None
//        }
//      }
      val subtotal = calculateSubtotal(shoppingList)
      val
      shopping = false
    }
  }



  oneShopping

}