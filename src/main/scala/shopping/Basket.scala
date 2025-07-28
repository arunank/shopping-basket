package shopping

case class Item(name: String, price: BigDecimal)

object Basket {
  val items = Map(
    "Soup"   -> Item("Soup", BigDecimal(0.65)),
    "Bread"  -> Item("Bread", BigDecimal(0.80)),
    "Milk"   -> Item("Milk", BigDecimal(1.30)),
    "Apples" -> Item("Apples", BigDecimal(1.00))
  )

  def parseBasket(args: Seq[String]): List[Item] = {
    val (valid, invalid) = args.partition(items.contains)
    invalid.foreach(item => println(s"Warning: '$item' is not a recognized product and will be ignored."))
    valid.flatMap(items.get).toList
  }

  def subtotal(basket: List[Item]): BigDecimal = {
    basket.map(_.price).sum
  }

  def itemCounts(basket: List[Item]): Map[String, Int] = {
    basket.groupBy(_.name).mapValues(_.size).view.toMap
  }

  def totalSavings(subtotal: BigDecimal, discounts: BigDecimal): BigDecimal = {
    (subtotal - discounts).max(0).setScale(2)
  }
}