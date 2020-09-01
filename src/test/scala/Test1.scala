
import org.junit.jupiter.api.{DisplayName, Test}
import org.junit.jupiter.api.Assertions._


class Test1 {
  @Test
  def t1(): Unit = {
    assertEquals("Binary Life", Main.msg)
  }
  @Test
  @DisplayName("Generate genom with middleOne method")
  def middleOne() = {
    assertAll(
      () => assertArrayEquals(Array(false,true,false),BinLife.middleOneGenom(3).genom),
      () => assertArrayEquals(Array(false,false,true,false,false),BinLife.middleOneGenom(5).genom),
      () => assertArrayEquals(Array(false,true),BinLife.middleOneGenom(2).genom),
      () => assertArrayEquals(Array(false,false,true,false),BinLife.middleOneGenom(4).genom),
    )
  }
  @Test
  @DisplayName("Generate genom byNum method")
  def byNum() = {
    assertAll(
      () => assertArrayEquals(Array(false,true,true,false,true),BinLife.initByNumGenom(22).genom),
      () => assertArrayEquals(Array(true,true,true),BinLife.initByNumGenom(7).genom),
      () => assertArrayEquals(Array(false,false,false,true),BinLife.initByNumGenom(8).genom)
    )
  }
  @Test
  @DisplayName("Check setRule method")
  def setRule() = {
    val g = BinLife.initGenom(Array(true,true,true))
    g.setRule(128)
    assertAll(
      () => assertArrayEquals(Array(true,true,true),g.genom),
      () => assertEquals(3,g.size),
      () => assertArrayEquals(Array(false,false,false,false,false,false,false,true),g.rule)
    )
    g.next()
    assertArrayEquals(Array(true,true,true),g.genom)
  }
}