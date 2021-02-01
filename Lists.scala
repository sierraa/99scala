// http://aperiodic.net/phil/scala/s-99/

object Lists {
  def last(l: List[Int]): Int = { // p0
    return l.last
  }

  def penultimate(l: List[Int]): Option[Int] = { // p1
    if (l.size < 2) {
      return None
    }
    return Some(l(l.size - 2))
  }

  def main(args: Array[String]): Unit = {
    val nums = List(1, 2, 3, 4)
    println(penultimate(nums))
  }
}