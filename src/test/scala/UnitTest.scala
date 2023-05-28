import Main.itemPrices
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UnitTest extends AnyFlatSpec with Matchers {

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

  "calculateSubtotal" should "return the correct subtotal" in {
    val items = List("soup", "bread", "milk")
    val subtotal = calculateSubtotal(items)
    subtotal should be(2.75)
  }

  "calculateApplesDiscount" should "return the correct discount for apples" in {
    val items = List("apples", "apples", "soup", "bread")
    val discount = calculateApplesDiscount(items)
    discount should be(0.10)
  }

  "calculateBreadDiscount" should "return the correct discount for bread" in {
    val items = List("soup", "soup", "bread")
    val discount = calculateBreadDiscount(items)
    discount should be(0.40)
  }
}
