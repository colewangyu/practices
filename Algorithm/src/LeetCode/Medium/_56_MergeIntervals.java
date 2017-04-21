package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class _56_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result;
        result = new ArrayList<Interval>();
        result.addAll(intervals);
        // sort result
        Collections.sort(result, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });
        for(int index = 0; index < result.size(); index++) {
            Interval thisOne = result.get(index);
            for(int indexInner = index + 1; indexInner < result.size(); indexInner++) {
                Interval nextOne = result.get(indexInner);
                if(thisOne.end >= nextOne.start) {
                    int start = thisOne.start < nextOne.start ? thisOne.start : nextOne.start;
                    int end = thisOne.end > nextOne.end ? thisOne.end : nextOne.end;
                    thisOne = new Interval(start, end);
                    result.add(index, thisOne);
                    result.remove(index + 1);
                    result.remove(index + 1);
                    indexInner--;
                }
            }
        }
        return result;
    }
}


//Definition for an interval.
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;

        Interval interval = (Interval) o;

        if (start != interval.start) return false;
        if (end != interval.end) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}

