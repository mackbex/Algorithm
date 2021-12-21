package compleity

import search.BinarySearch

class TimeComplexity {

    constructor() {
        val things = arrayOf("apples","baboons","cribs","dulcimers")

        //O(N)
        for(thing in things) {
            print("$thing")
        }

        //O(Log N)
        val binarySearch = BinarySearch()
        binarySearch.search(arrayOf(1,2,5,6,7), 6)
    }
}