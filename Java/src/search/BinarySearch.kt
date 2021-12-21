package search

class BinarySearch {

    fun search(ar:Array<Int>, value:Int):Int? {

        //Define upper & under bound first
        var lower_bound = 0
        var upper_bound = ar.size - 1


        //loop for check the mid point.
        while(lower_bound <= upper_bound) {
            val midPoint = (lower_bound + upper_bound) / 2
            val value_at_midPoint = ar[midPoint]

            //decrease upper_bound
            if(value < value_at_midPoint) {
                upper_bound = midPoint - 1
            }

            //increase lower_bound
            else if(value > value_at_midPoint) {
                lower_bound = midPoint + 1
            }
            else if(value == value_at_midPoint) {
                return value
            }
        }

        return null
    }
}