
object Main {

  def main(args: Array[String]): Unit = {
    println(s"Hello world, from $msg!")
    val g1 = BinLife.middleOneGenom(8)
    println(g1)
    val g2 = BinLife.randomGenom(10)
    println(g2)
    val g3 = BinLife.initGenom(Array(true,false,true,true,false))
    println(g3)
    val g4 = BinLife.initByNumGenom(114)
    println(g4)
    val g = BinLife.middleOneGenom(51)
    g.setRule(22)
    println(g)
    (0 to 100).foreach { _ =>
      g.next()
      println(g)
    }
  }
  val msg = "Binary Life"
}
