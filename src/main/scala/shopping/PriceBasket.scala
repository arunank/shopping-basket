package shopping

object PriceBasket {
  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Usage: PriceBasket item1 item2 ...")
      return
    }

    val basket = Basket.parseBasket(args)
    val subtotal = Basket.subtotal(basket).setScale(2)
    val (discountMessages, totalDiscount) = Discount.applyDiscounts(basket)
    val totalPrice = (subtotal - totalDiscount).setScale(2)

    println("-------------")
    println(f"Subtotal: £$subtotal")
    if (discountMessages.nonEmpty) {
      discountMessages.foreach(println)
    } else {
      println("(No offers available)")
    }
    println(f"Total price: £$totalPrice")
    println("-------------")
  }

}