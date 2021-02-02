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

  def nth(k: Int, l: List[Int]): Int = {
    return l(k)
  }

  def reverse(l: List[Int]): List[Int] = {
    return l.reverse
  }

  def isPalindrome(l: List[Int]): Boolean = {
    return l == l.reverse
  }

  def flat(l: List[List[Int]]): List[Int] = {
    return l.flatten
  }

  def compress(l: List[Int]): List[Int] = {
    var result = Array[Int]()
    l.foreach((x: Int) => if (result.size == 0 || result.last != x) result = result :+ x)
    return result.toList
  }

  def pack(l: List[Int]): List[List[Int]] = {
    if (l.isEmpty) List(List())
    else {
      val (packed, next) = l span {
        _ == l.head
      }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  def encode(l: List[Symbol]): List[(Int, Symbol)] = {
    if (l.isEmpty) List(List())
    val (packed, next) = l span {
      _ == l.head
    }
    val encoded = (packed.size, packed.head)
    if (next == Nil) List(encoded)
    else encoded :: encode(next)
  }

  def main(args: Array[String]): Unit = {
    val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    println(encode(ls))
  }
}