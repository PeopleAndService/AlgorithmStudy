package programmers.level2기

// 소수찾기

class FindPrime {
    private val makeNumbers = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        getCombination(numbers, "")

        return makeNumbers.count { isPrime(it) }
    }

    private fun getCombination(numbers: String, result: String) {
        if (result.isNotEmpty()) makeNumbers.add(result.toInt())
        if (numbers.isEmpty()) return

        numbers.forEachIndexed { index, c ->
            getCombination(numbers.removeRange(index..index), c.plus(result))
        }
    }

    private fun isPrime(number: Int): Boolean {
        if (number == 1 || number == 0) {
            return false
        }
        for (i in (2..(number / 2))) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}


/* 시퀀스를 사용하는 소수 찾기! -> 근데 시간초과뜸
* private val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        while (true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1)
                .filter { it % prime != 0 }
        }
    }*/