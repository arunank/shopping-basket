package shopping

import org.scalatest.funsuite.AnyFunSuite

class BasketTest extends AnyFunSuite {


  test("subtotal calculates correct total") {
    val basket = List("Milk", "Apples", "Soup").flatMap(Basket.items.get)
    val total = Basket.subtotal(basket)
    assert(total == BigDecimal(2.95))
  }

  test("itemCounts returns correct map") {
    val basket = List("Apples", "Apples", "Soup").flatMap(Basket.items.get)
    val counts = Basket.itemCounts(basket)
    assert(counts("Apples") == 2)
    assert(counts("Soup") == 1)
  }

  test("empty basket returns 0 subtotal") {
    val basket = List.empty[Item]
    val total = Basket.subtotal(basket)
    assert(total == 0)
  }

  test("unrecognized item is ignored") {
    val basket = Basket.parseBasket(Seq("Milk", "Toothpaste", "Bread"))
    assert(basket.map(_.name).sorted == List("Bread", "Milk"))
  }

  test("total savings never negative") {
    val savings = Basket.totalSavings(BigDecimal(1.00), BigDecimal(1.50))
    assert(savings == BigDecimal(0.00))
  }

}