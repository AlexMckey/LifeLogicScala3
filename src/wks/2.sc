import BinLife._

Range(0,8).foreach(print)
(0 to 7).foreach(print)
initGenom(Array(true,false,true,true,false))
initByNumGenom(22)
val rg = randomGenom(10)
middleOneGenom(10)
rg.setRule(22)
rg.genom.toList.grouped(3).toList
rg.genom.toList.sliding(3).toList