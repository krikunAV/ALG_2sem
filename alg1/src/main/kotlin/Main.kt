//import java.util.Vector
//
//В данной задаче требуется ввести N точек своими координатами (x,y).
//Затем требуется определить, существует ли выпуклая оболочка заданного множества точек.
//При этом можно использовать: или алгоритм Грэхема, или алгоритм Джарвиса, или метод «разделяй и властвуй»
//
//class ConvexHull(val dotsList: List<Pair<Double,Double>>) {
//    fun jarvisConvexHull(dotsList: List<Pair<Double, Double>>): List<Pair<Double, Double>>{
//        var dot0 = dotsList[0]
//        for (dot in dotsList){
//            if (dot.first < dot0.first || (dot0.first == dot.first && dot.second < dot0.second))
//                dot0 = dot
//        }
//        var jarvisShell: MutableList<Pair<Double, Double>> = mutableListOf(dot0)
//        var stop = true
//        while (stop){
//            var dott: Pair<Double, Double>? = null
//            for (dot in dotsList) {
//                if (dot == dot0) continue
//                if (dott == null) {
//                    dott = dot
//                    continue
//                }
//                var p = Pair(dot.first - dot0.first, dot.second - dot0.second)
//                var t = Pair(dott.first - dot0.first, dott.second - dot0.second)
//                if ((p.first * t.second) - (p.second * t.first) > 0)
//                    dott = dot
//            }
//            if (dott == null || dott == dot0) {
//                stop = false
//            } else {
//                jarvisShell.add(dott)
//                dot0 = dott
//            }
//        }
//        return jarvisShell
//
//            //        {
////            var dott: Pair<Double,Double>?  = null
////            for (dot in dotsList){
////                var p = Pair((dot.first - dot0.first), dot.second - dot0.second)
////                var t = Pair((dott.first - dot0.first), dott.second - dot0.second)
////                if((p.first * t.second) - (p.second * t.first) > 0)
////                    dott = dot
////            }
////            if (dott == dot0) break
////            else jarvisShell.add(dott)
////        }
////        return jarvisShell
////    }
//
//        }
//    }
//
//
//
//
//fun main(args: Array<String>) {
//    val dotList: List<Pair<Double,Double>> = listOf(
//        Pair(0.0, 0.0), Pair(1.0, 0.0), Pair(2.0, 0.0), Pair(3.0, 0.0), Pair(4.0, 0.0),
//        Pair(0.0, 1.0), Pair(1.0, 1.0), Pair(2.0, 1.0), Pair(3.0, 1.0), Pair(4.0, 1.0),
//        Pair(0.0, 2.0), Pair(1.0, 2.0), Pair(2.0, 2.0), Pair(3.0, 2.0), Pair(4.0, 2.0),
//        Pair(0.0, 3.0), Pair(1.0, 3.0), Pair(2.0, 3.0), Pair(3.0, 3.0), Pair(4.0, 3.0)
//    )
//
//    val convexHull = ConvexHull(dotList)
//    val result = convexHull.jarvisConvexHull(dotList)
//    println("Выпуклая оболочка:")
//    for (dot in result) {
//        println(dot)
//    }
//
//}

import java.util.Stack

class ConvexHull(val dotsList: List<Pair<Double,Double>>) {
    // Метод для построения выпуклой оболочки методом Джарвиса
    fun jarvisConvexHull(dotsList: List<Pair<Double, Double>>): List<Pair<Double, Double>> {
        var dot0 = dotsList[0]
        for (dot in dotsList) {
            if (dot.first < dot0.first || (dot.first == dot0.first && dot.second < dot0.second))
                dot0 = dot
        }
        var jarvisShell: MutableList<Pair<Double, Double>> = mutableListOf(dot0)
        var stop = true
        var dott: Pair<Double, Double> = dot0
        while (stop) {

            for (dot in dotsList) {
                var p = Pair(dot.first - dot0.first, dot.second - dot0.second)
                var t = Pair(dott.first - dot0.first, dott.second - dot0.second)
                if ((p.first * t.second) - (p.second * t.first) > 0)
                    dott = dot
            }
            if (dott == null || dott == dot0) {
                stop = false
            } else {
                jarvisShell.add(dott)
                dot0 = dott
            }
        }
        return jarvisShell
    }
}

fun main(args: Array<String>) {
    val dotList: List<Pair<Double,Double>> = listOf(
        Pair(0.0, 0.0), Pair(1.0, 0.0), Pair(2.0, 0.0), Pair(3.0, 0.0), Pair(4.0, 0.0),
        Pair(0.0, 1.0), Pair(1.0, 1.0), Pair(2.0, 1.0), Pair(3.0, 1.0), Pair(4.0, 1.0),
        Pair(0.0, 2.0), Pair(1.0, 2.0), Pair(2.0, 2.0), Pair(3.0, 2.0), Pair(4.0, 2.0),
        Pair(0.0, 3.0), Pair(1.0, 3.0), Pair(2.0, 3.0), Pair(3.0, 3.0), Pair(4.0, 3.0)
    )

    val convexHull = ConvexHull(dotList)
    val result = convexHull.jarvisConvexHull(dotList)
    println("Выпуклая оболочка:")
    for (dot in result) {
        println(dot)
    }
}
