package shopping

import org.scalatest.funsuite.AnyFunSuite

class DiscountTest extends AnyFunSuite {

  test("10% discount on apples") {
    val basket = List.fill(3)(Basket.items("Apples"))
    val (_, discount) = Discount.applyDiscounts(basket)
    assert(discount == BigDecimal("0.30"))
  }

  test("Buy 2 soups get 1 bread half price") {
    val basket = List("Soup", "Soup", "Bread").flatMap(Basket.items.get)
    val (_, discount) = Discount.applyDiscounts(basket)
    assert(discount == BigDecimal("0.40"))
  }

  test("Buy 4 soups and 1 bread = 1 discount only") {
    val basket = List("Soup", "Soup", "Soup", "Soup", "Bread").flatMap(Basket.items.get)
    val (_, discount) = Discount.applyDiscounts(basket)
    assert(discount == BigDecimal("0.40"))
  }

  test("Buy 4 soups and 2 breads = 2 discounts") {
    val basket = List("Soup", "Soup", "Soup", "Soup", "Bread", "Bread").flatMap(Basket.items.get)
    val (_, discount) = Discount.applyDiscounts(basket)
    assert(discount == BigDecimal("0.80"))
  }

  test("no discounts if no qualifying items") {
    val basket = List("Milk").flatMap(Basket.items.get)
    val (messages, discount) = Discount.applyDiscounts(basket)
    assert(messages.isEmpty)
    assert(discount == 0)
  }
}
