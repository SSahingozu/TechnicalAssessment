object Main extends App {
  var shopping = true

  val itemPrices: Map[String, Double] = Map(
    "soup" -> 0.65,
    "bread" -> 0.80,
    "milk" -> 1.30,
    "apples" -> 1.00
  )
  def calculateSubtotal(items: List[String]): Double = {
    items.flatMap(itemPrices.get).sum
  }

  def calculateApplesDiscount(items: List[String]): Double = {
    val appleCount = items.count(_ == "apples")
    val discountIteration = appleCount / 2 * itemPrices("apples") * 0.1
    discountIteration
  }

  def calculateBreadDiscount(items: List[String]): Double = {
    val soupCount = items.count(_ == "soup")
    val breadCount = items.count(_ == "bread")
    val discountIteration = (soupCount / 2) * (breadCount min 1) * (itemPrices("bread") / 2)
    discountIteration
  }
//  def calculateApplesDiscount(items: List[String]) = {
//    var appleCount = 0
//    var appleDiscount = 0.0
//
//    items.foreach { x =>
//              x match
//              {
//                case "apples" => appleCount += 1
//                case _ => None
//              }
//            }
//    while (appleCount >= 2) {
//      val discountIteration = itemPrices("apples") * 0.1
//      appleDiscount += discountIteration
//      appleCount -= 2
//    }
//    if (appleDiscount == 0) 0
//    else (appleDiscount)
//  }
//
//  def calculateBreadDiscount(items: List[String]) = {
//    var breadCount = 0
//    var soupCount = 0
//    var breadDiscount = 0.0
//
//    items.foreach { x =>
//      x match {
//        case "bread" => breadCount += 1
//        case "soup" => soupCount += 1
//        case _ => None
//      }
//    }
//    while (soupCount >= 2 & breadCount >= 1){
//      val discountIteration = itemPrices("bread") * 0.5
//      breadDiscount += discountIteration
//      soupCount -= 2
//      breadCount -= 1
//    }
//    if (breadDiscount == 0) 0
//    else (breadDiscount)
//  }
  def Shopping  = {
    while (shopping) {
      println("Please input your items in the command line first input should be PriceBasket")
      val shoppingItems = scala.io.StdIn.readLine().toLowerCase()
      val shoppingList = shoppingItems.split(" ").toList
      val subtotal = calculateSubtotal(shoppingList)
      val applesDiscount = (calculateApplesDiscount(shoppingList).toString.toDouble)
      val breadDiscount = (calculateBreadDiscount(shoppingList).toString.toDouble)
      val finalPrice = subtotal - applesDiscount - breadDiscount

      println(s"Subtotal: £" + f"$subtotal%.2f")

      if (applesDiscount == 0) println("No Apples Discount applied")
      else println(s"Apples 10% discount applied: £" + f"$applesDiscount%.2f")

      if (breadDiscount == 0) println("No Bread Discount applied")
      else println(s"50% off a loaf of bread due to buying 2 cans of soup: £" + f"$breadDiscount%.2f")

      println(s"Total Price: £" + f"$finalPrice%.2f")
      shopping = false
    }
  }

  Shopping
}