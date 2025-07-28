package shopping

object Discount {

  def applyDiscounts(items: List[Item]): (List[String], BigDecimal) = {
    val counts = Basket.itemCounts(items)
    var totalDiscount = BigDecimal(0)
    val messages = scala.collection.mutable.ListBuffer[String]()

    // Apple 10% off
    val appleCount = counts.getOrElse("Apples", 0)
    if (appleCount > 0) {
      val appleDiscount = BigDecimal(0.10) * appleCount
      totalDiscount += appleDiscount
      messages += f"Apples 10%% off: -£${appleDiscount.setScale(2)}"
    }

    // Buy 2 soups, get bread at 50% off
    val soupCount = counts.getOrElse("Soup", 0)
    val breadCount = counts.getOrElse("Bread", 0)
    val eligibleDiscounts = soupCount / 2 min breadCount
    if (eligibleDiscounts > 0) {
      val breadDiscount = BigDecimal(0.40) * eligibleDiscounts
      totalDiscount += breadDiscount
      messages += f"${eligibleDiscounts}x Bread half price: -£${breadDiscount.setScale(2)}"
    }

    (messages.toList, totalDiscount.setScale(2))
  }
}
