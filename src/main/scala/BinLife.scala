import scala.util.Random

class BinLife(val size: Int) {
  var genom = new Array[Boolean](size)
  val rule = new Array[Boolean](8)
  
  private def this(init: Array[Boolean]) = {
    this(init.size)
    this.genom = init
  }
  private def this(size: Int, init: => Boolean) = {
    this(size)
    this.genom = Array.fill(size)(init)
  }

  override def toString: String = {
    genom.map(if _ then "#" else " ").mkString("")
  }
  
  private def update(idx: Int, value: Boolean): Unit = {
    genom(idx) = value
  }
  
  private def convertBooleanTripletToRuleIndex(bools: List[Boolean]): Int = {
    bools
      .zip(Array(4,2,1))
      .map((v,i) => (if v then 1 else 0)*i)
      .sum
  }
  
  def setRule(numberOfRule: Int) =
    (numberOfRule % 256)
      .toBinaryString.reverse
      .zipWithIndex
      .foreach{(v,i) => rule(i) = v == '1'}
  
  def next() = {
    val d = (genom.last :: genom.toList) :+ genom.head
    val newG = d.sliding(3).map(triplet => rule(convertBooleanTripletToRuleIndex(triplet)))
    genom = newG.toArray
  }
}

object BinLife {
  def middleOneGenom(size: Int) = {
    val res = BinLife(size)
    res(size/2) = true
    res
  }
  def initGenom(init:Array[Boolean]) = {
    BinLife(init)
  }
  def initByNumGenom(initNum:Int) = {
    BinLife(initNum.toBinaryString.reverse.map(_ == '1').toArray)
  }
  def randomGenom(size: Int) = {
    BinLife(size,Random.nextBoolean())
  }
}
