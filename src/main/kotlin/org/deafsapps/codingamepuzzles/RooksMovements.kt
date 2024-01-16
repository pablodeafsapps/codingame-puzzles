package org.deafsapps.codingamepuzzles

fun main() {
    val rookPosition = "d5"

    val pieceDataList = mutableListOf<Pair<Int, String>>().apply {
        add(0 to "g5")
        add(0 to "d2")
        add(1 to "d7")
    }

    val rookCol = rookPosition[0]
    val rookRow = rookPosition[1].digitToInt()

    val allPossiblePositionsButMine = mutableListOf<String>()
    for (cMinus in rookCol.dec() downTo 'a') {
        if (pieceDataList.contains(0 to "$cMinus$rookRow")) {
            break
        } else if (pieceDataList.contains(1 to "$cMinus$rookRow")) {
            allPossiblePositionsButMine.add("$cMinus$rookRow")
            break
        } else {
            allPossiblePositionsButMine.add("$cMinus$rookRow")
        }
    }
    for (rMinus in rookRow.dec() downTo 1) {
        if (pieceDataList.contains(0 to "$rookCol$rMinus")) {
            break
        } else if (pieceDataList.contains(1 to "$rookCol$rMinus")) {
            allPossiblePositionsButMine.add("$rookCol$rMinus")
            break
        } else {
            allPossiblePositionsButMine.add("$rookCol$rMinus")
        }
    }
    for (cPlus in rookCol.inc() .. 'h') {
        if (pieceDataList.contains(0 to "$cPlus$rookRow")) {
            break
        } else if (pieceDataList.contains(1 to "$cPlus$rookRow")) {
            allPossiblePositionsButMine.add("$cPlus$rookRow")
            break
        } else {
            allPossiblePositionsButMine.add("$cPlus$rookRow")
        }
    }
    for (rPlus in rookRow.inc() .. 8) {
        if (pieceDataList.contains(0 to "$rookCol$rPlus")) {
            break
        } else if (pieceDataList.contains(1 to "$rookCol$rPlus")) {
            allPossiblePositionsButMine.add("$rookCol$rPlus")
            break
        } else {
            allPossiblePositionsButMine.add("$rookCol$rPlus")
        }
    }

    val result = mutableListOf<String>()
    allPossiblePositionsButMine.forEach { possiblePosition ->
        val match = pieceDataList.indexOfFirst { it.second == possiblePosition }
        if (match == -1) {
            result.add("R$rookPosition-$possiblePosition")
        } else {
            if (pieceDataList[match].first == 1) {
                result.add("R${rookPosition}x$possiblePosition")
            }
        }
    }

    result.sorted().forEach { println(it) }
}
